package br.com.wellingtoncosta.reservationservice.data.repository;

import br.com.wellingtoncosta.reservationservice.data.entity.ReservationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Wellington Costa on 10/12/18
 */
@Repository
public interface ReservationRepository extends CrudRepository<ReservationEntity, Long> {

    @Query("from ReservationEntity where bookId = :bookId and returnedAt is null")
    ReservationEntity findActiveByBookId(
            @Param("bookId") Long bookId
    );

}
