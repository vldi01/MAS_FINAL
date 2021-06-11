package com.vlad.mas_project.controllers

import com.vlad.mas_project.helpers.TokenGenerator
import com.vlad.mas_project.models.db.Person
import com.vlad.mas_project.models.dto.*
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
        if (person.email.isEmpty()
            || person.password.isEmpty()
            || person.name.isEmpty()
            || person.surname.isEmpty()
        ) return response(Error.BadRequest)

        if (personRepository.isExistWithEmail(person.email) == true) {
            return response(Error.EmailExists)
        }

        personRepository.save(person)

        val token = TokenGenerator().generateUniqueToken(tokenRepository, person)

        tokenRepository.save(token)

        return response(body = token.dto())
    }

    @PostMapping("/login")
    fun login(@RequestBody loginInfo: LoginInfoDTO): ResponseEntity<VAResponse> {
        val person = personRepository.findByEmailAndPassword(
            loginInfo.email,
            loginInfo.password
        ) ?: return response(Error.BadLogin)

        val token = TokenGenerator().generateUniqueToken(tokenRepository, person)

        tokenRepository.save(token)

        return response(body = person.dto(token))
    }

    @PostMapping("/loginToken")
    fun loginToken(@RequestBody tokenDTO: TokenDTO): ResponseEntity<VAResponse> {
        val person = tokenRepository.getPersonByUuid(tokenDTO.uuid) ?: return response(Error.BadLogin)

        tokenRepository.deleteByUuid(tokenDTO.uuid)

        val token = TokenGenerator().generateUniqueToken(tokenRepository, person)

        tokenRepository.save(token)

        return response(body = person.dto(token))
    }
}