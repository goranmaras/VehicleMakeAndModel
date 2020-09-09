package com.goranm.vehiclemakeandmodel.model

import android.os.Parcelable
import androidx.room.*
import com.goranm.vehiclemakeandmodel.util.Converters
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
@Entity(tableName = "vehicle_make_table")
data class VehicleMake(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    val name: String,
    val abrv: String,
    @TypeConverters(Converters::class)
    val list : @RawValue List<VehicleModel>
): Parcelable{
    constructor(): this(0,"","", emptyList())
}