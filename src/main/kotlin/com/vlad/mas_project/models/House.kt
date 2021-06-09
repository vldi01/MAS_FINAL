package com.vlad.mas_project.models

data class House(
    var rooms: Int,
    var kitchens: Int,
    var bathrooms: Int
): ReservationObject() {
    override var maxPeople: Int = 0
    override var price: Int = 0

}