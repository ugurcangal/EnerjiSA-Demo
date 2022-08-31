package com.ugurcangal.demoproject.service

import com.ugurcangal.demoproject.model.Menu
import com.ugurcangal.demoproject.model.Result
import com.ugurcangal.demoproject.model.ResultObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface API {


    @GET("bydevelopertr/enerjisa/main/menu.json")
    suspend fun getMenuItems() : Response<Menu>
}