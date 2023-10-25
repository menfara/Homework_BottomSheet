package com.example.homework_bottomsheet

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ChargePoint(
    val stationImageResId: Int,
    val stationName: String,
    val address: String,
    val portsAvailable: Int,
    val portType: String,
    val cost: String,
    val power: String
) : Parcelable
