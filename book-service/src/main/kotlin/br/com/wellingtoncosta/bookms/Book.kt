package br.com.wellingtoncosta.bookms

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
 * @author Wellington Costa on 24/07/18.
 */
@Document
data class Book(
        @Id val id: String,
        val title: String,
        val description: String = "",
        val author: String,
        val year: String
)