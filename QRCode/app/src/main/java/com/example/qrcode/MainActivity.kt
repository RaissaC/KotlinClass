package com.example.qrcode

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.zxing.BarcodeFormat
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFun()
    }

    private fun initFun() {
        button.setOnClickListener {
            initScann()
        }
    }

    private fun initScann() {
        IntentIntegrator(this).initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?, page: View) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

        if (result != null) {
            if (result.contents == null) {
                //se os dados do resultado for nulo ou vazio
                Toast.makeText(this, "Não há conteúdo nesse QRcCode", Toast.LENGTH_LONG).show()
            }
        } else {
            //a câmera não fecha enquanto o resultado for nullo
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun setScannerProperties() {
        qrCodeScanner.setFormats(listOf(BarcodeFormat.QR_CODE))
        qrCodeScanner.setAutoFocus(true)
        qrCodeScanner.setLaserColor(R.color.colorAccent)
        qrCodeScanner.setMaskColor(R.color.colorAccent)
        if (Build.MANUFACTURER.equals(HUAWEI, ignoreCase = true))
            qrCodeScanner.setAspectTolerance(0.5f)
    }


}
