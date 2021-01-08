package com.example.lab3_bai3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int ProcRed, ProcGreen, ProcBlue;
    SeekBar  SeekbarRed, SeekberGreen, SeekbarBlue;
    RelativeLayout ViewRGB, ViewCMW;
    TextView textViewRed, textView2, textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
        SeekbarRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ProcRed = progress;

                ViewRGB();
                ViewCMW();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        SeekberGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    ProcGreen = progress;
                ViewRGB();
                ViewCMW();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        SeekbarBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    ProcBlue = progress;
                ViewRGB();
                ViewCMW();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    public  void ViewRGB(){
//        Color mColor = new Color();
//        mColor.red(ProcRed);
//        mColor.green(ProcGreen);
//        mColor.blue(ProcBlue);

        ViewRGB.setBackgroundColor(Color.rgb(ProcRed, ProcGreen, ProcBlue));
    }
    public void ViewCMW(){
        ViewCMW.setBackgroundColor(Color.rgb(255-ProcRed, 255-ProcGreen, 255-ProcBlue));
    }



    public void Init() {
        SeekbarRed = findViewById(R.id.sbRed);
        SeekberGreen = findViewById(R.id.sbG);
        SeekbarBlue = findViewById(R.id.sbB);
        ViewRGB = findViewById(R.id.viewRGB);
        ViewCMW = findViewById(R.id.viewCMY);
    }

}