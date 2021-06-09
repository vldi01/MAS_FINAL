package com.vlad.mas_project.models

class Bike(
    var color: Int,
    var height: Int,
    var wheelSize: Int
): RentObject() {
    override var minAge: Int
        get() = MIN_AGE
        set(value) {
            MIN_AGE = value
        }
    override var price: Int
        get() = PRICE
        set(value) {
            PRICE = value
        }

    companion object {
        private var MIN_AGE = 16
        private var PRICE = 50
    }
}