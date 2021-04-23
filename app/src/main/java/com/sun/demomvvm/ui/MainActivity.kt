package com.sun.demomvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.sun.demomvvm.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navigationHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentNavigationHost) as NavHostFragment
        val navigationController = navigationHostFragment.navController
        bottomNavigationView.apply {
            setupWithNavController(navigationController)
            setOnNavigationItemSelectedListener {
                if (it.itemId != bottomNavigationView.selectedItemId) {
                    NavigationUI.onNavDestinationSelected(it, navigationController)
                }
                true
            }
        }
    }
}
