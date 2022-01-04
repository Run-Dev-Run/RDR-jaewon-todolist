package com.drd.rdr_to_do_list.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {
    @Value("${jwt.secret-key}")
    private static String SECRET_KEY;
    @Value("${jwt.token-name}")
    private static String TOKEN_NAME;
    private static long TOKEN_EXPIRATION;
    @Value("jwt.authorities-key")
    private static String AUTHORITIES_KEY;

    public JwtConfig(@Value("${jwt.token-expiration}") long tokenExpiration) {
        JwtConfig.TOKEN_EXPIRATION = tokenExpiration * 1000;
    }

    public static String SECRET_KEY() {
        return SECRET_KEY;
    }

    public static long TOKEN_EXPIRATION() {
        return TOKEN_EXPIRATION;
    }

    public static String TOKEN_NAME() {
        return TOKEN_NAME;
    }

    public static String AUTHORITIES_KEY() {
        return AUTHORITIES_KEY;
    }
}
