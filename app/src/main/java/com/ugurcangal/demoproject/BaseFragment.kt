package com.ugurcangal.demoproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ugurcangal.demoproject.viewmodel.RandevuViewModel
import java.lang.IllegalArgumentException

abstract class BaseFragment<VB: ViewDataBinding, VM : ViewModel> : Fragment(){

    lateinit var binding : VB
    lateinit var viewModel : VM


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,getFragmentView(),container,false)
        viewModel = ViewModelProvider(this)[getViewModel()]
        return binding.root


    }

    abstract fun getFragmentView(): Int

    abstract fun getViewModel() : Class<VM>
}