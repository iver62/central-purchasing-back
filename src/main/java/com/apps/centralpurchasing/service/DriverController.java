package com.apps.centralpurchasing.service;

import com.apps.centralpurchasing.business.DriverServiceImpl;
import com.apps.centralpurchasing.domain.entity.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("driver")
public class DriverController {

    private final DriverServiceImpl driverService;

    @Autowired
    public DriverController(DriverServiceImpl driverService) {
        this.driverService = driverService;
    }

    /**
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public ResponseEntity<Driver> getDriver(@PathVariable long id) {
        Driver driver = driverService.getOne(id);
        if (Objects.isNull(driver)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(driver);
    }

    /**
     * @param page
     * @param size
     * @param property
     * @param direction
     * @return
     */
    public ResponseEntity<Page<Driver>> getDrivers(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "property", defaultValue = "name") String property,
            @RequestParam(value = "direction", defaultValue = "asc") String direction) {
        Sort.Direction dir = direction.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        return ResponseEntity.ok(driverService.getAll(PageRequest.of(page, size, Sort.by(dir, property))));
    }

    /**
     * @param driver
     * @return
     */
    @PostMapping
    public ResponseEntity<Driver> createDriver(@Valid @RequestBody Driver driver) {
        return ResponseEntity.ok(driverService.create(driver));
    }

    /**
     * @param id
     * @param driver
     * @return
     */
    @PutMapping("{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable long id, @Valid @RequestBody Driver driver) {
        return ResponseEntity.ok(driverService.update(id, driver));
    }

    /**
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable long id) {
        driverService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
