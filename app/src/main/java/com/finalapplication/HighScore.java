package com.finalapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Collections;

public class HighScore extends AppCompatActivity {
Splash_screen splash_screen;
First first;
TextView textView1,textView2,textView3,textView4,textView5;
TextView name1,name2,name3,name4,name5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Highscore");


        setContentView(R.layout.activity_high_score);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        splash_screen=new Splash_screen();
        first=new First();
        textView1=findViewById(R.id.firstScore);
        textView2=findViewById(R.id.secondScore);
        textView3=findViewById(R.id.thirdScore);
        textView4=findViewById(R.id.fourthScore);
        name1=findViewById(R.id.firstName);
        name2=findViewById(R.id.secondName);
        name3=findViewById(R.id.thirdName);
        name4=findViewById(R.id.fourthName);
        name5=findViewById(R.id.fivthName);
        textView5=findViewById(R.id.fivthScore);
        Intent i=getIntent();
        int u=i.getIntExtra("man",0);
        if(u==1)
        {
            Splash_screen.Rlayout=1;
        }
        else Splash_screen.Rlayout=0;
        SharedPreferences sharedPreferences=getSharedPreferences("Highscore", Context.MODE_PRIVATE);
        boolean first=sharedPreferences.getBoolean("6",false);
        if(first)
        {
            int score=sharedPreferences.getInt("1",0);
            String name=sharedPreferences.getString("11","");
            if(score<10)
            {
                textView1.setText("0"+score);
                name1.setText(name);
            }
            else
            {
                textView1.setText(""+score);
                name1.setText(name);
            }
        }
        else
        {
            textView1.setText("_____");
            name1.setText("_____");
        }
        boolean second=sharedPreferences.getBoolean("7",false);
        if(second)
        {
            int score=sharedPreferences.getInt("2",0);
            String name=sharedPreferences.getString("12","");
            if(score<10)
            {
                textView2.setText("0"+score);
                name2.setText(name);
            }
            else
            {
                textView2.setText(""+score);
                name2.setText(name);
            }
        }
        else
        {
            textView2.setText("_____");
            name2.setText("_____");
        }
        boolean third=sharedPreferences.getBoolean("8",false);
        if(third)
        {
            int score=sharedPreferences.getInt("3",0);
            String name=sharedPreferences.getString("13","");
            if(score<10)
            {
                textView3.setText("0"+score);
                name3.setText(name);
            }
            else
            {
                textView3.setText(""+score);
                name3.setText(name);
            }
        }
        else
        {
            textView3.setText("_____");
            name3.setText("_____");
        }
        boolean fourth=sharedPreferences.getBoolean("9",false);
        if(fourth)
        {
            int score=sharedPreferences.getInt("4",0);
            String name=sharedPreferences.getString("14","");
            if(score<10)
            {
                textView4.setText("0"+score);
                name4.setText(name);
            }
            else
            {
                textView4.setText(""+score);
                name4.setText(name);
            }
        }
        else
        {
            textView4.setText("_____");
            name4.setText("_____");
        }
        boolean fivth=sharedPreferences.getBoolean("10",false);
        if(fivth)
        {
            int score=sharedPreferences.getInt("5",0);
            String name=sharedPreferences.getString("15","");
            if(score<10)
            {
                textView5.setText("0"+score);
                name5.setText(name);
            }
            else
            {
                textView5.setText(""+score);
                name5.setText(name);
            }
        }
        else
        {
            textView5.setText("_____");
            name5.setText("_____");
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(getApplicationContext(),MainMenu.class);
        startActivity(i);
        finish();
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            Intent i=new Intent(getApplicationContext(),MainMenu.class);
            startActivity(i);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
