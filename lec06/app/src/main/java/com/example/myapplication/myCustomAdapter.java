package com.example.myapplication;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

//Super Class.
public class myCustomAdapter extends BaseAdapter {

    List<String> adapterSongNameList = new ArrayList<>();
    List<Integer> adapterSongPicList = new ArrayList<>();
    int currentPlayIndex; // Keeps track of index of current song.
    boolean playStatus; // It is playing now or not.

    public myCustomAdapter(List<String> adapterSongNameList, List<Integer> adapterSongPicList) {
        this.adapterSongNameList = adapterSongNameList;
        this.adapterSongPicList = adapterSongPicList;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
