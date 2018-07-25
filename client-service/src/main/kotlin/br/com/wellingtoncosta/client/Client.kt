package br.com.wellingtoncosta.client

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
 * @author Wellington Costa on 25/07/18.
 */
@Document
data class Client(
        @Id var id: String,
        var name: String,
        var email: String,
        var phone: String
)