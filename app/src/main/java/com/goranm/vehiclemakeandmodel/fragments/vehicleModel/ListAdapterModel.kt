package com.goranm.vehiclemakeandmodel.fragments.vehicleModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.goranm.vehiclemakeandmodel.R
import com.goranm.vehiclemakeandmodel.model.VehicleMake
import com.goranm.vehiclemakeandmodel.model.VehicleModel
import kotlinx.android.synthetic.main.custom_row.view.*
import kotlinx.android.synthetic.main.custom_row_model.view.*

class ListAdapterModel: RecyclerView.Adapter<ListAdapterModel.MyViewHolder>() {

    private var vehicleModelList = emptyList<VehicleModel>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_row_model, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
       return vehicleModelList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = vehicleModelList[position]
        holder.itemView.tv_model_name.text = currentItem.name
        holder.itemView.tv_model_picture.text = currentItem.vehicleModelPicture
    }

    fun setData(list: List<VehicleModel>){
        this.vehicleModelList = list
        notifyDataSetChanged()
    }

}