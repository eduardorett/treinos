package br.com.alfa11.devedu.treinos.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import br.com.alfa11.devedu.treinos.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_usuario_cadastro.*
import kotlinx.android.synthetic.main.activity_usuario_cadastro.edit_email
import kotlinx.android.synthetic.main.activity_usuario_cadastro.edit_password

class CadastroUsuarioActivity : AppCompatActivity() {

    private var auth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario_cadastro)

        auth = FirebaseAuth.getInstance()

        button_save_cadastro.setOnClickListener {

            val email = edit_email.text.toString()
            val senha = edit_password.text.toString()
            val senhaConfirmar =  confirm_password.text.toString()
            var counterDaSenha:Int =  0
            var counterDoEmail:Int = 0


            if (email == "" && senha == ""){
                Toast.makeText(baseContext, "Preencha os campos", Toast.LENGTH_SHORT).show()
            } /*else if (email =="" && senha != ""){
                Toast.makeText(baseContext, "Preencha o email", Toast.LENGTH_SHORT).show()
            }else if(senha =="" && email != ""){
                Toast.makeText(baseContext, "Preencha a senha", Toast.LENGTH_SHORT).show()
            }*/
            if(senha != "" && senhaConfirmar != ""){
            if (senha == senhaConfirmar ) {
                counterDaSenha = 1
            } else{
                Toast.makeText(baseContext, " As senhas diferem", Toast.LENGTH_SHORT).show()
                counterDaSenha = 0
            }}

            if(email != ""){
            if (android.util.Patterns.EMAIL_ADDRESS.matcher(edit_email.text.toString()).matches() && email != ""){
                counterDoEmail = 1
            }else{
                Toast.makeText(baseContext, " Insira um endereço de email valido", Toast.LENGTH_SHORT).show()
                counterDoEmail = 0
            }}

            if(counterDaSenha == 1 && counterDoEmail == 1){
              createAccount(email,senha)
            }
        }



    }

    private fun createAccount(email: String, password: String) {

        auth!!.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    Toast.makeText(baseContext, "usuario criado com sucesso.",
                        Toast.LENGTH_SHORT).show()
                    val user = auth!!.currentUser
                    updateUI(user)
                    finish()
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Não foi possivel criar o usuario.",
                        Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }
    }

    private fun updateUI(user: FirebaseUser?) {

    }

    companion object {
        private const val TAG = "CadastrousuarioActivity"
    }
}