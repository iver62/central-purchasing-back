package com.apps.centralpurchasing.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Driver implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private String firstname;
    private LocalDate birthDate;
    @Column(nullable = false)
    private LocalDate recruitmentDate;
    @Column(nullable = false)
    private String phoneNumber;
    @Email
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_address", nullable = false)
    private Address address;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Driver driver = (Driver) o;
        return id != null && Objects.equals(id, driver.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
