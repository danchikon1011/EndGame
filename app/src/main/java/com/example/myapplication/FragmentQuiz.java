package com.example.myapplication;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
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
    public static final String APP_PREFERENCES = "Leng";
    String language;
    int rightanswer=0;
    int wronganswer=0;

    Button btn_help;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_quiz_fragment, container, false);
        bg=view.findViewById(R.id.quiz_bg);
        answer=view.findViewById(R.id.editText);
        question=view.findViewById(R.id.textView);
        rs=view.getResources();
        mSettings = getActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        language= mSettings.getString("language","");
        btn_help=view.findViewById(R.id.button2);
        btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer.setText(ListAnswers[count-1]);
            }
        });
        if(language.equals("Rus")) {
           ListAnswers = new String[]{rs.getString(R.string.Answer1), rs.getString(R.string.Answer2), rs.getString(R.string.Answer3), rs.getString(R.string.Answer4), rs.getString(R.string.Answer5), rs.getString(R.string.Answer6), rs.getString(R.string.Answer7), rs.getString(R.string.Answer8),
            rs.getString(R.string.Answer9), rs.getString(R.string.Answer10), rs.getString(R.string.Answer11)};
           ListQuestions = new String[]{rs.getString(R.string.Question1), rs.getString(R.string.Question2), rs.getString(R.string.Question3), rs.getString(R.string.Question4), rs.getString(R.string.Question5), rs.getString(R.string.Question6), rs.getString(R.string.Question7), rs.getString(R.string.Question8),
            rs.getString(R.string.Question9), rs.getString(R.string.Question10), rs.getString(R.string.Question11)};
        }
        else{
            Log.d("TAG", "onCreateView: Eng");
            ListAnswers = new String[]{rs.getString(R.string.Answer1Eng), rs.getString(R.string.Answer2Eng), rs.getString(R.string.Answer3Eng), rs.getString(R.string.Answer4Eng), rs.getString(R.string.Answer5Eng), rs.getString(R.string.Answer6Eng), rs.getString(R.string.Answer7Eng), rs.getString(R.string.Answer8Eng),
                    rs.getString(R.string.Answer9Eng), rs.getString(R.string.Answer10Eng), rs.getString(R.string.Answer11Eng)};
            ListQuestions = new String[]{rs.getString(R.string.Question1Eng), rs.getString(R.string.Question2Eng), rs.getString(R.string.Question3Eng), rs.getString(R.string.Question4Eng), rs.getString(R.string.Question5Eng), rs.getString(R.string.Question6Eng), rs.getString(R.string.Question7Eng), rs.getString(R.string.Question8Eng),
                    rs.getString(R.string.Question9Eng), rs.getString(R.string.Question10Eng), rs.getString(R.string.Question11Eng)};
        }
        question.setText(ListQuestions[0]);
        Button btn=view.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if(answer.getText().toString().toLowerCase().equals(ListAnswers[count-1].toLowerCase())) {
                    v.setBackgroundColor(Color.parseColor("#008000"));//green
                    Log.d("TAG", "onClick: trueset");
                   rightanswer+=1;
                    Log.d("TAG", "onClick: "+rightanswer);
                    }
                else{v.setBackgroundColor(Color.parseColor("#FF6C6C"));
                   wronganswer+=1;
                    Log.d("TAG", "onClick: "+wronganswer);
                }
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(count==11){
                            Log.d("TAG", "run: "+rightanswer);
                            Log.d("TAG", "run: "+wronganswer);
                            Intent results=new Intent(getActivity(),ResultsQuiz.class);
                            results.putExtra("wronganswer",wronganswer);
                            results.putExtra("rightanswer",rightanswer);
                            startActivity(results);
                        }else{
                        count++;
                         v.setBackgroundResource(android.R.drawable.btn_default);
                        question.setText(ListQuestions[count-1]);
                            Log.d("TAG", "run: здесь"+count);
                        answer.setText(null);
                        }

                    }
                }, 1000);
                }

        });
        return view;

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


}
