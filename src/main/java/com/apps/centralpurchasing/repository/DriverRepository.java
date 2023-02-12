package com.apps.centralpurchasing.repository;

import com.apps.centralpurchasing.domain.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
