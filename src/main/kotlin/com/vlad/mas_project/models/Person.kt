package com.vlad.mas_project.models

import javax.persistence.*

@Entity(name = "Person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
open class Person(
    open var name: String? = null,
    open var surname: String? = null,
    open var phone: String? = null,
    open var city: String? = null,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id = 0
    override fun toString(): String {
        return "Person(name=$name, surname=$surname, phone=$phone, city=$city, id=$id)"
    }
}