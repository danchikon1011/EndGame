package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ResultsQuiz extends AppCompatActivity {

    String lang;
    SharedPreferences mSettings;
    public static final String APP_PREFERENCES = "Leng";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String textotnosh;
        String textmark;
        String textright;
        String textwrong;
        setContentView(R.layout.activity_results_quiz);
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        String lang=mSettings.getString("language","");
        int right=getIntent().getIntExtra("rightanswer",0);
        int wrong=getIntent().getIntExtra("wronganswer",0);
        Log.d("TAG", "onCreate:прав и неправ "+right+wrong);
        TextView ViewRight=findViewById(R.id.textView7);
        TextView ViewWrong=findViewById(R.id.textView8);
        TextView ViewOtnosh=findViewById(R.id.textView9);
        TextView ViewMark=findViewById(R.id.textView6);
        int Otnosh=Integer.valueOf(right*100/11);
        Log.d("TAG", "onCreate: отношение"+Otnosh);
        int mark;
        if(Otnosh<35){mark=2;}
        else if(Otnosh<50){mark=3;}
        else if(Otnosh<75){mark=4;}
        else {mark=5;}
        if(lang.equals("Rus")){
            textotnosh="Вы решили";
            textmark="Ваша оценка";
            textright="Правильных ответов";
            textwrong="Неправильных ответов";
        }
        else{
            textotnosh="You got";
            textmark="Your mark";
            textright="Right answers";
            textwrong="Wrong answers";

        }
        ViewMark.setText(textmark+" "+mark);
        ViewRight.setText(textright+" "+right);
        ViewWrong.setText(textwrong+" "+wrong);
        ViewOtnosh.setText(textotnosh+" "+Otnosh);





    }

    public void GoNext(View view) {

        Intent main=new Intent(this,MainActivity.class);
        //передать в майнактивити
        main.putExtra("fragment", "");
        startActivity(main);
    }
}
