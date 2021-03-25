package com.example.demo.repository;

import com.example.demo.models.realmodel.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    Object findByUsername(String username);
}
