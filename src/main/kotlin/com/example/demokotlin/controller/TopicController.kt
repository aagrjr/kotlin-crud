package com.example.demokotlin.controller

import com.example.demokotlin.model.payload.NewTopicPayload
import com.example.demokotlin.model.payload.UpdateTopicPayload
import com.example.demokotlin.model.response.TopicPerCategoryResponse
import com.example.demokotlin.model.response.TopicResponse
import com.example.demokotlin.service.TopicService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun list(@RequestParam(required = false) courseName: String?,
             @PageableDefault(size = 10, page = 0, sort = ["creationDate"], direction = Sort.Direction.DESC) page: Pageable): Page<TopicResponse> {
        return service.list(courseName, page)
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id: Long): TopicResponse {
        return service.findById(id)
    }

    @PostMapping
    fun create(@RequestBody @Valid dto: NewTopicPayload,
               uriBuilder: UriComponentsBuilder): ResponseEntity<TopicResponse> {
        val topicResponse = service.create(dto)
        val uri = uriBuilder.path("/topics/{id}").buildAndExpand(topicResponse.id).toUri()
        return ResponseEntity.created(uri).body(topicResponse)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody @Valid dto: UpdateTopicPayload,
               uriBuilder: UriComponentsBuilder): ResponseEntity<TopicResponse> {
        return ResponseEntity.ok(service.update(id, dto))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun delete(@PathVariable id: Long) {
        return service.delete(id)
    }

    @GetMapping("/report")
    @ResponseStatus(HttpStatus.OK)
    fun report(): List<TopicPerCategoryResponse> {
        return service.report()
    }
}