/*package com.example.Mistumori.dao;

import com.example.Mistumori.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDAO {
    int insertUser(Integer id, User user);

    default int insertUser(User user){
        return insertUser(user);
    }
    List<User> selectAllPeople();

    Optional<User> selectPersonById(Integer id);

    int deletePersonById(Integer id);

    int updatePersonById(Integer id, User newUser);
}
*/