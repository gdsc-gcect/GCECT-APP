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

import android.widget.ExpandableListView





class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    var listAdapter: ExpandableListAdapter? = null
    var expListView: ExpandableListView? = null
    var listDataHeader: List<String>? = null
    var listDataChild: HashMap<String, List<String>>? = null

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

//        navView.setNavigationItemSelectedListener{
//            when(it.itemId){
//                R.id.nav_home -> {Toast.makeText(applicationContext,
//                    "Clicked Home",Toast.LENGTH_SHORT).show()
//                    drawerLayout.closeDrawer(GravityCompat.START)
//                }
//
//                R.id.nav_aboutus ->{ Toast.makeText(applicationContext,
//                    "Clicked About Us",Toast.LENGTH_SHORT).show()
//                    drawerLayout.closeDrawer(GravityCompat.START)
//                }
//                R.id.nav_acad -> {Toast.makeText(applicationContext,
//                    "Clicked Academics",Toast.LENGTH_SHORT).show()
//                    drawerLayout.closeDrawer(GravityCompat.START)
//                }
//
//            }
//            true
//        }

        // get the listview
        // get the listview
        var expListView = findViewById<View>(R.id.lvExp) as ExpandableListView

        // preparing list data

        // preparing list data
        prepareListData()

        val listAdapter = listDataHeader?.let { listDataChild?.let { it1 ->
            ExpandableListAdapter(this, it,
                it1
            )
        } }

        // setting list adapter

        // setting list adapter
        expListView.setAdapter(listAdapter)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    /*
     * Preparing the list data
     */
    private fun prepareListData() {
        listDataHeader = ArrayList<String>()
        listDataChild = HashMap<String, List<String>>()

        // Adding child data
        (listDataHeader as ArrayList<String>).add("Home")
        (listDataHeader as ArrayList<String>).add("About Us")
        (listDataHeader as ArrayList<String>).add("Academics")
        (listDataHeader as ArrayList<String>).add("Infrastructure")

        // Adding child data
        val home: MutableList<String> = ArrayList()
//        top250.add("The Shawshank Redemption")
//        top250.add("The Godfather")
//        top250.add("The Godfather: Part II")
//        top250.add("Pulp Fiction")
//        top250.add("The Good, the Bad and the Ugly")
//        top250.add("The Dark Knight")
//        top250.add("12 Angry Men")
        val aboutus: MutableList<String> = ArrayList()
//        nowShowing.add("The Conjuring")
//        nowShowing.add("Despicable Me 2")
//        nowShowing.add("Turbo")
//        nowShowing.add("Grown Ups 2")
//        nowShowing.add("Red 2")
//        nowShowing.add("The Wolverine")
        val acad: MutableList<String> = ArrayList()
        acad.add("Departments")
        acad.add("Syllabus")
        acad.add("Research and development")
        acad.add("Collaboration")
        acad.add("Consultancy")
        acad.add("Academic Regulation")
        acad.add("Academic Calender")
        acad.add("Mandatory Disclosures")
        val infra: MutableList<String> = ArrayList()
        listDataChild!![(listDataHeader as ArrayList<String>)[0]] = home // Header, Child data
        listDataChild!![(listDataHeader as ArrayList<String>)[1]] = aboutus
        listDataChild!![(listDataHeader as ArrayList<String>)[2]] = acad
        listDataChild!![(listDataHeader as ArrayList<String>)[3]] = infra

    }

}