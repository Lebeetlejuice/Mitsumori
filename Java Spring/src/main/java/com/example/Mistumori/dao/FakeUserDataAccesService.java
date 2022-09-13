package com.example.Mistumori.dao;

import com.example.Mistumori.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("PostGreesql")
public class FakeUserDataAccesService implements UserDAO{
    private static List<User> DB = new ArrayList<>();

    @Override
    public int insertUser(UUID id, User user) {
        DB.add(new User(id, user.getName()));
        return 1;
    }

    @Override
    public List<User> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<User> selectPersonById(UUID id) {
        return DB.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }
}
