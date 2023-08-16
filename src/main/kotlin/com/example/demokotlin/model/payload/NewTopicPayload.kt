package com.example.demokotlin.model.payload

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class NewTopicPayload(
        @field:NotBlank var title: String,
        @field:NotBlank val message: String,
        @field:NotNull val courseId: Long,
        @field:NotNull val authorId: Long
)


