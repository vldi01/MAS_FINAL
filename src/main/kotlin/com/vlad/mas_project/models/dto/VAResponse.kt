package com.vlad.mas_project.models.dto

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class VAResponse(
    val error: Error? = null,
    val body: Any? = null
) {
    fun responseEntity(): ResponseEntity<VAResponse> {
        return ResponseEntity
            .status(error?.status ?: HttpStatus.OK)
            .body(this)
    }
}

enum class Error(val status: HttpStatus){
    EmailExists(HttpStatus.CONFLICT)
}