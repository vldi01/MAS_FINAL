package com.vlad.mas_project.controllers

import com.google.gson.Gson
import com.vlad.mas_project.models.db.Person
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoApplication {
    @GetMapping("/hello")
    fun hello(@RequestParam(value = "name", defaultValue = "World") name: String?): String {
        return Gson().toJson(Person("Vlad", "Diachuk"))
    }
}