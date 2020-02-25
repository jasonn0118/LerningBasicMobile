package com.example.lec05_demo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyCustomerAdaptor extends BaseAdapter {

    List<String> adapterList;
    List<Integer> adapterPics;
    Context context;

    public MyCustomerAdaptor(Context context, List<String> myList, List<Integer> myPics) {
        this.context = context;
        adapterList = myList;
        adapterPics = myPics;
    }
    @Override
    public int getCount() {
        //Must reflect size of data.
        return adapterList.size();
    }

    @Override
    public Object getItem(int position) {
        return adapterList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //showing one view.

        //if nothing on the convertView.
        if (convertView==null) {
            LayoutInflater myLayoutInflater = LayoutInflater.from(parent.getContext());
            //existing context coming from parent.
            convertView = myLayoutInflater.inflate(R.layout.layout_item, parent,false);
        }
        //Caution: this is common mistake happend point.
        TextView txtViewItem = convertView.findViewById(R.id.textViewItem);
        txtViewItem.setText(adapterList.get(position));
        Drawable img = parent.getResources().getDrawable(adapterPics.get(position));
        img.setBounds(0,0,80,80);
        txtViewItem.setCompoundDrawables(img, null, null, null);
        txtViewItem.setCompoundDrawablePadding(16);
        return convertView;
    }
}
