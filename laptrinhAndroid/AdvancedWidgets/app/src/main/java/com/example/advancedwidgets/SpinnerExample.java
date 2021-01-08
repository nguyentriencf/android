package com.example.advancedwidgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerExample extends AppCompatActivity {
    String[] country = { "India", "USA", "China", "Japan", "Other"};
    Spinner mySpinner;
    Integer[] imgs = {R.drawable.android_logo,R.drawable.ios_logo,R.drawable.blackberry_logo,
            R.drawable.phone_logo,R.drawable.symbian_logo};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_example);
        mySpinner = findViewById(R.id.spnMain);
       // final ArrayAdapter adapter = new ArrayAdapter(this,
         //       android.R.layout.simple_spinner_item,country);

        final MyListAdapter adapter = new MyListAdapter(this,country,country,imgs);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(adapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),country[i],Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}