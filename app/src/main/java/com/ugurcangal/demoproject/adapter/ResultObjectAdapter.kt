package com.ugurcangal.demoproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ugurcangal.demoproject.R
import com.ugurcangal.demoproject.databinding.MenuItemRowBinding
import com.ugurcangal.demoproject.model.ResultObject
import com.ugurcangal.demoproject.view.RandevuFragment

class ResultObjectAdapter(var mContext: Context,
                          val resultListesi : List<ResultObject>) : RecyclerView.Adapter<ResultObjectAdapter.MenuViewHolder>() {

   inner class MenuViewHolder(binding: MenuItemRowBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding :MenuItemRowBinding
        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding: MenuItemRowBinding = DataBindingUtil.inflate(layoutInflater,R.layout.menu_item_row, parent,false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val resultItem = resultListesi[position].value
        holder.binding.menuItem = resultItem

        holder.binding.itemImageView.setImageResource(
            when(resultListesi[position].key){
                1 -> R.drawable.ic_abonelik
                2 -> R.drawable.ic_dilekce
                4 -> R.drawable.ic_tahliye
                5 -> R.drawable.ic_nakil
                else -> R.drawable.ic_abonelik
            }
        )

        holder.binding.menuCard.setOnClickListener {
            when(resultListesi[position].key){
                1 -> Navigation.findNavController(it).navigate(R.id.action_randevuFragment_to_yeniAboneFragment)
            }
        }

    }

    override fun getItemCount(): Int {
        return resultListesi.size
    }
}