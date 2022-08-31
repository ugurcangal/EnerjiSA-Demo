package com.ugurcangal.demoproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ugurcangal.demoproject.R
import com.ugurcangal.demoproject.adapter.ResultObjectAdapter
import com.ugurcangal.demoproject.databinding.FragmentRandevuBinding
import com.ugurcangal.demoproject.viewmodel.RandevuViewModel
import kotlinx.coroutines.cancel


class RandevuFragment : Fragment() {

    private lateinit var binding: FragmentRandevuBinding
    private lateinit var viewModel: RandevuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: RandevuViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_randevu, container, false)
        binding.randevuFragment = this
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getMenuCoroutine()
        observeMenuLiveData()
    }

    private fun observeMenuLiveData(){
        viewModel.observeMenuLiveData().observe(viewLifecycleOwner){
            val adapter = ResultObjectAdapter(requireContext(),it)
            binding.resultObjectAdapter = adapter
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        viewModel.job.cancel()
    }
}