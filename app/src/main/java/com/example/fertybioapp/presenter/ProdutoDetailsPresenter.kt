package com.example.fertybioapp.presenter

import com.example.fertybioapp.model.ProdutoReposytory
import com.example.fertybioapp.view.ProdutoDetailsView

class ProdutoDetailsPresenter(
    private val view: ProdutoDetailsView,
    private val reposytory: ProdutoReposytory
) {
    fun loadDetails(id: Long) {
        reposytory.hotelById(id) { produtos ->
            if (produtos != null) {
                view.showProdutoDetails(produtos)
            } else {
                view.errorProdutosNotFound()
            }
        }
    }

}