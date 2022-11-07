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
public class Skills implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long person_id;
    private Boolean type_skill;    //hard o soft
    private Long percent;
    private String title;
    private String image_src;
    private Boolean show_image;
    private String outer_stroke_color;
    private String inner_stroke_color;
    private String background_color;

    public Skills() {
    }

    public Skills(Long id, Long person_id, Boolean type_skill, Long percent, String title, String image_src, Boolean show_image, String outer_stroke_color, String inner_stroke_color, String background_color) {
        this.id = id;
        this.person_id = person_id;
        this.type_skill = type_skill;
        this.percent = percent;
        this.title = title;
        this.image_src = image_src;
        this.show_image = show_image;
        this.outer_stroke_color = outer_stroke_color;
        this.inner_stroke_color = inner_stroke_color;
        this.background_color = background_color;
    }

    @Override
    public String toString() {
        return "Skills{" + "id=" + id + ", person_id=" + person_id + ", type=" + type + ", percent=" + percent + ", title=" + title + ", image_src=" + image_src + ", show_image=" + show_image + ", outer_stroke_color=" + outer_stroke_color + ", inner_stroke_color=" + inner_stroke_color + ", background_color=" + background_color + '}';
    }

}
