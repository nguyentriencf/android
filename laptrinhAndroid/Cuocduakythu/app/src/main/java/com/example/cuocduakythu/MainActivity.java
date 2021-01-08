package com.example.cuocduakythu;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.OnAccountsUpdateListener;
import android.app.UiAutomation;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageButton btnPlay;
    CheckBox cbOne, cbTwo, cbThree;
    SeekBar seekOne, seekTwo, seekthree;
    TextView tvDiem;
    int macdinh = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        Rangbuocseekbar();
        tvDiem.setText(macdinh +"");

        final CountDownTimer countDownTimer = new CountDownTimer(60000,300) {
            @Override
            public void onTick(long millisUntilFinished) {
                Random number = new Random();
                int so= 5;
                int one = number.nextInt(so);
                int two = number.nextInt(so);
                int three = number.nextInt(so);
                if (seekOne.getProgress() >= seekOne.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this, "One Win", Toast.LENGTH_SHORT).show();
                    btnPlay.setVisibility(View.VISIBLE);
                    if (cbOne.isChecked()){
                        macdinh +=10;
                        Toast.makeText(MainActivity.this, "Bạn là người thắng cuôc", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        macdinh -= 5;
                        Toast.makeText(MainActivity.this, "Bạn là đặt cược sai", Toast.LENGTH_SHORT).show();
                    }
                    tvDiem.setText(macdinh +"");
                    resetCheckbox();
                    EnableCheckbox();

                }
                if (seekTwo.getProgress() >= seekTwo.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this, "Two Win", Toast.LENGTH_SHORT).show();
                    btnPlay.setVisibility(View.VISIBLE);
                    if (cbTwo.isChecked()){
                        macdinh += 10;
                        Toast.makeText(MainActivity.this, "Bạn chọn đúng", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        macdinh -=5;
                        Toast.makeText(MainActivity.this, "Bạn chon sai", Toast.LENGTH_SHORT).show();
                    }
                    tvDiem.setText(macdinh +"");
                    resetCheckbox();
                    EnableCheckbox();
                }
                if (seekthree.getProgress() >= seekthree.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this, "Three Win", Toast.LENGTH_SHORT).show();
                    btnPlay.setVisibility(View.VISIBLE);
                    if(cbThree.isChecked()){
                        macdinh +=10;
                        Toast.makeText(MainActivity.this, "bạn chọn đúng", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        macdinh -=5;
                        Toast.makeText(MainActivity.this, "bạn chon sai", Toast.LENGTH_SHORT).show();
                    }
                    tvDiem.setText(macdinh +"");
                    resetCheckbox();
                    EnableCheckbox();
                }
                seekOne.setProgress(seekOne.getProgress() + one);
                seekTwo.setProgress(seekTwo.getProgress() + two);
                seekthree.setProgress(seekthree.getProgress() + three);

            }

            @Override
            public void onFinish() {

            }


        };
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbOne.isChecked() || cbTwo.isChecked() || cbThree.isChecked()) {
                    seekOne.setProgress(0);
                    seekTwo.setProgress(0);
                    seekthree.setProgress(0);
                    btnPlay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                    DisableCheckbox();
                }
                else {
                    Toast.makeText(MainActivity.this, "Mời bạn đặt cược trước khi chơi", Toast.LENGTH_SHORT).show();
                }
            } });
        Rangbuoccheckbox();

    }
    private  void EnableCheckbox(){
        cbOne.setEnabled(true);
        cbTwo.setEnabled(true);
        cbThree.setEnabled(true);
    }
    private  void DisableCheckbox(){
        cbOne.setEnabled(false);
        cbTwo.setEnabled(false);
        cbThree.setEnabled(false);
    }

    private void resetCheckbox(){
        cbOne.setChecked(false);
        cbTwo.setChecked(false);
        cbThree.setChecked(false);
    }
    private void Rangbuocseekbar(){
        seekOne.setEnabled(false);
        seekTwo.setEnabled(false);
        seekthree.setEnabled(false);
    }

    private void Rangbuoccheckbox(){
        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cbTwo.setChecked(false);
                cbThree.setChecked(false);
            }
        });
        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    cbOne.setChecked(false);
                    cbThree.setChecked(false);
            }
        });
        cbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cbOne.setChecked(false);
                cbTwo.setChecked(false);
            }
        });
    }

    private void Anhxa(){
        tvDiem = (TextView) findViewById(R.id.tvdiem);
        cbOne = (CheckBox) findViewById(R.id.cbOne);
        cbTwo = (CheckBox) findViewById(R.id.cbTwo);
        cbThree = (CheckBox) findViewById(R.id.cbThree);
        seekOne = (SeekBar) findViewById(R.id.seekone);
        seekTwo = (SeekBar) findViewById(R.id.seektwo);
        seekthree = (SeekBar) findViewById(R.id.seekthree);
        btnPlay = (ImageButton) findViewById(R.id.btnPlay);
        tvDiem = (TextView) findViewById(R.id.tvdiem);
    }
}