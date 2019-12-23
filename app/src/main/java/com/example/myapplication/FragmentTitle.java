package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class FragmentTitle  extends Fragment {
    SharedPreferences mSettings;
    SharedPreferences.Editor editor;

    Intent intent;
    public static final String APP_PREFERENCES = "Leng";


    public static FragmentTitle newInstance() {
        return new FragmentTitle();
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_title, container, false);
        mSettings = getActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        editor = mSettings.edit();
        Switch swtch=view.findViewById(R.id.switch1);
        String lang=mSettings.getString("language",null);
        Log.d("TAG", "onCreateView: "+lang);
        if(lang.equals("Rus")){
            swtch.setChecked(false);
            swtch.setText("Rus");
        }
        else if(lang.equals("Eng")){swtch.setChecked(true);swtch.setText("Eng");}
        else {
            editor.putString("language", "Rus");
            editor.apply();}

        intent = new Intent(getActivity(), MainActivity.class);

        Switch change = view.findViewById(R.id.switch1);
        if (change != null) {
            change.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        buttonView.setText("Eng");
                        editor = mSettings.edit();
                        editor.putString("language", "Eng");
                        editor.apply();
                        //изменить текста в title
                    } else {
                        buttonView.setText("Rus");
                        editor = mSettings.edit();
                        editor.putString("language", "Rus");
                        editor.apply();
                        //изменить текста в title
                    }
                }
            });



        }
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
