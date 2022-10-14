/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.ammolina.service;

import com.miportfolio.ammolina.model.Skills;
import java.util.List;

/**
 *
 * @author Sisita
 */
public interface ISkillsService {

    public List<Skills> getAllSkills();

    public Skills addSkills(Skills skills);

    public void deleteSkills(Long id);

    public Skills getSkillsById(Long id);

    public Skills updateSkills(Skills skills);
}
