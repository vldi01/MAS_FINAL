package com.vlad.mas_project.models.db

import javax.persistence.*

@Entity
class Token (val expirationDate: Long = 0L, val uuid: String = "") {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0

    @ManyToOne
    val person: Person = Person()
}