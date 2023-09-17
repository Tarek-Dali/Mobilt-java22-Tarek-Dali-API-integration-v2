package com.example.uppgift3v1


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val masterFragmentId = R.id.masterFragment
        val chuckNorrisFragmentId = R.id.chuckNorrisFragment
        val dogsFragmentId = R.id.dogsFragment
        val jokesFragmentId = R.id.jokesFragment

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        val button = findViewById<Button>(R.id.btnToChuckNorrisFgm)
        val button2 = findViewById<Button>(R.id.btnToDogImgs)
        val button3 = findViewById<Button>(R.id.btnToJokesFgm)
        val button4 = findViewById<Button>(R.id.btnHome)

        button.setOnClickListener{
            when (navController.currentDestination?.id) {
                masterFragmentId -> navController.navigate(R.id.action_masterFragment_to_chuckNorrisFragment)
                dogsFragmentId -> navController.navigate(R.id.action_dogsFragment_to_chuckNorrisFragment)
                jokesFragmentId -> navController.navigate(R.id.action_jokesFragment_to_chuckNorrisFragment)
            }
        }

        button2.setOnClickListener{
            when (navController.currentDestination?.id) {
                masterFragmentId -> navController.navigate(R.id.action_masterFragment_to_dogsFragment)
                chuckNorrisFragmentId -> navController.navigate(R.id.action_chuckNorrisFragment_to_dogsFragment)
                jokesFragmentId -> navController.navigate(R.id.action_jokesFragment_to_dogsFragment)
            }
        }

        button3.setOnClickListener{
            when (navController.currentDestination?.id) {
                masterFragmentId -> navController.navigate(R.id.action_masterFragment_to_jokesFragment)
                chuckNorrisFragmentId -> navController.navigate(R.id.action_chuckNorrisFragment_to_jokesFragment)
                dogsFragmentId -> navController.navigate(R.id.action_dogsFragment_to_jokesFragment)
            }
        }

        button4.setOnClickListener{
            navController.popBackStack(R.id.masterFragment, false)
        }


    }
}