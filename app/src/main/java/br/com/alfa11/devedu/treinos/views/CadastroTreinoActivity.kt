package br.com.alfa11.devedu.treinos.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.alfa11.devedu.treinos.R
import kotlinx.android.synthetic.main.activity_treino_cadastro.*

class CadastroTreinoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_treino_cadastro)

        criar_novo_treino.setOnClickListener {
            startActivity(Intent(this, DetalhesTreinoActivity::class.java))

        }
    }
}