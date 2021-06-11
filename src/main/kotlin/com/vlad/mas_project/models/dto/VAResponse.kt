package com.vlad.mas_project.models.dto

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

data class VAResponse(
    val error: Error? = null,
    val body: Any? = null
)

fun response(
    error: Error? = null,
    body: Any? = null
): ResponseEntity<VAResponse> = ResponseEntity.status(HttpStatus.OK).body(VAResponse(error, body))


enum class Error {
    EmailExists,
    BadRequest,
    BadLogin
}