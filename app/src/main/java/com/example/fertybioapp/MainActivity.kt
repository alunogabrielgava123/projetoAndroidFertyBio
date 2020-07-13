package com.example.fertybioapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.fertybioapp.Fragmant.ProdutoListFragment
import com.example.fertybioapp.data.Produtos

class MainActivity : AppCompatActivity(), ProdutoListFragment.OnProdutoClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produto)
    }

    override fun onProdutoClickListener(produtos: Produtos) {
        showDetilsActivity(produtos.id)
    }

    private fun showDetilsActivity(produtoId:Long){
        ProdutoDetailsActivity.open(this, produtoId)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}
