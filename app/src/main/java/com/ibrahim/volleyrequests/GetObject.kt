package com.ibrahim.volleyrequests

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class GetObject : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_object)
        getRequest()
    }

    fun getRequest() {
        var url = "https://raw.githubusercontent.com/ibrahim4851/VolleyRequests/master/nestedjson.json"
        val queue: RequestQueue = Volley.newRequestQueue(this)
        val request = JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            { response ->
                val glossary = response.getJSONObject("glossary")
                val GlossDiv = glossary.getJSONObject("GlossDiv")
                val GlossList = GlossDiv.getJSONObject("GlossList")
                val GlossEntry = GlossList.getJSONObject("GlossEntry")
                val id = GlossEntry.getString("ID")
                val GlossDef = GlossEntry.getJSONObject("GlossDef")
                val jsonArray = GlossDef.getJSONArray("GlossSeeAlso")
                for (i in 0 until jsonArray.length()) {
                    var string = jsonArray.getString(i)
                    Log.i("value", string)
                }
            },
            { error -> Log.i("errormessage", "Connection Error") })
        queue.add(request)
    }

}