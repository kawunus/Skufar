package com.kawunus.skufar.utils.dialogHelper

import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import com.kawunus.skufar.MainActivity
import com.kawunus.skufar.R
import com.kawunus.skufar.databinding.SignDialogBinding

class DialogHelper(private val activity: MainActivity) {

    fun provideSignDialog(state : DialogConsts.DialogState) {
        val dialogBuilder = AlertDialog.Builder(activity)
        val binding = SignDialogBinding.inflate(activity.layoutInflater)

        when (state){
            DialogConsts.DialogState.SignIn -> {
                binding.titleTextView.text = activity.getString(R.string.acc_sign_in)
                binding.signButton.text = activity.getString(R.string.sign_in_action)
                binding.resetPasswordButton.isVisible = true
            }
            DialogConsts.DialogState.SignUp -> {
                binding.titleTextView.text = activity.getString(R.string.acc_sign_up)
                binding.signButton.text = activity.getString(R.string.sign_up_action)
                binding.resetPasswordButton.isVisible = false
            }
        }
        dialogBuilder.setView(binding.root)
        dialogBuilder.show()
    }
}