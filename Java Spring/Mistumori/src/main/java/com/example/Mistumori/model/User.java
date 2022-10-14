package com.example.Mistumori.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String mdp;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

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
