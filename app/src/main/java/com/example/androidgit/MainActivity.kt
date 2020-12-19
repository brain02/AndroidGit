package com.example.androidgit

import android.R.attr.button
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
            val myIntent = Intent(this, SecondActivity::class.java)

        // переход во фрагмент
        btnBack.setOnClickListener {
            startActivity(Intent(this,ThridActivity::class.java))
        }

        //переход в активити подключение DB
        btnNext.setOnClickListener {
            myIntent.putExtra("text", "SecondActivity") //
            startActivity(myIntent)
        }
    }

}