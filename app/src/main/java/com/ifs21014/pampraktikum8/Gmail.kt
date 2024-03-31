package com.ifs21014.pampraktikum8

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Gmail(
    val img: Int,
    val pengirim: String,
    val waktu: String,
    val pesan: String
) : Parcelable
