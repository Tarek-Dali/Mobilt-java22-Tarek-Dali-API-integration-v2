package com.example.uppgift3v1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser


class JokesFragment : Fragment() {

    private val url = "https://v2.jokeapi.dev/joke/Any?blacklistFlags=nsfw,religious,political,racist,sexist,explicit"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_jokes, container, false)

        val textJoke = view.findViewById<TextView>(R.id.textViewJokes)
        val button = view.findViewById<Button>(R.id.btnGetJoke)


        button.setOnClickListener{
            val requestQueue = Volley.newRequestQueue(requireContext())
            val request = StringRequest(
                Request.Method.GET, url,
                {res ->
                    val parser = JSONParser()
                    val obj: Any? = parser.parse(res as String)
                    val response = obj as JSONObject

                    if(response.containsKey("joke")){
                        textJoke.text = "${response["joke"]}"
                    }else{
                        textJoke.text = "${response["setup"]} \n \n ${response["delivery"]}"
                    }

                },
                {err -> Log.d("Tarek", err.toString())}
            )
            requestQueue.add(request)
        }

        return view
    }

}