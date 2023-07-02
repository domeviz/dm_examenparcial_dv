package com.vizcarra.domenica.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Datos(val nombre: String,
                 val asunto: String,
                 val cuerpo: String,
                 val imagen: String) : Parcelable