package com.example.edittext

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide

class HTTPGlideImageView : AppCompatActivity() {

    lateinit var imageView: ImageView
    private var btn_home: Button? = null


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_httpglide_image_view)

        btn_home = findViewById(R.id.btn_home)
        btn_home?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@HTTPGlideImageView, MainActivity::class.java)
            startActivity(intent) // 액티비티 이동.
        })

        imageView = findViewById(R.id.imaegView)

        val searchBtn: Button = findViewById(R.id.searchBtn)
        searchBtn.setOnClickListener {

            //이미지 가져오기
            showImage()
        }
    }

    /**
     * 이미지 보여주기
     */
    private fun showImage(){

        val url = "https://picsum.photos/200"

        Glide.with(this)
            .load(url)//이미지 위치
            .placeholder(R.drawable.frame)//로딩 이미지
            .error(R.drawable.error)//에러 이미지
            .into(imageView)//보여줄 위치
    }
}