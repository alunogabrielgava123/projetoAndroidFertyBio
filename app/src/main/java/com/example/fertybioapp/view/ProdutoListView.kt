package com.example.fertybioapp.view

import com.example.fertybioapp.data.Produtos

interface ProdutoListView {
    fun showProdutos(produtos: List<Produtos>)
    fun showProdutosDetails(produtos: Produtos)
}