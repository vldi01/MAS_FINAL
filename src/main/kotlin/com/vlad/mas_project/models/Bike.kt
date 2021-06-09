package com.vlad.mas_project.models

import javax.persistence.Entity

@Entity
class Bike(
    var color: Int = 0,
    var height: Int = 0,
    var wheelSize: Int = 0
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