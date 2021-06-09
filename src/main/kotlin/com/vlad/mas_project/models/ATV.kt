package com.vlad.mas_project.models

import javax.persistence.Entity

@Entity
class ATV(
    var engineVolume: Int,
    var color: Int,
    var year: Int
) : RentObject(){
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
        private var MIN_AGE = 18
        private var PRICE = 100
    }
}