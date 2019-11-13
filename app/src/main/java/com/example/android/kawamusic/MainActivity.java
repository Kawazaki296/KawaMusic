package com.example.android.kawamusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Play List");
        final ArrayList<Song> songsList = new ArrayList<Song>();
        songsList.add(new Song("Baby I'm Yours", "Breakbot", R.drawable.im_yours, R.raw.im_yours));
        songsList.add(new Song("Waving Flag", "K'naan", R.drawable.wavin_flag, R.raw.wavin_flag));
        songsList.add(new Song("Good As Hell", "Lizzo", R.drawable.good_hell, R.raw.good_hell));
        songsList.add(new Song("Party Rock Anthem", "LMFAO", R.drawable.lmfao, R.raw.lmfao));
        songsList.add(new Song("Can't Hold Us", "Macklemore", R.drawable.hold_us, R.raw.hold_us));
        songsList.add(new Song("Hey Jude", "The Beatles", R.drawable.jude, R.raw.jude));
        songsList.add(new Song("Joy", "Bastille", R.drawable.joy, R.raw.joy));
        songsList.add(new Song("Clocks", "ColdPlay", R.drawable.clocks, R.raw.clocks));
        songsList.add(new Song("Kifak Enta", "Fairouz", R.drawable.kifak_enta, R.raw.kifak_enta));
        songsList.add(new Song("Got My Mind Set On You", "George Harrison", R.drawable.setonu, R.raw.setonu));
        SongArrayAdapter itemsAdapter = new SongArrayAdapter(this, R.layout.list_item, songsList);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(android.widget.AdapterView<?> parent, View view, int position, long id) {
                Song currentSong = songsList.get(position);
                Intent intent = new Intent(view.getContext(), PlayerActivity.class);
                intent.putExtra("image id", currentSong.getImageId());
                intent.putExtra("song id", currentSong.getSongId());
                intent.putExtra("artist name", currentSong.getArtist_name());
                intent.putExtra("song title", currentSong.getSong_name());
                startActivity(intent);
            }
        });

    }
}
