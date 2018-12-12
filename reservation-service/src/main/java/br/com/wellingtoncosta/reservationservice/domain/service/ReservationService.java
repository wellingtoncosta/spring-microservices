package br.com.wellingtoncosta.reservationservice.domain.service;

import br.com.wellingtoncosta.reservationservice.domain.model.Reservation;

import java.util.List;

/**
 * @author Wellington Costa on 11/12/18
 */
public interface ReservationService {

    List<Reservation> findAll();

    Reservation findById(Long id);

    Reservation save(Reservation book);

    Reservation getBack(Long id);

}
