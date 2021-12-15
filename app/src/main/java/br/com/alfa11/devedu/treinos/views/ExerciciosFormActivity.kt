package br.com.alfa11.devedu.treinos.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.alfa11.devedu.treinos.R
import kotlinx.android.synthetic.main.activity_exercicios_form.*

class ExerciciosFormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercicios_form)


      button_save_exercicio.setOnClickListener {
            Toast.makeText(this, "exercicios salvos", Toast.LENGTH_SHORT).show()
      }
    }


}