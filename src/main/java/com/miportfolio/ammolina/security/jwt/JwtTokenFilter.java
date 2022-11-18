/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.ammolina.security.jwt;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.userdetails.UserDetails;
import com.miportfolio.ammolina.security.service.UserDetailsServiceImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author Sisita Esta clase se va a ejecutar por cada petición, comprobará que
 * sea válido el token (validación usando el provider) y en caso de que sea
 * válido va a permitir el acceso y en caso contrario lanza una excepción.
 */
public class JwtTokenFilter extends OncePerRequestFilter {

    private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String token = getToken(request);
            if (token != null && jwtProvider.validateToken(token)) {    //Comprobamos que el token existe y que es válido
                String nameUser = jwtProvider.getNameUserFromToken(token);  //a partir del token obtenemos el usuario
                UserDetails userDetails = userDetailsService.loadUserByUsername(nameUser);  // y creamos el userDetail y lo autenticamos una vez
                UsernamePasswordAuthenticationToken auth
                        = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                //además de la autenticación necesitamos la autorización, saber quién es quién y a qué
                //recursos puede acceder.
                //Al contexto de autenticación le vamos a asignar ese usuario
                SecurityContextHolder.getContext().setAuthentication(auth);
            }

        } catch (Exception e) {
            logger.error("fail en el metodo doFilter" + e.getMessage());
        }

        filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer")) {
            return header.replace("Bearer ", "");
        }
        return null;
    }
}
