package com.example.edittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.edittext.databinding.ActivityFirebaseCrudBinding

class FirebaseCrud : AppCompatActivity() {

    private lateinit var binding: ActivityFirebaseCrudBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_crud)

        //데이터베이스 클래스 객체 생성
        val dao = UserDao()

        binding.addBtn.setOnClickListener {

            val name = binding.nameEdit.text.toString() //이름
            val age = binding.ageEdit.text.toString() //나이

            //데이터 셋팅
            val user = User("", name, age)

            dao.add(user)?.addOnSuccessListener {
                Toast.makeText(this, "등록 성공", Toast.LENGTH_SHORT).show()

            }?.addOnFailureListener {
                Toast.makeText(this, "등록 실패: ${it.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}