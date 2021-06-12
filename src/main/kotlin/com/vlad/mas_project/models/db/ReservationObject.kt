package com.vlad.mas_project.models.db

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
abstract class ReservationObject(open val name: String = "") {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id = 0

    @ManyToMany(mappedBy = "reservationObjects")
    @JsonIgnore
    open var reservations: MutableList<Reservation> = arrayListOf()

    abstract var maxPeople: Int
    abstract var price: Int
}