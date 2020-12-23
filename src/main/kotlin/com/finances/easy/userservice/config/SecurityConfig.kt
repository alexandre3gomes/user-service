package com.finances.easy.userservice.config

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

class SecurityConfig : WebSecurityConfigurerAdapter() {

    @Bean
    fun configure(http: ServerHttpSecurity): SecurityWebFilterChain {
        http
            .cors()
            .and()
            .csrf()
            .disable()
            .authorizeExchange()
            .pathMatchers("/")
            .hasAnyRole()
            .anyExchange()
            .authenticated()
            .and()
            .oauth2ResourceServer()
            .jwt()
        return http.build()
    }

}
