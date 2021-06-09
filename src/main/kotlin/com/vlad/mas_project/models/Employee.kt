package com.vlad.mas_project.models

import javax.persistence.*

@Entity(name = "Employee")
class Employee(
    name: String? = null,
    surname: String? = null,
    phone: String? = null,
    city: String? = null,
    @Column(name = "start_date")
    var startDate: Long? = null
): Person(name, surname, phone, city){
    override fun toString(): String {
        return "Employee(startDate=$startDate) ${super.toString()}"
    }
}