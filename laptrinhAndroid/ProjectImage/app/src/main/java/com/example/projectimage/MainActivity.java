package com.example.projectimage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    Button btn;
    ArrayList<Integer> arrayList;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        img.setImageResource(R.drawable.instagram);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                random = new Random();
                arrayList = new ArrayList<>();
                arrayList.add(R.drawable.hinh1);
                arrayList.add(R.drawable.fb);
                arrayList.add(R.drawable.hinh2);
                arrayList.add(R.drawable.instagram);
                int vitri= random.nextInt(arrayList.size());
                img.setImageResource(arrayList.get(vitri));
            }
        });
    }
    public void Anhxa(){
        img = (ImageView) findViewById(R.id.img);
        btn = (Button) findViewById(R.id.chuyen);
    }
}