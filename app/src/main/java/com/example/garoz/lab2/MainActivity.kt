package com.example.garoz.lab2

/**
 * Actividad principal de primera pantalla
 *
 * @author Rodrigo Garoz
 */

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menuButton = findViewById<Button>(R.id.buttonShowMenu)
        val orderButton = findViewById<Button>(R.id.buttonOrder)

        /**
         * Botones para abrir las nuevas actividades
         */
        menuButton.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        orderButton.setOnClickListener {
            val intent = Intent(this, OrderActivity::class.java)
            startActivity(intent)
        }
    }
}

