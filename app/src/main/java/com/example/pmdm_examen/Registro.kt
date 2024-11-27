package com.example.pmdm_examen

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

//Los @ de esta clase son para que la dependecia de Json pueda convertirlo a cadena de texto

@Serializable
@Parcelize
data class Registro(
    val nombre:String,
    val apellido:String,
    val dni:String,
    val mail:String
): Parcelable

