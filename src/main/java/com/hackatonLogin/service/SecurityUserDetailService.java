package com.hackatonLogin.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hackatonLogin.models.User;
import com.hackatonLogin.repositories.UserRepository;
import com.hackatonLogin.security.SecurityUser;

@Service
public class SecurityUserDetailService implements UserDetailsService {
	private final UserRepository userRepository;

	// Inyectamos una instancia de userRepository dentro del constructor de la clase
	public SecurityUserDetailService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Obtenemos el usuario mediante al método findByUserName
		Optional<User> optUser = this.userRepository.findByUsername(username);

		// Si existe retornamos un user creado a partir del usuario
		if (optUser.isPresent()) {
			return new SecurityUser(optUser.get());
		}
		// En el caso de que no existe el usuario, lanzamos una excepción de tipo
		// UsernameNotFoundExcelption
		throw new UsernameNotFoundException("User not found: " + username);
	}
}
