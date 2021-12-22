package br.com.alfa11.devedu.treinos.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.alfa11.devedu.treinos.treinos.TreinoModel
import br.com.alfa11.devedu.treinos.treinos.TreinoResponse
import com.google.firebase.firestore.FirebaseFirestore

class TreinosViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext = application.applicationContext
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    private val mSaveSuccess = MutableLiveData<Boolean>()
    val success: LiveData<Boolean> = mSaveSuccess

    private var mTreinoResponse = MutableLiveData<TreinoResponse>()
    val treinoResponse: LiveData<TreinoResponse> = mTreinoResponse




    fun addTreino(treino: TreinoModel) {
        db.collection("treinos")
            .add(treino)
            .addOnSuccessListener { documentReference ->
                mSaveSuccess.value = true
            }
            .addOnFailureListener { e ->
                Log.w("RecipeViewModel", "Error adding document", e)
                mSaveSuccess.value = false
            }
    }

    fun getAllTreinos(){
        var treino: List<TreinoModel>? = null
        val treinoResponse = TreinoResponse()
        db.collection("treinos")
            .get()
            .addOnSuccessListener { result ->
                result?.let {
                    treino = result.documents.mapNotNull { snapShot ->
                        snapShot.toObject(TreinoModel::class.java)
                    }
                }
                Log.d("TreinosViewModel","ta: "+treino!!.size)
                Log.d("TreinosViewModel","Description: "+treino!!.get(0).descricao)
                treinoResponse.treino = treino
                mTreinoResponse.value = treinoResponse
            }
            .addOnFailureListener { exception ->
                Log.d("TreinosViewModel", "Error getting documents.", exception)
                treinoResponse.erro = "Erro"
                mTreinoResponse.value = treinoResponse
            }

    }


}
