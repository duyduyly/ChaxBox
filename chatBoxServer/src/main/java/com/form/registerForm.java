package com.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class registerForm {

	private String username;
	private String password;
	private String confirmPassword;
	private String name;
	
	
	
	@Override
	public String toString() {
		return "registerForm [username=" + username + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ "]";
	}

	
	
}
