package com.example.demokotlin.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Topic(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        val title: String,
        val message: String,
        val creationDate: LocalDateTime = LocalDateTime.now(),
        var updatedDate: LocalDateTime? = null,
        @ManyToOne
        val course: Course,
        @ManyToOne
        val author: Author,
        @Enumerated(value = EnumType.STRING)
        val status: StatusTopic = StatusTopic.NOT_ANSWERED,
        @OneToMany(mappedBy = "topic")
        val answers: List<Answer> = ArrayList()
)