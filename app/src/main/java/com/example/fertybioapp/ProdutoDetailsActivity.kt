package com.example.fertybioapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fertybioapp.Fragmant.ProdutoFragmentDetails
import kotlinx.android.synthetic.main.activity_produto.*

class ProdutoDetailsActivity : AppCompatActivity() {

    private val produtoId: Long by lazy {intent.getLongExtra(EXTRA_PRODUTO_ID, -1)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produto_details)
        if(savedInstanceState == null){
            showProdutoDetailsFragment()
        }
    }

    private fun showProdutoDetailsFragment(){
        val fragment  = ProdutoFragmentDetails.newInstance(produtoId)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.details, fragment, ProdutoFragmentDetails.TAG_DETAILS)
            .commit()
    }
    companion object {
        private const val  EXTRA_PRODUTO_ID = "produtoId"
        fun open(context: Context, produtoId: Long){
            context.startActivity(Intent(context,ProdutoDetailsActivity::class.java).apply {
                putExtra(EXTRA_PRODUTO_ID, produtoId)
            });
        }
    }
}