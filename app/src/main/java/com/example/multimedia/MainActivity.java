package com.example.multimedia;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnPlay)
    Button btnPlay;
    @BindView(R.id.btnPause)
    Button btnPause;
    @BindView(R.id.btnResume)
    Button btnResume;
    @BindView(R.id.btnStop)
    Button btnStop;
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigation;
    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        enable(btnPlay);
        disable(btnStop, btnResume, btnPause);

        //inisialisasi variabel
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //setting home terseleksi
        bottomNavigationView.setSelectedItemId(R.id.nav_audio_sederhana);

        //perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_audio_streaming:
                        startActivity(new Intent(getApplicationContext()
                                , AudioStreamingActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nav_audio_sederhana:
                        return true;
                    case R.id.nav_video_sederhana:

                        return true;
                    case R.id.nav_video_streaming:
                        startActivity(new Intent(MainActivity.this
                                , VideoStreamingActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }

    @OnClick({R.id.btnPlay, R.id.btnPause, R.id.btnResume, R.id.btnStop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnPlay:
                Uri uriMusik = Uri.parse("android.resource://"
                        + getPackageName()+"/"+R.raw.music);
                mPlayer = new MediaPlayer();
                mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mPlayer.setDataSource(MainActivity.this,
                            uriMusik);
                    mPlayer.prepare();

                } catch (IOException e){
                    e.printStackTrace();
                }
                mPlayer.start();
                enable(btnPause, btnStop);
                disable(btnPlay, btnResume);
                break;
            case R.id.btnPause:
                if(mPlayer.isPlaying()){
                    mPlayer.pause();
                    enable(btnResume, btnStop);
                    disable(btnPause, btnPlay);
                }
                break;
            case R.id.btnResume:
                mPlayer.start();
                enable(btnPause, btnStop);
                disable(btnPlay, btnResume);
                break;
            case R.id.btnStop:
                if(mPlayer.isPlaying() && mPlayer != null){
                    mPlayer.stop();
                    enable(btnPlay);
                    disable(btnResume, btnStop, btnPause);
                }
                break;
        }
    }
    //Todo untuk Set Enable
    public void enable(View...views){
        for (View mView: views){
            mView.setEnabled(true);
        }
    }
    //Todo untuk Set Disable
    public void disable(View...views) {
        for (View mView : views) {
            mView.setEnabled(false);
        }
    }

}