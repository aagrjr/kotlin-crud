package com.example.demokotlin.service

import com.example.demokotlin.model.Course
import org.springframework.stereotype.Service

@Service
class CourseService(private var courses: List<Course> = ArrayList()) {

    init {
        courses = courses.plus(
                Course(
                        id = 1,
                        name = "Kotlin",
                        category = "Programming"
                )
        )
        courses = courses.plus(
                Course(
                        id = 2,
                        name = "Java",
                        category = "Programming"
                )
        )
    }

    fun findById(id: Long): Course {
        return courses.stream().filter { course -> course.id == id }.findFirst().get()
    }


}