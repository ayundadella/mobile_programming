package com.example.uts_mobile_terapan

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import kotlinx.android.synthetic.main.activity_form_tambah.*
import kotlinx.android.synthetic.main.list_layout.*
import org.json.JSONArray

class Form_tambah : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_tambah)


        btntambah.setOnClickListener{
            var data_namapenduduk: String = dataNama.text.toString()
            var data_ttlpenduduk: String = dataTtl.text.toString()
            var data_hppenduduk: String = dataHP.text.toString()
            var data_alamatpenduduk: String = dataAlamat.text.toString()

            postkeserver(data_namapenduduk, data_ttlpenduduk, data_hppenduduk, data_alamatpenduduk)

            startActivity(Intent(this@Form_tambah, Data_penduduk::class.java))
            finish()

//            val intent2 = Intent(context, Dashboard::class.java)
//            startActivity(intent2)
        }




        btnlogout.setOnClickListener() {
            val sharedPreferences=getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)
            val editor=sharedPreferences.edit()

            editor.putString("STATUS","0")
            editor.apply()

            startActivity(Intent(this@Form_tambah, Login::class.java))
        }
    }

    fun postkeserver(data1:String, data2:String, data3:String, data4:String)
    {
        AndroidNetworking.post("http://192.168.43.200/uts_kotlin/proses-penduduk.php")
            .addBodyParameter("nama_penduduk",data1)
            .addBodyParameter("ttl_penduduk",data2)
            .addBodyParameter("alamat_penduduk",data3)
            .addBodyParameter("hp_penduduk",data4)
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

