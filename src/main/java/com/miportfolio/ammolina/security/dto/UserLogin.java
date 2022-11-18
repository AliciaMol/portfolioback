/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.ammolina.security.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Sisita
 */
@Getter
@Setter
public class UserLogin {

    @NotBlank
    private String nameUser;

    @NotBlank
    private String password;
}
