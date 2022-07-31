/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.ammolina.service;

import com.miportfolio.ammolina.model.Education;
import java.util.List;

/**
 *
 * @author Sisita
 */
public interface IEducationService {
    public List<Education> getAllEducation();
    public Education addEducation(Education education);
    public void saveEducation(Education education);
    public void deleteEducation(Long id);
    public Education searchEducation(Long id);
    public Education editEducation(Education education);
}
