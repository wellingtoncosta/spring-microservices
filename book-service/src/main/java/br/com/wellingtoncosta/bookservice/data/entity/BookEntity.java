package br.com.wellingtoncosta.bookservice.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDate;

import static javax.persistence.GenerationType.AUTO;

/**
 * @author Wellington Costa on 30/11/2018.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "description")
    private String description;

    @Column(name = "release_date", nullable = false, columnDefinition = "DATE")
    private LocalDate releaseDate;

}
