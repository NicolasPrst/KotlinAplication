package com.project.kotlinaplication.Presentation.Main

import android.provider.ContactsContract

sealed class LoginStatus

data class LoginSuccess(val email: String): LoginStatus()
object LoginError : LoginStatus()