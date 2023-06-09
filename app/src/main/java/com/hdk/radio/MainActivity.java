package com.hdk.radio;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String streamUrl = "http://radio.linnrecords.com:8000/stream"; // 라디오 API를 통해 얻은 스트림 URL
                MediaPlayer mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource(streamUrl);
                    mediaPlayer.prepareAsync();
                    mediaPlayer.start(); // 재생 시작
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }
}