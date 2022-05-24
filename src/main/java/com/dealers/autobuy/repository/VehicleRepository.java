package com.dealers.autobuy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dealers.autobuy.model.Vehicle;

/**
 * Repository for Vehicle
 * @author Ali Golkar
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    /**
     * find by vehicle Id
     * @param id vehicle Id
     * @return Vehicle
     */
    Optional<Vehicle> findById(int id);
}
