package com.miage.spring.config;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogConfigurationException;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.google.common.collect.Sets;
import com.miage.spring.config.security.UserDetailsImpl;
import com.miage.spring.model.Role;
import com.miage.spring.model.User;
import com.miage.spring.model.UserOrigin;
import com.miage.spring.repository.RoleRepository;
import com.miage.spring.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class OAuthConfig {
	private Log log;
	private UserRepository userRepository ;
	private RoleRepository roleRepository ;
	@Autowired
	public OAuthConfig(UserRepository userRepository , RoleRepository roleRepository) {
		this.userRepository = userRepository ;
		this.roleRepository = roleRepository ;
	}
	/**
	 * This Bean is used to extract OAuth2 connection information 
	 * and then save them to DB. By using this extractor we make sure that
	 * we can always map an user (coming from OAuth or from classic registration) to 
	 * a know MyPrincipal interface. this allows us to use the @CurrentUSer
	 * annotation in our controller to always retrieve a Principal with a know implementation 
	 * (and also decoupling from Spring Security).
	 */
	@Bean
	public PrincipalExtractor principalExtractor() {
		return map ->{
			String oauthId= (String) map.get("sub");
			 
			User user = userRepository.eagerFindByOauthId(oauthId);
			if(user == null) {
				log.info("Mapping google user and saving it to DB");
				user = new User();
				Role userRole = roleRepository.findByRole("ROLE_USER");
			/*	user.setEmail((String) map.get("email"))
				.setOauthId((String) map.get("sub")).setUsername((String) map.get("name"))
				.setFirstname((String) map.get("given_name"))
				.setLastname((String) map.get("family_name"))
				.setPicture((String) map.get("picture"))
				.setRoles(Sets.newHashSet(userRole))
				.setOrigin(UserOrigin.GOOGLE);*/
			}else {
				log.info("Google auth exixsting user found, updating profile pic");
				// we will update picture every time to make sure our data is fresh
				user.setPicture((String) map.get("picture"));
			}
		
		User saved = userRepository.save(user);
		saved.setPassword("");// To prevent error with UserDetails super() call
		return new UserDetailsImpl(saved, getAuthorities(saved.getRoles()));
		
	};
}
	private Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles){
		List<GrantedAuthority> authorities = new ArrayList<>(roles.size());
		for(Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return authorities ;
	}
	
}
