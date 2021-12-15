package br.com.alfa11.devedu.treinos.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.alfa11.devedu.treinos.R
import kotlinx.android.synthetic.main.activity_usuario_cadastro.*

class CadastroUsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario_cadastro)

        button_save_cadastro.setOnClickListener {
            Toast.makeText(this, "Cadastro criado com sucesso", Toast.LENGTH_SHORT).show()
        }

    }
}