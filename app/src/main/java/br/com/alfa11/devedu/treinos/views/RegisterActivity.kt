package br.com.alfa11.devedu.treinos.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.alfa11.devedu.treinos.R
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_treinos_form.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        button_save_cadastro.setOnClickListener {
            Toast.makeText(this, "Cadastro criado com sucesso", Toast.LENGTH_SHORT).show()
        }

    }
}