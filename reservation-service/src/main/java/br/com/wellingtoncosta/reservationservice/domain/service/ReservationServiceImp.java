package br.com.wellingtoncosta.reservationservice.domain.service;

import br.com.wellingtoncosta.reservationservice.data.entity.ReservationEntity;
import br.com.wellingtoncosta.reservationservice.data.mapper.ReservationMapper;
import br.com.wellingtoncosta.reservationservice.data.repository.ReservationRepository;
import br.com.wellingtoncosta.reservationservice.domain.exception.BookAlreadyReservedException;
import br.com.wellingtoncosta.reservationservice.domain.exception.BookNotFoundException;
import br.com.wellingtoncosta.reservationservice.domain.exception.ClientNotFoundException;
import br.com.wellingtoncosta.reservationservice.domain.exception.ReservationNotFoundException;
import br.com.wellingtoncosta.reservationservice.domain.model.Book;
import br.com.wellingtoncosta.reservationservice.domain.model.Client;
import br.com.wellingtoncosta.reservationservice.domain.model.Reservation;
import br.com.wellingtoncosta.reservationservice.web.client.BookApi;
import br.com.wellingtoncosta.reservationservice.web.client.ClientApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static br.com.wellingtoncosta.reservationservice.data.mapper.ReservationMapper.toDomain;
import static br.com.wellingtoncosta.reservationservice.data.mapper.ReservationMapper.toEntity;
import static java.util.stream.Collectors.toList;

/**
 * @author Wellington Costa on 11/12/18
 */
@Service public class ReservationServiceImp implements ReservationService {

    private final BookApi bookApi;
    private final ClientApi clientApi;
    private final ReservationRepository repository;

    @Autowired public ReservationServiceImp(
            BookApi bookApi,
            ClientApi clientApi,
            ReservationRepository repository
    ) {
        this.bookApi = bookApi;
        this.clientApi = clientApi;
        this.repository = repository;
    }

    @Override public List<Reservation> findAll() {
        Spliterator<ReservationEntity> spliterator = repository.findAll().spliterator();
        Stream<ReservationEntity> stream = StreamSupport.stream(spliterator, false);
        return stream.map(ReservationMapper::toDomain).collect(toList());
    }

    @Override public Reservation findById(Long id) {
        return toDomain(findEntityById(id));
    }

    @Override public Reservation save(Reservation reservation) {
        checkIfHasActiveReservation(reservation.getBookId());
        checkIfBookExists(reservation.getBookId());
        checkIfClientExists(reservation.getClientId());
        return toDomain(repository.save(toEntity(reservation)));
    }
    private void checkIfBookExists(Long bookId) {
        ResponseEntity<Book> response = bookApi.findById(bookId);

        if(response.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
            throw new BookNotFoundException(bookId);
        }
    }

    private void checkIfClientExists(Long clientId) {
        ResponseEntity<Client> response = clientApi.findById(clientId);

        if(response.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
            throw new ClientNotFoundException(clientId);
        }
    }

    private void checkIfHasActiveReservation(Long bookId) {
        Optional<ReservationEntity> optional = repository.findActiveByBookId(bookId);

        if(optional.isPresent()) {
            throw new BookAlreadyReservedException(bookId);
        }
    }

    @Override public Reservation getBack(Long id) {
        ReservationEntity entity = findEntityById(id);
        entity.setReturnedAt(LocalDate.now());
        return null;
    }

    @NonNull private ReservationEntity findEntityById(Long id) {
        Optional<ReservationEntity> optional = repository.findById(id);

        if(!optional.isPresent()) {
            throw new ReservationNotFoundException(id);
        }

        return optional.get();
    }

}
