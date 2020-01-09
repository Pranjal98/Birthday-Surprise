package com.pranjal98.mausam;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PageOne extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 23000;

    ImageView m1, m2, m3, m4, m5, m6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_one);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(PageOne.this, PageTwo.class);
                PageOne.this.startActivity(mainIntent);
                PageOne.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

        m1 = findViewById(R.id.first);
        m2 = findViewById(R.id.sec);
        m3 = findViewById(R.id.third);
        m4 = findViewById(R.id.forth);
        m5 = findViewById(R.id.fifth);
        m6 = findViewById(R.id.sixth);

        m1.animate().alpha(1).setDuration(500).setStartDelay(20000);
        m2.animate().alpha(1).setDuration(500).setStartDelay(20500);
        m3.animate().alpha(1).setDuration(500).setStartDelay(21000);
        m4.animate().alpha(1).setDuration(500).setStartDelay(21500);
        m5.animate().alpha(1).setDuration(500).setStartDelay(22000);
        m6.animate().alpha(1).setDuration(500).setStartDelay(22500);
    }
}
