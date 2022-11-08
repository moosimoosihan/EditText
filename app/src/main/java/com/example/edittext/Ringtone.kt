package com.example.edittext

import android.content.Intent
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Ringtone : AppCompatActivity() {

    private var btn_home: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ringtone)

        btn_home = findViewById(R.id.btn_home)
        btn_home?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Ringtone, MainActivity::class.java)
            startActivity(intent) // 액티비티 이동.
        })
    }
    //소리 알림
    fun getSound(view: View) {

        when(view.id){

            //시스템 소리
            R.id.systemBtn -> {
                //소리 얻기
                var sound: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

                //소리 담기
                val ringtone = RingtoneManager.getRingtone(applicationContext, sound)

                //실행
                ringtone.play()
            }
            //사용자 정의
            R.id.customBtn -> {

                //소리 얻기
                val player: MediaPlayer = MediaPlayer.create(this, R.raw.tiny_button_push_sound)

                //실행
                player.start()
            }
        }// when
    }//getSound()
}