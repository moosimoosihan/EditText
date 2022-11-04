package com.example.edittext

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.edittext.databinding.ActivityMakeTextViewBinding

class MakeTextView : AppCompatActivity() {

    lateinit var binding: ActivityMakeTextViewBinding
    private var btn_home: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMakeTextViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btn_home = findViewById(R.id.btn_home)
        btn_home?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MakeTextView, MainActivity::class.java)
            startActivity(intent) // 액티비티 이동.
        })

        //텍스트뷰 생성 버튼
        binding.createBtn.setOnClickListener {
            //텍스트뷰 생성
            createTextView()
        }
    }//onCreate

    /**
     * 텍스트뷰 생성
     */
    private fun createTextView(){

        //1. 텍스트뷰 생성
        val textView: TextView = TextView(applicationContext)

        //2. 텍스트뷰 글자
        textView.text  = "텍스트 생성"

        //3. 텍스트뷰 글자 크기
        textView.textSize = 12f

        //4. 텍스트뷰 글자 타입
        textView.setTypeface(null, Typeface.BOLD)

        //5. 텍스트뷰 ID
        textView.id = 0

        //6. 레이아웃
        val param: LinearLayout.LayoutParams = LinearLayout
            .LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)

        param.leftMargin = 30

        //7. 레이아웃 적용
        textView.layoutParams = param

        //8. 텍스트뷰 배경 색상
        textView.setBackgroundColor(Color.BLACK)

        //9. 텍스트뷰 텍스트 색상
        textView.setTextColor(Color.WHITE)

        //10. 레이아웃에 텍스트뷰 추가
        binding.listLayout.addView(textView)
    }
}