package com.example.demokotlin.service

import com.example.demokotlin.exception.NotFoundException
import com.example.demokotlin.model.Author
import com.example.demokotlin.repository.AuthorRepository
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class AuthorService(private val repository: AuthorRepository) {

    @Cacheable("author")
    fun findById(id: Long): Author {
        return repository.findById(id).orElseThrow { NotFoundException("Author not found") }
    }


}