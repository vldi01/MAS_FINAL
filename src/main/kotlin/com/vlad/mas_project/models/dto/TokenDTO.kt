package com.vlad.mas_project.models.dto

import com.vlad.mas_project.models.db.Token

class TokenDTO(val expirationDate: Long = 0L, val uuid: String = "") {
}
fun Token.dto() = TokenDTO(expirationDate, uuid)