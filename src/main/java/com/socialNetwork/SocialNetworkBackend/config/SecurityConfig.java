package com.socialNetwork.SocialNetworkBackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
public class SecurityConfig {

    private final UserAuthenticationEntryPoint userAuthenticationEntryPoint;
    private final UserAuthenticationProvider userAuthenticationProvider;

    public SecurityConfig(UserAuthenticationEntryPoint userAuthenticationEntryPoint,
                          UserAuthenticationProvider userAuthenticationProvider) {
        this.userAuthenticationEntryPoint = userAuthenticationEntryPoint;
        this.userAuthenticationProvider = userAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http
    		.exceptionHandling().authenticationEntryPoint(userAuthenticationEntryPoint)
    		.and()
    		.addFilterBefore(new UsernamePasswordAuthFilter(userAuthenticationProvider), BasicAuthenticationFilter.class)
    		.addFilterBefore(new JwtAuthFilter(userAuthenticationProvider), UsernamePasswordAuthFilter.class)
    		// .csrf().disable()
    		.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
    		.and()
    		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    		.and()
    		.authorizeHttpRequests()
    		.requestMatchers(HttpMethod.GET, "/v1/csrf").permitAll()
			.requestMatchers(HttpMethod.POST, "/v1/signIn", "/v1/signUp").permitAll()
    		.anyRequest().authenticated();
    	return http.build();
    }
    
}
