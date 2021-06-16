package com.vamsi.digitalmindstask

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StateDistrictsRepository {
    val getStateDistrictsWiseData = MutableLiveData<List<StateDistricsWiseData>>()
    fun getStatesDataFromServer(): MutableLiveData<List<StateDistricsWiseData>> {
        val dataCall = RetrofitInstance.apiInterface.getStatesDistrictData()
        dataCall.enqueue(object : Callback<List<StateDistricsWiseData>> {
            override fun onFailure(call: Call<List<StateDistricsWiseData>>, t: Throwable) {
                Log.e("Service:::", "Service failed")
            }

            override fun onResponse(
                call: Call<List<StateDistricsWiseData>>,
                response: Response<List<StateDistricsWiseData>>
            ) {
                if (response.isSuccessful) {
                    getStateDistrictsWiseData.value = response.body()
                }
            }

        })
        return getStateDistrictsWiseData
    }
}