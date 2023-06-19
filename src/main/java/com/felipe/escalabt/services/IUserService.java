package com.felipe.escalabt.services;

import com.felipe.escalabt.persistence.entities.User;

import java.util.List;

public interface IUserService {
    List<User> getUsers();

    User getUserByEmail(String email);

    User createUser(User user);

    void deleteUser(String email);

    User updateUser(String email, User user);
}
