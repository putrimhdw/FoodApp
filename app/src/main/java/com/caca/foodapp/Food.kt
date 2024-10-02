package com.caca.foodapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Food(
    val name : String,
    val description : String,
    val image : String,
    val calorie : Int,
    val category : String
) : Parcelable
