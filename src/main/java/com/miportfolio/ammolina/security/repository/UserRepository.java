/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.ammolina.security.repository;

import com.miportfolio.ammolina.security.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sisita
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByNameUser(String nameUser);

    boolean existsByNameUser(String NameUser);
}