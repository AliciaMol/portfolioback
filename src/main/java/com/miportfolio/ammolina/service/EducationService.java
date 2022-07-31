/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.ammolina.service;

import com.miportfolio.ammolina.model.Education;
import com.miportfolio.ammolina.repository.IEducationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sisita
 */
@Service
public class EducationService implements IEducationService{

    @Autowired
    public IEducationRepository ieducationrepository;
    
    @Override
    public List<Education> getAllEducation() {
        return ieducationrepository.findAll();
    }

    @Override
    public void saveEducation(Education education) {
        ieducationrepository.save(education);
    }

    @Override
    public void deleteEducation(Long id) {
        ieducationrepository.deleteById(id);
    }

    @Override
    public Education searchEducation(Long id) {
        return ieducationrepository.findById(id).orElse(null);
    }

    @Override
    public Education addEducation(Education education) {
        return ieducationrepository.save(education);
    }

    @Override
    public Education editEducation(Education education) {
        return ieducationrepository.save(education);
    }
    
}
