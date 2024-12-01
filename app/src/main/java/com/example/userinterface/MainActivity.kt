package com.example.userinterface

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.drawerlayout.widget.DrawerLayout
import com.example.userinterface.ui.theme.UserInterfaceTheme
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.ActionBarDrawerToggle

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize DrawerLayout and NavigationView
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        // Button to navigate to the next activity
        val btnNextActivity: Button = findViewById(R.id.btnNextActivity)
        btnNextActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        // Button to open the drawer
        val btnOpenDrawer: Button = findViewById(R.id.btnOpenDrawer)
        btnOpenDrawer.setOnClickListener {
            drawerLayout.openDrawer(navView) // Open the navigation drawer
        }

        // Handle navigation item clicks
        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_main -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_second -> {
                    val intent = Intent(this, SecondActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_easter_egg -> {
                    Toast.makeText(
                        this,
                        "Félicitations, vous avez trouvé l'Easter Egg ! Vous gagnez 1 point bonus.",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
            drawerLayout.closeDrawers() // Close the drawer after an item is selected
            true
        }
    }
}