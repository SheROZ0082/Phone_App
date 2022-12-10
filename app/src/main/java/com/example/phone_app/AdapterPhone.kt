package com.example.phone_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.phone_app.databinding.ItemPhoneBinding

class AdapterPhone(var list:List<Phone>): RecyclerView.Adapter<AdapterPhone.ViewHolderPhone>() {
     var onClick: ((Phone) -> Unit?)? = null

     inner class ViewHolderPhone(var binding :ItemPhoneBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(phone: Phone) {
            binding.text.text = phone.phone
            binding.price.text = phone.price
itemView.setOnClickListener {
    onClick?.invoke(phone)
}

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPhone {
        return  ViewHolderPhone(ItemPhoneBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolderPhone, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
return list.size
    }
}