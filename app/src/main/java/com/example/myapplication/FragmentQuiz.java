package com.example.myapplication;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ResourceBundle;

public class FragmentQuiz extends Fragment {
ConstraintLayout bg;
    public static FragmentQuiz newInstance() {
        return new FragmentQuiz();
    }
    int count=1;
    TextView question;
    EditText answer;
    Resources rs;
    String[]ListAnswers;
    String[]ListQuestions;
    SharedPreferences mSettings;
    SharedPreferences.Editor editor;
    public static final String APP_PREFERENCES = "Leng";
    String language;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_quiz_fragment, container, false);
        bg=view.findViewById(R.id.quiz_bg);
        answer=view.findViewById(R.id.editText);
        question=view.findViewById(R.id.textView);
        rs=view.getResources();
        mSettings = getActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        language= mSettings.getString("language","");
        if(language=="Rus") {
           ListAnswers = new String[]{rs.getString(R.string.Answer1), rs.getString(R.string.Answer2), rs.getString(R.string.Answer3), rs.getString(R.string.Answer4), rs.getString(R.string.Answer5), rs.getString(R.string.Answer6), rs.getString(R.string.Answer7), rs.getString(R.string.Answer8),
            rs.getString(R.string.Answer9), rs.getString(R.string.Answer10), rs.getString(R.string.Answer11)};
           ListQuestions = new String[]{rs.getString(R.string.Question1), rs.getString(R.string.Question2), rs.getString(R.string.Question3), rs.getString(R.string.Question4), rs.getString(R.string.Question5), rs.getString(R.string.Question6), rs.getString(R.string.Question7), rs.getString(R.string.Question8),
            rs.getString(R.string.Question9), rs.getString(R.string.Question10), rs.getString(R.string.Question11)};
        }
        else{
            ListAnswers=new String[]{rs.getString(R.string.Answer10)};
        }
        Button btn=view.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if(answer.getText().toString().toLowerCase().equals(ListAnswers[count-1].toLowerCase())) {
                    v.setBackgroundColor(Color.parseColor("#008000"));//green
                    /*Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                        }
                    }, 10000);*/
                    SystemClock.sleep(2000);
                        count++;
                   // v.setBackgroundResource(android.R.drawable.btn_default);
                        question.setText(ListQuestions[count]);
                        answer.setText(null);

                    }
                }

        });
        return view;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


}
