package com.example.demokotlin.service

import com.example.demokotlin.model.User
import org.springframework.stereotype.Service

@Service
class AuthorService(private var authors: List<User> = ArrayList()) {

    init {
        authors = authors.plus(
                User(
                        id = 1,
                        name = "Joao",
                        email = "joao@email.com"
                )
        )
        authors = authors.plus(
                User(
                        id = 2,
                        name = "Maria",
                        email = "maria@email.com"
                )
        )
    }

    fun findById(id: Long): User {
        return authors.stream().filter { author -> author.id == id }.findFirst().get()
    }


}