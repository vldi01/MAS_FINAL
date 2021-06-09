package com.vlad.mas_project.models

class Janitor(
    name: String,
    surname: String,
    birthday: Long,
    city: String,
    phone: List<String>,
    startDate: Long
): Employee(name, surname, birthday, city, phone, startDate)