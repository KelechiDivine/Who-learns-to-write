package com.whowritesblog.service;

import com.whowritesblog.dto.RegisterClientDto;
import com.whowritesblog.dto.UpdateClientDto;
import com.whowritesblog.exception.ClientException;
import com.whowritesblog.model.Client;

import java.util.List;

public interface ClientService {
	
	void registerClient(RegisterClientDto registerClientDto) throws ClientException;
	
	Client findClientById(String id);
	
	void updateClient(UpdateClientDto updateClientDto) throws ClientException;
	
	List<Client> findAllClient();
	
	void deleteClient(String id);
	
}
