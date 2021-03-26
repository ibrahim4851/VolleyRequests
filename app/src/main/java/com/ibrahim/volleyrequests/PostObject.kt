package com.ibrahim.volleyrequests

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.*
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import java.util.HashMap

class PostObject : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_object)
        postNewCommentA(applicationContext)
    }

    fun postNewCommentA(context: Context?) {
        val queue = Volley.newRequestQueue(context)
        /*
        * NOTE:
        * If this link doesn't working, you can get the PHP codes from README.md and run it on your localhost.
        * */
        val sr: StringRequest = object : StringRequest(
            Method.POST, "http://favor4u.xyz/calisma/samplepost.php",
            Response.Listener { response ->
                val res = JSONObject(response)
                val value = res.getString("value")
                Toast.makeText(context, "Successful", Toast.LENGTH_SHORT).show()
                Log.i("value", value)
            }, Response.ErrorListener { error ->
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
            }) {
            override fun getParams(): Map<String, String> {
                val params: MutableMap<String, String> = HashMap()
                params["value"] = "value"
                return params
            }

            @Throws(AuthFailureError::class)
            override fun getHeaders(): Map<String, String> {
                val params: MutableMap<String, String> = HashMap()
                params["Content-Type"] = "application/x-www-form-urlencoded"
                return params
            }
        }
        queue.add(sr)
    }


}