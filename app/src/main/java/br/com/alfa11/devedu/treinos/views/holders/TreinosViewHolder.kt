package br.com.alfa11.devedu.treinos.views.holders

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.alfa11.devedu.treinos.R
import br.com.alfa11.devedu.treinos.treinos.TreinoModel
import br.com.alfa11.devedu.treinos.treinos.TreinosListener
import java.text.SimpleDateFormat
import java.util.*

class TreinosViewHolder(itemView: View, private val listener: TreinosListener) :
    RecyclerView.ViewHolder(itemView) {

    private val mDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

    fun bind(treino: TreinoModel) {

        val dataTreino = itemView.findViewById<TextView>(R.id.data_do_treino_recycler)
        val descricaoTreino = itemView.findViewById<TextView>(R.id.detalhes_do_treino_recycler)
        val nomeDescrpition   = itemView.findViewById<TextView>(R.id.nome_do_treino_recycler)
        val layout = itemView.findViewById<LinearLayout>(R.id.layout_item_treino)

        nomeDescrpition.text = treino.nome

        dataTreino.text = treino.data

        descricaoTreino.text = treino.descricao

        layout.setOnClickListener {
            listener.onClick(treino.nome)
        }

/*
      textDescription.setOnLongClickListener {
           AlertDialog.Builder(itemView.context)
               .setTitle(R.string.remocao_convidado)
                .setMessage(R.string.deseja_remover)
               .setPositiveButton(R.string.remover) { dialog, which ->
                   listener.onDelete(treino.nome)
              }
              .setNeutralButton(R.string.cancelar, null)
               .show()

          true
      }*/

    }
}