package com.ugurcangal.demoproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.ugurcangal.demoproject.R
import com.ugurcangal.demoproject.databinding.FragmentYeniAboneBinding


class YeniAboneFragment : Fragment() {

    private lateinit var binding: FragmentYeniAboneBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_yeni_abone, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val abonelikTipi = arrayOf("Mesken(Konut)", "Ticarethane", "Sanayi")
        val adapter = ArrayAdapter<String>(requireContext(), androidx.transition.R.layout.support_simple_spinner_dropdown_item,abonelikTipi)
        binding.abonelikTipiSpinner.adapter = adapter

        binding.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }




        binding.imageInfo.setOnClickListener {
            if (binding.cardConstraint3.visibility == View.GONE){
                binding.cardConstraint3.visibility = View.VISIBLE
            }else{
                binding.cardConstraint3.visibility = View.GONE
            }
        }

        binding.popupCloseBtn.setOnClickListener {
            binding.cardConstraint3.visibility = View.GONE
        }
    }

}