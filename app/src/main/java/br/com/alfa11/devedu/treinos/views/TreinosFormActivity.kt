package br.com.alfa11.devedu.treinos.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.alfa11.devedu.treinos.R
import kotlinx.android.synthetic.main.activity_exercicios_form.*
import kotlinx.android.synthetic.main.activity_treinos_form.*

class TreinosFormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_treinos_form)

        go_to_exercise_form.setOnClickListener {
            startActivity(Intent(this,ExerciciosFormActivity::class.java))
        }


        button_save_treino.setOnClickListener {
            Toast.makeText(this, "treino salvos", Toast.LENGTH_SHORT).show()
        }
    }
}