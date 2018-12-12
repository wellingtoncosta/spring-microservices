package br.com.wellingtoncosta.reservationservice.web.client;

import br.com.wellingtoncosta.reservationservice.domain.model.Book;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Wellington Costa on 11/12/18
 */
@FeignClient("book-service")
@Headers({"Content-type", "application/json"})
public interface BookApi {

    @GetMapping("/books/{bookId}")
    ResponseEntity<Book> findById(@PathVariable("bookId") Long bookId);

}
