package com.example.multimedia.menu;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.multimedia.R;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
        ButterKnife.bind(this);
        progressBarStream.setVisibility(View.VISIBLE);
        progressBarStream.setIndeterminate(false);
        progressBarStream.setMax(100);
        prepareAudioStream();
        btnPlayStreaming.setEnabled(true);
        btnStopStreaming.setEnabled(false);
    }

    private void prepareAudioStream() {
        String url = "https://202.147.199.99:8000/;";
        mPlayer = new MediaPlayer();
        try{
            mPlayer.setDataSource(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        mPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(MediaPlayer mp, int percent) {
                progressBarStream.setIndeterminate(true);
                progressBarStream.setSecondaryProgress(100);
            }
        });

    }

    @OnClick({R.id.progress_bar_stream, R.id.btn_play_streaming, R.id.btn_stop_streaming})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.progress_bar_stream:
                break;
            case R.id.btn_play_streaming:
                btnPlayStreaming.setEnabled(false);
                btnStopStreaming.setEnabled(true);
                progressBarStream.setVisibility(View.VISIBLE);
                progressBarStream.setIndeterminate(true);
                mPlayer.prepareAsync();
                mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.start();
                        progressBarStream.setIndeterminate(false);
                    }
                });
                break;
            case R.id.btn_stop_streaming:
                if(mPlayer==null)return;
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
