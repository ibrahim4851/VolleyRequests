package com.ibrahim.volleyrequests

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var getarray: Button
    private lateinit var getobject: Button
    private lateinit var postarray: Button
    private lateinit var postobject: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getarray = findViewById(R.id.getarray)
        getobject = findViewById(R.id.getobject)
        postarray = findViewById(R.id.postarray)
        postobject = findViewById(R.id.postobject)

    }

    fun click(){
        getarray.setOnClickListener {  }
    }

}