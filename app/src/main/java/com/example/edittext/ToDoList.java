package com.example.edittext;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ToDoList extends AppCompatActivity {

        ArrayList<String> toDoList;
        ArrayAdapter<String> adapter;
        ListView listView;
        EditText editText;
        private Button btn_home;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_to_do_list);


            //초기화
            toDoList = new ArrayList<>();
            adapter = new ArrayAdapter<String>(this, R.layout.list_item, toDoList);
            listView = findViewById(R.id.list_view);
            editText = findViewById(R.id.edit_text);

            //어뎁터 적용
            listView.setAdapter(adapter);

            //할일추가 버튼 이벤트
            Button addBtn = findViewById(R.id.add_btn);
            addBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addItemToList();
                }
            });

            //리스트 아이템 클릭 했을때 이벤트
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    TextView textView = (TextView) view;

                    //취소선 넣기
                    textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }
            });

            btn_home = findViewById(R.id.btn_home);
            btn_home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ToDoList.this, MainActivity.class);
                    startActivity(intent); // 액티비티 이동.
                }
            });
        }//onCreate

        //할일 추가
        public void addItemToList(){

            //아이템 등록
            toDoList.add(editText.getText().toString());

            //적용
            adapter.notifyDataSetChanged();;

            //입력창 초기화
            editText.setText("");
        }
}