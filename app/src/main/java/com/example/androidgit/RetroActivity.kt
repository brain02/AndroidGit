package com.example.androidgit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RetroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retro)
        title = "Retrofit"
    }
}