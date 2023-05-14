package com.hackatonLogin.utils;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.hackatonLogin.models.Authority;
import com.hackatonLogin.models.User;
import com.hackatonLogin.repositories.AuthorityRespository;
import com.hackatonLogin.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Runner implements CommandLineRunner {
	
	private final UserRepository userRepository;
	private final AuthorityRespository authorityRepository;

	public Runner(UserRepository userRepository, AuthorityRespository authorityRepository) {
		this.userRepository = userRepository;
		this.authorityRepository = authorityRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		if (this.authorityRepository.count() == 0) {
			this.authorityRepository.saveAll(
				List.of(
					new Authority(AuthorityName.ADMIN), // Creamos la AuthorityName.ADMIN
					new Authority(AuthorityName.READ),  // Creamos la AuthorityName.READ
					new Authority(AuthorityName.WRITE)  // Creamos la AuthorityName.WRITE
				)
			);
			log.info("Authorities values was added!");
		}
		
		// Si no existen usuarios creamos los siguientes
		if (this.userRepository.count() == 0) {
			// Creamos los usuarios:
			//User: david, Pass: 1234, Authority: READ
			this.userRepository.save(
				new User("guillem", new BCryptPasswordEncoder().encode("alumne"), (List<Authority>) List.of(this.authorityRepository.findByName(AuthorityName.READ).get()))
			);
			// User: bernal, Pass: 1234, Authority: WRITE
			this.userRepository.save(
				new User("alpi", new BCryptPasswordEncoder().encode("123"), (List<Authority>) List.of(this.authorityRepository.findByName(AuthorityName.WRITE).get()))
			);
			// User: gonzalez, Pass: 1234, Authority: ADMIN
			this.userRepository.save(
				new User("nacho", new BCryptPasswordEncoder().encode("nacho"), (List<Authority>) List.of(this.authorityRepository.findByName(AuthorityName.ADMIN).get()))
			);
			log.info("Users & relational tabled (N:M) values was added!");
		}

		
	}

}
