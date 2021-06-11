package com.vlad.mas_project.controllers

import com.vlad.mas_project.helpers.TokenGenerator
import com.vlad.mas_project.models.dto.*
import com.vlad.mas_project.repositories.ClientRepository
import com.vlad.mas_project.repositories.TokenRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/accounts")
class AccountsController(val clientRepository: ClientRepository,
                         val tokenRepository: TokenRepository) {
    @PostMapping("/register")
    fun register(@RequestBody client: ClientDTO): ResponseEntity<VAResponse> {
        if (client.email.isEmpty()
            || client.password.isEmpty()
            || client.name.isEmpty()
            || client.surname.isEmpty()
        ) return response(Error.BadRequest)

        if (clientRepository.isExistWithEmail(client.email) == true) {
            return response(Error.EmailExists)
        }

        val clientEntity = client.entity()
        clientRepository.save(clientEntity)

        val token = TokenGenerator().generateUniqueToken(tokenRepository, clientEntity)
        tokenRepository.save(token)

        return response(body = token.dto())
    }

    @PostMapping("/login")
    fun login(@RequestBody loginInfo: LoginInfoDTO): ResponseEntity<VAResponse> {
        val client = clientRepository.findByEmailAndPassword(
            loginInfo.email,
            loginInfo.password
        ) ?: return response(Error.BadLogin)

        val token = TokenGenerator().generateUniqueToken(tokenRepository, client)
        tokenRepository.save(token)

        return response(body = client.dto(token).apply { password = "" })
    }

    @PostMapping("/loginToken")
    fun loginToken(@RequestBody tokenDTO: TokenDTO): ResponseEntity<VAResponse> {
        val client = tokenRepository.getClientByUuid(tokenDTO.uuid) ?: return response(Error.BadLogin)

        tokenRepository.deleteByUuid(tokenDTO.uuid)

        val token = TokenGenerator().generateUniqueToken(tokenRepository, client)
        tokenRepository.save(token)

        return response(body = client.dto(token).apply { password = "" })
    }

    @GetMapping("/checkEmail")
    fun checkEmail(@RequestParam(value = "email", defaultValue = "") email: String?): ResponseEntity<VAResponse> {
        if (email.isNullOrEmpty()) return response(Error.BadRequest)
        return response(body = clientRepository.isExistWithEmail(email) == true)
    }
}