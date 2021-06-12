package com.vlad.mas_project.models.db

import javax.persistence.Entity

@Entity
class Room(
    var kitchen: Boolean = false,
    var bathroom: Boolean = false,
    var refrigerator: Boolean = false,
    name: String = ""
) : ReservationObject(name) {
    override var maxPeople: Int = 0
    override var price: Int = 0
}