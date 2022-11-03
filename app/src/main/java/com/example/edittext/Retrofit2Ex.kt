package com.example.edittext

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.edittext.databinding.ActivityPicViewBinding
import com.example.edittext.databinding.ActivityRetrofit2ExBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit2Ex : AppCompatActivity() {

    private var btn_home: Button? = null
    lateinit var binding: ActivityRetrofit2ExBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetrofit2ExBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btn_home = findViewById(R.id.btn_home)
        btn_home?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@Retrofit2Ex, MainActivity::class.java)
            startActivity(intent) // 액티비티 이동.
        })

        val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).build();
        val service = retrofit.create(RetrofitService::class.java);

        service.getUserPage("1")?.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if(response.isSuccessful){
                    // 정상적으로 통신이 성공된 경우
                    var result: User? = response.body()
                    Log.d("YMC", "onResponse 성공: " + result?.toString());
                }else{
                    // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
                    Log.d("YMC", "onResponse 실패")
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
                Log.d("YMC", "onFailure 에러: " + t.message.toString());
            }
        })
    }
}