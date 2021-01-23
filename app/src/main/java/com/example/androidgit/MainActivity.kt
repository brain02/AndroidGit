package com.example.androidgit

import android.R.attr.button
import android.R.attr.name
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.webkit.WebView
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            //init component
            val btnBack = findViewById<Button>(R.id.btnBack)
            val btnNext = findViewById<Button>(R.id.btnNext)
            val btnRetro = findViewById<Button>(R.id.btnRetrofit)
            val myIntent = Intent(this, SecondActivity::class.java)

        // переход во фрагмент
        btnBack.setOnClickListener {
            startActivity(Intent(this,ThridActivity::class.java))
        }

        //DB
        btnNext.setOnClickListener {
            myIntent.putExtra("text", "SecondActivity") //
            startActivity(myIntent)
        }

        //retrofit
        btnRetro.setOnClickListener {
            //startActivity(Intent(this, RetroActivity::class.java))
            Toast.makeText(this,"Hello, Android Development",Toast.LENGTH_SHORT).show()
            //startActivity(Intent(this,RetroActivity::class.java).putExtra("lol", 5))
        }


    }

}