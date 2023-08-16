package com.example.demokotlin.integration

import com.example.demokotlin.model.TopicTest
import com.example.demokotlin.model.response.TopicPerCategoryResponse
import com.example.demokotlin.repository.TopicRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TopicRepositoryTest {

    @Autowired
    private lateinit var topicRepository: TopicRepository

    private val topic = TopicTest.build()

    companion object {
        @Container
        private val mySQLContainer = MySQLContainer<Nothing>("mysql:latest").apply {
            withDatabaseName("testdb")
            withUsername("test")
            withPassword("test")
        }

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl)
            registry.add("spring.datasource.username", mySQLContainer::getUsername)
            registry.add("spring.datasource.password", mySQLContainer::getPassword)
        }
    }

    @Test
    fun `must generate a report`() {
        val report = topicRepository.report();

        Assertions.assertNotNull(report)
        assertThat(report.first()).isExactlyInstanceOf(TopicPerCategoryResponse::class.java)
    }

    @Test
    fun `must list topic by courseName`() {
        val result = topicRepository.findByCourseName("JPA in 50 Steps", PageRequest.of(0, 10));

        Assertions.assertNotNull(result)
        assertEquals(1, result.content.size)
        assertEquals("JPA in 50 Steps", result.first().course.name)
        assertEquals(1, result.first().id)
    }
}