package br.com.wellingtoncosta.reservationservice.domain.model;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author Wellington Costa on 10/12/18
 */
@Data public class Reservation {

    private Long id;
    private Long bookId;
    private Long clientId;
    private LocalDate reservedAt;
    private LocalDate returnedAt;
    private String description;

}
