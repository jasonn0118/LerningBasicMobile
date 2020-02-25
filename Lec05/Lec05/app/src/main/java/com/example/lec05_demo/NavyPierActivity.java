package com.example.lec05_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.util.LinkifyCompat;

import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;

public class NavyPierActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navy_pier);

        TextView txtViewNavyPier = findViewById(R.id.textViewNavyPier);
        txtViewNavyPier.setText("Click below for Navy pier Hours and Admission"+
                "\nhttps://navypier.org/visit/hours-admission/");
        LinkifyCompat.addLinks(txtViewNavyPier, Linkify.WEB_URLS);
    }
}
