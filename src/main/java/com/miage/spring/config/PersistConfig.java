package com.miage.spring.config;

import org.apache.tomcat.jni.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@EnableJpaAuditing
public class PersistConfig {
	@Bean
	public AuditorAware<User> auditorProvider(){
		return () -> {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
				MyPrincipal principal = (MyPrincipal) authentication.getPrincipal();
				return new User();
			}
			//will be System account created in seeder
			return new User();
		};
	}
}
