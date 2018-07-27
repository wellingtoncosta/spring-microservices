package br.com.wellingtoncosta.reservation.exception

import java.lang.RuntimeException

/**
 * @author Wellington Costa on 27/07/18.
 */
class ClientNotFoundException(id: String) : RuntimeException("Client with id $id not found.")