package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ZoomCharacter extends AppCompatActivity {
String language;
SharedPreferences mSettings;
    public static final String APP_PREFERENCES = "Leng";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom_character);
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        language= mSettings.getString("language","");
        Log.d("TAG", "onCreate: "+language);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        String character=getIntent().getStringExtra("character");
        ImageView imageView=findViewById(R.id.imageView5);
        TextView textViewname=findViewById(R.id.textView3);
        TextView textViewinf=findViewById(R.id.textView2);
        String textinf=null;
        String textname=null;
        switch (character){
            case "Ivchenko":
                imageView.setImageResource(R.drawable.char1);
                if(language.equals("Rus")){
                textinf=getResources().getString(R.string.IvchenkoRus);
                textname=getResources().getString(R.string.IvchenkoNameRus);}
                else{
                    textname=getResources().getString(R.string.IvchenkoNameEng);
                    textinf=getResources().getString(R.string.IvchenkoEng);
                }
                break;
            case "Shablin":
                imageView.setImageResource(R.drawable.char2);
                if(language.equals("Rus")){
                    textinf=getResources().getString(R.string.ShablinRus);
                textname=getResources().getString(R.string.ShablinNameRus);}
                else{
                textname=getResources().getString(R.string.IvchenkoNameEng);
                textinf=getResources().getString(R.string.IvchenkoEng);
            }
                break;
            case "Merezkov":
                imageView.setImageResource(R.drawable.char3);
                if(language.equals("Rus")){
                textinf=getResources().getString(R.string.MerezkovRus);
                textname=getResources().getString(R.string.MerezkovNameRus);}
                else{
                textname=getResources().getString(R.string.MerezkovNameEng);
                textinf=getResources().getString(R.string.MerezkovEng);
            }
                break;
            case "Shubin":
                imageView.setImageResource(R.drawable.char4);
                if(language.equals("Rus")){
                textinf=getResources().getString(R.string.ShubinRus);
                textname=getResources().getString(R.string.ShablinNameRus);}
                else{
                textname=getResources().getString(R.string.ShubinNameEng);
                textinf=getResources().getString(R.string.ShubinEng);
            }
                break;
            case "Bredov":
                imageView.setImageResource(R.drawable.char5);
                if(language.equals("Rus")){
                textinf=getResources().getString(R.string.BredovRus);
                textname=getResources().getString(R.string.BredovNameRus);}
                else{
                    textname=getResources().getString(R.string.BredovNameEng);
                    textinf=getResources().getString(R.string.BredovEng);
                }
                break;
            case "Golovko":
                imageView.setImageResource(R.drawable.char6);
                if(language.equals("Rus")){
                textinf=getResources().getString(R.string.GolovkoRus);
                textname=getResources().getString(R.string.GolovkoNameRus);}
                else{
                    textname=getResources().getString(R.string.GolovkoNameEng);
                    textinf=getResources().getString(R.string.GolovkoEng);
                }
                break;
        }
        textViewinf.setText(textinf);
        textViewname.setText(textname);
    }

    public void back(View view) {
        Intent main=new Intent(this,MainActivity.class);
        main.putExtra("fragment","char");
        startActivity(main);
    }
}
