package com.example.demokotlin.model

import java.time.LocalDateTime

data class Answer(
        val id: Long? = null,
        val message: String,
        val topic: Topic,
        val creationDate: LocalDateTime = LocalDateTime.now(),
        val author: User,
        val solution: Boolean,
)
