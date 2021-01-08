package com.example.advancedwidgets;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

public class MyListAdapter extends ArrayAdapter<String> {
    private Activity context;
    private String[] titles;
    private String[] contents;
    private Integer[] imgs;
    public MyListAdapter(Activity context, String[] titles, String[] contents, Integer[] imgs){
        super(context, R.layout.mylist, titles);
        this.context = context;
        this.titles = titles;
        this.contents = contents;
        this.imgs = imgs;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mylist,null,true);

        ImageView img = rowView.findViewById(R.id.imgIcon);
        TextView title = rowView.findViewById(R.id.txtTitle);
        TextView content = rowView.findViewById(R.id.txtContent);

        img.setImageResource(imgs[position]);
        title.setText(titles[position]);
        content.setText(contents[position]);
        return rowView;
    }
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        return getView(position,convertView,parent);
    }
}
