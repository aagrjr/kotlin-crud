package com.example.demokotlin.mapper

import com.example.demokotlin.model.Topic
import com.example.demokotlin.model.response.TopicResponse
import org.springframework.stereotype.Component

@Component
class TopicResponseMapper : Mapper<Topic, TopicResponse> {

    override fun map(parameter: Topic): TopicResponse {
        return TopicResponse(
                id = parameter.id,
                title = parameter.title,
                message = parameter.message,
                status = parameter.status,
                creationDate = parameter.creationDate,
                updatedDate = parameter.updatedDate
        )
    }
}