package com.kawunus.skufar

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthHelper(private val mAuth: FirebaseAuth) {

    fun signUpWithEmail(email: String, password: String, callback: (AuthResponse) -> Unit) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    sendEmailVerification(task.result.user!!, callback)
                } else {
                    callback.invoke(AuthResponse.Error("При регистрации произошла ошибка"))
                }
            }
        } else {
            callback(AuthResponse.Error("Поля email и пароль не должны быть пустыми"))
        }
    }

    private fun sendEmailVerification(user: FirebaseUser, callback: (AuthResponse) -> Unit) {
        user.sendEmailVerification().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                callback.invoke(AuthResponse.Successful)
            } else {
                callback.invoke(AuthResponse.Error("При отправке подтверждающего письма произошла ошибка!"))
            }
        }
    }
}
