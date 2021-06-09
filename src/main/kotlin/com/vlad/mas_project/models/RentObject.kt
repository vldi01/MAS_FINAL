package com.vlad.mas_project.models

import javax.persistence.*

@Entity
abstract class RentObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id = 0

    @ManyToMany(mappedBy = "rentObjects")
    open var rents: MutableList<Rent> = arrayListOf()

    abstract var minAge: Int
    abstract var price: Int //price for hour
}