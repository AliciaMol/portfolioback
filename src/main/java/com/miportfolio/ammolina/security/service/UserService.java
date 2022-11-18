/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.ammolina.security.service;

import com.miportfolio.ammolina.security.entity.User;
import com.miportfolio.ammolina.security.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Sisita
 */
//Transactional es para mantener la coherencia de la base de datos, si falla una 
//operación se hace un roll back y se vuelve al estado anterior.
@Service
@Transactional
@ComponentScan
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Optional<User> getByNameUser(String nameUser) {
        return userRepository.findByNameUser(nameUser);
    }

    public boolean existsByNameUser(String nameUser) {
        return userRepository.existsByNameUser(nameUser);
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
