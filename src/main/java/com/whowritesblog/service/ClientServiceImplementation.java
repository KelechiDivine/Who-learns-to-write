package com.whowritesblog.service;

import com.whowritesblog.dto.RegisterClientDto;
import com.whowritesblog.dto.UpdateClientDto;
import com.whowritesblog.exception.ClientException;
import com.whowritesblog.model.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j

public class ClientServiceImplementation implements ClientService{
	
	@Override
	public void registerClient(RegisterClientDto registerClientDto) throws ClientException {
	
	}
	
	@Override
	public Client findClientById(String id) {
		return null;
	}
	
	@Override
	public void updateClient(UpdateClientDto updateClientDto) throws ClientException {
	
	}
	
	@Override
	public List<Client> findAllClient() {
		return null;
	}
	
	@Override
	public void deleteClient(String id) {
	
	}
}
