package com.kawunus.skufar

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.kawunus.skufar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.includedLayout.toolbar, R.string.open_driver, R.string.close_driver)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

}