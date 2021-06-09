package com.vlad.mas_project.models.db

import javax.persistence.*

@Entity
abstract class ReservationObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id = 0

    @ManyToMany(mappedBy = "reservationObjects")
    open var reservations: MutableList<Reservation> = arrayListOf()

    abstract var maxPeople: Int
    abstract var price: Int
}