package com.miage.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * A USer can have Many roles, such as ROLE_ADMIN or ROLE_USER
 * 
 * @author admin
 *
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@Entity
public class Role implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String role;
}
