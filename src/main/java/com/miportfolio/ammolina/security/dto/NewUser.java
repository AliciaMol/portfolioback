/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.ammolina.security.dto;

import java.util.HashSet;
import java.util.Set;
//import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Sisita
 */
@Getter
@Setter

public class NewUser {

    @NotBlank
    private String name;

    @NotBlank
    private String nameUser;

//    @Email
//    private String email;
    @NotBlank
    private String password;

    private Set<String> roles = new HashSet<>();
    /*al utilizar una API-REST vamos a utilizar JSON, es mejor que los objetos
    tipo JSON sean cadenas. Si el tráfico va a ser ágil*/

}
