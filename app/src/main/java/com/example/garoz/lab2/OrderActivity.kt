package com.example.garoz.lab2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_order.*

/**
 * Actividad para hacer una orden
 */
class OrderActivity : AppCompatActivity() {
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        listView = findViewById(R.id.orderList)

        /**
         * Se llaman a los tres botones necesarios
         */
        val backButton = findViewById<Button>(R.id.backButton)
        val clearButton = findViewById<Button>(R.id.clearButton)
        val orderButton = findViewById<Button>(R.id.orderButton)

        /**
         * Se une con el adaptador apropiado
         * El mismo que MenuActivity
         */
        val adapter = ItemAdapter(this, appExtensio.menuOrder)
        listView.adapter = adapter

        /**
         * Al presionar el botón se regresa a página principal
         */
        backButton.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        /**
         * Al presionar el botón de limpiar o hacer pedido se limpia la lista
         * Se muestra el toast apropiado
         */
        clearButton.setOnClickListener{
            appExtensio.clear()
            var toast = Toast.makeText(applicationContext, "Pedido borrado", Toast.LENGTH_SHORT)
            toast.show()
            listView.invalidateViews()
        }

        orderButton.setOnClickListener {
            appExtensio.clear()
            var toast = Toast.makeText(applicationContext, "Pedido hecho", Toast.LENGTH_SHORT)
            toast.show()
            listView.invalidateViews()
        }
    }
}
