package com.dealers.autobuy.service;

import java.util.Collection;

import com.dealers.autobuy.model.Vehicle;

/**
 * Interface for Vehicle Service
 * @author Ali Golkar
 */
public interface IVehicleService {

    Vehicle findById(int id);

    Collection<Vehicle> findAll();

    Vehicle save(Vehicle vehicle);

    Vehicle update(Vehicle vehicle);

    Integer delete(int id);
}
