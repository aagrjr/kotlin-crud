package com.example.demokotlin.service

import com.example.demokotlin.exception.NotFoundException
import com.example.demokotlin.model.Author
import com.example.demokotlin.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository) {

    fun findById(id: Long): Author {
        return repository.findById(id).orElseThrow { NotFoundException("User not found") }
    }


}