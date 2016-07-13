package com.rpl.tugas.tugas_rpl2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.os.AsyncTask;
import android.widget.Toast;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.logging.Handler;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    MediaPlayer mp;
    ImageButton btnZoom;
    TextView pengaturan_musik;

    Intent music;


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //membuat animasi ketika di klik
        final Animation animScale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);

        //deklarasi tombol dan textview
        btnZoom = (ImageButton) findViewById(R.id.button_main);
        pengaturan_musik = (TextView) findViewById(R.id.txt_musik);

        //mengatur font
        String font_utama = "CFJackStory.ttf";
        Typeface typeface = Typeface.createFromAsset(getAssets(), font_utama);

        pengaturan_musik.setTypeface(typeface);



        //ImageButton btnZoom2 = (ImageButton) findViewById(R.id.button_pengaturan);

        music = new Intent(getApplicationContext(), MusicService.class);
        startService(music);






        //((TextView)findViewById(R.id.showOutput)).setText(resp);


        btnZoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                finish();
                Intent intent = new Intent(MainActivity.this, PermainanActivity.class);
                startActivity(intent);

            }
        });

        pengaturan_musik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);

                if (pengaturan_musik.getText().equals("Musik: Hidup")){
                    stopService(music);
                    Log.e(TAG,"++++++Musik Mati++++++");
                    pengaturan_musik.setText("Musik: Mati");
                    //Intent intent = new Intent(MainActivity.this,Sqlitetutorialactivity.class);
                    //startActivity(intent);
                } else if (pengaturan_musik.getText().equals("Musik: Mati")){
                    startService(music);
                    Log.e(TAG,"++++++Musik Hidup++++++");
                    pengaturan_musik.setText("Musik: Hidup");
                    //Intent intent = new Intent(MainActivity.this,Sqlitetutorialactivity.class);
                    //startActivity(intent);
                }


        }
        });



        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

}

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        stopService(music);
        this.finish();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //mp.stop();
    }
}
