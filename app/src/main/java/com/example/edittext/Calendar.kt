package com.example.edittext

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.Calendar

class Calendar : AppCompatActivity() {

    lateinit var dateText: TextView

    private var btn_home: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        btn_home = findViewById(R.id.btn_home)
        btn_home?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Calendar, MainActivity::class.java)
            startActivity(intent) // 액티비티 이동.
        })

        dateText = findViewById(R.id.dateText)

        val dateBtn: Button = findViewById(R.id.dateBtn)

        //버튼 클릭 이벤트
        dateBtn.setOnClickListener {

            //달력 보여주기 함수
            showDatePicker()
        }
    }

    /**
     * 달력 보여주기 함수
     */
    private fun showDatePicker(){

        //오늘 날짜 변수에 담기
        val calendar: Calendar = Calendar.getInstance()

        val iYear = calendar.get(Calendar.YEAR)//년
        val iMonth = calendar.get(Calendar.MONTH)//월
        val iDay = calendar.get(Calendar.DAY_OF_MONTH)//일

        //달력 호출
        val datePicker: DatePickerDialog = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->

                //1월은 0부터 시작해서 +1 해준다
                val tMonth: Int = month + 1

                //년 월 일
                val date: String = "$year / $tMonth / $day"

                //화면에 선택한 날짜 보여주기
                dateText.text = date
            }, iYear, iMonth, iDay)

        //달력 호출
        datePicker.show()
    }
}