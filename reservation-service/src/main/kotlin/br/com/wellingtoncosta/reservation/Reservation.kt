package br.com.wellingtoncosta.reservation

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME
import java.util.*

/**
 * @author Wellington Costa on 25/07/18.
 */
@Document
data class Reservation(
    @Id var id: String,
    var bookId: String,
    var clientId: String,
    @DateTimeFormat(iso = DATE_TIME) var reservedAt: Date,
    @DateTimeFormat(iso = DATE_TIME) var returnedAt: Date? = null
)