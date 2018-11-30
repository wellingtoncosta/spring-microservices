package br.com.wellingtoncosta.bookservice.web;

import br.com.wellingtoncosta.bookservice.domain.model.Book;
import br.com.wellingtoncosta.bookservice.domain.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author Wellington Costa on 30/11/2018.
 */
@RestController public class BookController {

    private final BookService service;

    @Autowired public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Book> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping(
            consumes = APPLICATION_JSON_UTF8_VALUE,
            produces = APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<Book> save(@RequestBody Book book) {
        return ResponseEntity.ok(service.save(book));
    }

    @PutMapping(
            value = "/{id}",
            consumes = APPLICATION_JSON_UTF8_VALUE,
            produces = APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<Book> update(@PathVariable("id") Long id, @RequestBody Book book) {
        return ResponseEntity.ok(service.update(id, book));
    }

    @DeleteMapping(
            value = "/{id}",
            consumes = APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
