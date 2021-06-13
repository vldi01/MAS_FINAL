package com.vlad.mas_project.models.responses

import com.vlad.mas_project.models.db.House
import com.vlad.mas_project.models.db.Room

data class ReservationsObjectsResponse(
    var houses: List<House> = arrayListOf(),
    var rooms: List<Room> = arrayListOf()
)