package com.example.tablas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener{


    var progreso:Int? = null

    var elementos = arrayOfNulls<String>(11)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekControl.setOnSeekBarChangeListener(this)//seek bar

        calcularTablas(seekControl.progress)

    }


    fun calcularTablas(progreso:Int){
        tvLeyenda.text = "Tabla del $progreso"
        for (i in 0..10){
            val texto ="$progreso x $i = ${progreso*i}"
            elementos.set(i, texto)
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, elementos)

        lvTablas.adapter = adapter

    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

        calcularTablas(progress)
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }

}
