package br.com.wellingtoncosta.book

import org.springframework.data.repository.reactive.ReactiveCrudRepository

/**
 * @author Wellington Costa on 24/07/18.
 */
interface BookRepository : ReactiveCrudRepository<Book, String>