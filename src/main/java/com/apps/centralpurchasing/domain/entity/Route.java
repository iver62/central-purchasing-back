package com.apps.centralpurchasing.domain.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Route implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDateTime departure;
    private LocalDateTime arrival;
    @ManyToOne
    private Warehouse warehouse;
    @ManyToOne
    private Supermarket supermarket;
    @ManyToOne
    private Truck truck;
    @ManyToOne
    private Driver driver;
    @ManyToOne
    private Supplier supplier;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Route route = (Route) o;
        return id != null && Objects.equals(id, route.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
