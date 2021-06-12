package com.vlad.mas_project.controllers

import com.vlad.mas_project.models.dto.*
import com.vlad.mas_project.repositories.ReservationObjectsRepository
import com.vlad.mas_project.repositories.ReservationRepository
import com.vlad.mas_project.repositories.TokenRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/reservations")
class ReservationController(
    val tokenRepository: TokenRepository,
    val reservationRepository: ReservationRepository,
    val reservationObjectsRepository: ReservationObjectsRepository
) {
    @PostMapping("/book")
    fun reserve(@RequestBody reservation: ReservationDTO): ResponseEntity<VAResponse> {
        val client = reservation.token?.let {
            tokenRepository.getClientByUuid(it.uuid)
        } ?: return response(Error.BadLogin)

        val reservationEntity = reservation.entity()
        reservationEntity.client = client

        reservationRepository.save(reservationEntity)

        return response(body = client.dto())
    }

    @GetMapping("getObjects")
    fun getObjects(
        @RequestParam(value = "dateFrom", defaultValue = "") dateFrom: Long?,
        @RequestParam(value = "dateTo", defaultValue = "") dateTo: Long?
    ): ResponseEntity<VAResponse> {
        var objects = reservationObjectsRepository.findAll()

        if (dateFrom==null || dateFrom==0L || dateTo==null || dateTo==0L) return response(Error.BadRequest)

        objects = objects.filter {
            it.reservations.find { reservation ->
                dateFrom in (reservation.dateFrom!!..reservation.dateTo!!) ||
                dateTo in (reservation.dateFrom!!..reservation.dateTo!!) ||
                reservation.dateFrom in
                        (dateFrom..dateTo)
            } == null
        }

        return response(body = objects)
    }
}