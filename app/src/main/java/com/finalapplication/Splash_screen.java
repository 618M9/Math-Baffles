package com.finalapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Splash_screen extends AppCompatActivity
{
    TextView textView;
    public static  int Rlayout=0;
    static boolean first=false,second=false,third=false,fourth=false;
    ProgressBar progressBar;
    boolean f=false;
    MediaPlayer mediaPlayer;
    static  int dyna=0;
    public static ArrayList<String>name=new ArrayList<String>();
    public static ArrayList<Integer>scoreBoard;

    int progress;
    Thread thread;
    int arokta=0;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

       boolean fe=chkwarningextreme();


        scoreBoard=new ArrayList<>();

       if(!fe)
       {
           setwarningextreme();
           SharedPreferences sharedPreferences=getSharedPreferences("Highscore",MODE_PRIVATE);

           SharedPreferences.Editor editor=sharedPreferences.edit();
           editor.putInt("1",-1);
           editor.putInt("2",-1);
           editor.putInt("3",-1);
           editor.putInt("4",-1);
           editor.putInt("5",-1);
           editor.putBoolean("6",false);
           editor.putBoolean("7",false);
           editor.putBoolean("8",false);
           editor.putBoolean("9",false);
           editor.putBoolean("10",false);
           editor.putString("11","");
           editor.putString("12","");
           editor.putString("13","");
           editor.putString("14","");
           editor.putString("15","");
          // editor.putInt("16",-1);

           editor.commit();


       }

        setContentView(R.layout.activity_splash_screen);


        textView=findViewById(R.id.textView);
        Animation animation=AnimationUtils.loadAnimation(this,R.anim.mytransition);
textView.startAnimation(animation);
        mediaPlayer=MediaPlayer.create(this,R.raw.second);
        mediaPlayer.start();
        f=false;
        progressBar=findViewById(R.id.progressBarId);





        thread=new Thread(new Runnable()
        {
            public void run()
            {
                for (progress = 20; progress <= 100; )
                {
                    if(arokta==1)
                    {

                        continue;
                    }

                    try {
                        Thread.sleep(500);
                        progressBar.setProgress(progress);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progress=progress+20;


                }

                if(!f)
                {
                    Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                    startActivity(intent);
                }


                finish();



            }
        });
        thread.start();
    }
    public void onBackPressed()
    {
        super.onBackPressed();
        mediaPlayer.stop();

        thread.interrupt();
        f=true;
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
        overridePendingTransition(R.anim.slide_out_right2,R.anim.slide_out_right);
    }
    protected void onPause()
    {
        super.onPause();
        mediaPlayer.pause();

        arokta=1;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        f=false;
        mediaPlayer.start();

        arokta=0;
    }
    private boolean chkwarningextreme() {
        SharedPreferences sharedPreferences = getSharedPreferences("warning", Context.MODE_PRIVATE);
        String s = sharedPreferences.getString("extreme", "jesta");
        if (s.equals("dekha oigese")) return true;
        else return false;
    }

    private void setwarningextreme() {
        SharedPreferences sharedPreferences = getSharedPreferences("warning", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("extreme", "dekha oigese");
        editor.commit();
    }
    private boolean chkwarningextreme2() {
        SharedPreferences sharedPreferences = getSharedPreferences("warnin", Context.MODE_PRIVATE);
        String s = sharedPreferences.getString("extreme", "jesta");
        if (s.equals("dekha oigese")) return true;
        else return false;
    }

    private void setwarningextreme2() {
        SharedPreferences sharedPreferences = getSharedPreferences("warnin", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("extreme", "dekha oigese");
        editor.commit();
    }

}
