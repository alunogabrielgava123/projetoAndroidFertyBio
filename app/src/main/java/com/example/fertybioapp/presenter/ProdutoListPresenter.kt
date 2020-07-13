package com.example.fertybioapp.presenter

import com.example.fertybioapp.model.ProdutoReposytory
import com.example.fertybioapp.data.Produtos
import com.example.fertybioapp.view.ProdutoListView

class ProdutoListPresenter(
    private val view: ProdutoListView,
    private val repository: ProdutoReposytory
) {
    fun searchProdutos(term: String) {
        repository.search(term) { produtos ->
            view.showProdutos(produtos)
        }

    }

    fun showProdutoDetails(produtos: Produtos){
        view.showProdutosDetails(produtos)
    }

}
