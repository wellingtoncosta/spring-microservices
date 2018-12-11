package br.com.wellingtoncosta.reservationservice.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author Wellington Costa on 10/12/18
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_reservation")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "book_id", nullable = false)
    private Long bookId;

    @Column(name = "client_id", nullable = false)
    private Long clientId;

    @Column(name = "reserved_at", nullable = false, columnDefinition = "DATE")
    private LocalDate reservedAt;

    @Column(name = "returned_at", columnDefinition = "DATE")
    private LocalDate returnedAt;

    @Column(name = "description")
    private String description;

}
