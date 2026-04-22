package com.example.user_db_api;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID> {
    // Spring Data JPA automatically writes the SQL query for this!
    boolean existsByEmail(String email);
}