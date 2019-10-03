package com.example.alexandria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import kotlinx.android.synthetic.main.menu.*

class Menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)
    }

    fun nextReservation(button: View) {
        val pageReservation = Intent(this, Reservation::class.java)
        pageReservation.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        startActivity(pageReservation)
    }

    fun nextGiveBack(button: View) {
        val pageGiveBack = Intent(this, GiveBack::class.java)
        pageGiveBack.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        startActivity(pageGiveBack)
    }

    fun nextRenew(button: View) {
        val pageRenew = Intent(this, Renew::class.java)
        pageRenew.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        startActivity(pageRenew)
    }
}
