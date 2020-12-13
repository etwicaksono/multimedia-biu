package com.example.multimedia.menu;

import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.multimedia.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VideoStreamingActivity extends AppCompatActivity {
    @BindView(R.id.video_view_stream)
    VideoView videoViewStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_streaming);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.video_view_stream)
    public void onViewClicked() {
    }
}
