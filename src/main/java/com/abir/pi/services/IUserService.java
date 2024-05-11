package com.abir.pi.services;

import com.abir.pi.entities.User;

import java.util.List;

public interface IUserService {
    User addUser(User user);
    User updateUser(User user);
    void deleteUser(int idUser);
    List<User> findAllUsers();
    User findUserById(int idUser);

}
