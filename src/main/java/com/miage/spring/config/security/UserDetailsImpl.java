package com.miage.spring.config.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.miage.spring.config.MyPrincipal;
import com.miage.spring.model.User;
import com.miage.spring.model.UserOrigin;

public class UserDetailsImpl extends User implements MyPrincipal {

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
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isFromDB() {
		// TODO Auto-generated method stub
		return false;
	}
	public UserDetailsImpl(User user,Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.origin = origin;
	}


}
