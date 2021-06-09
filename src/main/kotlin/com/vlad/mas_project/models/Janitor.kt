package com.vlad.mas_project.models

class Janitor(
    name: String = "",
    surname: String = "",
    birthday: Long = 0L,
    city: String = "",
    phones: List<String> = listOf(),
    email: String = "",
    startDate: Long
): Employee(name, surname, birthday, city, phones, email, startDate)