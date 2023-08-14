package com.example.demokotlin.mapper

import com.example.demokotlin.model.Topic
import com.example.demokotlin.model.payload.NewTopicPayload
import com.example.demokotlin.service.CourseService
import com.example.demokotlin.service.UserService
import org.springframework.stereotype.Component

@Component
class NewTopicPayloadMapper(
        private val courseService: CourseService,
        private val authorService: UserService,
) : Mapper<NewTopicPayload, Topic> {

    override fun map(parameter: NewTopicPayload): Topic {
        return Topic(
                title = parameter.title,
                message = parameter.message,
                course = courseService.findById(parameter.courseId),
                author = authorService.findById(parameter.authorId)
        )
    }
}