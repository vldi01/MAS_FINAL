package com.vlad.mas_project.models

import javax.persistence.*

@Entity(name = "Client")
class Client(
    name: String = "",
    surname: String = "",
    birthday: Long = 0L,
    city: String = "",
    phones: List<String> = listOf(),
    email: String = "",
    var bonuses: Int? = null
): Person(name, surname, birthday, city, phones, email){

    @OneToMany(mappedBy = "client")
    var reservations: MutableList<Reservation> = arrayListOf()

    @OneToMany(mappedBy = "client")
    var rents: MutableList<Rent> = arrayListOf()

    fun addReservation(reservation: Reservation) {
        if (reservations.contains(reservation).not()) {
            reservations.add(reservation)
            reservation.client = this
        }
    }

    fun addRent(rent: Rent) {
        if (rents.contains(rent).not()) {
            rents.add(rent)
            rent.client = this
        }
    }

    override fun toString(): String {
        return "Client(bonuses=$bonuses, reservations=$reservations) ${super.toString()}"
    }
}