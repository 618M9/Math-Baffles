package com.finalapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.drm.DrmStore;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


public class Level extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    Button button1,button2,button3;
    public  static  final  String TAG=Level.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Math Baffles");
        getSupportActionBar().setSubtitle("Level");
        setContentView(R.layout.activity_level);
        mediaPlayer=MediaPlayer.create(this,R.raw.main);
        button1=findViewById(R.id.first_button);
        button2=findViewById(R.id.second_button);
        button3=findViewById(R.id.third_button);
        StartAnimations();
        Splash_screen.Rlayout=0;

        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mediaPlayer.start();
                Animation animation=AnimationUtils.loadAnimation(Level.this,R.anim.slide_out_right2);
                button1.startAnimation(animation);

                Intent i=new Intent(Level.this,First.class);

                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
                finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                Animation animation=AnimationUtils.loadAnimation(Level.this,R.anim.slide_out_right2);
                button1.startAnimation(animation);

                Intent i=new Intent(Level.this,Second.class);

                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
                finish();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                Animation animation=AnimationUtils.loadAnimation(Level.this,R.anim.slide_out_right2);
                button1.startAnimation(animation);

                Intent i=new Intent(Level.this,Third.class);

                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            Intent i=new Intent(getApplicationContext(),MainMenu.class);
            startActivity(i);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed()
    {
        super.onBackPressed();

        Intent i=new Intent(Level.this,MainMenu.class);
        startActivity(i);
        overridePendingTransition(R.anim.fadeout1,R.anim.slide_out_right2);
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onRestart()
    {
        super.onRestart();

    }
    private void StartAnimations() {

        Animation slideup = AnimationUtils.loadAnimation(this, R.anim.slideup);
        Animation slidedown = AnimationUtils.loadAnimation(this, R.anim.slidedown);
        Animation left=AnimationUtils.loadAnimation(this,R.anim.leftside);
        Animation right=AnimationUtils.loadAnimation(this,R.anim.rightside);
        Animation alpha=AnimationUtils.loadAnimation(this,R.anim.alpha);
        Animation mytransition2=AnimationUtils.loadAnimation(this,R.anim.mytransition2);
        Animation translate=AnimationUtils.loadAnimation(this,R.anim.translate);
        slidedown.reset();
        slideup.reset();
        left.reset();
        right.reset();
        alpha.reset();
        mytransition2.reset();
        translate.reset();

        button1.clearAnimation();
        button1.startAnimation(translate);


        button2.clearAnimation();
        button2.startAnimation(mytransition2);


        button3.clearAnimation();
        button3.startAnimation(slidedown);

    }
}
