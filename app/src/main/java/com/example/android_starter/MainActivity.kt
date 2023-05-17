package com.example.android_starter

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.math.BigDecimal
import java.math.RoundingMode


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calculateBtn=findViewById<Button>(R.id.calculateBtn);
        val weight=findViewById<TextView>(R.id.weightText);
        val height=findViewById<TextView>(R.id.HeightText);

        calculateBtn.setOnClickListener {
            if(height.text.isNotEmpty() && weight.text.isNotEmpty()){
                val weight=weight.text.toString().toDouble();
                val height=height.text.toString().toDouble()/100;

                if(weight >0  && height>=0.5 ){
                    val intent= Intent(this@MainActivity, ResultActivity::class.java)
                    intent.putExtra("bmi", calculateBmi(weight,height))
                    startActivity(intent)
                }
                else{
                    showError("incorrect value")
                }
            }
            else{
                showError("A field is missing")
            }
            }
        }

   private fun showError(errorMsg:String){
      Toast.makeText(this,"error : $errorMsg", Toast.LENGTH_LONG).show()
   }

   private fun calculateBmi(weight:Double, height:Double)= BigDecimal(weight/(height * height))
       .setScale(2,RoundingMode.HALF_EVEN).toDouble()
}