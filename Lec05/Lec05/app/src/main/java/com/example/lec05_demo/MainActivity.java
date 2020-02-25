package com.example.lec05_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> attrList = new ArrayList<>();
    List<Integer> attrPics = new ArrayList<Integer>();

    private void addItems(){
        attrList.add("Magnificent Mile");
        attrList.add("Art Institute of Chicago");
        attrList.add("Navy Pier");
        attrPics.add(R.drawable.magmile);
        attrPics.add(R.drawable.artinst);
        attrPics.add(R.drawable.pier);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listViewItems = findViewById(R.id.listTxtView);
        addItems();//call method.
        listViewItems.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                attrList));
        MyCustomerAdaptor myAdapter = new MyCustomerAdaptor(this, attrList, attrPics);
        listViewItems.setAdapter(myAdapter);
        listViewItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.themagnificentmile.com/")));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, ArtInstActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, NavyPierActivity.class));
                        break;
                }
            }
        });
    }
}
