package com.example.androidgit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.androidgit.fragments.FirstFragment
import com.google.android.material.tabs.TabLayout

@Suppress("DEPRECATION")
class ThridActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thrid)
        title = "ThridActivity"
        //init
        val tabs = findViewById<TabLayout>(R.id.tabs)
        val viewpager = findViewById<ViewPager>(R.id.viewpager)

        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        viewpager.adapter=fragmentAdapter
        tabs.setupWithViewPager(viewpager)

    }

}