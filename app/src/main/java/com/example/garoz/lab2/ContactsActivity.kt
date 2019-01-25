package com.example.garoz.lab2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class ContactsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        val goBack = findViewById<Button>(R.id.goBackButton)
        val addContact = findViewById<Button>(R.id.addButton)
        val newContactName = findViewById<TextView>(R.id.contactName)
        val newContactPhone = findViewById<TextView>(R.id.contactPhone)
        val newContactEmail = findViewById<TextView>(R.id.contactMail)

        goBack.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        /**
         * Al agregar un nuevo contacto se vacían los campos
         */
        addContact.setOnClickListener {
            try {
                val newContact = appExtension.Companion.Contact(
                        newContactName.text.toString(),
                        Integer.parseInt(newContactPhone.text.toString()),
                        newContactEmail.text.toString()
                )
                appExtension.allContacts.add(newContact)
                Toast.makeText(applicationContext, "Contacto agregado", Toast.LENGTH_SHORT).show()
                newContactEmail.text = ""
                newContactName.text = ""
                newContactPhone.text = ""

            }catch (e: NumberFormatException){ // en caso no sea válido el número
                Toast.makeText(this, "Número de teléfono no válido", Toast.LENGTH_LONG).show()
            }

        }
    }
}
