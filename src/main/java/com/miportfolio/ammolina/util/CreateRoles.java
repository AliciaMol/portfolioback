///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.miportfolio.ammolina.util;
//
//import com.miportfolio.ammolina.security.entity.Rol;
//import com.miportfolio.ammolina.security.enums.RolName;
//import com.miportfolio.ammolina.security.service.RolService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
///**
// *
// * @author Sisita
// */
//@Component
//public class CreateRoles implements CommandLineRunner {
//
//    /*Injectamos un rolService*/
//    @Autowired
//    RolService rolService;
//    
//    @Override
//    public void run(String... args) throws Exception {
//        Rol rolAdmin = new Rol(RolName.ROLE_ADMIN);
//        Rol rolUser = new Rol(RolName.ROLE_USER);
//        rolService.save(rolAdmin);
//        rolService.save(rolUser);
//    }
//
//}
