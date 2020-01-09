package com.pranjal98.mausam;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class PageTwo extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 23000;

    ImageView background, foreOne, foreTwo, foreThree;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_two);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(PageTwo.this, PageThree.class);
                PageTwo.this.startActivity(mainIntent);
                PageTwo.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

        background = findViewById(R.id.back);
        text = findViewById(R.id.text);
        foreOne = findViewById(R.id.foreOne);
        foreTwo = findViewById(R.id.foreTwo);
        foreThree = findViewById(R.id.foreThree);

        foreOne.setTranslationX(10000f);
        foreTwo.setTranslationX(-10000f);

        background.animate().alpha(0.3f).setDuration(2000).setStartDelay(1000);
        text.animate().alpha(1).setDuration(0).setStartDelay(3000);
        foreOne.animate().translationXBy(-10000f).setDuration(2000).setStartDelay(20000);
        foreTwo.animate().translationXBy(10000f).setDuration(2000).setStartDelay(20000);
        foreThree.animate().alpha(1).setDuration(2000).setStartDelay(21000);
    }
}
