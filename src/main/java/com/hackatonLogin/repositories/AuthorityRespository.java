package com.hackatonLogin.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackatonLogin.models.Authority;
import com.hackatonLogin.utils.AuthorityName;

public interface AuthorityRespository extends JpaRepository<Authority, Long> {
	Optional<Authority> findByName(AuthorityName name);

}
