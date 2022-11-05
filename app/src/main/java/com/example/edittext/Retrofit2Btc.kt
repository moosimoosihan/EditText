package com.example.edittext

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit2Btc : AppCompatActivity() {

    lateinit var coinEdit: EditText
    lateinit var resultText: TextView

    private var btn_home: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit2_btc)

        btn_home = findViewById(R.id.btn_home)
        btn_home?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Retrofit2Btc, MainActivity::class.java)
            startActivity(intent) // 액티비티 이동.
        })


        coinEdit = findViewById(R.id.coinEdit)
        resultText = findViewById(R.id.resultText)
        val searchBtn: Button = findViewById(R.id.searchBtn)

        //버튼 클릭 이벤트
        searchBtn.setOnClickListener {
            //초기화
            resultText.text = ""

            //api 호출
            apiRequest()
        }
    }

    /**
     * HTTP api 호출
     */
    private fun apiRequest(){

        //1. retrofit 객체 생성
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.bithumb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //2. service 객체 생성
        val apiService: ApiService = retrofit.create(ApiService::class.java)

        //3. Call객체 생성
        val coinNm = coinEdit.text.toString().uppercase()//입력값, 대문자로
        val tickerCall = apiService.getCoinTicker(coinNm, "KRW")

        //4. 네트워크 통신
        tickerCall.enqueue(object: Callback<Ticker> {
            override fun onResponse(call: Call<Ticker>, response: Response<Ticker>) {
                //호출 데이터
                val tickerInfo = response.body()

                resultText.append("status: ${tickerInfo?.status} \n")
                resultText.append("closing_price: ${tickerInfo?.data?.closing_price} \n")
                resultText.append("opening_price: ${tickerInfo?.data?.opening_price} \n")
                resultText.append("max_price: ${tickerInfo?.data?.max_price} \n")
                resultText.append("min_price: ${tickerInfo?.data?.min_price} \n")
            }

            override fun onFailure(call: Call<Ticker>, t: Throwable) {
                //오류 시 발생
                call.cancel()
            }
        })
    }
}