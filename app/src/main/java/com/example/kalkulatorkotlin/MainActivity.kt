package com.example.kalkulatorkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        jumlahkan.setOnClickListener() {
//            var bilangan1: String = bil1.text.toString()
//            var bilangan2: String = bil2.text.toString()
//
//            var a: Int = bilangan1.toInt()
//            var b: Int = bilangan2.toInt()
//
//            var c: Int = a + b
//
//            hasil.setText(c.toString())
//        }
//
//        kurangi.setOnClickListener() {
//                var bilangan1:String=bil1.text.toString()
//                var bilangan2:String=bil2.text.toString()
//
//                var a:Int=bilangan1.toInt()
//                var b:Int=bilangan2.toInt()
//
//                var c:Int=a-b
//
//                hasil.setText(c.toString())
//            }
//
//        bagi.setOnClickListener() {
//            var bilangan1:String=bil1.text.toString()
//            var bilangan2:String=bil2.text.toString()
//
//            var a:Int=bilangan1.toInt()
//            var b:Int=bilangan2.toInt()
//
//            var c:Int=a/b
//
//            hasil.setText(c.toString())
//        }
//
//        kali.setOnClickListener() {
//            var bilangan1:String=bil1.text.toString()
//            var bilangan2:String=bil2.text.toString()
//
//            var a:Int=bilangan1.toInt()
//            var b:Int=bilangan2.toInt()
//
//            var c:Int=a*b
//
//            hasil.setText(c.toString())
//        }

        jumlahkan.setOnClickListener() {
            tambah()
        }

        kurangi.setOnClickListener(){
            kurang()
        }

        bagi.setOnClickListener(){
            pembagian()
        }

        kali.setOnClickListener(){
            perkalian()
        }
    }

    fun tambah() {
        var bilangan1: String = bil1.text.toString()
        var bilangan2: String = bil2.text.toString()

        var a: Int = bilangan1.toInt()
        var b: Int = bilangan2.toInt()

        var c: Int = a + b
        hasil.setText(c.toString())

    }

    fun kurang() {
        var bilangan1: String = bil1.text.toString()
        var bilangan2: String = bil2.text.toString()

        var a: Int = bilangan1.toInt()
        var b: Int = bilangan2.toInt()

        var c: Int = a - b
        hasil.setText(c.toString())

    }

    fun pembagian() {
        var bilangan1: String = bil1.text.toString()
        var bilangan2: String = bil2.text.toString()

        var a: Int = bilangan1.toInt()
        var b: Int = bilangan2.toInt()

        var c: Int = a / b
        hasil.setText(c.toString())
    }

    fun perkalian() {
        var bilangan1: String = bil1.text.toString()
        var bilangan2: String = bil2.text.toString()

        var a: Int = bilangan1.toInt()
        var b: Int = bilangan2.toInt()

        var c: Int = a * b
        hasil.setText(c.toString())
    }
}
