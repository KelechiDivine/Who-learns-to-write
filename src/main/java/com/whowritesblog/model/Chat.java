package com.whowritesblog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class Chat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false)
	private String message;
	
	@Column(nullable = false, unique = true)
	private Integer clientId;
	
	@Column(nullable = false)
	private Reaction reaction;
	
	@Column(nullable = false)
	private LocalDate dateCreated;
	
}
