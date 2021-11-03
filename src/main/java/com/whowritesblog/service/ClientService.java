package com.whowritesblog.service;

import com.whowritesblog.dto.RegisterClientDto;
import com.whowritesblog.dto.UpdateClientDto;
import com.whowritesblog.exception.ClientException;
import com.whowritesblog.model.Client;

import java.util.List;

public interface ClientService {
	
	void registerClient(Client client) throws ClientException;
	
	Client findClientById(Integer id);
	
	Client findClientByEmail(String email);
	void updateClient(UpdateClientDto updateClientDto) throws ClientException;
	
	List<Client> findAllClient();
	
	void deleteClient(Integer id) throws ClientException;
	
}
