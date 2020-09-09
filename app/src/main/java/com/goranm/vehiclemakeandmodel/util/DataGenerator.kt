package com.goranm.vehiclemakeandmodel.util

import com.goranm.vehiclemakeandmodel.model.VehicleMake
import com.goranm.vehiclemakeandmodel.model.VehicleModel

object DataGenerator {

    val listOfBmw = listOf<VehicleModel>(
        VehicleModel("5 Series", "5 Series Picture"),
        VehicleModel("6 Series", "6 Series Picture")
    )

    val listofAudi = listOf<VehicleModel>(
        VehicleModel("A7","Picture of A7"),
        VehicleModel("A8", "Picture of A8")
    )

    val listofTesla = listOf<VehicleModel>(
        VehicleModel("Model S","Picture of Model S"),
        VehicleModel("Model 3", "Picture of Model 3")
    )

    val listOfRolls = listOf<VehicleModel>(
        VehicleModel("Rolls Royce Ghost","Picture of Rolls Ghost"),
        VehicleModel("Rolls Royce Phantom", "Picture of Rolls Phantom")
    )

    val listOfPorshe = listOf<VehicleModel>(
        VehicleModel("Cayman","Picture of Cayman"),
        VehicleModel("Boxter", "Picture of Boxter")
    )


    val startingList = listOf<VehicleMake>(
        VehicleMake(1,"Bayerische Motoren Werke","BMW", listOfBmw),
        VehicleMake(2,"Auto Union Deutschland Ingolstadt","Audi", listofAudi),
        VehicleMake(3,"Electric Cars, Solar & Clean Energy","Tesla", listofTesla),
        VehicleMake(4,"Rolls-Royce Holdings","Rolls-Royce", listOfRolls),
        VehicleMake(5,"Piece Of Retired Scrap, Continually High Expense Car, Technology, Driving","Porsche",
            listOfPorshe)
    )

}