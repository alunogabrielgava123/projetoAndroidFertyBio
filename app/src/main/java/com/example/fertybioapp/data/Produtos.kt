package com.example.fertybioapp.data

data class Produtos(
    var id:Long = 0,
    var name: String = "",
    var modelo: String = "",
    var size: String = "",
    var produto: Int

) {
    override fun toString(): String = name
}
