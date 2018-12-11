package br.com.wellingtoncosta.bookservice.web;

import br.com.wellingtoncosta.bookservice.domain.model.Book;
import br.com.wellingtoncosta.bookservice.domain.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation("Get all books")
    @GetMapping(value = "/", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @ApiOperation("Get a book by id")
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Book> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @ApiOperation("Save a new book")
    @PostMapping(
            value = "/",
            consumes = APPLICATION_JSON_UTF8_VALUE,
            produces = APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<Book> save(@RequestBody Book book) {
        return ResponseEntity.ok(service.save(book));
    }

    @ApiOperation("Update a book by id")
    @PutMapping(
            value = "/{id}",
            consumes = APPLICATION_JSON_UTF8_VALUE,
            produces = APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<Book> update(@PathVariable("id") Long id, @RequestBody Book book) {
        return ResponseEntity.ok(service.update(id, book));
    }

    @ApiOperation("Delete a book by id")
    @DeleteMapping(
            value = "/{id}",
            consumes = APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
