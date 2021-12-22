package br.com.alfa11.devedu.treinos.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.alfa11.devedu.treinos.R


class MainAcitivity : AppCompatActivity() {

 /*   private lateinit var recyclerView: RecyclerView
    private lateinit var treinoArrayList: ArrayList<TreinoModel>
    private lateinit var mAdapter: TreinosAdapter
    private lateinit var mListener: RecipeListener
    private lateinit var mViewModel: TreinosViewModel
*/

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.treinos_container, MainFragment())
                .commitAllowingStateLoss()
        }}}

        /*mViewModel = ViewModelProvider(this).get(TreinosViewModel::class.java)

        observe()

        val root = inflater.inflate(R.layout.activity_main, container, false)
        val recycler = root.findViewById<RecyclerView>(R.id.)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = mAdapter


        button_novo_treino.setOnClickListener{
            startActivity(Intent(this, CadastroTreinoActivity::class.java))
        }

        go_to_training_form.setOnClickListener{
            startActivity(Intent(this, ExerciciosActivity::class.java))
        }
    }*/


        /* recyclerView = findViewById(R.id.recycler_treinos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        treinoArrayList = arrayListOf()

        mAdapter = TreinosAdapter(treinoArrayList)

        recyclerView.adapter = mAdapter

        EventChangeListener()*/

//    }

    /*private fun EventChangeListener(){

        db = FirebaseFirestore.getInstance()
        db.collection("Treinos").orderBy("nome",Query.Direction.ASCENDING).
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
*/


