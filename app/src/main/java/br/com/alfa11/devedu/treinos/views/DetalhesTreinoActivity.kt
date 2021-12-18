package br.com.alfa11.devedu.treinos.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.alfa11.devedu.treinos.R
import br.com.alfa11.devedu.treinos.service.TreinoModel
import br.com.alfa11.devedu.treinos.views.adapters.TreinosAdapter
import com.google.firebase.firestore.*
import kotlinx.android.synthetic.main.activity_treino_detalhes.*

class DetalhesTreinoActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_treino_detalhes)



        go_to_exercise_form.setOnClickListener {
            startActivity(Intent(this,CadastroExercicioActivity::class.java))
        }


        button_save_treino.setOnClickListener {
            Toast.makeText(this, "treino salvos", Toast.LENGTH_SHORT).show()
        }

    }

}