package com.vlad.mas_project.models.db

import javax.persistence.*

@Entity(name = "Person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
open class Person(
    open var name: String = "",
    open var surname: String = "",
    open var birthday: Long = 0L,
    open var city: String = "",
    @ElementCollection
    open var phones: List<String> = listOf(),
    open var email: String = "",
    open var password: String = ""
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id = 0
    override fun toString(): String {
        return "Person(name=$name, surname=$surname, phone=$phones, city=$city, id=$id)"
    }

    @OneToMany(mappedBy = "person")
    open val tokens: List<Token> = listOf()
}