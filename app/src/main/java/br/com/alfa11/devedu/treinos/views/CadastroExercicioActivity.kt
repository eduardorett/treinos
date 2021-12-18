package br.com.alfa11.devedu.treinos.views

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import br.com.alfa11.devedu.treinos.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_exercicio_cadastro.*


class CadastroExercicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercicio_cadastro)



        button_save_exercicio.setOnClickListener {
            Toast.makeText(this, "exercicios salvos", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,DetalhesTreinoActivity::class.java))
      }
    }


}