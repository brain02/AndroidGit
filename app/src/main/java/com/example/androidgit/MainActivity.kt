package com.example.androidgit

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //init component
        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val myIntent = Intent(this, SecondActivity::class.java)

        btnBack.setOnClickListener {
          //  toastMe(this,"Click Back")

            val firstFragment: Fragment = FirstFragment()
            val fragmentManager = supportFragmentManager
            val ft: FragmentTransaction = fragmentManager.beginTransaction()
            ft.replace(android.R.id.content, firstFragment)
            ft.commit()
        }

        btnNext.setOnClickListener {
            myIntent.putExtra("text","SecondActivity") //
            startActivity(myIntent)
        }

    }

    //Всплывающее окно Toast
    fun toastMe(context: Context,text:String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

}