package com.example.garoz.lab2

import android.app.Application

class appExtensio:Application() {
    companion object:MenuOrder {
        var menu = ArrayList<String>()

        

        override var menuOrder: ArrayList<String> = ArrayList<String>()
        override fun clear() {
            this.menuOrder.clear()
        }

        override fun add(elemento: String) {
            this.menuOrder.add(elemento)
        }

        override fun del(elementIndex: Int) {
            this.menuOrder[elementIndex].drop(elementIndex)
        }

        override fun done() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }
}