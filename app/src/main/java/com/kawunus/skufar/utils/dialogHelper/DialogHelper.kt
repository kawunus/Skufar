package com.kawunus.skufar.utils.dialogHelper

import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import com.kawunus.skufar.AuthHelper
import com.kawunus.skufar.AuthResponse
import com.kawunus.skufar.R
import com.kawunus.skufar.databinding.SignDialogBinding
import com.kawunus.skufar.presentation.activity.main.ui.MainActivity

class DialogHelper(private val activity: MainActivity, private val authHelper: AuthHelper) {

    fun showSignDialog(state: DialogConsts.DialogState) {
        val dialogBuilder = AlertDialog.Builder(activity)
        val binding = SignDialogBinding.inflate(activity.layoutInflater)
        when (state) {
            DialogConsts.DialogState.SignIn -> {
                binding.titleTextView.text = activity.getString(R.string.acc_sign_in)
                binding.signButton.text = activity.getString(R.string.sign_in_action)
                binding.resetPasswordButton.isVisible = true

                binding.signButton.setOnClickListener {
                }
            }

            DialogConsts.DialogState.SignUp -> {
                binding.titleTextView.text = activity.getString(R.string.acc_sign_up)
                binding.signButton.text = activity.getString(R.string.sign_up_action)
                binding.resetPasswordButton.isVisible = false

                binding.signButton.setOnClickListener {
                    val email = binding.emailEditText.text.toString()
                    val password = binding.passwordEditText.text.toString()
                    signUp(email, password)
                }
            }
        }
        dialogBuilder.setView(binding.root)
        dialogBuilder.show()
    }

    private fun signUp(email:String, password:String){
        authHelper.signUpWithEmail(email, password) { response ->
            when (response) {
                is AuthResponse.Error -> {
                    Toast.makeText(activity, response.message, Toast.LENGTH_LONG).show()
                }

                AuthResponse.Successful -> {
                    Toast.makeText(
                        activity,
                        activity.getString(R.string.sign_in_success),
                        Toast.LENGTH_LONG
                    ).show()

                }
            }
        }
    }
}