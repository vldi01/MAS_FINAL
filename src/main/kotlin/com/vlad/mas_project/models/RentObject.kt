package com.vlad.mas_project.models

abstract class RentObject {
    abstract var minAge: Int
    abstract var price: Int //price for hour

    var rent: Rent? = null
}