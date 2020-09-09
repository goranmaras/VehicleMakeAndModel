package com.goranm.vehiclemakeandmodel.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.goranm.vehiclemakeandmodel.data.VehicleDatabase
import com.goranm.vehiclemakeandmodel.repository.VehicleMakeRepository
import com.goranm.vehiclemakeandmodel.model.VehicleMake
import com.goranm.vehiclemakeandmodel.util.DataGenerator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VehicleMakeViewModel(application: Application): AndroidViewModel(application) {

    val TAG = "ViewModel"

    val readAllData: LiveData<List<VehicleMake>>
    private val repository: VehicleMakeRepository

    init {
        val vehicleMakeDao = VehicleDatabase.getDatabase(application).vehicleMakeDao()
        repository = VehicleMakeRepository(vehicleMakeDao)
        readAllData = repository.readAllData
    }

    fun addVehicleMake(vehicleMake: VehicleMake){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addVehicleMake(vehicleMake)
        }
    }

    fun updateVehicleMake(vehicleMake: VehicleMake){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateVehicle(vehicleMake)
        }
    }

    fun deleteVehicle(vehicleMake: VehicleMake){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteVehicle(vehicleMake)
        }
    }

    fun deleteAllVehicle(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllVehicle()
        }
    }

    fun initalData(){
        for (i in DataGenerator.startingList){
            addVehicleMake(i)
        }
    }

}