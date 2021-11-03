package com.whowritesblog.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class ChatHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false, unique = true)
	private Integer chatId;
	
	@Column(nullable = false)
	private LocalDate dateSaved;
	
	@Column(nullable = false)
	private Boolean isDeleted;
}
