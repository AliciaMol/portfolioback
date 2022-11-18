/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.ammolina.security.jwt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 *
 * @author Sisita * Esta clase va a comprobar si hay un token, sino, devuelve un
 * 401 no autorizado.
 */
@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {

    //Vamos a poner un loger para ver qué método está dando error en caso que no
    //funcione la aplicación
    private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {
        logger.error("Fallo en el método commence.");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "not authorized");
    }
}
