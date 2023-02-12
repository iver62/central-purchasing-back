package com.apps.centralpurchasing.domain.entity;

import com.apps.centralpurchasing.domain.Geolocation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Supplier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String address;
    @Email
    private String email;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    @Transient
    private Geolocation geolocation;
    private String description;
}
