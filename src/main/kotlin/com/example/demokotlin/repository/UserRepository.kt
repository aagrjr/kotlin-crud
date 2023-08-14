package com.example.demokotlin.repository

import com.example.demokotlin.model.Author
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<Author, Long> {

}