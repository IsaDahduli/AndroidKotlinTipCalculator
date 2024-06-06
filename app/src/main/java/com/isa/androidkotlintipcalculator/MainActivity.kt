package com.isa.androidkotlintipcalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        // To hide the status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val btnCalculate = findViewById<Button>(R.id.btn_calculate)
        val etBill = findViewById<EditText>(R.id.et_bill)
        val etTip = findViewById<EditText>(R.id.et_tip)
        val texTotal = findViewById<TextView>(R.id.tv_total)

        btnCalculate.setOnClickListener {
            val billString = etBill.text.toString()
            val tipString = etTip.text.toString()

            if (billString.isEmpty() || tipString.isEmpty()) {
                Toast.makeText(this@MainActivity, "Please enter a value", Toast.LENGTH_SHORT).show()
            } else {
                val billValue = billString.toDouble()
                val tipValue = tipString.toDouble()

                val totalValue = billValue * (1 + tipValue / 100)
                texTotal.text = String.format("%.2f", totalValue)
            }
        }
    }
}