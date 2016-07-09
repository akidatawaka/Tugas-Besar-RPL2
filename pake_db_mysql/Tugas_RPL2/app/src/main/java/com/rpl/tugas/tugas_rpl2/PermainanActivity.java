package com.rpl.tugas.tugas_rpl2;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class PermainanActivity extends AppCompatActivity {
    ArrayList<HashMap<String, String>> ListSoal;
    Integer i = 0;
    String str_soal;
    String str_jawaban;
    String str_petunjuk;
    String str_no;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permainan);

        String font_utama = "CFJackStory.ttf";
        Typeface typeface = Typeface.createFromAsset(getAssets(), font_utama);

        //deklarasi textview
        TextView kembali = (TextView) findViewById(R.id.btn_kembali);
        final TextView soal =  (TextView) findViewById(R.id.txtSoal);

        final TextView no = (TextView) findViewById(R.id.txtnosoal);

        //deklarasi textfield
        final EditText jawaban = (EditText)findViewById(R.id.editText_jawaban);
        final String jawabannya = jawaban.getText().toString();


        //deklarasi button
        final Button btn_jawab = (Button) findViewById(R.id.btn_jawab);
        final Button btn_petunjuk = (Button) findViewById(R.id.btn_petunjuk);



        //mengubah font
        jawaban.setTypeface(typeface);
        kembali.setTypeface(typeface);
        soal.setTypeface(typeface);
        no.setTypeface(typeface);



        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PermainanActivity.this, MainActivity.class);
                startActivity(intent);
            }

        });


        String resp = null;
        ListSoal = new ArrayList<HashMap<String, String>>();

        try {
            resp = new GETAsyncTask().execute().get();
            JSONObject jObj = new JSONObject(resp);
            JSONArray arr = jObj.getJSONArray("data");
            //{"data":[
            // {"no":"1","soal":"Jumlahku selalu bertambah, namun tidak pernah berkurang, Apakah aku ?","jawaban":"umur","petunjuk":"Dirayakan Pada Setiap Tahunnya"},
            // {"no":"2","soal":"Aku selalu jatuh ke tanah, Namun aku tidak pernah naik keatas.","jawaban":"hujan","petunjuk":"berhubungan dengan cuaca"}],"success":"1","message":"Berhasil load data"}
            for (int i = 0; i < arr.length(); i++) {
                JSONObject row = arr.getJSONObject(i);
                HashMap<String, String> dataSoal = new HashMap<String, String>();
                dataSoal.put("no", row.getString("no"));
                dataSoal.put("soal", row.getString("soal"));
                dataSoal.put("jawaban", row.getString("jawaban"));
                dataSoal.put("petunjuk", row.getString("petunjuk"));
                ListSoal.add(dataSoal);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }



            HashMap<String, String> out = new HashMap<>();
            out = ListSoal.get(i);
            str_no = out.get("no");
            str_soal = out.get("soal");
            str_jawaban = out.get("jawaban");
            str_petunjuk = out.get("petunjuk");
           // Toast.makeText(getApplicationContext(), "testing soal : " + str_soal, Toast.LENGTH_SHORT).show();
            Log.e("====== Soal nomor",str_no);
            Log.e("======",str_soal);
            Log.e("======",str_jawaban);
            no.setText("Tebakan ke " + str_no);
            soal.setText(str_soal);

/*
            String str_jawaban = out.get("jawaban");
            Toast.makeText(getApplicationContext(), "testing soal : " + str_jawaban, Toast.LENGTH_SHORT).show();
            jawaban.setText(str_jawaban);  */

        btn_petunjuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Petunjuk : " + str_petunjuk, Toast.LENGTH_LONG).show();
               // Log.e("======",str_petunjuk); //String str_petunjuk = out.get("petunjuk");
            }

        });







        btn_jawab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if ((jawaban.getText().toString().toLowerCase()).equals(str_jawaban)) {
                        new AlertDialog.Builder(PermainanActivity.this)
                                .setTitle("Selamat !")
                                .setMessage("Jawaban Kamu Benar")
                                .setCancelable(false)
                                .setPositiveButton("Sip", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //soal.setText("Alhamdulillah
                                        i++;

                                        //percabanan di soal
                                        if (i.equals(3)){
                                            no.setText("");
                                            btn_jawab.setVisibility(View.GONE);
                                            btn_petunjuk.setVisibility(View.GONE);
                                            jawaban.setVisibility(View.GONE);
                                            soal.setText("Nantikan update soal selanjutnya");

                                        } else {
                                            HashMap<String, String> out1 = new HashMap<>();
                                            out1 = ListSoal.get(i);
                                            str_no = out1.get("no");
                                            str_soal = out1.get("soal");
                                            str_jawaban = out1.get("jawaban");
                                            str_petunjuk = out1.get("petunjuk");
                                            // Toast.makeText(getApplicationContext(), "testing soal : " + str_soal, Toast.LENGTH_SHORT).show();
                                            Log.e("====== Soal nomor", str_no);
                                            Log.e("======", str_soal);
                                            Log.e("======", str_jawaban);
                                            no.setText("Tebakan ke " + str_no);
                                            soal.setText(str_soal);
                                        }
                                    }
                                })
                                .show();

                        //Toast.makeText(getApplicationContext(), "Jawaban Anda Benar", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Jawaban Kamu Masih Salah", Toast.LENGTH_SHORT).show();
                    }

                        jawaban.setText("");
                    // Log.e("======",str_petunjuk); //String str_petunjuk = out.get("petunjuk");
                }

        });



    }


    public class GETAsyncTask extends AsyncTask<String, String, String> {
        HttpURLConnection urlConnection;

        @Override
        protected String doInBackground(String... args) {
            StringBuilder result = new StringBuilder();
            try {
                URL url = new URL("http://akidatawaka.top/coba_cpanel/homeServices.php");
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                urlConnection.disconnect();
            }
            return result.toString();
        }
    }

    private String getQuery(Map<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        //Map <String,String> myMap = new HashMap<String,String>();
        Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> pairs = (Map.Entry<String, String>) iterator.next();
            String key = pairs.getKey();
            String value = pairs.getValue();
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value, "UTF-8"));
        }

        return result.toString();
    }


}

