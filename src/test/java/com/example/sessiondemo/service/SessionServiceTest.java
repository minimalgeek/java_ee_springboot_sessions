package com.example.sessiondemo.service;

import com.example.sessiondemo.SessiondemoApplicationTests;
import com.example.sessiondemo.model.Car;
import com.example.sessiondemo.repository.CarRepository;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class SessionServiceTest extends SessiondemoApplicationTests {

    @MockBean
    private CarRepository repository;

    @Autowired
    @InjectMocks
    private SessionService sessionService;

    @Before
    public void setUp() throws Exception {
        Car car = Car.randomCar();
        car.setId(0L);
        when(repository.findAll()).thenReturn(Lists.newArrayList(car));
        when(repository.findById(0L)).thenReturn(Optional.of(car));
    }

//    @Test
//    public void testRepositoryFindAll() {
//        assertEquals(1, repository.findAll().size());
//    }

    @Test
    public void buyCar() {
        sessionService.buyCar(0L);
        assertEquals(1, sessionService.getCarsInShoppingCart().size());
    }
}