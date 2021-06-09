package com.vlad.mas_project.controllers

import com.vlad.mas_project.helpers.TokenGenerator
import com.vlad.mas_project.models.db.Person
import com.vlad.mas_project.models.dto.Error
import com.vlad.mas_project.models.dto.VAResponse
import com.vlad.mas_project.models.dto.dto
import com.vlad.mas_project.repositories.PersonRepository
import com.vlad.mas_project.repositories.TokenRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/accounts")
class AccountsController(val personRepository: PersonRepository,
                         val tokenRepository: TokenRepository) {
    @PostMapping("/register")
    fun register(@RequestBody person: Person): ResponseEntity<VAResponse> {
        if (personRepository.isExistWithEmail(person.email) == true) {
            return VAResponse(Error.EmailExists).responseEntity()
        }
        personRepository.save(person)

        val token = TokenGenerator().generateUniqueToken(tokenRepository, person)

        tokenRepository.save(token)

        return VAResponse(body = token.dto()).responseEntity()
    }
}