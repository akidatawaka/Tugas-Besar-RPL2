package com.rpl.tugas.tugas_rpl2;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PermainanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permainan);

        String font_utama = "CFJackStory.ttf";
        Typeface typeface = Typeface.createFromAsset(getAssets(), font_utama);

        TextView kembali = (TextView) findViewById(R.id.btn_kembali);
        kembali.setTypeface(typeface);


        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PermainanActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
