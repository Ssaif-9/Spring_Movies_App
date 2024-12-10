package com.ssultan.movieapp.security;

import com.ssultan.movieapp.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final AccountService accountService;

    @Autowired
    public SecurityConfig(AccountService accountService) {
        this.accountService = accountService;
    }

    private final String[] publicurl = {"/",
            "/global-search/**",
            "/register",
            "/register/**",
            "/webjars/***",
            "/resources/**",
            "/assets/**",
            "/css/**",
            "/summernote/**",
            "/js/**",
            "/*.css",
            "/*.js",
            "/*.js.map",
            "/fonts**", "/favicon.ico", "/resources/++", "/error"
    };
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {
        return http.csrf(csrf -> csrf.disable())
                .csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .authenticationProvider(authenticationProvider())
                .authorizeHttpRequests(configurer -> configurer
                        .requestMatchers(publicurl).permitAll() // Allow preflight requests
                        .requestMatchers("/api/v1/auth/login/**").permitAll()
                        .anyRequest().authenticated())
                .formLogin(form->form.loginPage("/login").permitAll())
                .build();
        // http.formLogin(Customizer.withDefaults());
    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {
//       return http    .csrf(Customizer->Customizer.disable())
//                      .cors(Customizer.withDefaults())
//                      .authorizeHttpRequests(configurer -> configurer
//                              .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll() // Allow preflight requests
//                              .requestMatchers("/api/v1/auth/login/**").permitAll()
//                              .requestMatchers("/api/v1/auth/register/**").permitAll()
//                              .requestMatchers("/api/v1/admin/**").hasRole("ADMIN")
//                              .requestMatchers("/api/v1/user/**").hasRole("USER")
//                              .anyRequest().authenticated())
//                      .httpBasic(Customizer.withDefaults())
//                      .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                      .build();
//       // http.formLogin(Customizer.withDefaults());
//    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.addAllowedOriginPattern("*"); // Adjust this in production
        corsConfig.addAllowedMethod("*");
        corsConfig.addAllowedHeader("*");
        corsConfig.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsFilter(source);
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        authProvider.setUserDetailsService(accountService);
        return authProvider;
    }



}
