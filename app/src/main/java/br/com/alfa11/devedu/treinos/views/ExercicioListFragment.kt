package br.com.alfa11.devedu.treinos.views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.alfa11.devedu.treinos.R
import br.com.alfa11.devedu.treinos.exercicios.ExercicioListener
import br.com.alfa11.devedu.treinos.viewmodel.ExerciciosViewModel
import br.com.alfa11.devedu.treinos.views.adapters.ExerciciosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ExercicioListFragment : Fragment() {

    private val mAdapter: ExerciciosAdapter = ExerciciosAdapter()
    private  lateinit var mListener: ExercicioListener
    private lateinit var mViewModel: ExerciciosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {




        mViewModel = ViewModelProvider(this).get(ExerciciosViewModel::class.java)

        observe()

        val root = inflater.inflate(R.layout.fragment_exercicio_list, container, false)
        val recycler = root.findViewById<RecyclerView>(R.id.recycler_exercicios)
        val fab = root.findViewById<FloatingActionButton>(R.id.fab_novo_exercicio)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = mAdapter


        mListener = object : ExercicioListener {
            override fun onClick(nome: String?) {
                val intent = Intent(context, CadastroExercicioActivity::class.java)
                startActivity(intent)
            }
        }

        fab.setOnClickListener {
            val intent = Intent(activity,CadastroExercicioActivity::class.java)
            startActivity(intent)
        }

        return root
    }

    override fun onResume() {
        super.onResume()
        mAdapter.attachListener(mListener)
        mViewModel.getAllExercicios()
    }

    private fun observe() {

        mViewModel.exercicioResponse.observe(viewLifecycleOwner) {

            Log.d("RecipeViewModel","tamanho:"+it.exercicio!!.size)
            mAdapter.updateExercicios(it.exercicio!!)

        }
    }
}