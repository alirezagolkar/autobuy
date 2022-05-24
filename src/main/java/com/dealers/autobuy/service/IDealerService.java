package com.dealers.autobuy.service;

import java.util.Collection;
import org.springframework.stereotype.Service;
import com.dealers.autobuy.model.Dealer;

/**
 * Interface for Dealer Service
 * @author Ali Golkar
 */
@Service
public interface IDealerService {

    Dealer findById(int id);

    Collection<Dealer> findAll();

    Collection<Dealer> findAvailableVehicles(String name, String returnLocation, String pickupDate, String returnDate, String vehicleClass);

    Dealer save(Dealer dealer);

    Dealer update(Dealer dealer);

    Integer delete(int id);
}
