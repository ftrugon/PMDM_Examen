package com.example.pmdm_examen

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable


@Serializable
@Parcelize
data class Registro(
    val nombre:String,
    val apellido:String,
    val dni:String,
    val mail:String
): Parcelable

