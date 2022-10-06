package com.example.phonecontacts.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val f_name: String,
    val name: String,
    val phone: String,
    val image_url: String
): Parcelable
