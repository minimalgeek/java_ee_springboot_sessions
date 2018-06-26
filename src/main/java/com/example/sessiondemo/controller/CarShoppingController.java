package com.example.sessiondemo.controller;

import com.example.sessiondemo.model.Car;
import com.example.sessiondemo.service.AppService;
import com.example.sessiondemo.service.RequestService;
import com.example.sessiondemo.service.SessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class CarShoppingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarShoppingController.class);

    @Autowired
    private AppService appService;

    @Autowired
    private RequestService requestService;

    @Autowired
    private SessionService sessionService;

    @GetMapping("/buyCar/{id}")
    public Car buyCar(@PathVariable("id") Long id) {
        LOGGER.info("AppService" + appService.toString());
        LOGGER.info("RequestService" + requestService.toString());
        LOGGER.info("SessionService" + sessionService.toString());
        return sessionService.buyCar(id);
    }

    @GetMapping("/carsInShoppingCart")
    public Set<Car> getCarsInShoppingCart() {
        return sessionService.getCarsInShoppingCart();
    }

    @GetMapping("/secret-method")
    public String secretMethod() {
        return "Full secret!";
    }
}
