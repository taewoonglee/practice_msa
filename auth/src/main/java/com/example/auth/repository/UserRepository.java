package com.example.auth.repository;

import com.example.auth.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    @Query("select a from User as a where a.email=:email")
    Optional<User> findByEmail(String email);
}
