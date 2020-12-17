package com.example.multimedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.multimedia.menu.AudioSederhanaActivity;
import com.example.multimedia.menu.AudioStreamingActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.menu)
    BottomNavigationView menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        menu.setOnNavigationItemSelectedListener(listener);
    }

/*ini adalah versi awal dari deklarasi variabel listener*/
//    private BottomNavigationView.OnNavigationItemSelectedListener listener = new BottomNavigationView.OnNavigationItemSelectedListener() {
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.nav_audio_sederhana:
//                    startActivity(new Intent(MainActivity.this, AudioSederhanaActivity.class));
//                    break;
//                case R.id.nav_audio_streaming:
//                    break;
//                case R.id.nav_video_sederhana:
//                    break;
//                case R.id.nav_video_streaming:
//                    break;
//            }
//            return false;
//        }
//    };

     private BottomNavigationView.OnNavigationItemSelectedListener listener = item -> {
        switch (item.getItemId()) {
            case R.id.nav_audio_sederhana:
                startActivity(new Intent(MainActivity.this, AudioSederhanaActivity.class));
                break;
            case R.id.nav_audio_streaming:
                startActivity(new Intent(MainActivity.this, AudioStreamingActivity.class));
                break;
            case R.id.nav_video_sederhana:
                break;
            case R.id.nav_video_streaming:
                break;
        }
        return false;
    };


}
