package com.example.android_second_practice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    int RequestCode = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn = findViewById(R.id.btn3);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePhoto();
            }
        });
    }

    private void takePhoto(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE);


        startActivityForResult(intent, 100);

    }

    public void openSecondActivity(View v) {

    Intent i = new Intent(this, MainActivity2.class);

    EditText userNameEt = findViewById(R.id.userNameEt);
    String name = userNameEt.getText().toString();


    i.putExtra("name", name);


    startActivityForResult(i, RequestCode);




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (RequestCode == requestCode) {
            if (resultCode == RESULT_OK) {

                String age = data.getStringExtra("age");


                Toast.makeText(this, age, Toast.LENGTH_SHORT).show();


            } else {

                Toast.makeText(this, "No result", Toast.LENGTH_SHORT).show();

            }
        }

        if (requestCode == 100 && resultCode == RESULT_OK) {

            Bitmap image = (Bitmap) data.getExtras().get("data");

            ImageView im = findViewById(R.id.imageView);

            im.setImageBitmap(image);
        }

    }
}