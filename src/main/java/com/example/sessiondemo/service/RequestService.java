package com.example.sessiondemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestService {


    private static final Logger LOGGER = LoggerFactory.getLogger(RequestService.class);

    @PostConstruct
    public void init() {
        LOGGER.info("================ REQUEST SCOPED BEAN CREATED ================");
    }

}
