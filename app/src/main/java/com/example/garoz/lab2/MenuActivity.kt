package com.example.garoz.lab2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_menu2.*

/**
 * Actividad de pantalla con menú
 */

class MenuActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu2)

        listView = findViewById(R.id.menuList)

        /**
         * Se crea lista con las opciones del menú
         */
        val itemsList = ArrayList<String>()
        val backButton = findViewById<Button>(R.id.backToMenuButton)

        /**
         * Se llena con todos los tacos necesarios
         */
        itemsList.add("Tacos de pollo")
        itemsList.add("Tacos de pescado")
        itemsList.add("Tacos de costilla")
        itemsList.add("Tacos de tortilla")
        itemsList.add("Tacos al pastor")
        itemsList.add("Tacos mágicos")

        /**
         * Se une al adapter
         */
        val adapter = ItemAdapter(this, itemsList)
        listView.adapter = adapter

        /**
         * Se especifica el comportamiento al seleccionar un objeto
         */
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = itemsList[position]
            appExtensio.add(selectedItem) //Se une a lista globak
            val text = "Agregado $selectedItem"
            val toast = Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT)
            toast.show() //Se muestra toast apropiado
        }
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) //Botón para regresar a menú principal
        }
    }
}
