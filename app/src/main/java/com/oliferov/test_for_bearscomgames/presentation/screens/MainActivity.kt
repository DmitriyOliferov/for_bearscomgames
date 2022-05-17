package com.oliferov.test_for_bearscomgames.presentation.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.oliferov.test_for_bearscomgames.R
import com.oliferov.test_for_bearscomgames.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val drawerLayout = binding.dlMain
        val navView = binding.nvMain
        val navController = findNavController(R.id.nav_fragment)
        appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_news_feed),drawerLayout)
        navView.setupWithNavController(navController)
        val navigationBottom = findViewById<BottomNavigationView>(R.id.navigation_bottom)
        navigationBottom.setupWithNavController(navController)




    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}