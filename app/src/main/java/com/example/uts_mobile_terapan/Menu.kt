package com.example.uts_mobile_terapan

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*

class Menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val context = this
        menuData.setOnClickListener(){
            val intent = Intent(context, Data_penduduk::class.java)
            startActivity(intent)
        }

        menuTambah.setOnClickListener(){
            val intent = Intent(context, Form_tambah::class.java)
            startActivity(intent)
        }

        btnlogout.setOnClickListener() {
            val sharedPreferences=getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)
            val editor=sharedPreferences.edit()

            editor.putString("STATUS","0")
            editor.apply()

            startActivity(Intent(this@Menu, Login::class.java))
        }
    }
}
