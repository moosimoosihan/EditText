package com.example.edittext

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.edittext.databinding.ActivityPicView2Binding

class PicView2 : AppCompatActivity() {

    lateinit var binding: ActivityPicView2Binding
    private var btn_home: Button? = null

    var imageList: ArrayList<Uri> = ArrayList()

    var position = 0 //이미지 현재 위치

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPicView2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        btn_home = findViewById(R.id.btn_home)
        btn_home?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@PicView2, MainActivity::class.java)
            startActivity(intent) // 액티비티 이동.
        })

        //사진첩 호출 버튼 이벤트
        binding.galleryBtn.setOnClickListener {

            //갤러리 호출
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            //멀티 선택 기능
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            activityResult.launch(intent)
        }
        //이전 버튼 이벤트
        binding.backBtn.setOnClickListener {

            if(position > 0){
                position--
                //이미지 보여주기
                binding.imageView.setImageURI(imageList[position])
                // 현재 위치 보여주기
                showPosition(position.toString())
            }else{
                Toast.makeText(this, "첫 이미지 입니다.", Toast.LENGTH_SHORT).show()
            }
        }

        //다음 버튼 이벤트
        binding.nextBtn.setOnClickListener {
            if(position < imageList.size-1){
                position++
                //이미지 보여주기
                binding.imageView.setImageURI(imageList[position])
                // 현재 위치 보여주기
                showPosition(position.toString())
            }else{
                Toast.makeText(this, "마지막 이미지 입니다.", Toast.LENGTH_SHORT).show()
            }
        }

    }//onCreate

    //결과 가져오기
    private val activityResult: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){

        //결과 코드 OK , 결가값 null 아니면
        if(it.resultCode == RESULT_OK){

            //멀티 선택은 clipData
            if(it.data!!.clipData != null){ //멀티 이미지

                //선택한 이미지 갯수
                val count = it.data!!.clipData!!.itemCount

                for(index in 0 until count){
                    //이미지 담기
                    val imageUri = it.data!!.clipData!!.getItemAt(index).uri
                    //이미지 추가
                    imageList.add(imageUri)

                    //첫 번째 이미지로 보여준다.
                    binding.imageView.setImageURI(imageList[0])
                    position = 0
                    showPosition(position.toString())
                }
            }else{ //싱글 이미지
                val imageUri = it.data!!.data
                binding.imageView.setImageURI(imageUri)
                position = 0
                showPosition(position.toString())
            }
        }
    }

    /**
     * 현재 위치 보여주는 함수
     */
    private fun showPosition(position: String){
        binding.positionText.text = position
    }
}