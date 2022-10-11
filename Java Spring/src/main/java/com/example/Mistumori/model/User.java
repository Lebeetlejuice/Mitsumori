package com.example.Mistumori.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private final Integer id;
    private String name;
    private String surname;
    private String email;
    private String mdp;

    public User(@JsonProperty("id") Integer id, @JsonProperty("name") String name, @JsonProperty("surname") String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.mdp = mdp;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
}
  /*  public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getMdp() {
        return mdp;
    }
}*/
