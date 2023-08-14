package com.example.demokotlin.model.payload

import jakarta.validation.constraints.NotBlank

data class UpdateTopicPayload(
        @field:NotBlank val title: String,
        @field:NotBlank val message: String,
)


