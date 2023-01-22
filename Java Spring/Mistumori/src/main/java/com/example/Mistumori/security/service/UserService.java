package com.example.Mistumori.security.service;

import com.example.Mistumori.Repository.UserRepo;
import com.example.Mistumori.model.Estimation;
import com.example.Mistumori.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo1) {
        this.userRepo = userRepo1;
    }

    public List<User> listAllUser() {
        return userRepo.findAll();
    }


    public User saveUser(User user) {
       return userRepo.save(user);
    };

    public Optional<User> getUser(Long id) {
        return userRepo.findById(id);
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}