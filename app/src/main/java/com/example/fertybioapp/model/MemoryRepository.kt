package com.example.fertybioapp.model

import com.example.fertybioapp.data.Produtos

object MemoryRepository : ProdutoReposytory {


     private var nextId = 1L
     private val produtoListe = mutableListOf<Produtos>()

     init {
         save(
             Produtos(
                 0,
                 "BioProtex",
                 "Aplicacao",
                 "1L 5L 20L",
                  0
             )
         )
         save(
             Produtos(
                 0,
                 "Bioprotex",
                 "Aplicação",
                 "2L 5L 20L",
                 1
             )
         )
         save(
             Produtos(
                 0,
                 "BioProtex AZP",
                 "Aplicacao",
                 "2L",
                 2
             )
         )
         save(
             Produtos(
                 0,
                 "Protive",
                 "Biologico",
                 "2L 5L",
                 3
             )
         )
         save(
             Produtos(
                 0,
                 "Rivatti",
                 "Biologico",
                 "1L 2L",
                 4
             )
         )
         save(Produtos(
                 0,
                 "Bioative",
                 "Biologico",
                 "2L",
                 5
             ))
         save(
             Produtos(
                 0,
                 "Alltures",
                 "Biologico",
                 "2L 5L 20L",
                 6
             )
         )
         save(
             Produtos(
                 0,
                 "Agil",
                 "Aplicacao",
                 "2L",
                 7
             )
         )
         save(
             Produtos(
                 0,
                 "BioZeb",
                 "Formulação Especial",
                 "2L 5L 20L",
                 8
             )
         )
         save(
             Produtos(
                 0,
                 "SuperK",
                 "Nutrição",
                 "2L 5L 20L",
                 9
             )
         )
         save(
             Produtos(
                 0,
                 "SuperMn",
                 "Nutrição",
                 "2L",
                 10
             )
         )
         save(
             Produtos(
                 0,
                 "SuperMn +Mo",
                 "Nutrição",
                 "2L",
                 11
             )
         )
         save(
             Produtos(
                 0,
                 "Super Borio",
                 "Nutrição",
                 "2L",
                 12
             )
         )
         save(
             Produtos(
                 0,
                 "Bio Energy",
                 "Formulação especial",
                 "2L 5L 20L",
                 13
             )
         )
         save(
             Produtos(
                 0,
                 "Herbacal",
                 "Nutrição",
                 "2L",
                 14
             )
         )
         save(
             Produtos(
                 0,
                 "Nitrus",
                 "Nutrição",
                 "2L 5L 20L",
                 15
             )
         )
         save(
             Produtos(
                 0,
                 "Super Seed",
                 "Aplicação",
                 "2L",
                 16
             )
         )
         save(
             Produtos(
                 0,
                 "Super Seed Gold",
                 "Aplicacao",
                 "2L",
                 17
             )
         )
         save(
             Produtos(
                 0,
                 "Max Full",
                 "Aplicacao",
                 "2L",
                 18
             )
         )
         save(
             Produtos(
                 0,
                 "Super Full",
                 "Aplicacao",
                 "2L",
                 19
             )
         )
         save(
             Produtos(
                 0,
                 "Super Zinco",
                 "Aplicacao",
                 "2L",
                 20
             )
         )
         save(
             Produtos(
                 0,
                 "Bio Potency",
                 "Aplicacao",
                 "2L",
                 21
             )
         )
         save(
             Produtos(
                 0,
                 "Como PG",
                 "Aplicacao",
                 "2L",
                 22
             )
         )
         save(
             Produtos(
                 0,
                 "Como Soy",
                 "Aplicacao",
                 "2L",
                 23
             )
         )
         save(
             Produtos(
                 0,
                 "Aero Protive",
                 "Aplicacao",
                 "2L",
                 24
             )
         )
         save(
             Produtos(
                 0,
                 "Bio Energy cana ",
                 "Aplicacao",
                 "2L",
                 25
             )
         )
         save(
             Produtos(
                 0,
                 "Bio Energy Seed",
                 "Aplicacao",
                 "2L",
                 26
             )
         )
         save(
             Produtos(
                 0,
                 "Bio Energy Citrus",
                 "Aplicacao",
                 "2L",
                 27
             )
         )
         save(
             Produtos(
                 0,
                 "Sellemon Max",
                 "Aplicacao",
                 "2L",
                 28
             )
         )
         save(
             Produtos(
                 0,
                 "Vollus",
                 "Aplicacao",
                 "2L",
                 29
             )
         )
         save(
             Produtos(
                 0,
                 "Fulcrum",
                 "Aplicacao",
                 "2L",
                 30
             )
         )

     }


    override fun save(produtos: Produtos) {
     if(produtos.id == 0L){
         produtos.id = nextId++
         produtoListe.add(produtos)

     }else{
         val index = produtoListe.indexOfFirst { it.id == produtos.id }
         if(index > 0){
             produtoListe[index] = produtos
         }else{
             produtoListe.add(produtos)
         }
     }

    }
    override fun remove(vararg produtos: Produtos) {
        produtoListe.removeAll(produtos)
    }

    override fun hotelById(id: Long, callback: (Produtos?) -> Unit) {
        callback(produtoListe.find { it.id == id })
    }

    override fun search(term: String, callback: (List<Produtos>) -> Unit) {
        callback(
            if (term.isEmpty()) produtoListe
            else produtoListe.filter {
                it.name.toUpperCase().contains(term.toUpperCase())
            }
        )
    }


}