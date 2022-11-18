/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.ammolina.security.controller;

import com.miportfolio.ammolina.security.dto.JwtDto;
import com.miportfolio.ammolina.security.dto.NewUser;
import com.miportfolio.ammolina.security.dto.UserLogin;
import com.miportfolio.ammolina.security.entity.Rol;
import com.miportfolio.ammolina.security.entity.User;
import com.miportfolio.ammolina.security.enums.RolName;
import com.miportfolio.ammolina.security.jwt.JwtProvider;
import com.miportfolio.ammolina.security.service.RolService;
import com.miportfolio.ammolina.security.service.UserService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sisita Api Rest
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RolService roleService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/new")
    public ResponseEntity<?> neww(@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Message("Campos mal completados. Por favor, complételos nuevamente."), HttpStatus.BAD_REQUEST);
        }

        if (userService.existsByNameUser(newUser.getNameUser())) {
            return new ResponseEntity(new Message("El usuario ya existe"), HttpStatus.BAD_REQUEST);
        }

        User user = new User(newUser.getName(), newUser.getNameUser(), passwordEncoder.encode(newUser.getPassword()));

        Set<Rol> roles = new HashSet<>();
        roles.add(roleService.getByRoleName(RolName.ROLE_USER).get());
        if (newUser.getRoles().contains("admin")) {
            roles.add(roleService.getByRoleName(RolName.ROLE_ADMIN).get());
        }

        user.setRoles(roles);
        userService.save(user);

        return new ResponseEntity(new Message("Usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody UserLogin loginUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Message("Campos mal completados"), HttpStatus.BAD_REQUEST);
        }

        Authentication authentication
                = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
                (loginUser.getNameUser(), loginUser.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());

        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
