package com.pranjal98.mausam;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PageSix extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 30000;

    Button call, sms, whats, email;

    Intent calling;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    if (ContextCompat.checkSelfPermission(PageSix.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {

                        calling = new Intent(Intent.ACTION_CALL);
                        calling.setData(Uri.parse("tel:"+ "7002501320"));
                        startActivity(calling);
                    }
                }
                else
                {

                }
                return;
            }

            case 2: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    if (ContextCompat.checkSelfPermission(PageSix.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {

                        SmsManager sms = SmsManager.getDefault();           //sms without intent
                        sms.sendTextMessage("7002501320", null, "THANKS PRANJAL! love you", null, null);

                        Toast.makeText(this, "Message Sent!", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {

                }
                return;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_six);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(PageSix.this, MainActivity.class);
                PageSix.this.startActivity(mainIntent);
                PageSix.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

        MediaPlayer mp = MediaPlayer.create(this, R.raw.callertune);
//        mp.start();

        call = findViewById(R.id.call);
        sms = findViewById(R.id.sms);
        whats = findViewById(R.id.whats);
        email = findViewById(R.id.email);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ContextCompat.checkSelfPermission(PageSix.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(PageSix.this, new String[]{Manifest.permission.CALL_PHONE},1);
                }
                else
                {
                    calling = new Intent(Intent.ACTION_CALL);
                    calling.setData(Uri.parse("tel:"+ "7002501320"));
                    startActivity(calling);
                }
            }
        });

        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ContextCompat.checkSelfPermission(PageSix.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(PageSix.this, new String[]{Manifest.permission.SEND_SMS},2);
                }
                else
                {

                    SmsManager sms = SmsManager.getDefault();           //sms without intent
                    sms.sendTextMessage("7002501320", null, "THANKS PRANJAL! love you", null, null);

                    Toast.makeText(PageSix.this, "Message Sent!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        whats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String m = "";

                for (int i= 0; i< 100; i++){

                    m = m + "THANKS PRANJAL! love you" + "\n";
                }

                for (int i= 0; i< 50; i++){

                    m = m + "THANKS PRANJAL!" + "\n";
                }

                String toNumber = "8011696701"; // contains spaces.
//                    toNumber = toNumber.replace("+", "").replace(" ", "");
                toNumber = "91"+toNumber ;
                Intent sendIntent = new Intent("android.intent.action.MAIN");
                sendIntent.putExtra("jid", toNumber + "@s.whatsapp.net");
                sendIntent.putExtra(Intent.EXTRA_TEXT, m);
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setPackage("com.whatsapp");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String m = "";

                for (int i= 0; i< 50; i++){

                    m = m + "THANKS PRANJAL!" + "\n";
                }

                for (int i= 0; i< 100; i++){

                    m = m + "love you !" + "\n";
                }

                Intent eml = new Intent(Intent.ACTION_SEND);
                eml.setData(Uri.parse("email"));
                eml.putExtra(Intent.EXTRA_SUBJECT, "just wanna say you thanks..");      //have add text view later..
                eml.putExtra(Intent.EXTRA_EMAIL, new String[] {"daspranjal830@gmail.com"});     // email //whatsapp
                eml.putExtra(Intent.EXTRA_TEXT, m);

                eml.setType("message/rfc822");
                startActivity(eml);
            }
        });
    }
}
