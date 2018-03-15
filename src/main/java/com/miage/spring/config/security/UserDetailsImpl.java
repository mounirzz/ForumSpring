package com.miage.spring.config.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.miage.spring.config.MyPrincipal;
import com.miage.spring.model.User;
import com.miage.spring.model.UserOrigin;

public class UserDetailsImpl extends org.springframework.security.core.userdetails.User implements MyPrincipal {

	private Long id; 
	private String name ; 
	private String email ;
	private UserOrigin origin;
	
	
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}
	@Override
	public boolean isAdmin() {
		return getAuthorities().stream().anyMatch(authority->authority.getAuthority().equals("ROLE_ADMIN"));
	}
	@Override
	public boolean isFromDB() {
		return origin.equals(UserOrigin.DB);
	}
	public UserDetailsImpl(User user,Collection<? extends GrantedAuthority> authorities) {
		super(user.getUsername(), user.getPassword(), authorities);
		this.id = user.getId();
		this.name = user.getUsername();
		this.email = user.getEmail();
		this.origin = user.getOrigin();
	}


}
