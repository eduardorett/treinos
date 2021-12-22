package br.com.alfa11.devedu.treinos.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import br.com.alfa11.devedu.treinos.R
import br.com.alfa11.devedu.treinos.databinding.ActivityTreinoCadastroBinding
import br.com.alfa11.devedu.treinos.treinos.TreinoModel
import br.com.alfa11.devedu.treinos.viewmodel.TreinosViewModel
import java.time.Duration
import java.util.*

class CadastroTreinoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTreinoCadastroBinding
    private lateinit var mViewModel: TreinosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_treino_cadastro)

        binding = ActivityTreinoCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mViewModel = ViewModelProvider(this).get(TreinosViewModel::class.java)

        observe()

        binding.criarNovoTreino.setOnClickListener {

            val description = binding.descricaoDoTreino.text.toString()
            val nome = binding.nomeDoNovoTreino.text.toString()
            val data = binding.dataDoTreino.text.toString()

             if(description != "" && nome !="" && data !=""){
                val treino = TreinoModel(UUID.randomUUID().toString(),description)
                Log.d(TAG,"TreinoModel: "+treino.toString())
                mViewModel.addTreino(treino)
            } else{
                 Toast.makeText(this,"Preencha os campos adequadamente", Toast.LENGTH_SHORT).show()
             }

        }

    }

    private fun observe() {
        mViewModel.success.observe(this) {
            if(it){
                Toast.makeText(baseContext, "Treino criado!",
                    Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(baseContext, "Erro na criação do treino",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private const val TAG = "TreionActivityLog"
    }

    }


