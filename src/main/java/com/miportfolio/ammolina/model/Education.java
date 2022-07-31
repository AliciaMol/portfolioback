/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.ammolina.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Sisita
 */
@Getter
@Setter
@Entity
public class Education implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    private String title;   
    private String career;   
    private String faculty;    
    private String houseOfStudies;    
    private String startDate;    
    private String endingDate;    
    private String imageURL;    
    public Education(){ }
    
    public Education(Long id, String title, String career,String faculty, String houseOfStudies, 
            String startDate, String endingDate, String imageURL){
        this.id=id;
        this.title=title;
        this.career=career;
        this.faculty=faculty;
        this.houseOfStudies=houseOfStudies;
        this.startDate=startDate;
        this.endingDate=endingDate;
        this.imageURL=imageURL;
    }
}
