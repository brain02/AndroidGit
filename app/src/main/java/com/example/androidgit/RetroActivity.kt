package com.example.androidgit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class RetroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retro)
        title = "Retrofit"
        var i = intent.getIntExtra("lol",0)
        Toast.makeText(this,"! $i", Toast.LENGTH_SHORT).show()

    }
}