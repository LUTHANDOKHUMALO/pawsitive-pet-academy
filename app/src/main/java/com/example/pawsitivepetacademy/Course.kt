package com.example.pawsitivepetacademy

import java.io.Serializable

data class Course(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double
) : Serializable
