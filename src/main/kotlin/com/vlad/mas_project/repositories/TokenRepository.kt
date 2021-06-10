package com.vlad.mas_project.repositories

import com.vlad.mas_project.models.db.Person
import com.vlad.mas_project.models.db.Token
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
interface TokenRepository : CrudRepository<Token, String> {

    @Query("SELECT true FROM Token token WHERE token.uuid = :uuid")
    fun isExist(@Param("uuid") uuid: String): Boolean?

    @Query("SELECT token.person FROM Token token WHERE token.uuid = :uuid")
    fun getPersonByUuid(@Param("uuid") uuid: String): Person?

    @Transactional
    @Modifying
    @Query("delete from Token where uuid = :uuid")
    fun deleteByUuid(@Param("uuid") uuid: String)

}