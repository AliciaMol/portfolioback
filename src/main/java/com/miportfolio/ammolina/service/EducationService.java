/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.ammolina.service;

import com.miportfolio.ammolina.exception.UserNotFoundException;
import com.miportfolio.ammolina.model.Education;
import com.miportfolio.ammolina.repository.IEducationRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sisita
 */
@Service
@Transactional
public class EducationService implements IEducationService {

    @Autowired
    public IEducationRepository iEducationRepository;

    @Override
    public List<Education> getAllEducation() {
        return iEducationRepository.findAll();
    }

    @Override
    public void deleteEducation(Long id) {
        iEducationRepository.deleteById(id);
    }

    @Override
    public Education getEducationById(Long id) {
        return iEducationRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Education by id " + id + "was not found."));
    }

    @Override
    public Education addEducation(Education education) {
        return iEducationRepository.save(education);
    }

    @Override
    public Education updateEducation(Education education) {
        return iEducationRepository.save(education);
    }

}
