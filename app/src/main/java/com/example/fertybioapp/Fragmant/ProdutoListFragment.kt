package com.example.fertybioapp.Fragmant

import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.fragment.app.ListFragment
import com.example.fertybioapp.ProdutoAdapter
import com.example.fertybioapp.model.MemoryRepository
import com.example.fertybioapp.presenter.ProdutoListPresenter
import com.example.fertybioapp.view.ProdutoListView
import com.example.fertybioapp.data.Produtos

class ProdutoListFragment: ListFragment(),
    ProdutoListView {
    private val presenter =
        ProdutoListPresenter(
            this,
            MemoryRepository
        )
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.searchProdutos("")
    }

    override fun showProdutos(produtos: List<Produtos>) {
      //criando adapter de lista de produtos]
        val adapter = ProdutoAdapter(requireContext(),produtos)
        listAdapter = adapter
    }

    override fun showProdutosDetails(produtos: Produtos) {
          if(activity is OnProdutoClickListener){
              val listener = activity as OnProdutoClickListener
              listener.onProdutoClickListener(produtos)
          }
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        val produto = l?.getItemAtPosition(position) as Produtos
        presenter.showProdutoDetails(produto)
    }
    interface  OnProdutoClickListener{
        fun onProdutoClickListener(produtos: Produtos)
    }
}