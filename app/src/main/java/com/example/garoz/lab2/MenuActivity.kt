package com.example.garoz.lab2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_menu2.*

class MenuActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu2)

        listView = findViewById(R.id.menuList)

        val itemsList = ArrayList<String>()
        val backButton = findViewById<Button>(R.id.backToMenuButton)
        /*
        itemsList.add(Item("Tacos al pastor"))
        itemsList.add(Item("Tacos al carbón"))
        itemsList.add(Item("Tacos de tortilla"))
        */

        itemsList.add("Tacos de pollo")
        itemsList.add("Tacos de pescado")
        itemsList.add("Tacos de costilla")
        itemsList.add("Tacos de tortilla")


        val adapter = ItemAdapter(this, itemsList)
        listView.adapter = adapter
        
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = itemsList[position]
            appExtensio.add(selectedItem)
            val text = "Agregado " + selectedItem
            val toast = Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT)
            toast.show()
        }
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
