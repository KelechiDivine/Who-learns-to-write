package com.whowritesblog.repository;

import com.whowritesblog.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
	
	default void updateClient(Client client){
		client.setAccountCreationDate(LocalDate.now());
		save(client);
	}
	
}
