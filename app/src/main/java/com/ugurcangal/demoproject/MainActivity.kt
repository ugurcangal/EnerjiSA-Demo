package com.ugurcangal.demoproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ugurcangal.demoproject.model.Menu
import com.ugurcangal.demoproject.service.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }

}