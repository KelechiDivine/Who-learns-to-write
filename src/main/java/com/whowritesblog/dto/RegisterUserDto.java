package com.whowritesblog.dto;

import lombok.Data;

import javax.persistence.*;
@Data
public class RegisterUserDto {
	
	@Id
	@Column(nullable = false, unique = true, length = 11)
	private String phoneNumber;

	@Column(nullable = false)
	private String firstname;
	
	@Column(nullable = false)
	private String lastname;
	
	@Column(nullable = false)
	private String dateOfBirth;
	
	@Column(nullable = false)
	private String country;
	
	@Column(nullable = false)
	private Boolean isVerified;
}
