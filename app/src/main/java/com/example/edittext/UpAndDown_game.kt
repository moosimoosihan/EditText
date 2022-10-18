package com.example.edittext

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlin.random.Random

class UpAndDown_game : AppCompatActivity() {

    lateinit var requestText: EditText
    lateinit var lifeCountText: TextView
    lateinit var resultText: TextView
    lateinit var startBtn: Button
    lateinit var answerBtn: Button
    lateinit var resetBtn: Button
    private var btn_home: Button? = null


    // 랜덤값
    private var randomNumber = 0

    //최저값
    var min = 0

    //최고값
    var max = 100

    //기회 횟수
    var lifeCount = 10

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //입력 텍스트
        requestText = findViewById(R.id.requestText)
        //기회 횟수
        lifeCountText = findViewById(R.id.lifeCountText)
        //결과 텍스트
        resultText = findViewById(R.id.resultText)
        //시작 버튼
        startBtn = findViewById(R.id.startBtn)
        //정답 버튼
        answerBtn = findViewById(R.id.answerBtn)
        //초기화 버튼
        resetBtn = findViewById(R.id.resetBtn)

        //화면 설정
        viewMode("end")

        //기회 횟수 보여주기
        showLifeCount(lifeCount)

        //시작 버튼 이벤트
        startBtn.setOnClickListener {

            viewMode("start")

            toastMessage("게임 시작")

            //랜덤 숫자 생성
            createRandomNumber()
        }

        //정답 버튼 이벤트
        answerBtn.setOnClickListener {

            var inputNumber: String = requestText.text.toString()

            //입력값 체크
            if(inputNumber == ""){
                toastMessage("값을 입력해주세요")

            }else{ //값이 있으면
                //숫자 비교
                numberCheck(inputNumber)
            }
        }

        //초기화 버튼 이벤트
        resetBtn.setOnClickListener {

            //초기화
            reset()

            viewMode("end")
        }
        btn_home = findViewById(R.id.btn_home)
        btn_home?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@UpAndDown_game, MainActivity::class.java)
            startActivity(intent) // 액티비티 이동.
        })
    }//onCreate

    /**
     * 랜덤 숫자 생성
     */
    private fun createRandomNumber(){

        //랜덤 숫자 1 ~ 100 사이 생성
        randomNumber = Random.nextInt(100)+1
    }

    /**
     * 화면 구조
     * mode: start: 시작, end: 쉬는중
     */
    @RequiresApi(Build.VERSION_CODES.M)
    private fun viewMode(mode: String){

        if(mode == "start"){
            //활성화 설정
            startBtn.isEnabled = false
            requestText.isEnabled = true
            answerBtn.isEnabled = true
            resetBtn.isEnabled = true

            //색상 설정
            startBtn.setBackgroundColor(getColor(android.R.color.darker_gray))
            answerBtn.setBackgroundColor(getColor(android.R.color.holo_green_light))
            resetBtn.setBackgroundColor(getColor(android.R.color.holo_green_light))
        }
        else if(mode == "end"){
            //활성화 설정
            startBtn.isEnabled = true
            requestText.isEnabled = false
            answerBtn.isEnabled = false
            resetBtn.isEnabled = false

            //색상 설정
            startBtn.setBackgroundColor(getColor(android.R.color.holo_green_light))
            answerBtn.setBackgroundColor(getColor(android.R.color.darker_gray))
            resetBtn.setBackgroundColor(getColor(android.R.color.darker_gray))
        }
    }

    /**
     * 초기화
     */
    private fun reset(){
        min = 1
        max = 100
        lifeCount = 10

        //기회 횟수
        showLifeCount(lifeCount)

        //결과 텍스트
        resultText.text = ""
    }

    /**
     *기회 횟수보여주기
     * lifeCount: 횟수
     */
    private fun showLifeCount(lifeCount: Int){

        lifeCountText.text = "기회: $lifeCount 번"
    }

    /**
     * 숫자 비교
     * mInputNumber: 입력값
     */
    @RequiresApi(Build.VERSION_CODES.M)
    private fun numberCheck(mInputNumber: String){

        //기회 횟수 감소
        --lifeCount

        //변경된 기회 횟수 보여주기
        showLifeCount(lifeCount)

        var inputNumber = mInputNumber.toInt()

        //1. 입력값이 랜덤수보다 크면
        if(inputNumber > randomNumber){

            // 입력값을 최대값에 넣는다.
            max = inputNumber

            resultText.text = "$min ~ $max"
        }
        //2. 입력값이 랜덤수보다 작으면
        else if(inputNumber < randomNumber){

            //입력값을 최소값에 넣는다.
            min = inputNumber

            resultText.text = "$min ~ $max"
        }
        //3. 입력값이 랜덤수랑 같으면
        else if(inputNumber == randomNumber){

            toastMessage("정답입니다.")

            resultText.text = "정답: $inputNumber"
        }

        //기회 횟수가 없으면
        if(lifeCount == 0){
            toastMessage("게임 종료")

            reset()

            viewMode("end")
        }

        //입력 텍스트 초기화
        requestText.setText("")
    }

    /**
     * 메시지 알림
     *
     */
    private fun toastMessage(message: String){

        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

}