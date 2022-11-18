/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.ammolina.security.dto;

import java.util.Collection;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Sisita A esta clase la vamos a usar en el momento que hagamos un
 * login, nos va a devoler un json web token con varios campos
 */
@Getter
@Setter
public class JwtDto {

    private String token;
    private String bearer = "Bearer";
    private String nameUser;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtDto(String token, String nameUser, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.nameUser = nameUser;
        this.authorities = authorities;
    }
}
