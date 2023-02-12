package com.apps.centralpurchasing.business;

import com.apps.centralpurchasing.domain.entity.Driver;
import com.apps.centralpurchasing.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl extends AbstractCrudServiceImpl<Driver> {

    private final DriverRepository driverRepository;

    @Autowired
    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    protected JpaRepository<Driver, Long> getRepository() {
        return driverRepository;
    }
}
