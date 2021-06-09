package com.vlad.mas_project.models.db

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
class Token (val expirationDate: Long = 0L, val uuid: String = "") {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0

    @ManyToOne
    var person: Person = Person()
        set(value) {
            field = value
            value.tokens.add(this)
        }
}