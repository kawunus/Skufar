package com.kawunus.skufar.utils.dialogHelper

object DialogConsts{
    sealed interface DialogState{
        data object SignUp : DialogState
        data object SignIn : DialogState
    }
}