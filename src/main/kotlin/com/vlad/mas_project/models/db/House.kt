package com.vlad.mas_project.models.db

import javax.persistence.Entity

@Entity
class House(
    var rooms: Int = 0,
    var kitchens: Int = 0,
    var bathrooms: Int = 0,
    name: String = ""
): ReservationObject(name) {
    override var maxPeople: Int = 0
    override var price: Int = 0
}