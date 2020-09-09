package com.goranm.vehiclemakeandmodel.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.goranm.vehiclemakeandmodel.model.VehicleMake
import com.goranm.vehiclemakeandmodel.model.VehicleModel
import com.goranm.vehiclemakeandmodel.util.Converters

@Database(entities = [VehicleMake::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class VehicleDatabase: RoomDatabase() {

    abstract fun vehicleMakeDao(): VehicleMakeDao

    companion object {
        @Volatile
        private var INSTANCE: VehicleDatabase? = null

        fun getDatabase(context: Context): VehicleDatabase{
            val tempInstance = INSTANCE
            if (tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VehicleDatabase::class.java,
                    "vehicle_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }


}