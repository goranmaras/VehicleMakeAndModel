package com.goranm.vehiclemakeandmodel.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class VehicleModel(
    val name: String,
    val vehicleModelPicture: String
) {
}