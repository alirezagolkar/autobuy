package com.dealers.autobuy.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dealers.autobuy.model.ClientVehicle;
import com.dealers.autobuy.repository.ClientVehicleRepository;

/**
 * Service for ClientVehicle
 * @author Ali Golkar
 */
@Service
public class ClientVehicleService implements IClientVehicleService {

    @Autowired
    private ClientVehicleRepository clientVehicleRepository;

    @Transactional(readOnly = true)
    public ClientVehicle findByClientIdAndVehicleId(int clientId, int vehicleId) {
        return clientVehicleRepository.findByClientIdAndVehicleId(clientId, vehicleId).orElse(null);
    }

    @Transactional(readOnly = true)
    public ClientVehicle findTopByVehicleOrderByBidPriceDesc(int vehicleId) {
        return clientVehicleRepository.findTopByVehicleIdOrderByBidPriceDesc(vehicleId).orElse(null);
    }

    @Transactional
    public ClientVehicle save(ClientVehicle clientVehicle) {
        clientVehicleRepository.save(clientVehicle);
        return clientVehicle;
    }

    @Transactional
    public ClientVehicle update(ClientVehicle clientVehicle) {
        if (clientVehicle != null) {
            clientVehicleRepository.save(clientVehicle);
            return clientVehicle;
        }
        return null;
    }

    @Transactional
    public void delete(int clientId, int vehicleId) {
        ClientVehicle clientVehicle = findByClientIdAndVehicleId(clientId, vehicleId);
        if (clientVehicle != null) {
            clientVehicleRepository.delete(clientVehicle);
        }
    }
}
