package br.com.alfa11.devedu.treinos.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.alfa11.devedu.treinos.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        button_login.setOnClickListener {
            startActivity(Intent(this, TreinosAcitivity::class.java))
        }

        text_register.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }


        //IMPLEMENTAR MAIS TARDE

      /*  override fun onClick(v: View) {
            if (v.id == R.id.button_login) {
                val email = edit_email.text.toString()
                val password = edit_password.text.toString()



                if(  email == "" && password == ""){
                    Toast.makeText(this,"Preencha o cabeçalho",Toast.LENGTH_SHORT).show()
                }else if(email =="" && password != ""){
                    Toast.makeText(this,"Preencha o email",Toast.LENGTH_SHORT).show()
                } else if(email !="" && password == ""){
                    Toast.makeText(this,"Preencha a senha",Toast.LENGTH_SHORT).show()
                }
                else{
                    handleLogin()
                }



            } else if (v.id == R.id.text_register) {
                startActivity(Intent(this, RegisterActivity::class.java))
            }
        }

*/

    }}