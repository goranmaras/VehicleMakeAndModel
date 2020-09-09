package com.goranm.vehiclemakeandmodel.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.goranm.vehiclemakeandmodel.R
import com.goranm.vehiclemakeandmodel.viewmodel.VehicleMakeViewModel
import com.goranm.vehiclemakeandmodel.model.VehicleMake
import kotlinx.android.synthetic.main.fragment_add_vehicle_make.*
import kotlinx.android.synthetic.main.fragment_add_vehicle_make.view.*


class AddVehicleMake : Fragment() {

    private lateinit var mVehicleViewModel : VehicleMakeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_vehicle_make, container, false)
        mVehicleViewModel = ViewModelProvider(this).get(VehicleMakeViewModel::class.java)


        view.buttonAdd.setOnClickListener {
            insertDataToDatabase()
        }
        
        return view
    }

    private fun insertDataToDatabase() {
        val vehicleName = et_name.text.toString()
        val vechileAbrv = et_abrv.text.toString()

        if (inputCheck(vehicleName,vechileAbrv)){
            val vehicleMake = VehicleMake(0,vehicleName,vechileAbrv, emptyList())

            mVehicleViewModel.addVehicleMake(vehicleMake)
            Toast.makeText(requireContext(), "Succesfully added", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addVehicleMake_to_vehicleMakeFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fileds", Toast.LENGTH_SHORT).show()
        }

    }

    private fun inputCheck(name: String, abrv: String): Boolean{
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(abrv))
    }
}