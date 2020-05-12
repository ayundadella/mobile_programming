package com.example.fan1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_identitas_masjid.*
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject

class identitas_masjid : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_identitas_masjid)

        getdariserver()


        val context = this
        back1.setOnClickListener(){
            val intent = Intent(context,Menu::class.java)
            startActivity(intent)
        }

        btnupdate.setOnClickListener(){

            val intent = Intent(context,Menu::class.java)
            startActivity(intent)

            var data_namamasjid = edit_namamasjid.text.toString()
            var data_alamatmasjid = edit_alamatmasjid.text.toString()

            postkeserver(data_namamasjid,data_alamatmasjid)

        }
    }

    fun getdariserver() {
        AndroidNetworking.get("http://192.168.1.12/cobarepo-master/identitas_masjid_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("nama_masjid"))
                        Log.e("_kotlinTitle", jsonObject.optString("alamat_masjid"))

                        nama_masjid.setText(jsonObject.optString("nama_masjid"))//mengambil data dr json
                        alamat.setText(jsonObject.optString("alamat_masjid"))
                    }

                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }
            })
    }

    fun postkeserver(data1:String,data2:String)
    {
        AndroidNetworking.post("http://192.168.1.12/cobarepo-master/proses-identitas.php")
            .addBodyParameter("nama_masjid",data1)
            .addBodyParameter("alamat_masjid",data2)
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
