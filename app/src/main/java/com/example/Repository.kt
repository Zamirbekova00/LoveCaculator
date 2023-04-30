package com.example

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.remote.LoveModel
import com.example.remote.RetrofitService
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class Repository {

    fun getLove(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        var liveLove = MutableLiveData<LoveModel>()

        RetrofitService().api.percentageName(firstName, secondName)
            .enqueue(object : retrofit2.Callback<LoveModel> {
                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                    if (response.isSuccessful) {
                        liveLove.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                    Log.e("kalbusha", "onFailure: ${t.message}")
                }
            })
        return liveLove
    }
}