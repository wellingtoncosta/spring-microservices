package br.com.wellingtoncosta.clientservice.domain.service;

import br.com.wellingtoncosta.clientservice.domain.model.Client;

import java.util.List;

/**
 * @author Wellington Costa on 05/12/18
 */
public interface ClientService {

    List<Client> findAll();

    Client findById(Long id);

    Client save(Client client);

    Client update(Long id, Client client);

    void delete(Long id);


}
