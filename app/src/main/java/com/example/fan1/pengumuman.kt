package com.example.fan1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_identitas_masjid.*
import kotlinx.android.synthetic.main.activity_marquee.*
import kotlinx.android.synthetic.main.activity_pengumuman.*
import org.json.JSONArray
import org.json.JSONObject

class pengumuman : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengumuman)

        getdariserver()

        val context = this
        back4.setOnClickListener() {
            val intent = Intent(context, Menu::class.java)
            startActivity(intent)
        }

        btnupdate4.setOnClickListener(){

            val intent = Intent(context,Menu::class.java)
            startActivity(intent)

            var data_judulpeng = edit_judulpengumuman.text.toString()
            var data_isipeng = edit_isipengumuman.text.toString()

            postkeserver(data_judulpeng,data_isipeng)

        }
    }

    fun getdariserver() {
        AndroidNetworking.get("http://192.168.1.12/cobarepo-master/pengumuman_masjid_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("judul_pengumuman"))
                        Log.e("_kotlinTitle", jsonObject.optString("isi_pengumuman"))

                        judul_pengumuman.setText(jsonObject.optString("judul_pengumuman"))//mengambil data dr json
                        isi_pengumuman.setText(jsonObject.optString("isi_pengumuman"))
                    }

                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }
            })
    }

    fun postkeserver(data1:String,data2:String)
    {
        AndroidNetworking.post("http://192.168.1.12/cobarepo-master/proses-pengumuman.php")
            .addBodyParameter("judul_pengumuman",data1)
            .addBodyParameter("isi_pengumuman",data2)
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
