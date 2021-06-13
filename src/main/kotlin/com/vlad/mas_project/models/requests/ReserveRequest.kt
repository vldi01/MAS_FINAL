package com.vlad.mas_project.models.requests

import com.vlad.mas_project.models.dto.TokenDTO

data class ReserveRequest(
    val ids: List<Int> = listOf(),
    val dateFrom: Long = 0L,
    val dateTo: Long = 0L,
    val token: TokenDTO? = null
)
