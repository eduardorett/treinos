package br.com.alfa11.devedu.treinos.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.alfa11.devedu.treinos.R
import br.com.alfa11.devedu.treinos.treinos.TreinoModel
import br.com.alfa11.devedu.treinos.treinos.TreinosListener
import br.com.alfa11.devedu.treinos.views.holders.TreinosViewHolder

class TreinosAdapter:RecyclerView.Adapter<TreinosViewHolder>(){

    private var mTreinosList: List<TreinoModel> = arrayListOf()
    private lateinit var mListener: TreinosListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TreinosViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.row_treinos_list, parent, false)
        return TreinosViewHolder(item, mListener)
    }

    override fun getItemCount(): Int {
        return mTreinosList.count()
    }

    override fun onBindViewHolder(holder: TreinosViewHolder, position: Int) {
        holder.bind(mTreinosList[position])
    }

    fun updateTreinos(list: List<TreinoModel>) {
        mTreinosList = list
        notifyDataSetChanged()
    }

    fun attachListener(listener: TreinosListener) {
        mListener = listener
    }

}