package com.example.multimedia.menu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.multimedia.R;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_streaming);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.progress_bar_stream, R.id.btn_play_streaming, R.id.btn_stop_streaming})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.progress_bar_stream:
                break;
            case R.id.btn_play_streaming:
                break;
            case R.id.btn_stop_streaming:
                break;
        }
    }
}
