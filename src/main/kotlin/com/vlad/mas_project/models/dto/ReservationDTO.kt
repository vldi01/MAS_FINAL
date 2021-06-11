package com.vlad.mas_project.models.dto

import com.vlad.mas_project.models.db.Reservation
import com.vlad.mas_project.models.db.ReservationObject
import javax.persistence.*

class ReservationDTO(
    var dateFrom: Long? = null,
    var dateTo: Long? = null,
    var token: TokenDTO? = null
) {
    var reservationObjects: MutableList<ReservationObject> = arrayListOf()

    fun entity() = Reservation(dateFrom, dateTo).also { it.reservationObjects = reservationObjects }
}

fun Reservation.dto() = ReservationDTO(dateFrom, dateTo).also { it.reservationObjects = reservationObjects }