package br.com.alfa11.devedu.treinos.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.alfa11.devedu.treinos.R
import kotlinx.android.synthetic.main.activity_treinos.*
import kotlinx.android.synthetic.main.activity_treinos_form.*

class TreinosAcitivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_treinos)


        button_novo_treino.setOnClickListener {
            startActivity(Intent(this, NovoTreino::class.java))
        }

        go_to_training_form.setOnClickListener {
            startActivity(Intent(this,TreinosFormActivity::class.java))
        }
    }
}