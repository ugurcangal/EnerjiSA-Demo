package com.ugurcangal.demoproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ugurcangal.demoproject.model.Menu
import com.ugurcangal.demoproject.model.Result
import com.ugurcangal.demoproject.model.ResultObject
import com.ugurcangal.demoproject.service.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RandevuViewModel : ViewModel() {

    private var resultObjectList = MutableLiveData<List<ResultObject>>()
    val job = CoroutineScope(Dispatchers.IO)

    fun getMenuCoroutine(){
       job.launch {
            val response = RetrofitInstance.api.getMenuItems()
            withContext(Dispatchers.Main){
                if (response.isSuccessful){
                    response.body()?.let {
                        resultObjectList.value = it.result.resultObject
                    }
                }
            }
        }
    }


    fun observeMenuLiveData() : LiveData<List<ResultObject>>{
        return resultObjectList
    }
}