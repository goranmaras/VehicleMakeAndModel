package com.goranm.vehiclemakeandmodel.repository

import androidx.lifecycle.LiveData
import com.goranm.vehiclemakeandmodel.data.VehicleMakeDao
import com.goranm.vehiclemakeandmodel.model.VehicleMake

class VehicleMakeRepository(private val vehicleMakeDao: VehicleMakeDao) {

    val readAllData: LiveData<List<VehicleMake>> = vehicleMakeDao.readAllData()

    suspend fun addVehicleMake(vehicleMake: VehicleMake){
        vehicleMakeDao.addVehicleMake(vehicleMake)
    }

    suspend fun updateVehicle(vehicleMake: VehicleMake){
        vehicleMakeDao.updateVehicleMake(vehicleMake)
    }

    suspend fun deleteVehicle(vehicleMake: VehicleMake){
        vehicleMakeDao.deleteVehicle(vehicleMake)
    }

    suspend fun deleteAllVehicle(){
        vehicleMakeDao.deleteAllVehicle()
    }

}