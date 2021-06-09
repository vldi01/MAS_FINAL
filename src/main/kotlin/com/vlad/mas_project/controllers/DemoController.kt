package com.vlad.mas_project.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoApplication {
    @GetMapping("/hello")
    fun hello(@RequestParam(value = "name", defaultValue = "World") name: String?): String {
        return String.format("Hello %s!", name)
    }
}