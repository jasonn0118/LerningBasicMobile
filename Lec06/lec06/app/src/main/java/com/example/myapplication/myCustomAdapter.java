package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
        currentPlayIndex = -1;
        playStatus = false;
    }

    public int getCurrentPlayIndex() {
        return currentPlayIndex;
    }

    public void setCurrentPlayIndex(int currentPlayIndex) {
        this.currentPlayIndex = currentPlayIndex;
        notifyDataSetChanged();//This is absolutely required
    }

    public boolean isPlayStatus() {
        return playStatus;
    }

    public void setPlayStatus(boolean playStatus) {
        this.playStatus = playStatus;
        notifyDataSetChanged();//This is absolutely required
    }

    @Override
    public int getCount() {
        return adapterSongNameList.size();
    }

    @Override
    public Object getItem(int position) {
        return adapterSongNameList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) {
            LayoutInflater myLayoutFlater = LayoutInflater.from(parent.getContext());
            convertView = myLayoutFlater.inflate(R.layout.layout_myinstruments, parent,false);
        }
        ImageView imgViewItem = convertView.findViewById(R.id.imageViewItem);
        TextView textViewItem = convertView.findViewById(R.id.textViewItem);
        ImageView imgViewPlay = convertView.findViewById(R.id.imageViewPlay);
        textViewItem.setText(adapterSongNameList.get(position));
        imgViewItem.setImageResource(adapterSongPicList.get(position));//Caution.

        if(playStatus && position==currentPlayIndex){
            imgViewPlay.setImageResource(R.drawable.pause);
        } else{
            imgViewPlay.setImageResource(R.drawable.play);
        }
        return convertView;
    }
}
