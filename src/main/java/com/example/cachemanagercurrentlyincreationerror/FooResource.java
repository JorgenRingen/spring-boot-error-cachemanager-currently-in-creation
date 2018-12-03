package com.example.cachemanagercurrentlyincreationerror;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("foo")
public class FooResource {

    @Autowired
    private FooCacheHandler fooCacheHandler;

    @GetMapping
    public String foo() {
        fooCacheHandler.foo(-1L);
        return "yo";
    }
}
