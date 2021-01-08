package com.example.ralativelayouttext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText edtMin, edtMax;
    TextView txtNumber;
    Button btnRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                String chuoimin = edtMin.getText().toString().trim();
                String chuoimax = edtMax.getText().toString().trim();

                if (chuoimin.isEmpty()  || chuoimax.length() == 0) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập số", Toast.LENGTH_LONG).show();
                }
                else {
                    //ép kiểu dữ chuỗi => số
                    int min = Integer.parseInt(chuoimin);
                    int max = Integer.parseInt(chuoimax);
                    int result = random.nextInt(max - min + 1) + min;


                        Toast.makeText(MainActivity.this, "Vui Lòng Kiểm tra lại kết quả", Toast.LENGTH_SHORT).show();

                        txtNumber.setText(String.valueOf(result)); // number +""
                    
                }

            }
        });

    }
    public void AnhXa(){
        edtMin = (EditText) findViewById(R.id.edittextMin);
        edtMax = (EditText) findViewById(R.id.edittextMax);
        txtNumber = (TextView) findViewById(R.id.textviewNumber);
        btnRandom = (Button) findViewById(R.id.buttonRandom);

    }
}

