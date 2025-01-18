package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsManager userDetailsManager (DataSource dataSource){

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define query to retrieve a user by username

        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "SELECT email, password, active from users where email=? "
        );
        // define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "SELECT email, user_role from users where email=?"
        );
        return jdbcUserDetailsManager;

    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(config->
                config
                        .requestMatchers(HttpMethod.GET,"/User/users" ).hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/User/**" ).hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST,"/User" ).permitAll()
                        .requestMatchers(HttpMethod.POST,"/User/login" ).permitAll()
                        .requestMatchers(HttpMethod.PUT,"/User" ).hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/User/**" ).hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET,"/moves/All" ).permitAll()
                        .requestMatchers(HttpMethod.GET,"/moves/title/**" ).permitAll()
                        .requestMatchers(HttpMethod.GET,"/moves/id/**" ).permitAll()
                        .requestMatchers(HttpMethod.POST,"/moves/**" ).hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/moves/**" ).hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/moves/pageable/**" ).permitAll()

                        // Swagger API
                        .requestMatchers("/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/swagger-resources/**",
                                "/webjars/**").permitAll().anyRequest().authenticated()

                        // Moves API


        );

        // use HTTP authentication
        http.httpBasic(Customizer.withDefaults());
        // disable Cross Site Request Forgery (CSRF) protection
        // in general, not required for stateless REST APIs that use POST, PUT, DELETE and PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

}



//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails john = User.builder()
//                .username("admin")
//                .password("{noop}admin123")
//                .roles("admin")
//                .build();
//
//        UserDetails susan = User.builder()
//                .username("user")
//                .password("{noop}user123")
//                .roles("User")
//                .build();
//        return new InMemoryUserDetailsManager(john, susan);
//    }
