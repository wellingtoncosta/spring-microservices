package br.com.wellingtoncosta.book

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

/**
 * @author Wellington Costa on 14/05/18.
 */
@EnableDiscoveryClient
@SpringBootApplication
class BookApplication

fun main(args: Array<String>) {
    runApplication<BookApplication>(*args)
}