package com.example.sessiondemo.repository;

import com.example.sessiondemo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

@RestResource(path = "car")
public interface CarRepository extends JpaRepository<Car, Long> {

    @Secured("ROLE_ADMIN")
    List<Car> findByLicensePlateStartsWith(@Param("plate") String licensePlate);

}
