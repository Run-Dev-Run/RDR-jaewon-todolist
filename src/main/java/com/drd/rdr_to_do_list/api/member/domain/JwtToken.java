package com.drd.rdr_to_do_list.api.member.domain;

import com.drd.rdr_to_do_list.config.security.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class JwtToken {
    private final String token;

    private JwtToken(final String token) {
        this.token = token;
    }

    public String token() {
        return token;
    }

    public static Optional<JwtToken> fromHttpServletRequest(HttpServletRequest request) {
        return Optional.ofNullable(WebUtils.getCookie(request, "X-AUTH-TOKEN"))
                .map(Cookie::getValue)
                .map(JwtToken::new);
    }

    public void validate() {
        try {
            parsedClaimsJws(token);
        } catch (Exception e) {
            // TODO Exception
            e.printStackTrace();
        }
    }

    private Jws<Claims> parsedClaimsJws(final String tokenValue) {
        return Jwts.parser()
                .setSigningKey(JwtConfig.SECRET_KEY())
                .parseClaimsJws(tokenValue);
    }
}
