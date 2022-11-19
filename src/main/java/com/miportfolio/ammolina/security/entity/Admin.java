/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.ammolina.security.entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Sisita Esta clase va a ser la que se encargue de tener la seguridad,
 * podría ser en la clase User pero separamos las responsabilidades. Esta clase
 * va a implementar el tema de los privilegios de cada usuario, convierte la
 * clase rol en authorities
 */
public class Admin implements UserDetails {

    private String name;
    private String nameUser;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public Admin(String name, String nameUser, String password, Collection<? extends GrantedAuthority> authorities) {
        this.name = name;
        this.nameUser = nameUser;
        this.password = password;
        this.authorities = authorities;
    }
    /**
     * Este método va a asignar los privilegos a cada usuario. le pasamos como
     * parámetro lleva un usuario principal que representa a la entidad de la
     * base de datos, que es el que usamos para saber los privilegios de cada
     * usuario.
     *
     * @return
     */
    public static Admin build(User user) {
        List<GrantedAuthority> authorities;
        authorities
                = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.
                getRolName().name())).collect(Collectors.toList());

        return new Admin(user.getName(), user.getNameUser(),
                user.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nameUser;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getName() {
        return name;
    }
}