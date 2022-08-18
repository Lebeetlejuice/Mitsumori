package com.example.Mistumori.model;

import java.util.UUID;

public class Person {
    private final UUID id;
    private String name;
    private String surname;
    private String email;
    private String mdp;

    public Person(UUID id, String name, String surname, String email, String mdp) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.mdp = mdp;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getMdp() {
        return mdp;
    }
}
