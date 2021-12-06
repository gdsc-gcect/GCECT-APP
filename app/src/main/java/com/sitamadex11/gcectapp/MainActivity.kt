package com.sitamadex11.gcectapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout=findViewById<View>(R.id.drawerLayout) as DrawerLayout

        toggle =ActionBarDrawerToggle(this,drawerLayout ,toolbar,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

//        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navView=findViewById<View>(R.id.navView) as NavigationView

        navView.setNavigationItemSelectedListener{
            when(it.itemId){
                R.id.nav_home -> {Toast.makeText(applicationContext,
                    "Clicked Home",Toast.LENGTH_SHORT).show()
                    drawerLayout.closeDrawer(GravityCompat.START)
                }

                R.id.nav_aboutus ->{ Toast.makeText(applicationContext,
                    "Clicked About Us",Toast.LENGTH_SHORT).show()
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.nav_acad -> {Toast.makeText(applicationContext,
                    "Clicked Academics",Toast.LENGTH_SHORT).show()
                    drawerLayout.closeDrawer(GravityCompat.START)
                }

            }
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}