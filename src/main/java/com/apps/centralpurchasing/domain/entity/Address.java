package com.apps.centralpurchasing.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private String street;
    private String furtherAddress;
    @Column(nullable = false)
    private int postalCode;
    @Column(nullable = false)
    private String city;
}
