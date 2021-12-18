package br.com.alfa11.devedu.treinos.views

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import br.com.alfa11.devedu.treinos.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_exercicio_cadastro.*


class CadastroExercicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercicio_cadastro)

        val db = Firebase.firestore

        val exercicio = hashMapOf(
            "imagem" to "",
            "nome" to "",
            "observacoes" to ""
        )



        db.collection("Exercicio").document("01JokprDtQigoozjS436")
            .set(exercicio)
            .addOnSuccessListener { Log.d(ContentValues.TAG, "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w(ContentValues.TAG, "Error writing document", e) }



        button_save_exercicio.setOnClickListener {
            Toast.makeText(this, "exercicios salvos", Toast.LENGTH_SHORT).show()
      }
    }


}