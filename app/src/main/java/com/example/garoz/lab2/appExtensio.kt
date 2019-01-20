package com.example.garoz.lab2

import android.app.Application

/**
 * Clase para poder acceder globalemente a interfaz
 *
 */
class appExtensio:Application() {

    /**
     * Objeto donde se guarda la orden actual
     */
    companion object : MenuOrder {

        override var menuOrder: ArrayList<String> = ArrayList()
        /**
         * Métodos para quitar y guardar elementos en la orden
         */
        override fun clear() {
            this.menuOrder.clear()
        }

        override fun add(elemento: String) {
            this.menuOrder.add(elemento)
        }

        override fun del(elementIndex: Int) {
            this.menuOrder.removeAt(elementIndex)
        }

        override fun done() {
        }
    }
}