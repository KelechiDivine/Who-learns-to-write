package com.whowritesblog.dto;

import javax.persistence.*;
import java.time.LocalDate;

public class RegisterClientDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false)
	private String firstname;
	
	@Column(nullable = false)
	private String lastname;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false, unique = true, length = 11)
	private String phoneNumber;
	
	@Column(nullable = false)
	private LocalDate accountCreationDate;
	
	@Column(nullable = false)
	private String dateOfBirth;
	
	@Column(nullable = false)
	@Transient
	private Integer age;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private String country;
	
	@Column(nullable = false)
	private Boolean isVerified;
	
	
}
