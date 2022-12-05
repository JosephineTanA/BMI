package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val height = findViewById<EditText>(R.id.heightEditText)
        val weight = findViewById<EditText>(R.id.weightEditText)

        val calcButton = findViewById<Button>(R.id.button)
        val clearButton = findViewById<Button>(R.id.clearButton)
        val bmiInfo = findViewById<TextView>(R.id.infoBMITextView)
        val heartRateButton = findViewById<Button>(R.id.heartRateButton)


        // make heart rate button inactive
        heartRateButton.visibility = GONE

        // Make info text invisible until Calculate button is pressed
        bmiInfo.visibility = View.INVISIBLE

        calcButton.setOnClickListener{
            var heightValue = 0.0
            var weightValue = 0.0
            if(height.text.toString().isNotEmpty()){
                heightValue = height.text.toString().toDouble()
            }
            if(weight.text.toString().isNotEmpty()){
                weightValue = weight.text.toString().toDouble()
            }
            if(weightValue > 0.0 && heightValue > 0.0){
                val bmiValue = String.format("%0.2f",
                    weightValue*703/heightValue*heightValue)
                bmiInfo.text = "BMI is ${String.format("%0.2f",bmiValue)} you are
                ${bmiResults(weightValue*703/heightValue*heightValue)}"
                bmiInfo.visibility = VISIBLE
            }
            else {
                Toast.makeText(
                    this, "Please input Weight and Height Values greater than 0",
                    Toast.LENGTH_LONG).show()
            }
        }

        clearButton.setOnClickListener {
            weight.text.clear()
            height.text.clear()
        }

    }
    }
}