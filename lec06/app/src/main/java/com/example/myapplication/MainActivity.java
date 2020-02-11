package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> songNameList = new ArrayList<>();
    List<Integer> songPicList = new ArrayList<>();
    List<Integer> songList = new ArrayList<>();
    MediaPlayer currentSong = new MediaPlayer();

    private void addItems(){
        songNameList = Arrays.asList("Drums", "Ukulele","Bag Pipes");
        songPicList = Arrays.asList(R.drawable.drums,R.drawable.ukulele,R.drawable.bagpipes);
        songList = Arrays.asList(R.raw.drums,R.raw.ukulele,R.raw.bagpipes);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addItems();

        final myCustomAdapter myAdapter = new myCustomAdapter(songNameList,songPicList);
        ListView listViewItems = findViewById(R.id.listViewSong);
        listViewItems.setAdapter(myAdapter);
        //On click change.
        listViewItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(myAdapter.getCurrentPlayIndex() == position){
                    if(currentSong != null && currentSong.isPlaying()){
                        currentSong.pause();
                        myAdapter.setPlayStatus(false);
                    } else if(currentSong!=null && !currentSong.isPlaying()){
                        currentSong.start();//resume play.
                        myAdapter.setPlayStatus(true);
                        if(!currentSong.isPlaying()){
                            myAdapter.setPlayStatus(false);
                        }
                    }
                } else {
                    //first stop current song if playing.
                    if(currentSong != null && currentSong.isPlaying()){
                        currentSong.stop();
                        //need to prepare if restarting the same media player objedct;
                    }
                    //already prepared
                    currentSong = MediaPlayer.create(MainActivity.this, songList.get(position));
                    currentSong.start();
                    if(!currentSong.isPlaying()){
                        myAdapter.setPlayStatus(false);
                    }

                    myAdapter.setCurrentPlayIndex(position);
                    myAdapter.setPlayStatus(true);
                }
            }
        });
    }
}
