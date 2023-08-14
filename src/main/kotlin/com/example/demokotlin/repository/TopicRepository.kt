package com.example.demokotlin.repository

import com.example.demokotlin.model.Topic
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository : JpaRepository<Topic, Long> {

}