package com.example.mahasiswa_kotlin

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_main2.*
import org.json.JSONArray
import org.json.JSONObject

class Main2 : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val context = this

        btntambah.setOnClickListener(){

//            val intent = Intent(context,Data_mhs::class.java)
//            startActivity(intent)

            var data_nim: String = dataNim.text.toString()
            var data_nama: String =dataNama.text.toString()
            var data_alamat: String =dataAlamat.text.toString()

            postkeserver(data_nim,data_nama,data_alamat)

            startActivity(Intent(this@Main2, Data_mhs::class.java))
            finish()

        }

        btnlogout.setOnClickListener() {
            val sharedPreferences=getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)
            val editor=sharedPreferences.edit()

            editor.putString("STATUS","0")
            editor.apply()

            startActivity(Intent(this@Main2, Login::class.java))
        }
    }

    fun postkeserver(data1:String, data2:String, data3:String)
    {
        AndroidNetworking.post("http://192.168.1.2/data_mahasiswa/proses_mhs.php")
            .addBodyParameter("nama_mahasiswa",data1)
            .addBodyParameter("nomer_mahasiswa",data2)
            .addBodyParameter("alamat_mahasiswa",data3)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray){

                }

                override fun onError(error: ANError) {

                }
            })
    }
}
