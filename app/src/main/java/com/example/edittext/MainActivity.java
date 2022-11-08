package com.example.edittext;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btn_move;
    private Button btn_move2;
    private Button btn_move3;
    private Button btn_move4;

    private Button btn_move9;

    private Button btn_move7;
    private Button btn_move5;

    private Button btn_move8;
    private Button btn_move10;
    private Button btn_music;
    private Button btn_picv;
    private Button btn_picv2;
    private Button btn_Retrofit2;
    private Button btn_MakeTextView;
    private Button btn_HTTPGlideImageView;
    private Button btn_Retrofit2Btc;
    private Button btn_Calendar;
    private Button btn_Viberator;
    private Button btn_Ringtone;



    MediaPlayer mediaPlayer;

    private EditText et_test;
    private String str;
    EditText et_id;
    Button btn_test;
    ImageView test;

    //액티비티가 종료될때 이곳을 실행
    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }

    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_id = findViewById(R.id.et_id);
        btn_test = findViewById(R.id.btn_test);

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_id.setText("무시무시한스무디");
            }
        });

        et_test = findViewById(R.id.et_test);


        btn_move = findViewById(R.id.btn_move);
        btn_move.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                str = et_test.getText().toString();
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("str",str);
                startActivity(intent); // 액티비티 이동.
            }
        });
        btn_move2 = findViewById(R.id.btn_move2);
        btn_move2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(MainActivity.this, ListActivity.class);

                startActivity(intent); // 액티비티 이동.
            }
        });


        btn_move3 = findViewById(R.id.btn_move3);
        btn_move3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);

                startActivity(intent); // 액티비티 이동.
            }
        });

        btn_move4 = findViewById(R.id.btn_move4);
        btn_move4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(MainActivity.this, StopWatch.class);

                startActivity(intent); // 액티비티 이동.
            }
        });

        btn_move9 = findViewById(R.id.btn_move9);
        btn_move9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(MainActivity.this, ToDoList.class);

                startActivity(intent); // 액티비티 이동.
            }
        });

        btn_move7 = findViewById(R.id.btn_move7);
        btn_move7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(MainActivity.this, LottoNumber.class);

                startActivity(intent); // 액티비티 이동.
            }
        });


        btn_move8 = findViewById(R.id.btn_move8);
        btn_move8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(MainActivity.this, Recognizerintent.class);

                startActivity(intent); // 액티비티 이동.
            }
        });

        btn_move10 = findViewById(R.id.btn_move10);
        btn_move10.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(MainActivity.this, Vpager2.class);

                startActivity(intent); // 액티비티 이동.
            }
        });

        btn_music = findViewById(R.id.btn_music);
        btn_music.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(MainActivity.this, MusicPlayerExample.class);

                startActivity(intent); // 액티비티 이동.
            }
        });

        btn_picv = findViewById(R.id.btn_picv);
        btn_picv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(MainActivity.this, PicView.class);

                startActivity(intent); // 액티비티 이동.
            }
        });

        btn_picv2 = findViewById(R.id.btn_picv2);
        btn_picv2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(MainActivity.this, PicView2.class);

                startActivity(intent); // 액티비티 이동.
            }
        });

        btn_Retrofit2 = findViewById(R.id.btn_Retrofit2);
        btn_Retrofit2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(MainActivity.this, Retrofit2Ex.class);

                startActivity(intent); // 액티비티 이동.
            }
        });

        btn_MakeTextView = findViewById(R.id.btn_MakeTextView);
        btn_MakeTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(MainActivity.this, MakeTextView.class);

                startActivity(intent); // 액티비티 이동.
            }
        });

        btn_HTTPGlideImageView = findViewById(R.id.btn_HTTPGlideImageView);
        btn_HTTPGlideImageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(MainActivity.this, HTTPGlideImageView.class);

                startActivity(intent); // 액티비티 이동.
            }
        });

        btn_Retrofit2Btc = findViewById(R.id.btn_Retrofit2Btc);
        btn_Retrofit2Btc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(MainActivity.this, Retrofit2Btc.class);

                startActivity(intent); // 액티비티 이동.
            }
        });

        btn_Calendar = findViewById(R.id.btn_Calendar);
        btn_Calendar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(MainActivity.this, Calendar.class);

                startActivity(intent); // 액티비티 이동.
            }
        });

        btn_Viberator = findViewById(R.id.btn_Vibrator);
        btn_Viberator.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(MainActivity.this, Vibrator_Activity.class);

                startActivity(intent); // 액티비티 이동.
            }
        });

        btn_Ringtone = findViewById(R.id.btn_Ringtone);
        btn_Ringtone.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(MainActivity.this, Ringtone.class);

                startActivity(intent); // 액티비티 이동.
            }
        });

        test = (ImageView)findViewById(R.id.test);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "무시무시한스무디",Toast.LENGTH_SHORT).show();
            }
        });




    }
}