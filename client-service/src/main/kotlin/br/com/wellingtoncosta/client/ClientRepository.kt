package br.com.wellingtoncosta.client

import org.springframework.data.repository.reactive.ReactiveCrudRepository

/**
 * @author Wellington Costa on 25/07/18.
 */
interface ClientRepository : ReactiveCrudRepository<Client, String>