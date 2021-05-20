package com.psc.cloud.biz2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authorization.HttpStatusServerAccessDeniedHandler;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebFluxSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig  {

	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
		http.authorizeExchange(exchanges ->
				exchanges
						.pathMatchers("/api/profile").authenticated()
						.pathMatchers("/api/client_a").hasAnyAuthority("SCOPE_CLIENT_A")
						.pathMatchers("/api/client_b").hasAnyAuthority("SCOPE_CLIENT_B")

		).oauth2ResourceServer(oauth2 -> oauth2
				.jwt(withDefaults())
				.and()
				.exceptionHandling().accessDeniedHandler(new HttpStatusServerAccessDeniedHandler(HttpStatus.OK))
		);

		return http.build();
	}
}
