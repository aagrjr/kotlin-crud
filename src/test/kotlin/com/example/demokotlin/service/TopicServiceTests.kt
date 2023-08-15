package com.example.demokotlin.service

import com.example.demokotlin.exception.NotFoundException
import com.example.demokotlin.mapper.NewTopicPayloadMapper
import com.example.demokotlin.mapper.TopicResponseMapper
import com.example.demokotlin.model.TopicResponseTest
import com.example.demokotlin.model.TopicTest
import com.example.demokotlin.repository.TopicRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import java.util.*

class TopicServiceTests {
    private val topicPage = PageImpl(listOf(
            TopicTest.build()
    ))
    val pagination: Pageable = mockk {
        every { pageNumber } returns 0
        every { pageSize } returns 10
    }
    val repository: TopicRepository = mockk {
        every { findByCourseName(any(), any()) } returns topicPage
        every { findAll(pagination) } returns topicPage
    }
    val topicResponseMapper: TopicResponseMapper = mockk {
        every { map(any()) } returns TopicResponseTest.build()
    }
    val topicPayloadMapper: NewTopicPayloadMapper = mockk()

    val topicService = TopicService(
            repository = repository,
            topicResponseMapper = topicResponseMapper,
            topicPayloadMapper = topicPayloadMapper
    )

    @Test
    fun `should return a list of topics filtered by course Name`() {
        every { topicResponseMapper.map(any()) } returns TopicResponseTest.build()
        val topics = topicService.list("Kotlin", pagination)
        assertEquals(1, topics.size)

        verify(exactly = 1) { repository.findByCourseName("Kotlin", pagination) }
        verify(exactly = 1) { topicResponseMapper.map(any()) }
        verify(exactly = 0) { repository.findAll(pagination) }

    }

    @Test
    fun `should return a list of all topics`() {
        val topics = topicService.list(null, pagination)
        assertEquals(1, topics.size)

        verify(exactly = 0) { repository.findByCourseName(any(), any()) }
        verify(exactly = 1) { topicResponseMapper.map(any()) }
        verify(exactly = 1) { repository.findAll(pagination) }
    }

    @Test
    fun `should thrown not found exception when topic not found`() {
        every { repository.findById(any()) } returns Optional.empty()
        val actualException = assertThrows<NotFoundException> { topicService.findById(1L) }
        verify(exactly = 1) { repository.findById(1L) }
        assertEquals("Topic not found", actualException.message)
    }
}