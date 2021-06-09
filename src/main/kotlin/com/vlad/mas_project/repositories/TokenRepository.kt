package com.vlad.mas_project.repositories

import com.vlad.mas_project.models.db.Token
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface TokenRepository : CrudRepository<Token, String> {

    @Query("SELECT true FROM Token token WHERE token.uuid = :value")
    fun isExist(@Param("value") value: String): Boolean?

    @Query("SELECT token.person.id FROM Token token WHERE token.uuid = :value")
    fun getUserIdByToken(@Param("value") value: String): Long?

}