package br.com.alfa11.devedu.treinos.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.alfa11.devedu.treinos.R
import br.com.alfa11.devedu.treinos.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button_login.setOnClickListener {
            startActivity(Intent(this, MainAcitivity::class.java))
        }

        text_register.setOnClickListener{
            startActivity(Intent(this, CadastroUsuarioActivity::class.java))
        }

    }
}


