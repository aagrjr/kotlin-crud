package com.example.demokotlin.service

import com.example.demokotlin.exception.NotFoundException
import com.example.demokotlin.mapper.NewTopicPayloadMapper
import com.example.demokotlin.mapper.TopicResponseMapper
import com.example.demokotlin.model.Topic
import com.example.demokotlin.model.payload.NewTopicPayload
import com.example.demokotlin.model.payload.UpdateTopicPayload
import com.example.demokotlin.model.response.TopicResponse
import com.example.demokotlin.repository.TopicRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TopicService(
        private val repository: TopicRepository,
        private val topicResponseMapper: TopicResponseMapper,
        private val topicPayloadMapper: NewTopicPayloadMapper,
) {

    fun list(courseName: String?,
             page: Pageable): Page<TopicResponse> {
        val topics = if (courseName == null) repository.findAll(page) else repository.findByCourseName(courseName, page)
        return topics.map { topicResponseMapper.map(it) }
    }

    fun findById(id: Long): TopicResponse {
        val topic = getTopic(id)
        return topicResponseMapper.map(topic)
    }

    fun create(payload: NewTopicPayload): TopicResponse {

        return topicResponseMapper.map(repository.save(topicPayloadMapper.map(payload)))
    }

    fun update(id: Long, payload: UpdateTopicPayload): TopicResponse {
        var topic = getTopic(id)
        topic = topic.copy(title = payload.title, message = payload.message)
        return topicResponseMapper.map(repository.save(topic))
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }

    private fun getTopic(id: Long): Topic {
        return repository.findById(id).orElseThrow { NotFoundException("Topic not found") }
    }
}