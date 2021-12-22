package br.com.alfa11.devedu.treinos.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.alfa11.devedu.treinos.R
import br.com.alfa11.devedu.treinos.exercicios.ExercicioListener
import br.com.alfa11.devedu.treinos.exercicios.ExercicioModel
import br.com.alfa11.devedu.treinos.treinos.TreinoModel
import br.com.alfa11.devedu.treinos.treinos.TreinosListener
import br.com.alfa11.devedu.treinos.viewmodel.ExerciciosViewModel
import br.com.alfa11.devedu.treinos.views.holders.ExerciciosViewHolder
import br.com.alfa11.devedu.treinos.views.holders.TreinosViewHolder

class ExerciciosAdapter: RecyclerView.Adapter<ExerciciosViewHolder>(){

    private var mExercicioList: List<ExercicioModel> = arrayListOf()
    private lateinit var mListener: ExercicioListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciciosViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.row_exercicios_list, parent, false)
        return ExerciciosViewHolder(item, mListener)
    }

    override fun getItemCount(): Int {
        return mExercicioList.count()
    }

    override fun onBindViewHolder(holder: ExerciciosViewHolder, position: Int) {
        holder.bind(mExercicioList[position])
    }

    fun updateExercicios(list: List<ExercicioModel>) {
        mExercicioList = list
        notifyDataSetChanged()
    }

    fun attachListener(listener: ExercicioListener) {
        mListener = listener
    }

}