/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.ammolina.security.service;

import com.miportfolio.ammolina.security.entity.Rol;
import com.miportfolio.ammolina.security.enums.RolName;
import com.miportfolio.ammolina.security.repository.RolRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Sisita
 */
@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository roleRepository;

    public Optional<Rol> getByRoleName(RolName roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    public void save(Rol role) {
        roleRepository.save(role);
    }
}