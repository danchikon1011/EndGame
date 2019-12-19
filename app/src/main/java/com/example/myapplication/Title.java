package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class Title extends AppCompatActivity {
    SharedPreferences mSettings;
    SharedPreferences.Editor editor;
    public static final String APP_PREFERENCES = "Leng";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
         Switch change=findViewById(R.id.switch1);
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        if (change != null) {
            change.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        buttonView.setText("Eng");
                        editor = mSettings.edit();
                        editor.putString("language","Eng");
                        editor.apply();
                        //изменить текста в title
                    }
                    else{
                        buttonView.setText("Rus");
                        editor = mSettings.edit();
                        editor.putString("language","Rus");
                        editor.apply();
                        //изменить текста в title
                    }                }
            });

        }
    }



}
