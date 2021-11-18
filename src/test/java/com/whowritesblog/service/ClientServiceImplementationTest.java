package com.whowritesblog.service;

import com.whowritesblog.model.Client;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientServiceImplementationTest {

    ClientService service;
    @BeforeEach
    public void setUp() {
        service = new ClientServiceImplementation();
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void createClient() {
        Client client = new Client();
        client.setFirstname("Mojoyin");
        client.setLastname("Toye");
        client.setAddress("Esther");
    }

    @Test
    public void deleteClientById() {
    }

    @Test
    public void updateClient() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findById() {
    }
}