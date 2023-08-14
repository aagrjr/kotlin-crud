package com.example.demokotlin.repository

import com.example.demokotlin.model.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository : JpaRepository<Course, Long> {

}