package com.vlad.mas_project.models

class ATV(
    var engineVolume: Int = 0,
    var color: Int = 0,
    var year: Int = 0
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