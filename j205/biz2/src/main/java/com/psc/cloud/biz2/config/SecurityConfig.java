package com.psc.cloud.biz2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authorization.HttpStatusServerAccessDeniedHandler;
import reactor.core.publisher.Mono;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
		http.authorizeExchange(exchanges -> exchanges
				.pathMatchers("/api/profile").permitAll()
				.pathMatchers("/api/client_a").hasAnyAuthority("SCOPE_CLIENT_A")
				.pathMatchers("/api/client_b").hasAnyAuthority("SCOPE_CLIENT_B")


				.anyExchange().authenticated()



		)
				.oauth2ResourceServer(oauth2 -> oauth2
						.jwt(withDefaults())
				).exceptionHandling().accessDeniedHandler(new HttpStatusServerAccessDeniedHandler(HttpStatus.OK)

		)
				.and()
				.csrf().disable();
		return http.build();
	}
}
