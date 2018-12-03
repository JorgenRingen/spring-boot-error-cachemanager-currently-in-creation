package com.example.cachemanagercurrentlyincreationerror;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CachemanagerCurrentlyInCreationErrorApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CachemanagerCurrentlyInCreationErrorApplication.class, args);
    }

    @Autowired
    private FooCacheHandler fooService;

    @Override
    public void run(String... args) throws Exception {
        fooService.foo(-1L);
    }
}
