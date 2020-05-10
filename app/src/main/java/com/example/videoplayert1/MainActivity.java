package com.example.videoplayert1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TabHost;
import android.widget.VideoView;


//DEVELOPER BRANCH STARTED

public class MainActivity extends AppCompatActivity {

    TabHost th;
    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        video = (VideoView)findViewById(R.id.videoView);

        String path1 = "android.resource://" + getPackageName() + "/"+R.raw.flower
                ;
        MediaController mc = new MediaController(this);
        mc.setAnchorView(video);
        mc.setMediaPlayer(video);
        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        Uri uri = Uri.parse(path1);
        video.setMediaController(mc);
        video.setVideoURI(uri);

        ImageButton startVideo = (ImageButton) findViewById(R.id.startImage);
        startVideo.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                video.start();
            }

        });

        ImageButton stopVideo = (ImageButton) findViewById(R.id.stopImage);
        stopVideo.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                video.pause();
            }

        });


    }


}
