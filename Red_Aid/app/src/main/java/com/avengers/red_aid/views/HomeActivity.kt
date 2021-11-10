package com.avengers.red_aid.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.avengers.red_aid.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var selectedFragment: Fragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        onClickOperations()
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener)
        bottomNavigationView.selectedItemId = R.id.nav_home
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, HomeFragment(), "MY_FRAGMENT")
            .commit()

        val drawerNavigationView = findViewById<NavigationView>(R.id.nav_view)
        drawerNavigationView.setNavigationItemSelectedListener(this)
        drawerNavigationView.bringToFront()
        val toggle =
            ActionBarDrawerToggle(this, drawer_layout, R.string.Open_Drawer, R.string.Close_Drawer)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun onClickOperations() {

        ivMenu.setOnClickListener(View.OnClickListener {
            drawer_layout.openDrawer(GravityCompat.START)
        })

        ivSearch.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Profile Clicked", Toast.LENGTH_SHORT).show()
        })
    }


    private val navListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            selectedFragment = when (item.itemId) {
                R.id.nav_home -> HomeFragment()
                R.id.nav_chats -> HomeFragment()
                R.id.nav_support -> HomeFragment()
                R.id.nav_notification -> HomeFragment()
                else -> HomeFragment()
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, selectedFragment, "MY_FRAGMENT")
                .commit()
            true
        }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.trackDonations -> Toast.makeText(this, "trackDonations", Toast.LENGTH_SHORT).show()
            R.id.rewards -> Toast.makeText(this, "rewards", Toast.LENGTH_SHORT).show()
            R.id.register -> Toast.makeText(this, "register", Toast.LENGTH_SHORT).show()
            R.id.previousRequirements -> Toast.makeText(this, "previousRequirements", Toast.LENGTH_SHORT).show()
            R.id.settings -> Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show()
            R.id.logout -> Toast.makeText(this, "logout", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


}