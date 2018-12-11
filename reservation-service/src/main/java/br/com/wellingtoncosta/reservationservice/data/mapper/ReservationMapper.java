package br.com.wellingtoncosta.reservationservice.data.mapper;

import br.com.wellingtoncosta.reservationservice.data.entity.ReservationEntity;
import br.com.wellingtoncosta.reservationservice.domain.model.Reservation;

/**
 * @author Wellington Costa on 10/12/18
 */
public final class ReservationMapper {

    private ReservationMapper() {
        throw new UnsupportedOperationException();
    }

    public static Reservation toDomain(ReservationEntity entity) {
        Reservation reservation = new Reservation();
        reservation.setId(entity.getId());
        reservation.setBookId(entity.getBookId());
        reservation.setClientId(entity.getClientId());
        reservation.setReservedAt(entity.getReservedAt());
        reservation.setReturnedAt(entity.getReturnedAt());
        reservation.setDescription(entity.getDescription());
        return reservation;
    }

    public static ReservationEntity toEntity(Reservation reservation) {
        ReservationEntity entity = new ReservationEntity();
        entity.setId(reservation.getId());
        entity.setBookId(reservation.getBookId());
        entity.setClientId(reservation.getClientId());
        entity.setReservedAt(reservation.getReservedAt());
        entity.setReturnedAt(reservation.getReturnedAt());
        entity.setDescription(reservation.getDescription());
        return entity;
    }

}
