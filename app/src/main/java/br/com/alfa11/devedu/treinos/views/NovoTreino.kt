package br.com.alfa11.devedu.treinos.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.alfa11.devedu.treinos.R
import kotlinx.android.synthetic.main.activity_novo_treino.*

class NovoTreino : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_treino)

        criar_novo_treino.setOnClickListener {
            startActivity(Intent(this, TreinosFormActivity::class.java))

        }
    }
}