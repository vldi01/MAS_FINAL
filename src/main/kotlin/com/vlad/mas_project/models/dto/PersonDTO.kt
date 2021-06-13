package com.vlad.mas_project.models.dto

import com.vlad.mas_project.models.db.Person
import com.vlad.mas_project.models.db.Token

open class PersonDTO(
    var name: String = "",
    var surname: String = "",
    var birthday: Long = 0L,
    var city: String = "",
    var phones: List<String> = listOf(),
    var email: String = "",
    var password: String = "",
    var token: TokenDTO? = null
)

//fun Person.dto(token: Token) = dto(token.dto())
//fun Person.dto(token: TokenDTO) = PersonDTO(name, surname, birthday, city, phones, email, password, token)