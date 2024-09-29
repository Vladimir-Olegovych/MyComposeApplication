package com.baron.domain.model

import com.google.gson.annotations.SerializedName

class NetworkResponse(
    @SerializedName("Date")
    val date: String = "",
    @SerializedName("PreviousDate")
    val previousDate: String = "",
    @SerializedName("PreviousURL")
    val previousURL: String = "",
    @SerializedName("Timestamp")
    val timestamp: String = "",
    @SerializedName("Valute")
    val stats: Map<String, Coin> = emptyMap()
)