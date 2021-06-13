package com.vlad.mas_project.models.dto

import com.vlad.mas_project.models.db.Client
import com.vlad.mas_project.models.db.Token
import javax.persistence.*

class ClientDTO(
    name: String = "",
    surname: String = "",
    birthday: Long = 0L,
    city: String = "",
    phones: List<String> = listOf(),
    email: String = "",
    password: String = "",
    var bonuses: Int? = null,
    token: TokenDTO? = null
): PersonDTO(name, surname, birthday, city, phones, email, password, token){

    var reservations: MutableList<ReservationDTO> = arrayListOf()

    fun entity() = Client(name, surname, birthday, city, phones, email, password, bonuses)
        .also { it.reservations = ArrayList(reservations.map{reservation -> reservation.entity()}) }
}

fun Client.dto(token: Token) = dto(token.dto())
fun Client.dto(token: TokenDTO) = ClientDTO(name, surname, birthday, city, phones, email, password, bonuses, token)
    .also { it.reservations = ArrayList(reservations.map { reservation -> reservation.dto() }) }