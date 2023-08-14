package com.example.demokotlin.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Answer(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val message: String,
        @ManyToOne
        val topic: Topic,
        val creationDate: LocalDateTime = LocalDateTime.now(),
        @ManyToOne
        val author: Author,
        val solution: Boolean,
)
