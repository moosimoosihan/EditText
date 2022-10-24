package com.example.edittext;

import android.content.Intent;
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
    private EditText et_test;
    private String str;
    EditText et_id;
    Button btn_test;
    ImageView test;

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

                Intent intent2 = new Intent(MainActivity.this, ListActivity.class);

                startActivity(intent2); // 액티비티 이동.
            }
        });


        btn_move3 = findViewById(R.id.btn_move3);
        btn_move3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent3 = new Intent(MainActivity.this, WebViewActivity.class);

                startActivity(intent3); // 액티비티 이동.
            }
        });

        btn_move4 = findViewById(R.id.btn_move4);
        btn_move4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent4 = new Intent(MainActivity.this, StopWatch.class);

                startActivity(intent4); // 액티비티 이동.
            }
        });

        btn_move9 = findViewById(R.id.btn_move9);
        btn_move9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent9 = new Intent(MainActivity.this, ToDoList.class);

                startActivity(intent9); // 액티비티 이동.
            }
        });

        btn_move7 = findViewById(R.id.btn_move7);
        btn_move7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent7 = new Intent(MainActivity.this, LottoNumber.class);

                startActivity(intent7); // 액티비티 이동.
            }
        });


        btn_move8 = findViewById(R.id.btn_move8);
        btn_move8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent8 = new Intent(MainActivity.this, Recognizerintent.class);

                startActivity(intent8); // 액티비티 이동.
            }
        });

        btn_move10 = findViewById(R.id.btn_move10);
        btn_move10.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent10 = new Intent(MainActivity.this, ViewPager33.class);

                startActivity(intent10); // 액티비티 이동.
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