package com.goranm.vehiclemakeandmodel.fragments.vehicleModel

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.goranm.vehiclemakeandmodel.R
import com.goranm.vehiclemakeandmodel.fragments.vehicleMake.ListAdapterMake
import kotlinx.android.synthetic.main.fragment_vehicle_make.view.*
import kotlinx.android.synthetic.main.fragment_vehicle_model.view.*

class VehicleModelFragment : Fragment() {

    private val args by navArgs<VehicleModelFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_vehicle_model, container, false)

        val adapter = ListAdapterModel()
        val recyclerView = view.recyclerViewModel
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter.setData(args.currentVehicleObject.list)

        return view
    }

}