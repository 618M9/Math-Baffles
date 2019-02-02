package com.finalapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import javax.security.auth.login.LoginException;

public class MainMenu extends AppCompatActivity
{
    Button button1,button2,button3,newButton,Exitbutton;
    static  int kuntaSelect=0;
    MediaPlayer mediaPlayer;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        setContentView(R.layout.activity_main_menu);
        button1=findViewById(R.id.first_button);
        button2=findViewById(R.id.second_button);
        newButton=findViewById(R.id.new_button);
        Exitbutton=findViewById(R.id.exitButton);

        StartAnimations();




        if(Splash_screen.Rlayout==1 )
        {
            newButton.setVisibility(View.VISIBLE);
            newButton.setClickable(true);


            button1.setText("Resume Game");
            button1.setTextSize(20f);
        }
        mediaPlayer=MediaPlayer.create(this,R.raw.main);

        final String buja=button1.getText().toString();
        newButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                First.index=0;
                First.score=0;
                Second.index=0;
                Second.score=0;
                Third.score=0;
                Third.index=0;
                Animation animation=AnimationUtils.loadAnimation(MainMenu.this,R.anim.slide_out_right);
                button1.startAnimation(animation);
                Intent i=new Intent(MainMenu.this,Level.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right2);
                finish();
            }
        });

        button1.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v)
            {
                Log.e("tag",""+button1.getText().toString());
                if(button1.getText().toString().equals("New Game"))
                {
                    mediaPlayer.start();
                    Animation animation=AnimationUtils.loadAnimation(MainMenu.this,R.anim.slide_out_right);
                    button1.startAnimation(animation);
                    First.index=0;
                    First.score=0;
                    Second.index=0;
                    Second.score=0;
                    Third.score=0;
                    Third.index=0;
                    Intent i=new Intent(MainMenu.this,Level.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right2);
                    finish();
                }
                else
                {
                    mediaPlayer.start();
                    Animation animation=AnimationUtils.loadAnimation(MainMenu.this,R.anim.slide_out_right);
                    button1.startAnimation(animation);


                    Intent i;
                    if(kuntaSelect==1)
                    {
                        kuntaSelect=0;
                        First.index--;
                        i=new Intent(getApplicationContext(),First.class);
                        startActivity(i);
                        overridePendingTransition(R.anim.fadeout1,R.anim.fadeout1);
                        finish();
                    }
                    else if(kuntaSelect==2)
                    {
                        kuntaSelect=0;
                        Second.index--;
                        i=new Intent(getApplicationContext(),Second.class);
                        startActivity(i);
                        overridePendingTransition(R.anim.fadeout1,R.anim.fadeout1);
                        finish();
                    }
                    else if(kuntaSelect==3)
                    {
                        kuntaSelect=0;
                        Third.index--;
                        i=new Intent(getApplicationContext(),Third.class);
                        startActivity(i);
                        overridePendingTransition(R.anim.fadeout1,R.anim.fadeout1);
                        finish();
                    }
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                Animation animation=AnimationUtils.loadAnimation(MainMenu.this
                ,R.anim.slide_out_right);
                button2.startAnimation(animation);
                Intent i= new Intent(getApplicationContext(),HighScore.class);
                i.putExtra("man",Splash_screen.Rlayout);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right2);
                finish();
            }
        });
        Exitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainMenu.this);
                alertDialogBuilder.setTitle("Alert!!");
                alertDialogBuilder.setInverseBackgroundForced(true);

                alertDialogBuilder.setMessage("Do you want to exit?");
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent a = new Intent(Intent.ACTION_MAIN);
                        Splash_screen.Rlayout=0;
                        a.addCategory(Intent.CATEGORY_HOME);
                        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(a);
                        overridePendingTransition(R.anim.fadeout1,R.anim.fadeout1);
                        finish();
                    }
                });
                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });
                AlertDialog alertDialog=alertDialogBuilder.create();
                alertDialog.show();
            }
        });

    }
    public void onBackPressed()
    {
        super.onBackPressed();

        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
        overridePendingTransition(R.anim.fadeout1,R.anim.fadeout1);
        finish();
    }
    protected void onPause()
    {
        super.onPause();

    }


    protected void onResume() {
        super.onResume();

    }


    protected void onRestart() {
        super.onRestart();

    }

    private void StartAnimations() {

        Animation slideup = AnimationUtils.loadAnimation(this, R.anim.slideup);
        Animation slidedown = AnimationUtils.loadAnimation(this, R.anim.slidedown);
        Animation left=AnimationUtils.loadAnimation(this,R.anim.leftside);
        Animation right=AnimationUtils.loadAnimation(this,R.anim.rightside);
        Animation alpha=AnimationUtils.loadAnimation(this,R.anim.alpha);
        slidedown.reset();
        slideup.reset();
        left.reset();
        right.reset();
        alpha.reset();
        newButton.clearAnimation();
        newButton.startAnimation(right);

        button1.clearAnimation();
        button1.startAnimation(slideup);


        button2.clearAnimation();
        button2.startAnimation(left);


        Exitbutton.clearAnimation();
        Exitbutton.startAnimation(slidedown);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);

        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.aboutItem)
        {
            Toast.makeText(getApplicationContext(),"Select About",Toast.LENGTH_SHORT).show();
            return true;
        }
        if(item.getItemId()==R.id.gameInfoItem)
        {
           // Toast.makeText(getApplicationContext(),"Select gameInfo",Toast.LENGTH_SHORT).show();
            Intent i=new Intent(getApplicationContext(),game_information.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
