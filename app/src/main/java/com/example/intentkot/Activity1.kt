package com.example.intentkot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_1.*
import kotlinx.android.synthetic.main.activity_main.*

class Activity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

        val context = this

        //passing atau mengirim data
        val intentObject:Intent=intent
        val name=intentObject.getStringExtra("name")
        textView.text = "HAI $name"

        BtnIntentUtama1.setOnClickListener(){
            val intent = Intent(context,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
