package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout mDrawer;
    NavigationView nvDrawer;
    String frg=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         frg = getIntent().getStringExtra("fragment");
        Log.d("TAG", "onCreate: "+frg);
        if(frg!=null){
            Log.d("TAG", "onCreate: "+frg);
            Fragment fragment = null;
            Class fragmentClass = null;

            switch (frg){
            case "quiz":
             fragmentClass = FragmentQuiz.class;
                Log.d("TAG", "onCreate: yes");
                break;
            case "char":
                fragmentClass = FragmentCharacters.class;
                break;
            case "nav4":
                fragmentClass = FragmentQuiz.class;
                break;
            }
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                Log.d("TAG", "selectDrawerItem: error");
            }

            // Вставить фрагмент, заменяя любой существующий
            Log.d("TAG", "onCreate: "+fragment);
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        }
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        mDrawer =  findViewById(R.id.drawer_layout);
        nvDrawer = findViewById(R.id.nvView);

        setupDrawerContent(nvDrawer);
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
        // Создать новый фрагмент и задать фрагмент для отображения
        // на основе нажатия на элемент навигации
        Fragment fragment = null;
        Class fragmentClass = null;
        switch(menuItem.getItemId()) {
            case R.id.Quiz:
                fragmentClass = FragmentQuiz.class;
                break;
            case R.id.Video:

                Intent intent=new Intent(this,Video.class);
                startActivity(intent);
                break;
            case R.id.Characters:

                fragmentClass = FragmentCharacters.class;
                break;
            case R.id.nav4:

                fragmentClass = FragmentQuiz.class;
                break;
            default:

                fragmentClass = FragmentQuiz.class;
        }
        if(menuItem.getItemId() == R.id.Quiz|menuItem.getItemId()== R.id.Characters|menuItem.getItemId()== R.id.nav4){
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            Log.d("TAG", "selectDrawerItem: error");
        }

        // Вставить фрагмент, заменяя любой существующий
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
        }

        // Выделение существующего элемента выполнено с помощью
        // NavigationView
        menuItem.setChecked(true);
        // Закрыть navigation drawer
        mDrawer.closeDrawers();
    }


}