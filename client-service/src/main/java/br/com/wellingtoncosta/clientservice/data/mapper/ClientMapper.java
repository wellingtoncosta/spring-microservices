package br.com.wellingtoncosta.clientservice.data.mapper;

import br.com.wellingtoncosta.clientservice.data.entity.ClientEntity;
import br.com.wellingtoncosta.clientservice.domain.model.Client;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author Wellington Costa on 05/12/18
 */
public final class ClientMapper {

    private ClientMapper() {
        throw new NotImplementedException();
    }

    public static Client toDomain(ClientEntity entity) {
        Client client = new Client();
        client.setId(entity.getId());
        client.setName(entity.getName());
        client.setEmail(entity.getEmail());
        client.setPhone(entity.getPhone());
        return client;
    }

    public static ClientEntity toEntity(Client client) {
        ClientEntity entity = new ClientEntity();
        entity.setId(client.getId());
        entity.setName(client.getName());
        entity.setEmail(client.getEmail());
        entity.setPhone(client.getPhone());
        return entity;
    }

}
