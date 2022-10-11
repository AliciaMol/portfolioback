/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.ammolina.controller;

import com.miportfolio.ammolina.model.Education;
import com.miportfolio.ammolina.service.IEducationService;
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
@RequestMapping("/education")
@CrossOrigin(origins = "*")
public class EducationController {

    private final IEducationService iEducationService; //interface
    @Autowired
    public EducationController(IEducationService iEducationService) {
        this.iEducationService = iEducationService;
    }
    
    @PostMapping("/add")
    public ResponseEntity<Education> addEducation(@RequestBody Education education) {
       Education newEducation = iEducationService.addEducation(education);
       return new ResponseEntity<>(newEducation, HttpStatus.CREATED);
    }
    
    @GetMapping("/getall")
    public ResponseEntity<List<Education>> getAllEducation() {
        List<Education> educations=iEducationService.getAllEducation();
        return new ResponseEntity<>(educations, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEducation(@PathVariable ("id")Long id) {
        iEducationService.deleteEducation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity <Education> updateEducation(@RequestBody Education education) {
        Education updateEducation = iEducationService.updateEducation(education);
        return new ResponseEntity<>(updateEducation,HttpStatus.OK);
    }
    
    @GetMapping("/getone/{id}")
    public ResponseEntity<Education> getEducationById(@PathVariable("id") Long id) { //(@PathVariable("id") Long id) {
        Education education = iEducationService.getEducationById(id);
        return new ResponseEntity<>(education, HttpStatus.OK);
    }
    
}
