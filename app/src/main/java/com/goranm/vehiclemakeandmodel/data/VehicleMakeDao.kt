package com.goranm.vehiclemakeandmodel.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.goranm.vehiclemakeandmodel.model.VehicleMake

@Dao
interface VehicleMakeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addVehicleMake(vehicleMake: VehicleMake)

    @Query("select * from vehicle_make_table")
    fun readAllData(): LiveData<List<VehicleMake>>

    @Update
    suspend fun updateVehicleMake(vehicleMake: VehicleMake)

    @Delete
    suspend fun deleteVehicle(vehicleMake: VehicleMake)

    @Query("delete from vehicle_make_table")
    suspend fun deleteAllVehicle()
}