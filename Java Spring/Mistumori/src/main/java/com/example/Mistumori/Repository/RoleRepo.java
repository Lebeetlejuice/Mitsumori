package com.example.Mistumori.Repository;

import com.example.Mistumori.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    Role findByname(String name);
}