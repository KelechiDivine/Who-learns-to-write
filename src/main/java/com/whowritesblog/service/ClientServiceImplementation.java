package com.whowritesblog.service;

import com.whowritesblog.dto.UpdateClientDto;
import com.whowritesblog.exception.ClientException;
import com.whowritesblog.model.Client;
import com.whowritesblog.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;


@Service
@Slf4j

public class ClientServiceImplementation implements ClientService{
	
	@Autowired
	private ClientRepository clientRepository;
	
	private Client client;
	
	
	public boolean clientDoesNotExistById(Integer id){
		return  !clientRepository.existsById(id);
	}
	
	public boolean clientDoesNotExistByPhoneNumber(String phoneNumber){
		return !clientRepository.existsByPhoneNumber(phoneNumber);
	}
	
	@Override
	public void registerClient(Client client, String url) throws ClientException {
		
		client.setFirstname(client.getFirstname());
		client.setLastname(client.getLastname());
		client.setEmail(client.getEmail());
		client.setIsVerified(false);
		client.setCountry(client.getCountry());
		client.setAddress(client.getAddress());
		client.setAge(client.getAge());
		client.setPhoneNumber(client.getPhoneNumber());
		client.setDateOfBirth(client.getDateOfBirth());
		client.setAccountCreationDate(LocalDate.now());
		client.setId(client.getId());
		
		clientRepository.save(client);
	}
	
	@Override
	public Client findClientById(Integer id) {
		return clientRepository.findById(id).orElse(null);
	}
	
	@Override
	public Client findClientByEmail(String email) {
		return clientRepository.findByEmail(email);
	}
	
	@Override
	public void updateClient(UpdateClientDto updateClientDto) throws ClientException {
		Client existingClient = clientRepository.findById(updateClientDto.getId()).orElse(new Client());
		
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		mapper.map(updateClientDto, existingClient);
		
		existingClient.setAccountCreationDate(LocalDate.now());
		clientRepository.updateClient(existingClient);
		
	}
	
	@Override
	public List<Client> findAllClient() {
		return clientRepository.findAll();
	}
	
	@Override
	public void deleteClient(Integer id) throws ClientException {
		client = clientRepository.findById(id).orElse(null);
		assert client != null;
		
		if (!client.getIsActive()){
			throw new ClientException("You can't update a client account that has been deleted");
		}
		clientRepository.deleteById(id);
	}
}
