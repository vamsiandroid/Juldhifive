package com.vamsi.digitalmindstask

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("state_district_wise.json")
    fun getStatesDistrictData(): Call<List<StateDistricsWiseData>>
}
