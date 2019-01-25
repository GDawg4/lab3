package com.example.garoz.lab2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class EmailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)

        val sendButton = findViewById<Button>(R.id.button)
        val from = findViewById<TextView>(R.id.editText)
        val to = findViewById<TextView>(R.id.editText2)
        val message = findViewById<TextView>(R.id.editText3)

        val newEmail = intent.getStringExtra("email")
        val newMessage = intent.getStringExtra("message")

        to.text = newEmail.toString()
        message.text = newMessage

        sendButton.setOnClickListener{
            Toast.makeText(this, "Mensaje enviado a ${to.text} de ${from.text}", Toast.LENGTH_LONG).show()
            from.text = ""
            to.text = ""
            message.text = ""
        }
    }
}
