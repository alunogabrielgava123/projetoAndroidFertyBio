package com.example.fertybioapp.view

import com.example.fertybioapp.data.Produtos

interface ProdutoDetailsView {
    fun showProdutoDetails(produtos: Produtos)
    fun errorProdutosNotFound()
}