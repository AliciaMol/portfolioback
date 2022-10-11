/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.ammolina.repository;

import com.miportfolio.ammolina.model.Education;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sisita
 */
@Repository
public interface IEducationRepository extends JpaRepository <Education, Long>{
        public Optional <Education> getEducationById(Long id);
}
