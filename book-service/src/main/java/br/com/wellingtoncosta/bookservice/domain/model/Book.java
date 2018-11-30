package br.com.wellingtoncosta.bookservice.domain.model;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author Wellington Costa on 30/11/2018.
 */
@Data public class Book {

    private Long id;
    private String tiile;
    private String author;
    private String description;
    private LocalDate releaseDate;

}
