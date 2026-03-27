package com.example.demo.web;

import com.example.demo.domain.Greeting;
import com.example.demo.domain.GreetingRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GreetingController {

    private final GreetingRepository greetingRepository;

    public GreetingController(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @GetMapping("/greeting")
    public String greet() {
        return greetingRepository
                .findAll()
                .stream()
                .findFirst()
                .map(Greeting::getMessage)
                .orElse("Bonjour depuis Spring Boot!");
    }
}
