package com.whowritesblog.model;

import javax.persistence.*;
import java.time.LocalDate;

public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDate accountCreationDate;

    @Column(nullable = false)
    private Boolean hasBeenRead;

}
