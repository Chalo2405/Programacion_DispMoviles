package com.example.editorperfil

import java.io.Serializable

data class Usuario(
    val nombre: String,
    val edad: Int,
    val ciudad: String,
    val email: String
) : Serializable
