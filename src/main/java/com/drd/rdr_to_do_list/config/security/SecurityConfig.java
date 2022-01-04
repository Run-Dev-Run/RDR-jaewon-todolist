package com.drd.rdr_to_do_list.config.security;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.*;

import java.util.Map;
import java.util.function.Consumer;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth
        //        .userDetailsService(userDetailsService)
        //        .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) {
        new ConfigureChain(http)
                .configure(this::configureAuthorization)
                .configure(this::configureAuthentication)
                .configure(this::configureSecurity);
    }

    @SneakyThrows
    private void configureAuthorization(HttpSecurity http) {
        http.authorizeRequests()
                .antMatchers( "/**", "/assets/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling();
    }

    @SneakyThrows
    private void configureAuthentication(HttpSecurity http) {
        http.formLogin().disable()
                .httpBasic().disable()
                .userDetailsService(userDetailsService)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @SneakyThrows
    private void configureSecurity(HttpSecurity http) {
        http.cors().and()
                .csrf().disable();
    }

    private static class ConfigureChain {
        private HttpSecurity httpSecurity;

        public ConfigureChain(final HttpSecurity httpSecurity) {
            this.httpSecurity = httpSecurity;
        }

        public ConfigureChain configure(Consumer<HttpSecurity> configureFunc) {
            configureFunc.accept(httpSecurity);
            return this;
        }
    }
}
