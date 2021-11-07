package com.whowritesblog.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

public class Admin {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String dateOfBirth;

    @Column(nullable = false)
    private String country;

    @Column (nullable = false)
    private String phoneNumber;

}
