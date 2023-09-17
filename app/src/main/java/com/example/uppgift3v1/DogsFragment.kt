package com.example.uppgift3v1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.squareup.picasso.Picasso
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser


class DogsFragment : Fragment() {

    private val url = "https://dog.ceo/api/breeds/image/random"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dogs, container, false)

        val button = view.findViewById<Button>(R.id.btnGetDogImg)
        val image = view.findViewById<ImageView>(R.id.imageViewDogs)

        button.setOnClickListener{
            val requestQueue = Volley.newRequestQueue(requireContext())
            val request = StringRequest(
                Request.Method.GET, url,
                {res ->
                    val parser = JSONParser()
                    val obj: Any? = parser.parse(res as String)
                    val response = obj as JSONObject
                    val imgUrl = response["message"].toString()
                    Picasso.get().load(imgUrl).into(image)

                },
                {err -> Log.d("Tarek", err.toString())}
            )
            requestQueue.add(request)
        }

        return view
    }


}