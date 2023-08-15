package com.example.demokotlin.repository

import com.example.demokotlin.model.Topic
import com.example.demokotlin.model.response.TopicPerCategoryResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicRepository : JpaRepository<Topic, Long> {

    fun findByCourseName(courseName: String, page: Pageable): Page<Topic>

    @Query("SELECT new com.example.demokotlin.model.response.TopicPerCategoryResponse(t.course.category, count(t)) FROM Topic t JOIN t.course c GROUP BY t.course.category")
    fun report(): List<TopicPerCategoryResponse>
}