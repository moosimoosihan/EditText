package com.example.edittext

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.widget.Button

class Vibrator_Activity : AppCompatActivity() {

    private var btn_home: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vibrator)

        btn_home = findViewById(R.id.btn_home)
        btn_home?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Vibrator_Activity, MainActivity::class.java)
            startActivity(intent) // 액티비티 이동.
        })

        val vibBtn: Button = findViewById(R.id.vibBtn)
        vibBtn.setOnClickListener {
            //진동
            showVibrator()
        }
    }

    //진동 이벤트
    private fun showVibrator(){

        val vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator

        //버전 오레오, 그 이상(안드로이드 8)
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            //진동시간, 세기 설정(0.5초, 기본세기)
            vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE))
        }else{ //오레오 이하
            //0.5초동안 울림
            vibrator.vibrate(500)
        }
    }
}