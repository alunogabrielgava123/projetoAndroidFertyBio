package com.example.fertybioapp

import android.content.Context
import android.content.res.TypedArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.fertybioapp.data.Produtos
import kotlinx.android.synthetic.main.item_produto_adapter.view.*


class ProdutoAdapter(
    private val ctx: Context,
    private val produtos: List<Produtos>
): BaseAdapter() {

    private val logos: TypedArray by lazy {
        ctx.resources.obtainTypedArray(R.array.logos)
    }



    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val produtos = produtos[position]
        val row = LayoutInflater.from(ctx).inflate(R.layout.item_produto_adapter, parent, false)
        row.imgLogo.setImageDrawable(logos.getDrawable(produtos.produto))
        row.textName.text = produtos.name
        row.textModelo.text = produtos.modelo
        row.textSize.text = produtos.size.toString()
        return row
    }

    override fun getItem(position: Int) = produtos[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getCount(): Int  = produtos.size
}