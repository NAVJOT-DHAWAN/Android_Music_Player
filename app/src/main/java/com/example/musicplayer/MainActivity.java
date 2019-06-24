package com.example.musicplayer;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button play;
    private Button pause;
    private Button stop;

    MediaPlayer mediaplayer;
    int pausePosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.playButton);
        pause = findViewById(R.id.pauseButton);
        stop = findViewById(R.id.stopButton);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

       // int id = v.getId();
        switch (v.getId()){

            case R.id.playButton:
                if(mediaplayer == null) {
                    mediaplayer = MediaPlayer.create(getApplicationContext(), R.raw.aashiqui);
                    mediaplayer.start();
                }

                else if(!mediaplayer.isPlaying()){
                    mediaplayer.seekTo(pausePosition);
                    mediaplayer.start();
                }
                break;
            case R.id.pauseButton:
                if(mediaplayer != null){
                    mediaplayer.pause();
                    pausePosition = mediaplayer.getCurrentPosition();

                }
                break;
            case R.id.stopButton:
                if(mediaplayer != null) {
                    mediaplayer.stop();
                    mediaplayer = null;
                }
                break;
        }

    }
}
