package com.kawunus.skufar

sealed class AuthResponse {
    data object Successful : AuthResponse()
    data class Error(val message: String) : AuthResponse()
}