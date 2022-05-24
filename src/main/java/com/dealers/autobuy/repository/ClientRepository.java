package com.dealers.autobuy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dealers.autobuy.model.Client;

/**
 * Repository for Client
 * @author Ali Golkar
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    /**
     * find by client Id
     * @param id client Id
     * @return Client
     */
    Optional<Client> findById(int id);
}
