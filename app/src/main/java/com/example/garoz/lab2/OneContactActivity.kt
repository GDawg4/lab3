package com.example.garoz.lab2

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v4.content.LocalBroadcastManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_contacts.*
import java.net.URI
import java.util.jar.Manifest

class OneContactActivity : AppCompatActivity() {

    private lateinit var myReceiver:BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_contact)

        /**
         * Se recibe toda la información de la actividad anterior
         */
        myReceiver = emailBroadcast()
        val name = intent.getStringExtra("name")
        val number = intent.getIntExtra("number", 0)
        val email = intent.getStringExtra("email")
        //Se registra un nuevo receriver
        registerReceiver(myReceiver, IntentFilter("com.example.garoz.TEST"))

        val nameShown = findViewById<TextView>(R.id.name)
        val numberShown = findViewById<TextView>(R.id.textView6)
        val emailShown = findViewById<TextView>(R.id.textView7)
        val backButton = findViewById<Button>(R.id.backButton)

        nameShown.text = name
        numberShown.text = number.toString()
        emailShown.text = email

        /**
         * Se revisa si se tiene los permisos necesarios
         * Se piden de ser necesario
         */
        numberShown.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), 1)
            }
            else{
                var callIntent = Intent(Intent.ACTION_CALL)
                callIntent.data = Uri.parse("tel:" + number.toString())
                startActivity(callIntent)
            }
        }

        emailShown.setOnClickListener {
            //Se crea un nuevo intent con la acción especial y se llama al receiver
            val emailIntent = Intent("com.example.garoz.TEST")

            emailIntent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
            emailIntent.putExtra("email", emailShown.text.toString())
            emailIntent.putExtra("topic", "Saludo")
            emailIntent.putExtra("message", "Hola, mi nombre es Rodrigo y mi número es 30068942")
            sendBroadcast(emailIntent)
        }

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
