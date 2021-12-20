package br.com.alfa11.devedu.treinos.views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.alfa11.devedu.treinos.R
import kotlinx.android.synthetic.main.activity_login.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity: AppCompatActivity() {

    private var auth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()


        button_login.setOnClickListener {

            val email = edit_email.text.toString()
            val senha = edit_password.text.toString()

            if(email == "" && senha == ""){
                Toast.makeText(baseContext, "Preencha os campos com um usuario valido",
                    Toast.LENGTH_SHORT).show()
            }else{
                signIn(email, senha)}

        }

        text_register.setOnClickListener{
            startActivity(Intent(this, CadastroUsuarioActivity::class.java))
        }

    }

    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth!!.currentUser
        updateUI(currentUser)
    }



    private fun signIn(email: String, password: String) {

        auth!!.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth!!.currentUser
                    updateUI(user)
                    startActivity(Intent(this, MainAcitivity::class.java))
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }

    }

    private fun updateUI(user: FirebaseUser?) {

    }

    private fun reload() {

    }

    companion object {
        private const val TAG = "LoginActivity"
    }
}


