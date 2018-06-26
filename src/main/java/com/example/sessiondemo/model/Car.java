package com.example.sessiondemo.model;

import javax.persistence.*;
import java.util.Random;
import java.util.UUID;

@Entity
public class Car {

    public enum Brand {
        OPEL, SUZUKI, TOYOTA, MERCEDES, AUDI, BMW;
    }

    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private Brand brand;
    private String licensePlate;

    public static Car randomCar() {
        Brand brand = Brand.values()[new Random().nextInt(Brand.values().length)];
        String licensePlate = UUID.randomUUID().toString();
        return new Car(brand, licensePlate);
    }

    public Car() {
    }

    public Car(Brand brand, String licensePlate) {
        this.brand = brand;
        this.licensePlate = licensePlate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
