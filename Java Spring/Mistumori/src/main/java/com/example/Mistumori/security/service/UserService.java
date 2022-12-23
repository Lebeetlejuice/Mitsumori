package com.example.Mistumori.security.service;

import com.example.Mistumori.Repository.UserRepo;
import com.example.Mistumori.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public List<User> listAllUser() {
        return userRepo.findAll();
    }

    public void saveUser(User user) {
        userRepo.save(user);
    }

    public User getUser(Long id) {
        return userRepo.findById(id).get();
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}