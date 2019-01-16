package com.example.garoz.lab2

interface MenuOrder{
    val menuOrder: ArrayList<String>
    fun clear()
    fun add(elemento:String)
    fun del(elementIndex:Int)
    fun done()
}