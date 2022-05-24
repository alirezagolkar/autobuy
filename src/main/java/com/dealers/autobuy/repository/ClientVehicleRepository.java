package com.dealers.autobuy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dealers.autobuy.model.ClientVehicle;

/**
 * Repository for ClientVehicle
 * @author Ali Golkar
 */
@Repository
public interface ClientVehicleRepository extends JpaRepository<ClientVehicle, Integer> {

    /**
     * find by clientId and vehicle Id
     * @param clientId  clientId
     * @param vehicleId vehicleId
     * @return ClientVehicle
     */
    Optional<ClientVehicle> findByClientIdAndVehicleId(int clientId, int vehicleId);

    /**
     * find highest bid by vehicle Id
     * @param vehicleId vehicleId
     * @return ClientVehicle
     */
    Optional<ClientVehicle> findTopByVehicleIdOrderByBidPriceDesc(int vehicleId);
}
