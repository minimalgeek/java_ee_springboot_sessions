package com.example.sessiondemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class AppService {


    private static final Logger LOGGER = LoggerFactory.getLogger(AppService.class);

    @PostConstruct
    public void init() {
        LOGGER.info("================ APP SCOPED BEAN CREATED ================");
    }

}
