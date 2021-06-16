package com.vamsi.digitalmindstask

data class StateDistricsWiseData(
    val state: String,
    val statecode: String,
    val districtData: List<District>
)