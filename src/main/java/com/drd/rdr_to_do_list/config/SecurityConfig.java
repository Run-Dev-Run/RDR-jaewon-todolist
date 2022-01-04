package com.drd.rdr_to_do_list.config;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.*;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder(@Value("${encoder.idForEncode}") String idForEncode) {
        return new DelegatingPasswordEncoder(idForEncode, Map.of(
                "noop", new BCryptPasswordEncoder(),
                "bcrypt", new BCryptPasswordEncoder(),
                "pbkdf2", new Pbkdf2PasswordEncoder()
        ));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth
        //        .userDetailsService(userDetailsService)
        //        .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) {
        ConfigureChain config = new ConfigureChain(http);

        config.configure(this::configureAuthorize)
                .configure(this::configureCsrf)
                .configure(this::configureLogin)
                .configure(this::configureLogout);
    }

    @SneakyThrows
    private void configureCsrf(HttpSecurity http) {
        http.csrf().disable();
    }

    @SneakyThrows
    private void configureAuthorize(HttpSecurity http) {
        http.authorizeRequests()
                .antMatchers( "/**", "/assets/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling();
    }

    @SneakyThrows
    private void configureLogin(HttpSecurity http) {
        http
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .exceptionHandling();
    }

    @SneakyThrows
    private void configureLogout(HttpSecurity http) {
        http
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("remember-me", "JSESSIONID")
                .and()
                .exceptionHandling();
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
