package br.com.wellingtoncosta.book

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
 * @author Wellington Costa on 24/07/18.
 */
@Document
data class Book(
        @Id var id: String,
        var title: String,
        var description: String = "",
        var author: String,
        var year: String
)