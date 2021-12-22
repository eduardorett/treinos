package br.com.alfa11.devedu.treinos.views


import android.content.Intent
import android.os.Bundle
import android.service.controls.actions.FloatAction
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.alfa11.devedu.treinos.R

import br.com.alfa11.devedu.treinos.treinos.TreinosListener
import br.com.alfa11.devedu.treinos.viewmodel.TreinosViewModel
import br.com.alfa11.devedu.treinos.views.adapters.TreinosAdapter
import br.com.alfa11.devedu.treinos.views.autenticacao.CadastroUsuarioActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {

    private val mAdapter: TreinosAdapter = TreinosAdapter()
    private  lateinit var mListener: TreinosListener
    private lateinit var mViewModel: TreinosViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mViewModel = ViewModelProvider(this).get(TreinosViewModel::class.java)

        observe()

        val root = inflater.inflate(R.layout.fragment_main, container, false)
        val recycler = root.findViewById<RecyclerView>(R.id.recycler_treinos)
        val fab = root.findViewById<FloatingActionButton>(R.id.fab_novo_treino)

        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = mAdapter

        mListener = object : TreinosListener {
            override fun onClick(nome: String?) {
               val intent = Intent(context,ExerciciosActivity::class.java)
              startActivity(intent)
            }
        }

        fab.setOnClickListener {
            val intent = Intent(activity,CadastroTreinoActivity::class.java)
            startActivity(intent)
        }

        return root
    }

    override fun onResume() {
        super.onResume()
        mAdapter.attachListener(mListener)
        mViewModel.getAllTreinos()
    }

    private fun observe() {

        mViewModel.treinoResponse.observe(viewLifecycleOwner) {

            Log.d("RecipeViewModel","tamanho:"+it.treino!!.size)
            mAdapter.updateTreinos(it.treino!!)

        }
    }
    }
