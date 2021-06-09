package com.vlad.mas_project.models

import javax.persistence.*

@Entity(name = "Reservation")
class Reservation(
    @Column(name = "date_from")
    var dateFrom: Long? = null,
    @Column(name = "date_to")
    var dateTo: Long? = null,
    @Column(name = "res_object")
    var resObject: String = ""
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0

    @ManyToOne
    var client: Client? = null
        set(value) {
            if (value == null) return
            value.addReservation(this)
            field = value
        }

    override fun toString(): String {
        return "Reservation(dateFrom=$dateFrom, dateTo=$dateTo, resObject=$resObject, id=$id, client.id=${client?.id})"
    }
}