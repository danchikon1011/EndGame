package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class FragmentCharacters extends Fragment {
Intent intent;
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_fragment_characters, container, false);
        ImageView Ivchenko=view.findViewById(R.id.imageView3);
        ImageView Shablin=view.findViewById(R.id.imageView);
        ImageView Merezkov=view.findViewById(R.id.imageView2);
        ImageView Shubin=view.findViewById(R.id.imageView4);
        ImageView Bredov=view.findViewById(R.id.imageView5);
        ImageView Golovko=view.findViewById(R.id.imageView6);
        intent=new Intent(getActivity(),ZoomCharacter.class);
        Ivchenko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("character","Ivchenko");
                startActivity(intent);
            }
        });
        Shablin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("character","Shablin");
                startActivity(intent);
            }
        });
        Merezkov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("character","Merezkov");
                startActivity(intent);
            }
        });
        Shubin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("character","Shubin");
                startActivity(intent);
            }
        });
        Bredov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("character","Bredov");
                startActivity(intent);
            }
        });
        Golovko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("character","Golovko");
                startActivity(intent);
            }
        });
        return view;


    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}

