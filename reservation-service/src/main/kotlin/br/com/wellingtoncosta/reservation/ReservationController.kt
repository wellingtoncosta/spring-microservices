package br.com.wellingtoncosta.reservation

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE as JSON

/**
 * @author Wellington Costa on 25/07/18.
 */
@RestController
@RequestMapping("/reservations")
class ReservationController {

    @Autowired
    private lateinit var repository: ReservationRepository

    @GetMapping(produces = [(JSON)])
    fun findAll() = repository.findAll()

    @GetMapping(produces = [(JSON)], value = ["/{id}"])
    fun findById(@PathVariable("id") id: String) = repository.findById(id)

    @PostMapping(consumes = [(JSON)], produces = [(JSON)])
    fun save(@RequestBody reservation: Reservation) = repository.save(reservation)

    @DeleteMapping(value = ["/{id}"])
    fun delete(@PathVariable("id") id: String) = repository.deleteById(id)

}