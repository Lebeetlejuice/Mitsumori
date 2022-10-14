package com.example.Mistumori.service;

import com.example.Mistumori.model.Role;
import com.example.Mistumori.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String surname, String roleName);
    User getUser(String surname);
    List<User>getUsers();
}
