/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.ammolina.repository;

import com.miportfolio.ammolina.model.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sisita
 */
@Repository
public interface ISkillsRepository extends JpaRepository<Skills, Long> {

    public Optional<Skills> getSkillsById(Long id);
}
