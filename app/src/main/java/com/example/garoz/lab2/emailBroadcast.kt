package com.example.garoz.lab2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * Se crea un BroadcastReceiver para nuestra acción
 */
class emailBroadcast : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val newIntent = Intent(context, EmailActivity::class.java)
        intent!!.flags = (Intent.FLAG_ACTIVITY_NEW_TASK)
        val newEmail = intent.getStringExtra("email")
        val newMessage = intent.getStringExtra("message")

        newIntent.putExtra("email", newEmail)
        newIntent.putExtra("message", newMessage)
        context!!.startActivity(newIntent)
    }
}