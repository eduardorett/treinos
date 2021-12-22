package br.com.alfa11.devedu.treinos.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.alfa11.devedu.treinos.exercicios.ExercicioModel
import br.com.alfa11.devedu.treinos.exercicios.ExercicioResponse
import com.google.firebase.firestore.FirebaseFirestore

class ExerciciosViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext = application.applicationContext
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    private val mSaveSuccess = MutableLiveData<Boolean>()
    val success: LiveData<Boolean> = mSaveSuccess

    private var mExercicioResponse = MutableLiveData<ExercicioResponse>()
    val exercicioResponse: LiveData<ExercicioResponse> = mExercicioResponse




    fun addExercicio(exercicio: ExercicioModel) {
        db.collection("exercicios")
            .add(exercicio)
            .addOnSuccessListener { documentReference ->
                mSaveSuccess.value = true
            }
            .addOnFailureListener { e ->
                Log.w("ExerciciosViewMOdel", "Error adding document", e)
                mSaveSuccess.value = false
            }
    }

    fun getAllExercicios(){
        var exercicio: List<ExercicioModel>? = null
        val exercicioResponse = ExercicioResponse()
        db.collection("exercicios")
            .get()
            .addOnSuccessListener { result ->
                result?.let {
                    exercicio = result.documents.mapNotNull { snapShot ->
                        snapShot.toObject(ExercicioModel::class.java)
                    }
                }
                Log.d("TreinosViewModel","ta: "+exercicio!!.size)
                Log.d("TreinosViewModel","Description: "+exercicio!!.get(0).observacoes)
                exercicioResponse.exercicio = exercicio
                mExercicioResponse.value = exercicioResponse
            }
            .addOnFailureListener { exception ->
                Log.d("ExerciosViewModel", "Error getting documents.", exception)
                exercicioResponse.erro = "Erro"
                mExercicioResponse.value = exercicioResponse
            }

    }


}
