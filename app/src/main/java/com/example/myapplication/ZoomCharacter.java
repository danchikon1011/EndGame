package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ZoomCharacter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom_character);
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
                textinf=getResources().getString(R.string.IvchenkoRus);
                textname=getResources().getString(R.string.IvchenkoNameRus);
                break;
            case "Shablin":
                imageView.setImageResource(R.drawable.char2);
                textinf=getResources().getString(R.string.ShablinRus);
                textname=getResources().getString(R.string.ShablinNameRus);
                break;
            case "Merezkov":
                imageView.setImageResource(R.drawable.char3);
                textinf=getResources().getString(R.string.MerezkovRus);
                textname=getResources().getString(R.string.MerezkovNameRus);
                break;
            case "Shubin":
                imageView.setImageResource(R.drawable.char4);
                textinf=getResources().getString(R.string.ShubinRus);
                textname=getResources().getString(R.string.ShablinNameRus);
                break;
            case "Bredov":
                imageView.setImageResource(R.drawable.char5);
                textinf=getResources().getString(R.string.BredovRus);
                textname=getResources().getString(R.string.BredovNameRus);
                break;
            case "Golovko":
                imageView.setImageResource(R.drawable.char6);
                textinf=getResources().getString(R.string.GolovkoRus);
                textname=getResources().getString(R.string.GolovkoNameRus);
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
