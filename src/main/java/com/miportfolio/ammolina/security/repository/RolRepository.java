/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.ammolina.security.repository;

import com.miportfolio.ammolina.security.entity.Rol;
import com.miportfolio.ammolina.security.enums.RolName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sisita
 */
@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByRoleName(RolName roleName);
}
