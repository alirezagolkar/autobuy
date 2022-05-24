package com.dealers.autobuy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dealers.autobuy.model.Dealer;

/**
 * Repository for Dealer
 * @author Ali Golkar
 */
@Repository
public interface DealerRepository extends JpaRepository<Dealer, Integer> {

    /**
     * find by dealerId
     * @param id dealer Id
     * @return Dealer
     */
    Optional<Dealer> findById(int id);
}
