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
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newContact = findViewById<Button>(R.id.newContactButton)
        listView = findViewById(R.id.contactView)

        listView.adapter = ItemAdapter(applicationContext, appExtension.allContacts)

        newContact.setOnClickListener {
            val intent = Intent(this, ContactsActivity::class.java)
            startActivity(intent)
        }
        listView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, OneContactActivity::class.java)
            intent.putExtra("name", appExtension.allContacts[position].name)
            intent.putExtra("number", appExtension.allContacts[position].number)
            intent.putExtra("emai", appExtension.allContacts[position].email)
            startActivity(intent)
        }
    }
}

