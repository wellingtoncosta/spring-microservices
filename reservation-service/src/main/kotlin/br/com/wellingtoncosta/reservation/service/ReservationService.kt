package br.com.wellingtoncosta.reservation.service

import br.com.wellingtoncosta.reservation.exception.BookNotFoundException
import br.com.wellingtoncosta.reservation.exception.ClientNotFoundException
import br.com.wellingtoncosta.reservation.model.Reservation
import br.com.wellingtoncosta.reservation.repository.ReservationRepository
import br.com.wellingtoncosta.reservation.web.client.BookServiceClient
import br.com.wellingtoncosta.reservation.web.client.ClientServiceClient
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import javax.inject.Inject

/**
 * @author Wellington Costa on 27/07/18.
 */
@Service
class ReservationService @Inject constructor(
        private val repository: ReservationRepository,
        private val bookServiceClient: BookServiceClient,
        private val clientServiceClient: ClientServiceClient
) {

    fun findAll() = repository.findAll()

    fun findById(id: String) = repository.findById(id)

    fun save(reservation: Reservation): Mono<Reservation> {
        verifyIfBookExists(reservation.bookId)
        verifyIfClientExists(reservation.clientId)
        return repository.save(reservation)
    }

    fun verifyIfBookExists(bookId: String) {
        bookServiceClient.getById(bookId) ?: throw BookNotFoundException(bookId)
    }

    fun verifyIfClientExists(clientId: String) {
        clientServiceClient.getById(clientId) ?: throw ClientNotFoundException(clientId)
    }

    fun deleteById(id: String) = repository.deleteById(id)

}