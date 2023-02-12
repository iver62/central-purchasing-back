package com.apps.centralpurchasing.domain.entity;

import com.apps.centralpurchasing.domain.Geolocation;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Warehouse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Integer surface;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Warehouse warehouse = (Warehouse) o;
        return id != null && Objects.equals(id, warehouse.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
