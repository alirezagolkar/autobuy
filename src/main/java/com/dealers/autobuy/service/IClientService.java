package com.dealers.autobuy.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.dealers.autobuy.model.Client;

/**
 * Interface for Client Service
 * @author Ali Golkar
 */
@Service
public interface IClientService {

    Client findById(int id);

    Collection<Client> findAll();

    Client save(Client dealer);

    Client update(Client dealer);

    Integer delete(int id);
}
