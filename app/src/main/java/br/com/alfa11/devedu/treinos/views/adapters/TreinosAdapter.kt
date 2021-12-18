package br.com.alfa11.devedu.treinos.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.alfa11.devedu.treinos.R
import br.com.alfa11.devedu.treinos.service.TreinoModel

class TreinosAdapter(private val treinosList: ArrayList<TreinoModel>):RecyclerView.Adapter<TreinosAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TreinosAdapter.MyViewHolder {

      val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_treinos_list,parent,false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TreinosAdapter.MyViewHolder, position: Int) {

        val treinoModel:TreinoModel = treinosList[position]
        holder.detalhes.text = treinoModel.detalhes
        holder.data.text = treinoModel.data // MUDAR O TIPO DEPOIS
        holder.nome.text = treinoModel.nome.toString()

    }

    override fun getItemCount(): Int {

        return treinosList.size

    }

    public class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val detalhes: TextView =itemView.findViewById(R.id.detalhes_do_treino_recycler)
        val nome : TextView =itemView.findViewById(R.id.nome_do_treino_recycler)
        val data : TextView =itemView.findViewById(R.id.data_do_treino_recycler)
    }
}