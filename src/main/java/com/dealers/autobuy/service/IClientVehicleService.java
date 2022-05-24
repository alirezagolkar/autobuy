package com.dealers.autobuy.service;

import org.springframework.stereotype.Service;
import com.dealers.autobuy.model.ClientVehicle;

/**
 * Interface for ClientVehicle Service
 * @author Ali Golkar
 */
@Service
public interface IClientVehicleService {

    ClientVehicle findByClientIdAndVehicleId(int clientId, int vehicleId);

    ClientVehicle findTopByVehicleOrderByBidPriceDesc(int vehicleId);

    ClientVehicle save(ClientVehicle dealer);

    ClientVehicle update(ClientVehicle dealer);

    void delete(int clientId, int vehicleId);
}
