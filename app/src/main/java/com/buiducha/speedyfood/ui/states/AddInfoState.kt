package com.buiducha.speedyfood.ui.states

import java.util.Date

data class AddInfoState(
    val fullName: String = "",
    val phoneNumber: String = "",
    val dateOfBirth: String = "",
    val gender: Boolean = true
)
