package com.example.Mistumori.Repository;

import com.example.Mistumori.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findBysurname(String surname);
}
