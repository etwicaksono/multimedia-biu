package com.example.multimedia;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VideoSederhanaActivity extends AppCompatActivity {

    @BindView(R.id.v_video)
    VideoView vVideo;
    @BindView(R.id.btn_playvideo)
    Button btnPlayvideo;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_video_sederhana );
        ButterKnife.bind( this );
        mediaController = new MediaController( this );
    }

    @OnClick({R.id.v_video, R.id.btn_playvideo})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.v_video:
                break;
            case R.id.btn_playvideo:
                Uri uri = Uri.parse( "android.resource://"
                        + getPackageName() + "/" + R.raw.video );
                vVideo.setVideoURI( uri );
                vVideo.setMediaController( mediaController );
                mediaController.setAnchorView( view );
                vVideo.start();
                break;
            case R.id.bottom_navigation:
                break;
        }
    }

}