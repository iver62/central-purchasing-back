package com.apps.centralpurchasing.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Truck implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate purchaseDate;
    @Column(nullable = false, unique = true)
    private String numberPlate;
    @Column(nullable = false)
    private Integer capacity;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Truck truck = (Truck) o;
        return id != null && Objects.equals(id, truck.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
