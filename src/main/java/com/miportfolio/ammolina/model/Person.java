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
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Sisita
 */
@Getter
@Setter
@Entity
/*Con la anotation Entity indicamos que esta clase va a ser el modelo*/
public class Person implements Serializable{

    @Id         //Con la anotation indicamos que va a ser la clave principal el id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotNull
//    @Size(min =1, max = 45, message = "Ingrese un nombre por favor")
    private String name;
    
//    @NotNull
//    @Size(min =1, max = 45, message = "Ingrese un apellido por favor")
    private String lastname;
    
//    @Size(min =1, max = 45, message = "Ingrese su correo electrónico por favor")
    private String email;
    
//    @Size(min =1, max = 300, message = "Ingrese su ocupación por favor")
    private String ocupation;
    
    private String phone;
    
//    @Size(min =1, max = 500, message = "Ingrese una descripción acerca de usted,"
//            + " por favor")
    private String aboutmedescription;
    
//      @Size(min =1, max = 150, message = "Ingrese la url de su imagen de perfil por favor")
    private String imageurl;

    public Person() {
    }

    public Person(Long id, String name, String lastname, String email, String ocupation, String phone, String aboutmedescription, String imageurl) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.ocupation = ocupation;
        this.phone = phone;
        this.aboutmedescription = aboutmedescription;
        this.imageurl = imageurl;
    }
    
    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", nombre=" + name + ", apellido=" + lastname + ", email=" + email + ", ocupacion=" + ocupation + ", teléfono=" + phone + ", acerca de mí=" + aboutmedescription + ", imagen URL=" + imageurl + '}';
    }

}

