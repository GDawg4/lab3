package com.example.garoz.lab2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class MenuActivity : AppCompatActivity() {

    public class MenuAdapter:ArrayAdapter<>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu2)


        val menuAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        val menu = findViewById<ListView>(R.id.menuList)
        val menuList = ArrayList<String>()
        menuList.add("Tacos al pastor")
        menuList.add("Tacos de carne")
        menuList.add("Tacos dulces")
        menuList.add("Tacos salados")
        menuList.add("Tacos con chicharrón")


    }
}
