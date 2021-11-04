package com.whowritesblog.controller;

import com.whowritesblog.dto.RegisterClientDto;
import com.whowritesblog.exception.ClientException;
import com.whowritesblog.model.Client;
import com.whowritesblog.repository.ClientRepository;
import com.whowritesblog.service.ClientService;
import com.whowritesblog.service.ClientServiceImplementation;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@Slf4j
@RequestMapping("/api/clients")

public class ClientController {
	
	
	@Autowired
	private ClientServiceImplementation clientServiceImplementation;
	
	private Client client;
	
	@Autowired
	private ClientRepository clientRepository;
	
	
	ModelMapper modelMapper = new ModelMapper();
	
	@PostMapping("")
	public ResponseEntity<?> registerClient(@Valid @RequestBody RegisterClientDto registerClientDto, HttpServletRequest httpServletRequest) throws ClientException {
		if (clientServiceImplementation.clientDoesNotExistByPhoneNumber(registerClientDto.getPhoneNumber())){
			String url = httpServletRequest.getRequestURL().toString().replace(httpServletRequest.getServletPath(), "");
			
			client = modelMapper.map(registerClientDto, Client.class);
			clientServiceImplementation.registerClient(client, url);
		}
		
		else {
			throw new ClientException("A client with phone number" + registerClientDto.getPhoneNumber() + " already exist.");
		}
	
		ResponseDetails responseDetails = new ResponseDetails(LocalDate.now(), "Client account created successfully.", HttpStatus.OK.toString());
		
		return ResponseEntity.status(200).body(responseDetails);
	}

}
