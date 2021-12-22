package br.com.alfa11.devedu.treinos.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.alfa11.devedu.treinos.R


class ExerciciosActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercicios)


        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.exercicios_container, ExercicioListFragment())
                .commitAllowingStateLoss()
        }}}