package br.com.wellingtoncosta.reservation.exception

import java.lang.RuntimeException

/**
 * @author Wellington Costa on 27/07/18.
 */
class BookNotFoundException(id: String) : RuntimeException("Book with id $id not found.")