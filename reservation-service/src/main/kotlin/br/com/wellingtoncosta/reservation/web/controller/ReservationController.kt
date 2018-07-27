package br.com.wellingtoncosta.reservation.web.controller

import br.com.wellingtoncosta.reservation.service.ReservationService
import br.com.wellingtoncosta.reservation.model.Reservation
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
    private lateinit var service: ReservationService

    @GetMapping(produces = [(JSON)])
    fun findAll() = service.findAll()

    @GetMapping(produces = [(JSON)], value = ["/{id}"])
    fun findById(@PathVariable("id") id: String) = service.findById(id)

    @PostMapping(consumes = [(JSON)], produces = [(JSON)])
    fun save(@RequestBody reservation: Reservation) = service.save(reservation)

    @DeleteMapping(value = ["/{id}"])
    fun delete(@PathVariable("id") id: String) = service.deleteById(id)

}