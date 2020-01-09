package com.pranjal98.mausam;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class PageThree extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 9000;

    ImageView m1, m2, m3, m4, m5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_three);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(PageThree.this, PageFour.class);
                PageThree.this.startActivity(mainIntent);
                PageThree.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

        m1 = findViewById(R.id.first);
        m2 = findViewById(R.id.forth);
        m3 = findViewById(R.id.sec);
        m4 = findViewById(R.id.fif);
        m5 = findViewById(R.id.third);

        m1.animate().translationYBy(-2800f).setDuration(7000).setStartDelay(500);
        m2.animate().translationYBy(-2800f).setDuration(7000).setStartDelay(500);
        m3.animate().translationYBy(-2800f).setDuration(7000).setStartDelay(500);
        m4.animate().translationYBy(-2800f).setDuration(7000).setStartDelay(500);
        m5.animate().translationYBy(-2800f).setDuration(7000).setStartDelay(500);
    }
}
