package br.com.wellingtoncosta.reservation

import org.springframework.data.repository.reactive.ReactiveCrudRepository

/**
 * @author Wellington Costa on 25/07/18.
 */
interface ReservationRepository : ReactiveCrudRepository<Reservation, String>