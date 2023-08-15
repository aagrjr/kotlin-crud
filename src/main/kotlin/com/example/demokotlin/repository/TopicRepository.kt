package com.example.demokotlin.repository

import com.example.demokotlin.model.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository : JpaRepository<Topic, Long> {

    fun findByCourseName(courseName: String, page: Pageable): Page<Topic>
}