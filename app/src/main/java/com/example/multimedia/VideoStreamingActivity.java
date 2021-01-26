package com.example.multimedia;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoStreamingActivity extends AppCompatActivity {

    @BindView(R.id.nav_video_streaming)
    VideoView videoStreaming;
    ProgressDialog dialog;
    String urlvideo = "https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_video_streaming );
        ButterKnife.bind( this );

        dialog = new ProgressDialog( VideoStreamingActivity.this );
        dialog.setTitle( "Video streaming" );
        dialog.setMessage( "Loading.." );
        dialog.setIndeterminate( false );
        dialog.setCancelable( false );
        dialog.show();

        MediaController mController = new MediaController( VideoStreamingActivity.this );
        mController.setAnchorView( videoStreaming );
        videoStreaming.setMediaController( mController );

        videoStreaming.setVideoURI( Uri.parse( urlvideo ) );
        videoStreaming.requestFocus();

        videoStreaming.setOnPreparedListener( new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                dialog.dismiss();
            }
        } );

    }
}