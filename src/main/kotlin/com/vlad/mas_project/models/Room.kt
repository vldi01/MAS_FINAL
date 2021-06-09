package com.vlad.mas_project.models

class Room private constructor(
    var kitchen: Boolean,
    var bathroom: Boolean,
    var refrigerator: Boolean
) : ReservationObject() {
    override var maxPeople: Int = 0
    override var price: Int = 0
    var deleted = false
}