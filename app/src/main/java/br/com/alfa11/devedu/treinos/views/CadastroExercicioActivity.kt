package br.com.alfa11.devedu.treinos.views

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import br.com.alfa11.devedu.treinos.R
import br.com.alfa11.devedu.treinos.databinding.ActivityExercicioCadastroBinding
import br.com.alfa11.devedu.treinos.exercicios.ExercicioModel
import br.com.alfa11.devedu.treinos.viewmodel.ExerciciosViewModel
import java.util.*


class CadastroExercicioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExercicioCadastroBinding
    private lateinit var mViewModel: ExerciciosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercicio_cadastro)

        binding = ActivityExercicioCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mViewModel = ViewModelProvider(this).get(ExerciciosViewModel::class.java)

        observe()


        binding.buttonSaveExercicio.setOnClickListener {

            val observacoes = binding.editObservacoes.text.toString()
            val nome = binding.editNomeDoExercicio.text.toString()
            val imagem = binding.imageUrl.text.toString()

            if(observacoes != "" && nome !="" && imagem !=""){
                val exercicio = ExercicioModel(UUID.randomUUID().toString(),observacoes,nome)
                Log.d(CadastroExercicioActivity.TAG,"TreinoModel: "+exercicio.toString())
                mViewModel.addExercicio(exercicio)
            } else{
                Toast.makeText(this,"Preencha os campos adequadamente", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun observe() {
        mViewModel.success.observe(this) {
            if(it){
                Toast.makeText(baseContext, "Exercicio criado!",
                    Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(baseContext, "Erro na criação do exercicio",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private const val TAG = "ExercicioActivityLog"
    }


}