package com.esprit.edusched.services;

import com.esprit.edusched.entities.User;

import java.util.List;

public interface IUserService {
    User addUser(User user);
    User updateUser(User user);
    List<User> findAllUsers();
    User findUserById(long idUser);
    void deleteUser(long idUser);
}