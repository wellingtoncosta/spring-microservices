package br.com.wellingtoncosta.bookservice.domain.service;

import br.com.wellingtoncosta.bookservice.domain.model.Book;

import java.util.List;

/**
 * @author Wellington Costa on 30/11/2018.
 */
public interface BookService {

    List<Book> findAll();

    Book findById(Long id);

    Book save(Book book);

    Book update(Long id, Book book);

    void delete(Long id);

}
