package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Video extends YouTubeBaseActivity {
    String API_KEY="asdfasdfasd";
    String VIDEO_ID="BG9bm4TCy64";
    DrawerLayout mDrawer;
    NavigationView nvDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // attaching layout xml
        setContentView(R.layout.activity_video);

        mDrawer =  findViewById(R.id.drawer_layout);
        nvDrawer = findViewById(R.id.nvView);

        setupDrawerContent(nvDrawer);
        // Initializing YouTube player view
        YouTubePlayerView youTubePlayerView =  findViewById(R.id.player);
        youTubePlayerView.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if(null== youTubePlayer) return;

                // Start buffering
                if (!b) {
                    youTubePlayer.cueVideo(VIDEO_ID);
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(Video.this, "Failed to initialize.", Toast.LENGTH_LONG).show();
            }
        });
    }
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        String str;

        switch(menuItem.getItemId()) {
            case R.id.Quiz:
                str="quiz";
                break;
            case R.id.Characters:
                str="char";
                break;
            case R.id.nav4:
                str="nav4";
                break;
            default:
                str="quiz";
        }
        Intent main=new Intent(this,MainActivity.class);
        //передать в майнактивити
        main.putExtra("fragment", str);
        startActivity(main);
        mDrawer.closeDrawers();
    }



}

