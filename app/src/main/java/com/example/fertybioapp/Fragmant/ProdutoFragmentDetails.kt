package com.example.fertybioapp.Fragmant

import android.content.res.TypedArray
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fertybioapp.R
import com.example.fertybioapp.data.Produtos
import com.example.fertybioapp.model.MemoryRepository
import com.example.fertybioapp.presenter.ProdutoDetailsPresenter
import com.example.fertybioapp.view.ProdutoDetailsView
import kotlinx.android.synthetic.main.fragment_produto_details.*
import kotlinx.android.synthetic.main.fragment_produto_details.imgLogo
import kotlinx.android.synthetic.main.fragment_produto_details.textModelo
import kotlinx.android.synthetic.main.fragment_produto_details.textName
import kotlinx.android.synthetic.main.fragment_produto_details.textSize
import kotlinx.android.synthetic.main.item_produto_adapter.*

class ProdutoFragmentDetails:Fragment(), ProdutoDetailsView {
    private val presenter = ProdutoDetailsPresenter(this, MemoryRepository)
    private var produto: Produtos? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_produto_details, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadDetails(arguments?.getLong(EXTRA_PRODUTO_ID, -1)?: -1)
    }

    override fun showProdutoDetails(produtos: Produtos) {
        this.produto = produto
        textName.text = produtos?.name
        textModelo.text = produtos?.modelo
        textSize.text = produtos?.size
        imgLogo.setImageDrawable(logos.getDrawable(produtos.produto))
    }

    private val logos: TypedArray by lazy {
        this.resources.obtainTypedArray(R.array.logos)
    }

    override fun errorProdutosNotFound() {

        textName.visibility = View.GONE
        textSize.visibility = View.GONE
        textModelo.visibility = View.GONE
    }

    companion object {
        const val  TAG_DETAILS = "tagDetails"
        private const val EXTRA_PRODUTO_ID = "produtoId"

        fun newInstance(id:Long): ProdutoFragmentDetails{
            val fragment = ProdutoFragmentDetails()
            val args = Bundle()
            args.putLong(EXTRA_PRODUTO_ID,id)
            fragment.arguments = args
            return fragment
        }

    }

}