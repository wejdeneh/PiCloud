package com.esprit.edusched.services;

import com.esprit.edusched.entities.User;
import com.esprit.edusched.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements IUserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(long idUser) {
        return userRepository.getById(idUser);
    }

    @Override
    public void deleteUser(long idUser) {
        userRepository.deleteById(idUser);
    }
}