package com.example.demokotlin.model.response

import com.example.demokotlin.model.StatusTopic
import java.io.Serializable
import java.time.LocalDateTime

data class TopicResponse(
        val id: Long?,
        val title: String,
        val message: String,
        val status: StatusTopic,
        val creationDate: LocalDateTime,
        val updatedDate: LocalDateTime?,
) : Serializable
