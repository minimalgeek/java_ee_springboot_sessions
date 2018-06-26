package com.example.sessiondemo.service;

import com.example.sessiondemo.model.Car;
import com.example.sessiondemo.repository.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionService.class);

    private Set<Car> shoppingCart = new HashSet<>();

    @Autowired
    private CarRepository repository;

    @PostConstruct
    public void init() {
        LOGGER.info("================ SESSION SCOPED BEAN CREATED ================");
    }

    public Car buyCar(Long id) {
        Optional<Car> car = repository.findById(id);
        if (car.isPresent()) {
            shoppingCart.add(car.get());
        }
        return car.get();
    }

    public Set<Car> getCarsInShoppingCart() {
        return shoppingCart;
    }
}
