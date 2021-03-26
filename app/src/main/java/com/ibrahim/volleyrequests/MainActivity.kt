package com.ibrahim.volleyrequests

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var getarray: Button
    private lateinit var getobject: Button
    private lateinit var postobject: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getarray = findViewById(R.id.getarray)
        getobject = findViewById(R.id.getobject)
        postobject = findViewById(R.id.postobject)
        click()

    }

    fun click(){
        getarray.setOnClickListener {
            val intent = Intent(this, GetArray::class.java)
            startActivity(intent)
        }
        getobject.setOnClickListener {
            val intent = Intent(this, GetObject::class.java)
            startActivity(intent)
        }
        postobject.setOnClickListener {
            val intent = Intent(this, PostObject::class.java)
            startActivity(intent)
        }
    }

}