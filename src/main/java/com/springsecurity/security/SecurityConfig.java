package com.springsecurity.security;

import com.springsecurity.filter.CustomAuthenticationFilter;
import com.springsecurity.filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String LOGIN = "/login/**";
    public static final String USERS = "/users/**";
    public static final String USERS_ADD_ROLE = "/users/addrole/**";
    public static final String ROLES = "/roles/**";
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_DEV = "DEV";
    public static final String ROLE_QA = "QA";

    private static final String[] AUTH_WHITELIST = {
            // -- Swagger UI v2
            "/v2/api-docs",
            "/configuration/ui",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/v3/api-docs/**",
            "/swagger-ui/**"
    };

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Value("${spring-security.key-word}")
    private String secret;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("Secrete word: {}", secret);

        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean(), secret);
        customAuthenticationFilter.setFilterProcessesUrl(LOGIN);

        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers(LOGIN).permitAll();
        http.authorizeRequests().antMatchers("/swagger/**").permitAll();
        http.authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST, USERS).hasAnyAuthority(ROLE_ADMIN, ROLE_DEV, ROLE_QA);
        http.authorizeRequests().antMatchers(HttpMethod.POST, USERS_ADD_ROLE).hasAnyAuthority(ROLE_ADMIN, ROLE_DEV, ROLE_QA);
        http.authorizeRequests().antMatchers(HttpMethod.GET, USERS).hasAnyAuthority(ROLE_ADMIN, ROLE_DEV, ROLE_QA);
        http.authorizeRequests().antMatchers(HttpMethod.POST, ROLES).hasAnyAuthority(ROLE_ADMIN, ROLE_DEV, ROLE_QA);
        http.authorizeRequests().antMatchers(HttpMethod.GET, ROLES).hasAnyAuthority(ROLE_ADMIN, ROLE_DEV, ROLE_QA);
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(secret), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}