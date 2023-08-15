package com.example.demokotlin.service

import com.example.demokotlin.exception.NotFoundException
import com.example.demokotlin.model.Course
import com.example.demokotlin.repository.CourseRepository
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class CourseService(private val repository: CourseRepository) {

    @Cacheable("courses")
    fun findById(id: Long): Course {
        return repository.findById(id).orElseThrow { NotFoundException("Course not found") }
    }


}