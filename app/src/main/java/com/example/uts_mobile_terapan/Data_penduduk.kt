package com.example.uts_mobile_terapan

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
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_data_penduduk.*
import kotlinx.android.synthetic.main.activity_form_tambah.*
import kotlinx.android.synthetic.main.activity_form_tambah.btnlogout
import org.json.JSONObject

class Data_penduduk : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_penduduk)

        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false) as RecyclerView.LayoutManager?

        val users = ArrayList<User>()

        AndroidNetworking.get("http://192.168.43.200/uts_kotlin/penduduk-json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTitle", jsonObject.optString("nama_penduduk"))

                        // txt1.setText(jsonObject.optString("shubuh")) ambil data dr DB
                        var isi1 = jsonObject.optString("nama_penduduk").toString()
                        var isi2 = jsonObject.optString("ttl_penduduk").toString()
                        var isi3 = jsonObject.optString("alamat_penduduk").toString()
                        var isi4 = jsonObject.optString("hp_penduduk").toString()

                        users.add(User("$isi1", "$isi2", "$isi3", "$isi4"))
                    }
                    val adapter = CustomAdapter(users)
                    recyclerView.adapter = adapter
                }

                override fun onError(anError: ANError) {
                    Log.i("_err", anError.toString())
                }
            })

        val context = this
        btntambahdata.setOnClickListener(){
            val intent = Intent(context, Form_tambah::class.java)
            startActivity(intent)
        }

        btnlogout.setOnClickListener({
            val sharedPreferences=getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)
            val editor=sharedPreferences.edit()

            editor.putString("STATUS","0")
            editor.apply()

            startActivity(Intent(this@Data_penduduk, Login::class.java))
        })
    }
    }

