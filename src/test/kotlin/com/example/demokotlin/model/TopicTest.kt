package com.example.demokotlin.model

object TopicTest {
    fun build(): Topic {
        return Topic(
                id = 2L,
                title = "Title",
                message = "Message",
                course = Course(
                        id = 2L,
                        name = "Kotlin",
                        category = "Programming"
                ),
                author = Author(
                        id = 2L,
                        name = "Author",
                        email = "author@email.com"
                )
        )
    }
}