package com.example.sessiondemo;

import com.example.sessiondemo.model.Car;
import com.example.sessiondemo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class SessiondemoApplication {

    @Autowired
    private CarRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SessiondemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return (String... args) -> {
            List<Car> randomCars = IntStream.range(0,500)
                    .mapToObj((i) -> Car.randomCar())
                    .collect(Collectors.toList());

            repository.saveAll(randomCars);
        };
    }
}
