package com.example.aswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Switch swWifi ;
    CheckBox cbAnhVan, cbToan, cbLy;
    Button btnDangki;
    ProgressBar pbLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        swWifi = (Switch) findViewById(R.id.swWifi);
        swWifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "Bạn đã Bật wifi", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Bạn đã tăt wifi", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cbAnhVan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Toast.makeText(MainActivity.this,"Bạn đã chọn môn anh",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Bạn đã bỏ chon môn anh", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cbToan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this,"Bạn đã chọn môn toán", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Bạn đã bỏ chọn môn Toán", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cbLy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "Bạn đã bỏ chon môn lý", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Bạn đã bỏ chọn môn lý", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnDangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s= "Bạn đã đăng kí:" + "\n";
                if(cbAnhVan.isChecked()){
                    s+=cbAnhVan.getText()+"\n";
                }
                if(cbToan.isChecked()){
                    s+=cbToan.getText()+"\n";
                }
                if(cbLy.isChecked()){
                    s+= cbLy.getText()+"\n";
                }


                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
                final CountDownTimer coundowntimer = new CountDownTimer(10000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int current = pbLoad.getProgress();
                        if(current >= pbLoad.getMax()) {
                            current = 0;
                        }
                        pbLoad.setProgress(current +10);
                    }

                    @Override
                    public void onFinish() {
                        this.start();

                    }
                };coundowntimer.start();
            }
        });

    }
    private void AnhXa(){
        cbAnhVan = (CheckBox) findViewById(R.id.cbanhvan);
        cbToan = (CheckBox) findViewById(R.id.cbtoan);
        cbLy = (CheckBox) findViewById(R.id.cbly);
        btnDangki = (Button) findViewById(R.id.skSound);
        pbLoad = (ProgressBar) findViewById(R.id.pbLoad);
    }
}