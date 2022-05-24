package com.dealers.autobuy.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dealers.autobuy.model.Vehicle;
import com.dealers.autobuy.repository.VehicleRepository;

/**
 * Service for Vehicle
 * @author Ali Golkar
 */
@Service
public class VehicleService implements IVehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Transactional(readOnly = true)
    public Vehicle findById(int id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public Collection<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Collection<Vehicle> findAvailableVehicles(String name, String returnLocation, String pickupDate, String returnDate, String vehicleClass) {
        return null;
    }

    @Transactional
    public Vehicle save(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
        return vehicle;
    }

    @Transactional
    public Vehicle update(Vehicle vehicle) {
        Collection<Vehicle> vehicles = findAll();
        for (Vehicle v : vehicles) {
            if (v.getId().equals(vehicle.getId())) {
                vehicleRepository.save(vehicle);
                return vehicle;
            }
        }
        return null;
    }

    @Transactional
    public Integer delete(int id) {
        Collection<Vehicle> vehicles = findAll();
        for (Vehicle v : vehicles) {
            if (v.getId().equals(id)) {
                vehicleRepository.delete(v);
                return id;
            }
        }
        return null;
    }
}
