package com.dealers.autobuy.service;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dealers.autobuy.model.Dealer;
import com.dealers.autobuy.repository.DealerRepository;

/**
 * Service for Dealer
 * @author Ali Golkar
 */
@Service
public class DealerService implements IDealerService {

    private final DealerRepository dealerRepository;

    public DealerService(DealerRepository dealerRepository) {
        this.dealerRepository = dealerRepository;
    }

    @Transactional(readOnly = true)
    public Dealer findById(int id) {
        return dealerRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public Collection<Dealer> findAll() {
        return dealerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Collection<Dealer> findAvailableVehicles(String name, String returnLocation, String pickupDate, String returnDate, String vehicleClass) {
        return null;
    }

    @Transactional
    public Dealer save(Dealer dealer) {
        dealerRepository.save(dealer);
        return dealer;
    }

    @Transactional
    public Dealer update(Dealer dealer) {
        Collection<Dealer> dealers = findAll();
        for (Dealer d : dealers) {
            if (d.getId().equals(dealer.getId())) {
                dealerRepository.save(d);
                return dealer;
            }
        }
        return null;
    }

    @Transactional
    public Integer delete(int id) {
        Collection<Dealer> dealers = findAll();
        for (Dealer d : dealers) {
            if (d.getId().equals(id)) {
                dealerRepository.delete(d);
                return id;
            }
        }
        return null;
    }
}
