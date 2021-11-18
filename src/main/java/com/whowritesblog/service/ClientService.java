package com.whowritesblog.service;

import com.whowritesblog.dto.RegisterClientDto;

import java.util.List;

public interface ClientService {
    void createClient(RegisterClientDto clientDto);
    void deleteClientById(Integer id);
    RegisterClientDto updateClient(RegisterClientDto clientDto);
    List<RegisterClientDto> findAll();
    RegisterClientDto findById(Integer id);
}
