package com.vlad.mas_project.models.dto

import com.vlad.mas_project.models.db.House
import com.vlad.mas_project.models.db.Reservation
import com.vlad.mas_project.models.db.Room

class ReservationDTO(
    var dateFrom: Long? = null,
    var dateTo: Long? = null,
    var token: TokenDTO? = null
) {
    var rooms: List<Room> = arrayListOf()
    var houses: List<House> = arrayListOf()

    fun entity() = Reservation(dateFrom, dateTo).also { it.reservationObjects = ArrayList(rooms + houses) }
}

fun Reservation.dto() = ReservationDTO(dateFrom, dateTo)
    .also {
        it.houses = reservationObjects.filterIsInstance<House>()
        it.rooms = reservationObjects.filterIsInstance<Room>()
    }