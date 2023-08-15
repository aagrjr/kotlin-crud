package com.example.demokotlin.model

import com.example.demokotlin.model.response.TopicResponse
import java.time.LocalDateTime

object TopicResponseTest {
    fun build(): TopicResponse {
        return TopicResponse(
                id = 1L,
                title = "Title",
                message = "Message",
                status = StatusTopic.NOT_ANSWERED,
                creationDate = LocalDateTime.now(),
                updatedDate = null
        )
    }
}
