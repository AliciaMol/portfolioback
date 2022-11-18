/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.ammolina.security.service;

import com.miportfolio.ammolina.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.miportfolio.ammolina.security.entity.Admin;

/**
 * Esta clase media entre el user y el principal user: tiene el usuario de la
 * base de datos y lo convierte en un usuario principal que es la clase que
 * utiliza spring security para obtener los datos de usuario y los privilegios
 * de usuario.
 *
 * @author Sisita
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String nameUser) throws UsernameNotFoundException {
        User user = userService.getByNameUser(nameUser).get();

        return Admin.build(user);
    }
}