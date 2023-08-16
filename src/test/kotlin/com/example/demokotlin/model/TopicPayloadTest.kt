package com.example.demokotlin.model

import com.example.demokotlin.model.payload.NewTopicPayload

object TopicPayloadTest {
    fun build(): NewTopicPayload {
        return NewTopicPayload(
                title = "Title",
                message = "Message",
                courseId = 1L,
                authorId = 1L,
        )
    }
}
