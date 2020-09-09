package com.goranm.vehiclemakeandmodel.fragments.vehicleMake

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.goranm.vehiclemakeandmodel.R
import com.goranm.vehiclemakeandmodel.model.VehicleMake
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapterMake(): RecyclerView.Adapter<ListAdapterMake.MyViewHolder>() {

    val TAG = "ListAdapter"

    private var vehicleList = emptyList<VehicleMake>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
       return vehicleList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currentItem = vehicleList[position]
       holder.itemView.tv_name.text = currentItem.name
        holder.itemView.tv_abrv.text = currentItem.abrv

        holder.itemView.rowLayout.setOnClickListener {
            Log.d(TAG, "onBindViewHolder: ${currentItem.list}")
            val action = VehicleMakeFragmentDirections.actionVehicleMakeFragmentToVehicleModelFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    fun setData(list: List<VehicleMake>){
        this.vehicleList = list
        notifyDataSetChanged()
    }

}