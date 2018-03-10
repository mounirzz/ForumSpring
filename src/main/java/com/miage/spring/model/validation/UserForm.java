package com.miage.spring.model.validation;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 
 * @author admin
 *
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@Component
public class UserForm {
	@NotEmpty
	@Email
	private String email;
	@Size(min = 3, max = 20)
	@NotEmpty
	private String username;
	@Size(min = 4, max = 100)
	@NotEmpty
	private String password;
	private String firstname;
	private String lastname;
}
