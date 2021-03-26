package com.ibrahim.volleyrequests

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException

class GetArray : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_array)
        getJsonArray()
    }

    fun getJsonArray() {
        val requestQueue: RequestQueue = Volley.newRequestQueue(this)
        val jsonArrayRequest =
            JsonArrayRequest("https://raw.githubusercontent.com/ibrahim4851/VolleyRequests/master/jsonarray.json",
                { response ->
                    for (i in 0 until response.length()) {
                        try {
                            val jsonObject = response.getJSONObject(i)
                            val title = jsonObject.getString("title")
                            val description = jsonObject.getString("description")
                            Log.i("title:", title)
                            Log.i("description:", description)
                        } catch (e: JSONException) {
                            e.printStackTrace()
                        }
                    }
                }) {
                Log.i("error", "Connection Error")
            }
        requestQueue.add(jsonArrayRequest)
    }

}