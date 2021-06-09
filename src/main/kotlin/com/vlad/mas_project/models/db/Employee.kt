package com.vlad.mas_project.models.db

import javax.persistence.*

@Entity(name = "Employee")
open class Employee(
    name: String = "",
    surname: String = "",
    birthday: Long = 0L,
    city: String = "",
    phones: List<String> = listOf(),
    email: String = "",
    @Column(name = "start_date")
    open var startDate: Long? = null
): Person(name, surname, birthday, city, phones, email){
    override fun toString(): String {
        return "Employee(startDate=$startDate) ${super.toString()}"
    }
}