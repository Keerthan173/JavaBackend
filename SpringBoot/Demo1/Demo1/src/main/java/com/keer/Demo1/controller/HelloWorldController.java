package com.keer.Demo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController                     // Makes the class return data (like JSON) instead of HTML.
public class HelloWorldController {

    // HTTP GET Request
    // http://localhost:8080/hello-world
    @GetMapping("hello-world")                     // To map HTTP GET request onto specific handler method.
    public String helloWorld(){
        return "Hello World!";
    }
}