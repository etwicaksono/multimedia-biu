package com.example.multimedia;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AudioStreamingActivity extends AppCompatActivity {

    @BindView(R.id.progress_bar_stream)
    ProgressBar progressBarStream;
    @BindView(R.id.btn_play_streaming)
    Button btnPlayStreaming;
    @BindView(R.id.btn_stop_streaming)
    Button btnStopStreaming;
    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_streaming);
        // TODO 1
        ButterKnife.bind(this);

        // TODO 2
        progressBarStream.setVisibility(View.VISIBLE);
        progressBarStream.setIndeterminate(false);
        progressBarStream.setMax(100);

        //TODO 3 membuat methode audio
        prepareAudioStream();
        btnPlayStreaming.setEnabled(true);
        btnStopStreaming.setEnabled(false);

        //inisialisasi variabel
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //setting home terseleksi
        bottomNavigationView.setSelectedItemId(R.id.nav_audio_streaming);

        //perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_audio_streaming:
                        return true;
                    case R.id.nav_audio_sederhana:
                        startActivity(new Intent(getApplicationContext()
                                ,MainActivity.class));
                        overridePendingTransition(0,0);
                       return true;
                    case R.id.nav_video_sederhana:
                        startActivity(new Intent(getApplicationContext()
                                ,VideoSederhanaActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_video_streaming:
                        startActivity(new Intent(getApplicationContext()
                                ,VideoStreamingActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    private void prepareAudioStream() {
         String url=  "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3";
        mPlayer = new MediaPlayer();
        // TODO 4 menampilkan error tanpa crash dengan try
        try{
            mPlayer.setDataSource(url);
        }catch (IOException e) {
            e.printStackTrace();
        }
        //TODO 5 membuat bufferreading
        mPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(MediaPlayer mp, int percent) {
                progressBarStream.setIndeterminate(true);
                progressBarStream.setSecondaryProgress(100);
            }
        });
    }

    @OnClick({R.id.btn_play_streaming, R.id.btn_stop_streaming})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_play_streaming:
                // TODO 6 memfungsikan button play
                btnPlayStreaming.setEnabled(false);
                btnStopStreaming.setEnabled(true);
                progressBarStream.setVisibility(View.VISIBLE);
                progressBarStream.setIndeterminate(true);
                mPlayer.prepareAsync();
                mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.start();
                        progressBarStream.setIndeterminate(false);
                    }
                });
                break;
            case R.id.btn_stop_streaming:
                // TODO 7 memfungsikan button stop
                if(mPlayer == null) return;
                if(mPlayer.isPlaying()){
                    btnPlayStreaming.setEnabled(true);
                    btnStopStreaming.setEnabled(false);
                    mPlayer.stop();
                    mPlayer.release();
                    prepareAudioStream();
                }
                break;
        }
    }

}