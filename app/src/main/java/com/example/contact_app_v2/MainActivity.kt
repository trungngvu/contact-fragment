package com.example.contact_app_v2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.navigation.findNavController
import com.example.contact_app_v2.model.Person

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu, menu)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.new_contact_menu -> {
                val navController = findNavController(R.id.nav_host_fragment)
                navController.navigate(R.id.nav_new_contact)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }




    companion object {
        val contacts: MutableList<Person> = mutableListOf<Person>(
            Person(1, "John Dang", "12345678", "johndang@gmail.com"),
            Person(2, "Tom Boy", "03834713439", "tomboy@gmail.com"),
            Person(3, "Fake Data", "1123912371", "fakedata@gmail.com"),
            Person(4, "User name", "1238491", "username@gmail.com"),
            Person(5, "Test function", "2347882", "testfunction@gmail.com"),
            Person(6, "Validate Data", "9812374", "dalidatedata@gmail.com")
        )
    }
}