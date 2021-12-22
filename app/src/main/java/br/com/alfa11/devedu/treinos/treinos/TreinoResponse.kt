package br.com.alfa11.devedu.treinos.treinos

data class TreinoResponse(
    var treino: List<TreinoModel>? = null,
    var erro: String? =  null)
