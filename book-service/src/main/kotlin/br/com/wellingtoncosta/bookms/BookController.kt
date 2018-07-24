package br.com.wellingtoncosta.bookms

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE as JSON

/**
 * @author Wellington Costa on 24/07/18.
 */
@RestController
@RequestMapping("/books")
class BookController {

    @Autowired
    private lateinit var repository: BookRepository

    @GetMapping(produces = [(JSON)])
    fun findAll() = repository.findAll()

    @GetMapping(produces = [(JSON)], value = ["/{id}"])
    fun findById(@PathVariable("id") id: String) = repository.findById(id)

    @PostMapping(consumes = [(JSON)], produces = [(JSON)])
    fun save(@RequestBody book: Book) = repository.save(book)

    @DeleteMapping(value = ["/{id}"])
    fun delete(@PathVariable("id") id: String) = repository.deleteById(id)

}