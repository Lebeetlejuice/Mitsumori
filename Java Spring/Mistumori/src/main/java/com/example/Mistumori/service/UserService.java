package com.example.Mistumori.service;

import com.example.Mistumori.dao.UserDAO;
import com.example.Mistumori.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserService(@Qualifier("postgres") UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    public int addUser(User user){
        return userDAO.insertUser(user);
    }

    public List<User> getAllPeople(){
        return userDAO.selectAllPeople();
    }

    public Optional<User> getPersonbyId(Integer id) {
        return userDAO.selectPersonById(id);
    }

    public int deletePerson(Integer id){
        return userDAO.deletePersonById(id);
    }
    public int updatePerson(Integer id, User newUser){
        return userDAO.updatePersonById(id, newUser);
    }
}
