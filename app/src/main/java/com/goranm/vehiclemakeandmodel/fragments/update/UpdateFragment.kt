package com.goranm.vehiclemakeandmodel.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.goranm.vehiclemakeandmodel.R
import com.goranm.vehiclemakeandmodel.model.VehicleMake
import com.goranm.vehiclemakeandmodel.viewmodel.VehicleMakeViewModel
import kotlinx.android.synthetic.main.fragment_add_vehicle_make.view.*
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var viewModel : VehicleMakeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)
        viewModel = ViewModelProvider(this).get(VehicleMakeViewModel::class.java)


        view.et_update_name.setText(args.currentVehicle.name)
        view.et_update_abrv.setText(args.currentVehicle.abrv)

        view.button_update_add.setOnClickListener {
            updateItem()
        }

        setHasOptionsMenu(true)

        return view
    }

    private fun updateItem(){
        val name = et_update_name.text.toString()
        val abrv = et_update_abrv.text.toString()

        if (inputCheck(name,abrv)){
            val updateVehicle = VehicleMake(args.currentVehicle.id,name,abrv, emptyList())

            viewModel.updateVehicleMake(updateVehicle)
            Toast.makeText(requireContext(), "Succesfully updated", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_vehicleMakeFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fileds", Toast.LENGTH_SHORT).show()
        }

    }

    private fun inputCheck(name: String, abrv: String): Boolean{
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(abrv))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_delete, menu)
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
            viewModel.deleteVehicle(args.currentVehicle)
            Toast.makeText(requireContext(), "Succesfully removed!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_vehicleMakeFragment)
        }
        builder.setNegativeButton("No"){_,_ -> }
        builder.setTitle("Delete ${args.currentVehicle.abrv}")
        builder.setMessage("Are you sure u want to delete ${args.currentVehicle.abrv}?")
        builder.create().show()
    }
}