package br.com.alfa11.devedu.treinos.service

import java.sql.Timestamp

// MUDAR O TIPO DO DATA PARA TIME STAMP DE UM JEITO QUE DE PRA POR NO ADAPTER
data class TreinoModel(var data:String? = null,
                       var descricao:String? = null,
                       var nome: Number? = null)
