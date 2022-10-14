/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.ammolina.service;

import com.miportfolio.ammolina.exception.UserNotFoundException;
import com.miportfolio.ammolina.model.Skills;
import com.miportfolio.ammolina.repository.ISkillsRepository;
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
public class SkillsService implements ISkillsService {

    @Autowired
    public ISkillsRepository iSkillsRepository;

    @Override
    public List<Skills> getAllSkills() {
        return iSkillsRepository.findAll();
    }

    @Override
    public void deleteSkills(Long id) {
        iSkillsRepository.deleteById(id);
    }

    @Override
    public Skills getSkillsById(Long id) {
        return iSkillsRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Skills by id " + id + "was not found."));
    }

    @Override
    public Skills addSkills(Skills skills) {
        return iSkillsRepository.save(skills);
    }

    @Override
    public Skills updateSkills(Skills skills) {
        return iSkillsRepository.save(skills);
    }

}
