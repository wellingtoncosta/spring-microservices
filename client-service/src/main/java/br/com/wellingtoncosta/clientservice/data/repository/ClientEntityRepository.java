package br.com.wellingtoncosta.clientservice.data.repository;

import br.com.wellingtoncosta.clientservice.data.entity.ClientEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Wellington Costa on 05/12/18
 */
@Repository public interface ClientEntityRepository extends CrudRepository<ClientEntity, Long> {

    @Query("from ClientEntity client where client.email = :email")
    Optional<ClientEntity> findByEmail(@Param("email") String email);

}
