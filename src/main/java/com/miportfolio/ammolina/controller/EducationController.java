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
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sisita
 */
@RestController
@RequestMapping("/education")
//@CrossOrigin(origins = "http://localhost:4200")
public class EducationController {

    @Autowired
    private IEducationService ieducationservice;

    @ResponseBody
    @GetMapping("/getall")
    public List<Education> getAllEducation() {
        return ieducationservice.getAllEducation();
    }

    @PostMapping("/new")
    public String addEducation(@RequestBody Education education) {
        ieducationservice.saveEducation(education);
        return "El registro de sus estudios se creó correctamente.";
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteEducation(@PathVariable Long id) {
        ieducationservice.deleteEducation(id);
        return "El registro de estudio se eliminó";
    }

    @PutMapping("/edit/{id}")
    public Education editEducation(@PathVariable Long id,
            @RequestParam("title") String newTitle,
            @RequestParam("career") String newCareer,
            @RequestParam("faculty") String newFaculty,
            @RequestParam("houseOfStudies") String newHouseOfStidies,
            @RequestParam("startDate") String newStartDate,
            @RequestParam("endingDate") String newEndingDate,
            @RequestParam("imageURL") String newImageURL) {
        Education education = ieducationservice.searchEducation(id);
        education.setTitle(newTitle);
        education.setCareer(newCareer);
        education.setFaculty(newFaculty);
        education.setHouseOfStudies(newHouseOfStidies);
        education.setStartDate(newStartDate);
        education.setEndingDate(newEndingDate);
        education.setImageURL(newImageURL);
        return education;
    }
    
    @GetMapping("/search/{id}")
    public Education searcEducation(@PathVariable Long id){ //(@PathVariable("id") Long id) {
        return ieducationservice.searchEducation(id);
    }
    
}
