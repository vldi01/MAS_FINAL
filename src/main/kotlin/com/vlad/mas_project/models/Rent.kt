package com.vlad.mas_project.models

import data.entity.Status
import javax.persistence.*

@Entity
data class Rent(
    @Column(name = "date_from")
    var dateFrom: Long = 0L,
    @Column(name = "date_to")
    var dateTo: Long = 0L,
    @Column(name = "people_number")
    var peopleNumber: Int = 0,
    @Column(name = "additional_info")
    var additionalInfo: String = "",
    var status: Status = Status.InRealisation
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0

    @ManyToOne
    var client: Client? = null
        set(value) {
            if (value == null) return
            value.addRent(this)
            field = value
        }

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "Rent_Object",
        joinColumns = [JoinColumn(name = "rent_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "obj_id", referencedColumnName = "id")]
    )
    var rentObjects: MutableList<ReservationObject> = arrayListOf()
}