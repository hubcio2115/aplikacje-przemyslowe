package com.example.zad1.service;

import com.example.zad1.domains.Person;

import org.springframework.stereotype.Component;

@Component
public class PersonComponent {
    private Person wiceprezes;

    public PersonComponent(Person wiceprezes) {
        this.wiceprezes = wiceprezes;
    }
}
