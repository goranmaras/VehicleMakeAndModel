package com.goranm.vehiclemakeandmodel.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.goranm.vehiclemakeandmodel.model.VehicleModel
import java.lang.reflect.Type
import java.util.*

class Converters {

        companion object {
            var gson = Gson()
            @TypeConverter
            @JvmStatic
            fun stringToSomeObjectList(data: String?): List<VehicleModel> {
                if (data == null) {
                    return Collections.emptyList()
                }
                val listType: Type = object : TypeToken<List<VehicleModel?>?>() {}.type
                return gson.fromJson<List<VehicleModel>>(data, listType)
            }

            @TypeConverter
            @JvmStatic
            fun someObjectListToString(someObjects: List<VehicleModel?>?): String {
                return gson.toJson(someObjects)
            }
        }

//    var gson = Gson()
//    @TypeConverter
//    fun stringToSomeObjectList(data: String?): List<VehicleModel> {
//        if (data == null) {
//            return Collections.emptyList()
//        }
//        val listType: Type = object : TypeToken<List<VehicleModel?>?>() {}.type
//        return gson.fromJson<List<VehicleModel>>(data, listType)
//    }
//
//    @TypeConverter
//    fun someObjectListToString(someObjects: List<VehicleModel?>?): String {
//        return gson.toJson(someObjects)
//    }

}