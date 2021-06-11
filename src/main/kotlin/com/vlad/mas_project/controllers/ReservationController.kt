package com.vlad.mas_project.controllers

import com.vlad.mas_project.models.dto.*
import com.vlad.mas_project.repositories.ReservationRepository
import com.vlad.mas_project.repositories.TokenRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/reservations")
class ReservationController(
    val tokenRepository: TokenRepository,
    val reservationRepository: ReservationRepository
) {
    @PostMapping()
    fun reserve(@RequestBody reservation: ReservationDTO): ResponseEntity<VAResponse> {
        val client = reservation.token?.let {
            tokenRepository.getClientByUuid(it.uuid)
        } ?: return response(Error.BadLogin)

        val reservationEntity = reservation.entity()
        reservationEntity.client = client

        reservationRepository.save(reservationEntity)

        return response(body = client.dto())
    }
}