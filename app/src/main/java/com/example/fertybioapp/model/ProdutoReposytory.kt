package com.example.fertybioapp.model

import com.example.fertybioapp.data.Produtos

interface ProdutoReposytory {
    fun save(produtos: Produtos)
    fun remove(vararg produtos: Produtos)
    fun hotelById(id:Long , callback:(Produtos?) -> Unit)
    fun search(term: String , callback: (List<Produtos>)-> Unit)

}