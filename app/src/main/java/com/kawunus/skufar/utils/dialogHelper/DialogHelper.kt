package com.kawunus.skufar.utils.dialogHelper

import androidx.appcompat.app.AlertDialog
import com.kawunus.skufar.MainActivity
import com.kawunus.skufar.databinding.SignDialogBinding

class DialogHelper(private val activity: MainActivity) {

    fun provideSignDialog() {
        val dialogBuilder = AlertDialog.Builder(activity)
        val binding = SignDialogBinding.inflate(activity.layoutInflater)
        dialogBuilder.setView(binding.root)
        dialogBuilder.show()
    }
}