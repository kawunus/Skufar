package com.kawunus.skufar

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.kawunus.skufar.databinding.ActivityMainBinding
import com.kawunus.skufar.utils.dialogHelper.DialogConsts
import com.kawunus.skufar.utils.dialogHelper.DialogHelper

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    private val dialogHelper = DialogHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.includedLayout.toolbar,
            R.string.open_driver,
            R.string.close_driver
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean = with(binding) {
        when (item.itemId) {

            R.id.id_my_adds -> {

            }

            R.id.id_car -> {

            }

            R.id.id_pc -> {

            }

            R.id.id_dm -> {

            }

            R.id.id_sign_up -> {
                dialogHelper.provideSignDialog(DialogConsts.DialogState.SignUp)
            }

            R.id.id_sign_in -> {
                dialogHelper.provideSignDialog(DialogConsts.DialogState.SignIn)
            }

            R.id.id_sign_out -> {

            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

}