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

    @Override
    public int deletePersonById(UUID id) {
        Optional<User> personMaybe = selectPersonById(id);
        if (personMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, User updateUser){
        return selectPersonById(id)
                .map(user ->{
                    int indexofPersonToUpdate = DB.indexOf(user);
                    if(indexofPersonToUpdate >= 0){
                        DB.set(indexofPersonToUpdate, new User(id, updateUser.getName()));
                        return 1;
                    }
                    return  0;
                })
                .orElse(0);
    }

}
