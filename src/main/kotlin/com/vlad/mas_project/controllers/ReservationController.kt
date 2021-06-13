package com.vlad.mas_project.controllers

import com.vlad.mas_project.models.db.House
import com.vlad.mas_project.models.db.Reservation
import com.vlad.mas_project.models.db.Room
import com.vlad.mas_project.models.dto.*
import com.vlad.mas_project.models.requests.ReserveRequest
import com.vlad.mas_project.models.responses.ReservationsObjectsResponse
import com.vlad.mas_project.repositories.ReservationObjectsRepository
import com.vlad.mas_project.repositories.ReservationRepository
import com.vlad.mas_project.repositories.TokenRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

@RestController
@RequestMapping("/api/reservations")
class ReservationController(
    val tokenRepository: TokenRepository,
    val reservationRepository: ReservationRepository,
    val reservationObjectsRepository: ReservationObjectsRepository
) {
    @PostMapping("/book")
    fun reserve(@RequestBody reserveRequest: ReserveRequest): ResponseEntity<VAResponse> {
        val client = reserveRequest.token?.let {
            tokenRepository.getClientByUuid(it.uuid)
        } ?: return response(Error.BadLogin)

        val reservation = Reservation(
            reserveRequest.dateFrom,
            reserveRequest.dateTo
        ).also {res ->
            res.client = client
            res.reservationObjects = ArrayList(
                reserveRequest.ids
                    .map { reservationObjectsRepository.findById(it) }
                    .filter { it.isPresent }
                    .map { it.get() })
        }

        reservationRepository.save(reservation)

        return response(body = "")
    }

    @GetMapping("getObjects")
    fun getObjects(
        @RequestParam(value = "dateFrom", defaultValue = "") dateFrom: Long?,
        @RequestParam(value = "dateTo", defaultValue = "") dateTo: Long?
    ): ResponseEntity<VAResponse> {
        var objects = reservationObjectsRepository.findAll()

        if (dateFrom == null || dateFrom == 0L || dateTo == null || dateTo == 0L) return response(Error.BadRequest)

        objects = objects.filter {
            it.reservations.find { reservation ->
                (dateFrom >= reservation.dateFrom!! && dateFrom <= reservation.dateTo!!) ||
                        (dateTo >= reservation.dateFrom!! && dateTo <= reservation.dateTo!!) ||
                        (reservation.dateFrom!! >= dateFrom && reservation.dateFrom!! <= dateTo)
            } == null
        }

        val res = ReservationsObjectsResponse(
            objects.filterIsInstance<House>(),
            objects.filterIsInstance<Room>()
        )

        return response(body = res)
    }
}