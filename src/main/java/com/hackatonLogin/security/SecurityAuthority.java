package com.hackatonLogin.security;

import org.springframework.security.core.GrantedAuthority;

import com.hackatonLogin.models.Authority;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {


	private static final long serialVersionUID = 7280971173508780317L;

	private final Authority authority;
	
	@Override
	public String getAuthority() {
		// Retonará el valor del autorityName contenido en la propiedad user
		return authority.getName().toString(); 
	}
}
