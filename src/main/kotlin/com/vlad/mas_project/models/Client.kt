package com.vlad.mas_project.models

import javax.persistence.*

@Entity(name = "Client")
class Client(
    name: String? = null,
    surname: String? = null,
    phone: String? = null,
    city: String? = null,
    var bonuses: Int? = null
): Person(name, surname, phone, city){

    @OneToMany(mappedBy = "client")
    var reservations: MutableList<Reservation> = arrayListOf()

    fun addReservation(reservation: Reservation) {
        if (reservations.contains(reservation).not()) {
            reservations.add(reservation)
            reservation.client = this
        }
    }

    override fun toString(): String {
        return "Client(bonuses=$bonuses, reservations=$reservations) ${super.toString()}"
    }
}