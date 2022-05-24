package com.dealers.autobuy.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dealers.autobuy.model.Client;
import com.dealers.autobuy.repository.ClientRepository;

/**
 * Service for Client
 * @author Ali Golkar
 */
@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public Client findById(int id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public Collection<Client> findAll() {
        return clientRepository.findAll();
    }

    @Transactional
    public Client save(Client client) {
        clientRepository.save(client);
        return client;
    }

    @Transactional
    public Client update(Client client) {
        Collection<Client> clients = findAll();
        for (Client d : clients) {
            if (d.getId().equals(client.getId())) {
                clientRepository.save(d);
                return client;
            }
        }
        return null;
    }

    @Transactional
    public Integer delete(int id) {
        Collection<Client> clients = findAll();
        for (Client c : clients) {
            if (c.getId().equals(id)) {
                clientRepository.delete(c);
                return id;
            }
        }
        return null;
    }
}
