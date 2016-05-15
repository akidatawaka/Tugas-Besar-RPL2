package com.rpl.tugas.tugas_rpl2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Animation animScale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);


        final ImageButton btnZoom = (ImageButton) findViewById(R.id.button_main);
        ImageButton btnZoom2 = (ImageButton) findViewById(R.id.button_pengaturan);


        btnZoom.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                Intent intent = new Intent(MainActivity.this,PermainanActivity.class);
                startActivity(intent);
            }});

        btnZoom2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale);
                Intent intent = new Intent(MainActivity.this,PengaturanActivity.class);
                startActivity(intent);
            }});
    }





}
