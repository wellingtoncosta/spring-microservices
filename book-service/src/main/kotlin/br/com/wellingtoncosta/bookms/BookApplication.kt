package br.com.wellingtoncosta.bookms

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * @author Wellington Costa on 14/05/18.
 */
@SpringBootApplication
class BookApplication

fun main(args: Array<String>) {
    runApplication<BookApplication>(*args)
}