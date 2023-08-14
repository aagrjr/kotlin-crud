package com.example.demokotlin.service

import com.example.demokotlin.exception.NotFoundException
import com.example.demokotlin.mapper.NewTopicPayloadMapper
import com.example.demokotlin.mapper.TopicResponseMapper
import com.example.demokotlin.model.Topic
import com.example.demokotlin.model.payload.NewTopicPayload
import com.example.demokotlin.model.payload.UpdateTopicPayload
import com.example.demokotlin.model.response.TopicResponse
import org.springframework.stereotype.Service

@Service
class TopicService(
        private var topics: List<Topic> = ArrayList(),
        private val topicViewMapper: TopicResponseMapper,
        private val topicFormMapper: NewTopicPayloadMapper,
) {

    fun list(): List<TopicResponse> {
        return topics.stream().map { topicViewMapper.map(it) }.toList()
    }

    fun findById(id: Long): TopicResponse {
        val topic = getTopic(id)
        return topicViewMapper.map(topic)
    }

    fun create(dto: NewTopicPayload): TopicResponse {
        val topic = topicFormMapper.map(dto)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
        return topicViewMapper.map(topic)
    }

    fun update(id: Long, dto: UpdateTopicPayload): TopicResponse {
        val topic = getTopic(id)
        topics = topics.minus(topic).plus(topic.copy(title = dto.title, message = dto.message))
        return topics.last().let { topicViewMapper.map(it) }
    }

    fun delete(id: Long) {
        val topic = getTopic(id)
        topics = topics.minus(topic)
    }

    private fun getTopic(id: Long): Topic {
        return topics.stream().filter { topic -> topic.id == id }.findFirst().orElseThrow { NotFoundException("Topic not found") }
    }
}