package com.example.edittext

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class LottoNumber : AppCompatActivity() {   lateinit var lottoText: TextView

    private var btn_home: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //객체 생성
        lottoText = findViewById(R.id.lottoText)
        val lottoBtn: Button = findViewById(R.id.lottoBtn)

        //로또 번호 생성
        lottoBtn.setOnClickListener {

            //로또 텍스트뷰 값 있으면 초기화
            if(lottoText.text.toString() != ""){
                lottoText.text = ""
            }

            //로또 생성
            createLotto()
        }
        btn_home = findViewById(R.id.btn_home)
        btn_home?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@LottoNumber, MainActivity::class.java)
            startActivity(intent) // 액티비티 이동.
        })
    }//onCreate

    private fun createLotto(){

        //Set, List 생성
        val lottoSet: HashSet<String> = HashSet()
        val list: ArrayList<String> = ArrayList()

        //7개 생성할때까지 반복
        while(lottoSet.size < 7){
            val num: Int = (Math.random() * 46 as Int).toInt()

            //숫자 0이 아니면 등록
            if(num != 0){
                lottoSet.add(num.toString())
            }
        }

        //list 담기
        list.addAll(lottoSet)

        for((index, item) in list.withIndex()){

            //0 ~ 6까지는 첫 째줄
            if(index < 6){
                lottoText.append("$item   ")

            }else{ // 나머지 숫자는 줄바꿈
                lottoText.append("\n 보너스 번호 $item")
            }
        }

        //초기화
        lottoSet.clear()
        list.clear()
    }
}