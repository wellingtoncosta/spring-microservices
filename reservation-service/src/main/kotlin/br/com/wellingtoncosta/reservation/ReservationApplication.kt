package br.com.wellingtoncosta.reservation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

/**
 * @author Wellington Costa on 14/05/18.
 */
@EnableDiscoveryClient
@SpringBootApplication
class ReservationApplication

fun main(args: Array<String>) {
    runApplication<ReservationApplication>(*args)
}