package com.example.advancedwidgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterViewAnimator;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //ListView
    String[] items = {"Android", "iOS", "Blackberry", "Windows Phone", "Symbian"};
    ListView lstMain ;

    //Custom listview
    String[] contents = {"Android", "iOS", "Blackberry", "Windows Phone", "Symbian"};
    Integer[] imgs = {R.drawable.android_logo,R.drawable.ios_logo,R.drawable.blackberry_logo,
                    R.drawable.phone_logo,R.drawable.symbian_logo};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstMain = findViewById(R.id.lstListMain);
        //Simple ListView
        /*final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
          this,
          android.R.layout.simple_list_item_1,
          android.R.id.text1,
          items
        );*/

        // Custom ListView
       final MyListAdapter adapter = new MyListAdapter(this,items,contents,imgs);

        lstMain.setAdapter(adapter);
        lstMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = adapter.getItem(i);
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_LONG).show();
            }
        });
    }
}