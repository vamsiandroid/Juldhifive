package com.vamsi.digitalmindstask

data class District(
    val district: String,
    val notes: String,
    val active: Long,
    val confirmed: Long,
    val migratedother: Int,
    val deceased: Long,
    val recovered: Long,
    val delta: Delta
)
