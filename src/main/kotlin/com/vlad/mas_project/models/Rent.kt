package com.vlad.mas_project.models

import data.entity.Status

data class Rent(
    var dateFrom: Long,
    var dateTo: Long,
    var peopleNumber: Int,
    var additionalInfo: String,
    var status: Status
) {
    private var rentObjects: ArrayList<RentObject> = arrayListOf()
    var client: Client = Client()

    fun addRentObject(rentObject: RentObject) {
        if (rentObject.rent == null) {
            rentObjects.add(rentObject)
            rentObject.rent = this
        } else {
            throw Exception("RentObject already has a rent")
        }
    }
}