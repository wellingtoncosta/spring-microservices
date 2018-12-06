package br.com.wellingtoncosta.clientservice.domain.service;

import br.com.wellingtoncosta.clientservice.data.entity.ClientEntity;
import br.com.wellingtoncosta.clientservice.data.mapper.ClientMapper;
import br.com.wellingtoncosta.clientservice.data.repository.ClientEntityRepository;
import br.com.wellingtoncosta.clientservice.domain.exception.ClientAlreadyExistsException;
import br.com.wellingtoncosta.clientservice.domain.exception.ClientNotFoundException;
import br.com.wellingtoncosta.clientservice.domain.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static br.com.wellingtoncosta.clientservice.data.mapper.ClientMapper.toDomain;
import static br.com.wellingtoncosta.clientservice.data.mapper.ClientMapper.toEntity;
import static java.util.stream.Collectors.toList;

/**
 * @author Wellington Costa on 05/12/18
 */
@Service public class ClientServiceImp implements ClientService {

    private final ClientEntityRepository repository;

    @Autowired public ClientServiceImp(ClientEntityRepository repository) {
        this.repository = repository;
    }

    @Override public List<Client> findAll() {
        Spliterator<ClientEntity> spliterator = repository.findAll().spliterator();
        Stream<ClientEntity> stream = StreamSupport.stream(spliterator, false);
        return stream.map(ClientMapper::toDomain).collect(toList());
    }

    @Override public Client findById(Long id) {
        Optional<ClientEntity> entity = repository.findById(id);

        if(!entity.isPresent()) {
            throw new ClientNotFoundException(id);
        }

        return toDomain(entity.get());
    }

    @Override @Transactional public Client save(Client client) {
        Optional<ClientEntity> clientDb = repository.findByEmail(client.getEmail());

        if(clientDb.isPresent()) {
            throw new ClientAlreadyExistsException(client.getEmail());
        }

        ClientEntity entity = repository.save(toEntity(client));
        return toDomain(entity);
    }

    @Override @Transactional public Client update(Long id, Client client) {
        ClientEntity clientDb = toEntity(findById(id));
        client.setId(clientDb.getId());
        return toDomain(repository.save(toEntity(client)));
    }

    @Override @Transactional public void delete(Long id) {
        repository.delete(toEntity(findById(id)));
    }
}
