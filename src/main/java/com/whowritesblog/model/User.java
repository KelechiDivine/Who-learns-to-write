package com.whowritesblog.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false)
	private String firstname;
	
	@Column(nullable = false)
	private String lastname;

	@Column(nullable = false, unique = true, length = 11)
	private String phoneNumber;

	@Column(nullable = false)
	private String dateOfBirth;

	@Column(nullable = false)
	private String country;
	
	@Column(nullable = false)
	private Boolean isVerified;
}
