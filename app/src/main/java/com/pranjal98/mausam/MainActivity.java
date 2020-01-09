package com.pranjal98.mausam;

import android.animation.ValueAnimator;
import android.app.WallpaperManager;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 9000;

    ImageView logo, mausam1, mausam2, mausam3, mausam4, mausam5;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(MainActivity.this, PageOne.class);
                MainActivity.this.startActivity(mainIntent);
                MainActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

        logo = findViewById(R.id.dpMausam);
        mausam1 = findViewById(R.id.m1);
        mausam2 = findViewById(R.id.m2);
        mausam3 = findViewById(R.id.m3);
        mausam4 = findViewById(R.id.m4);
        mausam5 = findViewById(R.id.m5);

        text = findViewById(R.id.mausam);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim);
        logo.startAnimation(animation);

        Animation m1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.m1);
        mausam1.startAnimation(m1);

        Animation m2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.m2);
        mausam2.startAnimation(m2);

        Animation m3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.m3);
        mausam3.startAnimation(m3);

        Animation m4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.m4);
        mausam4.startAnimation(m4);

        Animation m5 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.m5);
        mausam5.startAnimation(m5);

        Animation mausam = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.mausam);
        text.startAnimation(mausam);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.wallpaper);
        WallpaperManager myWallpaperManager
                = WallpaperManager.getInstance(getApplicationContext());
        try {
            myWallpaperManager.setBitmap(bitmap);

        }

        catch (IOException e){

            e.printStackTrace();
        }
    }
}
