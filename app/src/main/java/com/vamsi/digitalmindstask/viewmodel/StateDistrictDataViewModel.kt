package com.vamsi.digitalmindstask

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StateDistrictDataViewModel : ViewModel() {
    var stateDistricsWiseData: MutableLiveData<List<StateDistricsWiseData>>? = null
    val stateDistrictsRepository = StateDistrictsRepository()
    fun getStateDistrictData(): MutableLiveData<List<StateDistricsWiseData>> {
        return stateDistrictsRepository.getStatesDataFromServer()
    }
}