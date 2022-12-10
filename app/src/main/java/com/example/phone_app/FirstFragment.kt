package com.example.phone_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.phone_app.databinding.FragmentFirstBinding
import com.example.phone_app.databinding.FragmentSecondBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private val list= arrayListOf<Phone>()
private lateinit var adapter:AdapterPhone
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentFirstBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {

        list.(Phone("Phone 13", "124900"))
        list.add(Phone("Phone 13 Pro Max", "150990"))
        list.add(Phone("Phone 12", "100900"))
        list.add(Phone("Phone 11", "90000"))
        list.add(Phone("Phone 10", "60000"))

        adapter = AdapterPhone(list)
        adapter.onClick = {
            val bundle=Bundle()
            bundle.putSerializable("key",it)
            findNavController().navigate(R.id.secondFragment,bundle)
        }
        binding.recycle.adapter = adapter
    }

}