package com.vlad.mas_project.repositories

import com.vlad.mas_project.models.db.Client
import com.vlad.mas_project.models.db.Reservation
import com.vlad.mas_project.models.db.Token
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
interface ReservationRepository : CrudRepository<Reservation, String> {

}