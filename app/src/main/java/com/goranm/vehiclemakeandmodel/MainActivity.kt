package com.goranm.vehiclemakeandmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.goranm.vehiclemakeandmodel.viewmodel.VehicleMakeViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mVehicleViewModel: VehicleMakeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mVehicleViewModel = ViewModelProvider(this).get(VehicleMakeViewModel::class.java)
        mVehicleViewModel.initalData()

        setupActionBarWithNavController(findNavController(R.id.fragment))
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}