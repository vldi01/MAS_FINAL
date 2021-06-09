package com.vlad.mas_project.helpers

import com.vlad.mas_project.models.db.Person
import com.vlad.mas_project.models.db.Token
import com.vlad.mas_project.repositories.TokenRepository
import java.util.*

class TokenGenerator {
    companion object {
        private const val EXPIRATION_PERIOD = 24 * 60 * 60 * 1000
    }

    fun generateUniqueToken(tokenRepository: TokenRepository, person: Person): Token {
        while (true) {
            val token = generateToken()
            if (tokenRepository.isExist(token.uuid) != true)
                return token.also { it.person = person }
        }
    }

    private fun generateToken(): Token = Token(System.currentTimeMillis() + EXPIRATION_PERIOD, UUID.randomUUID().toString())
}