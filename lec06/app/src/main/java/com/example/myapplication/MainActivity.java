package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> songNameList = new ArrayList<>();
    List<Integer> songPicList = new ArrayList<>();

    private void addItems(){
        songNameList = Arrays.asList("Drums", "Ukulele","Bag Pipes");
        songPicList = Arrays.asList(R.drawable.drums,R.drawable.ukulele,R.drawable.bagpipes);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addItems();
    }
}
