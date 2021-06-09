package com.vlad.mas_project.repositories

import com.vlad.mas_project.models.db.Client
import com.vlad.mas_project.models.db.Person
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : CrudRepository<Person, Long> {

    @Query("SELECT true FROM Person WHERE email = :email")
    fun isExistWithEmail(@Param("email") email: String): Boolean?


    @Query("SELECT p FROM Person p WHERE p.email = :email AND p.password = :password")
    fun findByEmailAndPassword(@Param("email") email: String, @Param("password") password: String): Person

}