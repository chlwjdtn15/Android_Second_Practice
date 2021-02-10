package com.example.android_second_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        Intent intent = getIntent();


        String name = intent.getStringExtra("name");

        TextView tv = findViewById(R.id.nameTv);

        tv.setText("Hi " + name + " , Enter your age");





    }


    public void sendResult(View v) {
        EditText ageEt = findViewById(R.id.ageEt);

        String age = ageEt.getText().toString();



        Intent intent = new Intent();

        if(age.isEmpty()){

                setResult(RESULT_CANCELED, intent );


        }else
        {


            intent.putExtra("age", age);


            setResult(RESULT_OK, intent);


        }


        finish();

    }






}