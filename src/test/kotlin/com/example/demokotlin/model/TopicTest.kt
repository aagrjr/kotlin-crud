package com.example.demokotlin.model

object TopicTest {
    fun build(): Topic {
        return Topic(
                id = 1L,
                title = "Title",
                message = "Message",
                course = Course(
                        id = 1L,
                        name = "Kotlin",
                        category = "Programming"
                ),
                author = Author(
                        id = 1L,
                        name = "Author",
                        email = "author@email.com"
                )
        )
    }
}