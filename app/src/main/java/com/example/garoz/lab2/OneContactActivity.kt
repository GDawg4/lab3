package com.example.garoz.lab2

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_contacts.*
import java.net.URI

class OneContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_contact)
        val name = intent.getStringExtra("name")
        val number = intent.getIntExtra("number", 0)
        val email = intent.getStringExtra("email")

        val nameShown = findViewById<TextView>(R.id.name)
        val numberShown = findViewById<TextView>(R.id.textView6)
        val emailShown = findViewById<TextView>(R.id.textView7)
        val backButton = findViewById<Button>(R.id.backButton)

        nameShown.text = name
        numberShown.text = number.toString()
        emailShown.text = email

        numberShown.setOnClickListener {
            var callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("22556170")
            startActivity(callIntent)
        }
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
