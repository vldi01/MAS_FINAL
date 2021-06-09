package com.vlad.mas_project.models

import javax.persistence.Entity

@Entity
class Room(
    var kitchen: Boolean = false,
    var bathroom: Boolean = false,
    var refrigerator: Boolean = false
) : ReservationObject() {
    override var maxPeople: Int = 0
    override var price: Int = 0
}