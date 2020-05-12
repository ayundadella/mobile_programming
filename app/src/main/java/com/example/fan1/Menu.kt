package com.example.fan1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*

class Menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val context = this

        button1.setOnClickListener() {
            val intent = Intent(context, identitas_masjid::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener() {
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }

        button3.setOnClickListener() {
            val intent = Intent(context, marquee::class.java)
            startActivity(intent)
        }

        button4.setOnClickListener() {
            val intent = Intent(context, pengumuman::class.java)
            startActivity(intent)
        }

        button5.setOnClickListener() {
            val intent = Intent(context, slideshow::class.java)
            startActivity(intent)
        }

        button6.setOnClickListener() {
            val intent = Intent(context, tagline::class.java)
            startActivity(intent)
        }
    }
}
