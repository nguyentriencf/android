package com.example.camerademo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    int REQUEST__CODE_CAMERA = 100;
    Button btnaTake;
    ImageView imgDemo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnaTake = (Button) findViewById(R.id.btnTakeCamera);
        imgDemo= (ImageView) findViewById(R.id.imgMain);

        btnaTake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,REQUEST__CODE_CAMERA);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
     if(requestCode==REQUEST__CODE_CAMERA&&requestCode==RESULT_OK&&data!=null)
        super.onActivityResult(requestCode, resultCode, data);
    }
}