/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miportfolio.ammolina.security.jwt;

import com.miportfolio.ammolina.security.entity.Admin;
import io.jsonwebtoken.*;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 *
 * @author Sisita Esta clase va a generar el token, posee un método de
 * validación para corroborar que esté bien formado ni expirado.
 */
@Component
public class JwtProvider {

    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    //Estos dos valores son los que definimos en el application.propierties
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public String generateToken(Authentication authentication) {
        Admin admin = (Admin) authentication.getPrincipal();
        return Jwts.builder().setSubject(admin.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 10000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
        //con todo esto hemos generado el token
    }

    public String getNameUserFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().
                getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
            //Si se ha validado devuelve true, caso contrario, entra al catch correspondiente.
        } catch (MalformedJwtException e) {
            logger.error("Token mal formado");
        } catch (UnsupportedJwtException e) {
            logger.error("Token no soportado");
        } catch (ExpiredJwtException e) {
            logger.error("Token expirado");
        } catch (IllegalArgumentException e) {
            logger.error("Token vacío");
        } catch (SignatureException e) {
            logger.error("Fallo en la firma");
        }
        return false;
    }
}
