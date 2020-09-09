package com.goranm.vehiclemakeandmodel.fragments.vehicleMake

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.goranm.vehiclemakeandmodel.R
import com.goranm.vehiclemakeandmodel.viewmodel.VehicleMakeViewModel
import kotlinx.android.synthetic.main.fragment_vehicle_make.view.*


class VehicleMakeFragment : Fragment() {

    private lateinit var mVehicleViewModel: VehicleMakeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_vehicle_make, container, false)

        //Recycler
        val adapter = ListAdapterMake()
        val recyclerView = view.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //ViewModel
        mVehicleViewModel = ViewModelProvider(this).get(VehicleMakeViewModel::class.java)

        mVehicleViewModel.readAllData.observe(viewLifecycleOwner, Observer {
          //  mVehicleViewModel.compareForStartInput(it)
            adapter.setData(it)
        })

        view.button_add_new_vehicle.setOnClickListener {
            findNavController().navigate(R.id.action_vehicleMakeFragment_to_addVehicleMake)
        }


        setHasOptionsMenu(true)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_delete,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete){
            deleteUser()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteUser(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_,_ ->
            mVehicleViewModel.deleteAllVehicle()
            Toast.makeText(requireContext(), "Succesfully removed all data!", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No"){_,_ -> }
        builder.setTitle("Delete All Data?")
        builder.setMessage("Are you sure u want to delete everything from db?")
        builder.create().show()
    }


}