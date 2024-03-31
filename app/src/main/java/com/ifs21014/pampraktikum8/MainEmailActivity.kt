package com.ifs21014.pampraktikum8

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainEmailActivity : AppCompatActivity() {
    companion object {
        const val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    @SuppressLint("DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_dashboard)

        val pengirim = resources.getStringArray(R.array.pengirim)
        val pesan = resources.getStringArray(R.array.pesan)
        val gambar = resources.getStringArray(R.array.gambar)
        val waktu = resources.getStringArray(R.array.waktu)

        val gmailList = mutableListOf<Gmail>()

        for (i in pengirim.indices) {
            gmailList.add(
                Gmail(
                    resources.getIdentifier(gambar[i], "drawable", packageName),
                    pengirim[i],
                    waktu[i],
                    pesan[i]
                )
            )
        }

        val recyclerView = findViewById<RecyclerView>(R.id.rv_gmail)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        val adapter = EmailAdapter(this, gmailList) {  }
        recyclerView.adapter = adapter
    }
}
