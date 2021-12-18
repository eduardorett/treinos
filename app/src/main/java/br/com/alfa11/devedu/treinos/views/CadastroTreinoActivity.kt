package br.com.alfa11.devedu.treinos.views

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.alfa11.devedu.treinos.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_treino_cadastro.*

class CadastroTreinoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_treino_cadastro)

        criar_novo_treino.setOnClickListener {
            val nomeDoTreino = edit_email.text.toString()
            val descricaoDoTreino = edit_password.text.toString()
            val dataDoTreino = edit_password.text.toString()

        }


    }


}