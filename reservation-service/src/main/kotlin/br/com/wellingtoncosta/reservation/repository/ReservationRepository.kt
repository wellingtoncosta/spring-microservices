package br.com.wellingtoncosta.reservation.repository

import br.com.wellingtoncosta.reservation.model.Reservation
import org.springframework.data.repository.reactive.ReactiveCrudRepository

/**
 * @author Wellington Costa on 25/07/18.
 */
interface ReservationRepository : ReactiveCrudRepository<Reservation, String>