/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.ammolina.controller;

import com.miportfolio.ammolina.model.Skills;
import com.miportfolio.ammolina.service.ISkillsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sisita
 */
@RestController
@RequestMapping("/skills")
@CrossOrigin(origins = "*")
public class SkillsController {

    private final ISkillsService iSkillsService; //interface

    @Autowired
    public SkillsController(ISkillsService iSkillsService) {
        this.iSkillsService = iSkillsService;
    }

    @PostMapping("/add")
    public ResponseEntity<Skills> addSkills(@RequestBody Skills skills) {
        Skills newSkills = iSkillsService.addSkills(skills);
        return new ResponseEntity<>(newSkills, HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Skills>> getAllSkills() {
        List<Skills> SkillsList = iSkillsService.getAllSkills();
        return new ResponseEntity<>(SkillsList, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSkills(@PathVariable("id") Long id) {
        iSkillsService.deleteSkills(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Skills> updateSkills(@RequestBody Skills skills) {
        Skills updateSkills = iSkillsService.updateSkills(skills);
        return new ResponseEntity<>(updateSkills, HttpStatus.OK);
    }

    @GetMapping("/getone/{id}")
    public ResponseEntity<Skills> getSkillsById(@PathVariable("id") Long id) { //(@PathVariable("id") Long id) {
        Skills skills = iSkillsService.getSkillsById(id);
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }

}
