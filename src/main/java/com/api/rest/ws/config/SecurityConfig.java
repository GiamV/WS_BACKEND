package com.api.rest.ws.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	

	private final UserAuthenticationEntryPoint userAuthenticationEntryPoint;

	private final UserAuthProvider userAuthProvider;
	
    public SecurityConfig(UserAuthenticationEntryPoint userAuthenticationEntryPoint, 
            UserAuthProvider userAuthProvider) {
this.userAuthenticationEntryPoint = userAuthenticationEntryPoint;
this.userAuthProvider = userAuthProvider;
}
	
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.exceptionHandling()
            .authenticationEntryPoint(userAuthenticationEntryPoint)
            .and()
            .addFilterBefore(new JwtAuthFilter(userAuthProvider), BasicAuthenticationFilter.class)
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers(HttpMethod.POST, "/Login", "/register", "/api/password/request", "/api/password/reset").permitAll()
                .requestMatchers(HttpMethod.GET, "/perfil/correo").permitAll()  // Permitimos GET en /api/public/** para todos
                .anyRequest().authenticated()  // El resto de las solicitudes requieren autenticación
            );

        return http.build();
    }


}
