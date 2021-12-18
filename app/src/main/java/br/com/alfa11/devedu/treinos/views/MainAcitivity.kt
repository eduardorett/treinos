package br.com.alfa11.devedu.treinos.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.alfa11.devedu.treinos.R
import br.com.alfa11.devedu.treinos.service.TreinoModel
import br.com.alfa11.devedu.treinos.views.adapters.TreinosAdapter
import com.google.firebase.firestore.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_treino_detalhes.*


class MainAcitivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var treinoArrayList: ArrayList<TreinoModel>
    private lateinit var mAdapter: TreinosAdapter
    private lateinit var db: FirebaseFirestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.recycler_treinos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        treinoArrayList = arrayListOf()

        mAdapter = TreinosAdapter(treinoArrayList)

        recyclerView.adapter = mAdapter

        EventChangeListener()

    }

    private fun EventChangeListener(){

        db = FirebaseFirestore.getInstance()
        db.collection("Treino").orderBy("nome",Query.Direction.ASCENDING).
        addSnapshotListener(object : EventListener<QuerySnapshot> {
            override fun onEvent(
                value: QuerySnapshot?,
                error: FirebaseFirestoreException?
            ) {


                if(error !=null){
                    Log.e("FireStore Error",error.message.toString())
                    return
                }
                for (dc: DocumentChange in value?.documentChanges!!){




                    if(dc.type == DocumentChange.Type.ADDED){

                        treinoArrayList.add(dc.document.toObject(TreinoModel::class.java))
                    }
                }
                mAdapter.notifyDataSetChanged()
            }
        })



        button_novo_treino.setOnClickListener {
            startActivity(Intent(this, CadastroTreinoActivity::class.java))
        }

        go_to_training_form.setOnClickListener {
            startActivity(Intent(this,DetalhesTreinoActivity::class.java))
        }
    }
}