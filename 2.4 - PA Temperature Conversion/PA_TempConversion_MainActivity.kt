package com.example.patrickgonzaleztemperatureconversion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

//Patrick Gonzalez
//PA - Temperature Conversion App
//June 27, 2026
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnConvert = findViewById<Button>(R.id.btnConvert)
        btnConvert.setOnClickListener {
            val txtTemp = findViewById<EditText>(R.id.txtTemp)
            val radFtoC = findViewById<RadioButton>(R.id.radFtoC)
            val txtResult = findViewById<TextView>(R.id.txtResult)

            val inputStr = txtTemp.text.toString()
            if (inputStr.isEmpty()) {
                Toast.makeText(this, "Please enter a temperature value.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val enteredTemp = inputStr.toDouble()

            if (radFtoC.isChecked) {
                // Fahrenheit to Celsius - valid range: -100°F to 250°F
                if (enteredTemp < -100 || enteredTemp > 250) {
                    Toast.makeText(this, "°F value must be between -100 and 250.",
                        Toast.LENGTH_LONG).show()
                } else {
                    // Conversion formula: (°F - 32) * 5/9
                    val celsius = (enteredTemp - 32) * 5.0 / 9.0
                    val result = String.format("%.1f", celsius)
                    txtResult.text = "$result °C"
                }
            } else {
                // Celsius to Fahrenheit - valid range: -75°C to 125°C
                if (enteredTemp < -75 || enteredTemp > 125) {
                    Toast.makeText(this, "°C value must be between -75 and 125.",
                        Toast.LENGTH_LONG).show()
                } else {
                    // Conversion formula: (°C × 9/5) + 32
                    val fahrenheit = (enteredTemp * 9.0 / 5.0) + 32
                    val result = String.format("%.1f", fahrenheit)
                    txtResult.text = "$result °F"
                }
            }
        }
    }
}
