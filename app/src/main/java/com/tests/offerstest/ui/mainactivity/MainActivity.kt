package com.tests.offerstest.ui.mainactivity

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.tests.offerstest.R
import com.tests.offerstest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_responce,
                R.id.navigation_search,
                R.id.navigation_favorites,
                R.id.navigation_messages,
                R.id.navigation_profile,
                R.id.navigation_entry
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navView.menu.setGroupEnabled(0, false)


        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (
                (destination.id == R.id.navigation_entry) ||
                (destination.id == R.id.navigation_verification) ||
                (destination.id == R.id.navigation_card_vacancy)
                ) {
                supportActionBar?.show()
            } else {
                supportActionBar?.hide()
            }

            if (destination.id == R.id.navigation_card_vacancy)
            {
                navView.visibility = View.GONE
            } else {
                navView.visibility = View.VISIBLE
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}