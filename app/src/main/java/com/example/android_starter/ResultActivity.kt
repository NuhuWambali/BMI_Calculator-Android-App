package com.example.android_starter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val containerR=findViewById<LinearLayout>(R.id.containerR)
        val bmiValueTv=findViewById<TextView>(R.id.bmiValue)
        val flagImage=findViewById<ImageView>(R.id.bmiFlagImage)
        val bmiLabel=findViewById<TextView>(R.id.bmiLableTv)
        val comment=findViewById<TextView>(R.id.commentTv)
        val advice1Img=findViewById<ImageView>(R.id.advice1Img)
        val  advice1Tv=findViewById<TextView>(R.id.advice1Tv)
        val advice2Img=findViewById<ImageView>(R.id.advice2Img)
        val  advice2Tv=findViewById<TextView>(R.id.advice2Tv)
        val advice3Img=findViewById<ImageView>(R.id.advice3Img)
        val  advice3Tv=findViewById<TextView>(R.id.advice3Tv)

        val bmi=intent.getDoubleExtra("bmi", -1.0)
        if(bmi==-1.0){

            containerR.visibility= View.GONE
        }
        else{
            bmiValueTv.text=bmi.toString()
            if(bmi<18.5){
                containerR.setBackgroundResource(R.drawable.yellow_bg)
                flagImage.setImageResource(R.drawable.alert)
                bmiLabel.text="You are under weight"
                comment.text="Here are the tips to help you increase your weight"
                advice1Img.setImageResource(R.drawable.no_plastic_bottles)
                advice1Tv.text="Don't drink water before meal"
                advice2Img.setImageResource(R.drawable.roast_chicken)
                advice2Tv.text="Eat Big Meal"
                advice3Img.setImageResource(R.drawable.sleepy)
                advice3Tv.text="Get quality sleep"
            }
            else{
                if(bmi>25){
                    containerR.setBackgroundResource(R.drawable.red_bg)
                    flagImage.setImageResource(R.drawable.danger)
                    bmiLabel.text="You are over weight"
                    comment.text="Here are the tips to help you decrease your weight"
                    advice1Img.setImageResource(R.drawable.water)
                    advice1Tv.text="Don't drink water a half hour before meal"
                    advice2Img.setImageResource(R.drawable.ugali)
                    advice2Tv.text="Eat only two times  per day and make sure meal contains high protein"
                    advice3Img.setImageResource(R.drawable.sugar_free)
                    advice3Tv.text="Avoid sugar food, drink cofee"
                }
            }
        }
    }
}