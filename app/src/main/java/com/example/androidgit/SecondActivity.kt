package com.example.androidgit

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.core.content.ContextCompat.getSystemService

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setTitle(intent.getStringExtra("text"))
        // init var
        val datalist = mutableListOf<String>("один","Два")
        //init object
        val listView = findViewById<ListView>(R.id.listView)
        val btnConDB = findViewById<Button>(R.id.btnConDB)
        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datalist)
        listView.adapter=adapter

        btnConDB.setOnClickListener {
            Services().hideKeyboard()
        }

    }

}