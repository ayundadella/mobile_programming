package com.example.ayundaminggu1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var kota : String="Surabaya" //unmutable atau tidak bisa di ubah
//        kota="Malang" // var mutable atau bisa ubah-ubah
//        kota="Probolinggo"

//        var jam = 12
//        if (jam <= 12) {
//            Log.i("Hasil", "Selamat Pagi")
//        } else {
//            Log.i("Hasil", "Selamat Petang")
//        }

//        var nilai = 80
//        if (nilai >= 90 && nilai <= 100) {
//            Log.i("Hasil", "Nilai Anda A")
//            tampil.text="Nilai Anda A"
//
//        } else if (nilai >= 80 && nilai <= 89) {
//            Log.i("Hasil", "Nilai Anda AB")
//            tampil.text="Nilai Anda AB"
//
//        } else if (nilai >= 70 && nilai <= 79) {
//            Log.i("Hasil", "Nilai Anda B")
//            tampil.text="Nilai Anda B"
//
//        } else if (nilai >= 60 && nilai <= 69) {
//            Log.i("Hasil", "Nilai Anda BC")
//            tampil.text="Nilai Anda BC"
//
//        } else if (nilai <= 59) {
//            Log.i("Hasil", "Nilai Anda C")
//            tampil.text="Nilai Anda C"
//        }

        //Looping
//        for (x in 0..10)
//            Log.i("Hasil", "$x")

//        var i = 1
//        while (i <= 5) {
//            Log.i("Hasil", "Line $i")
//            ++i
//        }

//        var num = 2
//        var i = 1
//        do {
//            Log.i("Hasil", "2 * $i = "+num * i)
//            i++
//        } while (i < 11)

//        var a=7
//        var b=5
//        penjumlahan(a,b)

        var a=5
        var b=6
        var c=10
        hitung(a,b,c)
    }

//    fun penjumlahan(a:Int, b:Int) {
//        var c :Int
//        c = a+b
//        Log.i("Hasil", "$c")

    fun hitung(a:Int, b:Int, c:Int) {
        var d :Int
        d = (a * b - 10) / c
        Log.i("Hasil", "$d")
    }
    }

