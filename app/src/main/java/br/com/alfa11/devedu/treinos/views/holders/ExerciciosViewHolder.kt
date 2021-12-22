package br.com.alfa11.devedu.treinos.views.holders

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.alfa11.devedu.treinos.R
import br.com.alfa11.devedu.treinos.exercicios.ExercicioListener
import br.com.alfa11.devedu.treinos.exercicios.ExercicioModel
import br.com.alfa11.devedu.treinos.treinos.TreinoModel
import br.com.alfa11.devedu.treinos.treinos.TreinosListener
import java.text.SimpleDateFormat
import java.util.*

class ExerciciosViewHolder(itemView: View, private val listener: ExercicioListener) :
    RecyclerView.ViewHolder(itemView) {

    private val mDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

    fun bind(exercicio: ExercicioModel) {


        val nomeExercicio = itemView.findViewById<TextView>(R.id.nome_do_exercicio_recycler)
        val imagemExercicio = itemView.findViewById<TextView>(R.id.imagem_do_exercicio_recycler)
        val observacoesExercicio   = itemView.findViewById<TextView>(R.id.observacoes_do_treino)
        val layout = itemView.findViewById<LinearLayout>(R.id.exercicios_list)

        nomeExercicio.text = exercicio.nome

        imagemExercicio.text = exercicio.imagem

        observacoesExercicio.text = exercicio.observacoes

        layout.setOnClickListener {
            listener.onClick(exercicio.nome)
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