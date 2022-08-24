package com.example.Mistumori.dao;

import com.example.Mistumori.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDAO {
    int insertUser(UUID id, User user);

    default int insertUser(User user){
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }
    List<User> selectAllPeople();

    Optional<User> selectPersonById(UUID id);
}
