package com.miage.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	private String oauthId;
	private String username ;
	private String email;
	private String password ;
	private String firstname;
	private String lastname ;
	private String picture = "https://i.imgur.com/yfGGq35.png";
	private boolean enabled = true ;
}
