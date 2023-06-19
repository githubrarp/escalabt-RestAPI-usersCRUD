package com.felipe.escalabt.persistence.repositories;

import com.felipe.escalabt.persistence.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository <User, String> {

    public Optional<User> findByEmail(String email);
}
