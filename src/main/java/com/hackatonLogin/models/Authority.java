package com.hackatonLogin.models;

import com.hackatonLogin.utils.AuthorityName;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "authorities")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Authority {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private AuthorityName name;

	public Authority( AuthorityName name) {
		this.name = name;
	}
	
	
}