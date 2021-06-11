package com.vlad.mas_project.controllers

import com.google.gson.Gson
import com.vlad.mas_project.models.db.Person
import com.vlad.mas_project.models.dto.Error
import com.vlad.mas_project.models.dto.PersonDTO
import com.vlad.mas_project.models.dto.VAResponse
import com.vlad.mas_project.models.dto.response
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoApplication {
    @GetMapping("/hello")
    fun hello(@RequestParam(value = "name", defaultValue = "World") name: String?): ResponseEntity<VAResponse> {
//        return Gson().toJson(PersonDTO("Vlad", "Diachuk"))
        return response(body = PersonDTO("Vlad", "Diachuk"))
    }
}