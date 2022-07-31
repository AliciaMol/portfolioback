/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.ammolina.repository;

import com.miportfolio.ammolina.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Sisita
 */
public interface IEducationRepository extends JpaRepository <Education, Long>{
    
}
