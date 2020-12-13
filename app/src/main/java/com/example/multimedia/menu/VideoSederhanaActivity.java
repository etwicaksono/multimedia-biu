package com.example.multimedia.menu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.multimedia.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VideoSederhanaActivity extends AppCompatActivity {
    @BindView(R.id.btnPlay)
    Button btnPlay;
    @BindView(R.id.btnPause)
    Button btnPause;
    @BindView(R.id.btnResume)
    Button btnResume;
    @BindView(R.id.btnStop)
    Button btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_sederhana);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnPlay, R.id.btnPause, R.id.btnResume, R.id.btnStop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnPlay:
                break;
            case R.id.btnPause:
                break;
            case R.id.btnResume:
                break;
            case R.id.btnStop:
                break;
        }
    }
}
