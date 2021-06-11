package com.vlad.mas_project.repositories

import com.vlad.mas_project.models.db.Client
import com.vlad.mas_project.models.db.Person
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository : CrudRepository<Client, Long> {

    @Query("SELECT true FROM Client WHERE email = :email")
    fun isExistWithEmail(@Param("email") email: String): Boolean?


    @Query("SELECT c FROM Client c WHERE c.email = :email AND c.password = :password")
    fun findByEmailAndPassword(@Param("email") email: String, @Param("password") password: String): Client?

}