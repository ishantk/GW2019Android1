package com.auribises.gw2019android1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlayMusicActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtSongName;
    Button btnPlay, btnStop;

    String songToPlay;

    MediaPlayer mediaPlayer;

    String path;
    String url;


    void initViews(){

        txtSongName = findViewById(R.id.textViewSongName);
        btnPlay = findViewById(R.id.buttonPlay);
        btnStop = findViewById(R.id.buttonStop);

        btnPlay.setOnClickListener(this);
        btnStop.setOnClickListener(this);

        Intent rcv = getIntent();
        songToPlay = rcv.getStringExtra("keySong");

        txtSongName.setText(songToPlay);

        mediaPlayer = new MediaPlayer();

        path = "/storage";
        //path = Environment.getExternalStorageDirectory().getPath();

        //url = "https://firebasestorage.googleapis.com/v0/b/nimble-perigee-501.appspot.com/o/Nights.mp3?alt=media&token=2f6ca99d-f9ea-4389-9a56-056c2f92195c";
        url = "https://firebasestorage.googleapis.com/v0/b/nimble-perigee-501.appspot.com/o/Jugni.mp3?alt=media&token=6d08bf51-a745-45c3-a2dc-9f43bec344d7";

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        initViews();
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.buttonPlay){
            try{
                //mediaPlayer.setDataSource(path+"/"+songToPlay); // Path of the Song to play

                mediaPlayer.setDataSource(this, Uri.parse(url));

                mediaPlayer.prepare();
                mediaPlayer.start();

                //mediaPlayer.seekTo();
                //mediaPlayer.pause();

            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            mediaPlayer.stop();
            mediaPlayer.release();
            finish();
        }
    }
}


//PS : Explore VideoView in Android *