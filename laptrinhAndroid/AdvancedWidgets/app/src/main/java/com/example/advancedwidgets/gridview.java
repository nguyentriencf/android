package com.example.advancedwidgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class gridview extends AppCompatActivity {

    GridView gridView;
    static final String[] numbers = new String[] {
            "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",};

    // Custom ListView
    String[] items = {"Android", "iOS", "Blackberry", "Windows Phone", "Symbian"};
    Integer[] imgs = {R.drawable.android_logo,R.drawable.ios_logo,R.drawable.blackberry_logo,
            R.drawable.phone_logo,R.drawable.symbian_logo};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        gridView = findViewById(R.id.grvMain);
        /*final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,numbers);*/
        final MyListAdapter adapter = new MyListAdapter(this,items,items,imgs);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),adapter.getItem(i),Toast.LENGTH_LONG).show();
            }
        });
    }
}