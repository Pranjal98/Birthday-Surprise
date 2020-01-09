package com.pranjal98.mausam;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.VideoView;

public class PageFive extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 7000;

    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_page_five);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(PageFive.this, PageSix.class);
                PageFive.this.startActivity(mainIntent);
                PageFive.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

        video = findViewById(R.id.videoView);

        video.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video);
        video.start();
        video.setOnCompletionListener ( new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                video.start();
            }
        });
    }
}
