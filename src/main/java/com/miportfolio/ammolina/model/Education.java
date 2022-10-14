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
    private Long person_id;

    private String title;
    private String career;
    private String faculty;
    private String house_of_studies;
    private String start_date;
    private String ending_date;
    private String logo_url;

    public Education() {
    }

    public Education(Long id, Long person_id, String title, String career,
            String faculty, String house_of_studies, String start_date,
            String ending_date, String logo_url) {
        this.id = id;
        this.person_id = person_id;
        this.title = title;
        this.career = career;
        this.faculty = faculty;
        this.house_of_studies = house_of_studies;
        this.start_date = start_date;
        this.ending_date = ending_date;
        this.logo_url = logo_url;
    }

    @Override
    public String toString() {
        return "Education{" + "id=" + id + ", person_id=" + person_id + ", title=" + title + ", career=" + career + ", faculty=" + faculty + ", house_of_studies=" + house_of_studies + ", start_date=" + start_date + ", ending_date=" + ending_date + ", logo_url=" + logo_url + '}';
    }

}
