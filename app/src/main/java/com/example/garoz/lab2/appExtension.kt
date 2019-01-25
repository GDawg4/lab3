package com.example.garoz.lab2

import android.app.Application

/**
 * Clase para poder acceder globalemente a clase
 *
 */
class appExtension:Application() {

    /**
     * Objeto donde se guardan todos los contactos actuales
     */
    companion object {
        val allContacts:ArrayList<Contact> = ArrayList()

        data class Contact(val name: String,
                           val number: Int,
                           val email: String)
    }
}