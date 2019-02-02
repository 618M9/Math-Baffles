package com.finalapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Second extends AppCompatActivity {
    String crctAns;
    TextView textView1,textView2,textView3,textView4;
    private AlertDialog.Builder alertDialogBuilder;
    Handler handler=new Handler();
    CountDownTimer countDownTimer;
    boolean first=false,second=false,third=false,fourth=false;
    private  boolean mtimerRunning=true;
    boolean f=false;

    MediaPlayer mediaPlayer,mediaPlayer2,wrong;
    TextView timer;
    private long timeleft=16000;
    AlertDialog alertDialog;
    private  long raka;
    long er;
    static  int index=0;
    private  int progress=0;
    int ff=1;
    String val="";
    View view2;
    LinearLayout linear1,linear2,linear3;
    MedimuLibrary quiz;
    Button firstbutton;
    int com=0;
    static int score=0;
    Integer compare=0;
    Splash_screen splash_screen;
    ArrayList<Integer>scoreAna=new ArrayList<>();
    Button secondbutton,thirdbutton,fourthbutton;
    static  int backTrack=0;
    static int wrongTrack=0;
    View ui;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        splash_screen=new Splash_screen();
        compare=0;
        textView4=findViewById(R.id.highScore);

        int finl=loadScore();
        if(finl==-1) textView4.setText("00");
        else if(finl<10) textView4.setText("0"+loadScore());
        else textView4.setText(""+loadScore());

        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.number);
        if(score<10)
        {
            textView3.setText("0"+score);
        }
        else textView3.setText(""+score);
        ui=findViewById(R.id.firstui);
        f=false;
        quiz=new MedimuLibrary();
        timer=findViewById(R.id.timer);
        mediaPlayer=MediaPlayer.create(this,R.raw.main);
        wrong=MediaPlayer.create(this,R.raw.no);

        firstbutton=findViewById(R.id.first_button);
        secondbutton=findViewById(R.id.second_button);
        thirdbutton=findViewById(R.id.third_button);
        fourthbutton=findViewById(R.id.fourth_button);
        linear1=findViewById(R.id.linear1);
        linear2=findViewById(R.id.linear2);
        linear3=findViewById(R.id.linear3);
        if(backTrack==1 && wrongTrack==1 )
        {
            backTrack=0;
            wrongTrack=0;

            if(Splash_screen.first)
            {

                firstbutton.setBackgroundColor(Color.RED);
            }
            else if(Splash_screen.second)
            {
                secondbutton.setBackgroundColor(Color.RED);
            }
            else if(Splash_screen.third)
            {
                thirdbutton.setBackgroundColor(Color.RED);
            }
            else if(Splash_screen.fourth)
            {
                fourthbutton.setBackgroundColor(Color.RED);
            }
            Splash_screen.first=false;
            Splash_screen.second=false;
            Splash_screen.third=false;
            Splash_screen.fourth=false;
            storeValue(score);
        }
        else if(backTrack==1)
        {
            backTrack=0;
            if(index==19)
            {
                storeValue(score);
            }
        }
        setQuestion();

    }
    private int loadScore()
    {
        SharedPreferences sharedPreferences=getSharedPreferences("Highscore", Context.MODE_PRIVATE);
        int raka=sharedPreferences.getInt("1",0);
        return raka;
    }
    public void setQuestion()
    {


        Splash_screen.first=false;
        Splash_screen.second=false;
        Splash_screen.third=false;
        Splash_screen.fourth=false;
        mediaPlayer2=MediaPlayer.create(this,R.raw.ordians);
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



        ui.setBackgroundResource(quiz.getImage(index));
        ui.clearAnimation();
        ui.startAnimation(alpha);
        if(index==0|| index==19 ||index==6 || index==12 ||index==18 || index==4 || index==2 || index==8 || index==14 || index==10 || index==16)
        {
            textView2.setTextColor(Color.BLACK);
        }
        else
        {
            textView2.setTextColor(Color.WHITE);
        }

        textView1.setText(quiz.getQuestion(index));
        firstbutton.setText(quiz.getChoice_1(index));
        secondbutton.setText(quiz.getChoice_2(index));
        thirdbutton.setText(quiz.getChoice_3(index));
        fourthbutton.setText(quiz.getChoice_4(index));
        if(index==0 ||index==6 || index==12 ||index==18 || index==4 || index==2 || index==8 || index==14 || index==10 || index==16 || index==19)
        {
            firstbutton.setBackgroundResource(R.drawable.btnimage);
            secondbutton.setBackgroundResource(R.drawable.btnimage);
            thirdbutton.setBackgroundResource(R.drawable.btnimage);
            fourthbutton.setBackgroundResource(R.drawable.btnimage);
            firstbutton.setTextColor(Color.BLACK);
            secondbutton.setTextColor(Color.BLACK);
            thirdbutton.setTextColor(Color.BLACK);
            fourthbutton.setTextColor(Color.BLACK);
        }
        else {
            firstbutton.setBackgroundResource(R.drawable.btn);
            secondbutton.setBackgroundResource(R.drawable.btn);
            thirdbutton.setBackgroundResource(R.drawable.btn);
            fourthbutton.setBackgroundResource(R.drawable.btn);
            firstbutton.setTextColor(Color.WHITE);
            secondbutton.setTextColor(Color.WHITE);
            thirdbutton.setTextColor(Color.WHITE);
            fourthbutton.setTextColor(Color.WHITE);
        }
        firstbutton.setEnabled(true);
        secondbutton.setEnabled(true);
        thirdbutton.setEnabled(true);
        fourthbutton.setEnabled(true);
        crctAns=quiz.getCorrectAns(index).toLowerCase();
        index++;
    }
    public void firstbtn(View view)
    {
        String s=firstbutton.getText().toString().toLowerCase();
        mediaPlayer.start();
        Splash_screen.first=true;



        chkAns(s);
    }
    public void secondbtn(View view)
    {
        String s=secondbutton.getText().toString().toLowerCase();

        mediaPlayer.start();
        Splash_screen.second=true;


        chkAns(s);
    }
    public void thirdbtn(View view)
    {
        String s=thirdbutton.getText().toString().toLowerCase();
        mediaPlayer.start();
        Splash_screen.third=true;



        chkAns(s);
    }
    public void fourthbtn(View view)
    {
        mediaPlayer.start();
        fourthbutton.getBackground();
        Splash_screen.fourth=true;
        String s=fourthbutton.getText().toString().toLowerCase();
        chkAns(s);
    }
    private void chkAns(String s)
    {
        if(s.equals(crctAns))
        {
            mediaPlayer2.start();
            score+=2;
            if(score<10) textView3.setText("0"+score);
            else textView3.setText(""+score);
            Animation animation=AnimationUtils.loadAnimation(Second.this,R.anim.slide_in_right);
            if(Splash_screen.fourth)
            {
                fourthbutton.startAnimation(animation);
                fourthbutton.setBackgroundColor(Color.GREEN);
            }
            if(Splash_screen.second)
            {
                secondbutton.startAnimation(animation);
                secondbutton.setBackgroundColor(Color.GREEN);
            }
            if(Splash_screen.third) {
                thirdbutton.startAnimation(animation);
                thirdbutton.setBackgroundColor(Color.GREEN);
            }

            if(Splash_screen.first)
            {
                firstbutton.startAnimation(animation);
                firstbutton.setBackgroundColor(Color.GREEN);
            }
            boolean pre=false;
            if(index==20 && !pre)
            {
                pre=true;
                LayoutInflater layoutInflater=getLayoutInflater();
                View view=layoutInflater.inflate(R.layout.last_question_medium_toast,(ViewGroup)findViewById(R.id.mediumToast));
                Toast toast=new Toast(Second.this);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.setView(view);
                toast.show();
            }
            if(index!=1&& !pre && index!=20 && index!=7 && index!=13 && index!=19 && index!=5 && index!=3 && index!=9 && index!=15 && index!=11 && index!=17)
            {
                LayoutInflater layoutInflater=getLayoutInflater();
                View view=layoutInflater.inflate(R.layout.correct,(ViewGroup)findViewById(R.id.custom));
                Toast toast=new Toast(Second.this);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.setView(view);
                toast.show();
            }
            else if(!pre)
            {
                LayoutInflater layoutInflater=getLayoutInflater();
                View view=layoutInflater.inflate(R.layout.correct_imagetoast,(ViewGroup)findViewById(R.id.customToastImageCorrect));
                Toast toast=new Toast(Second.this);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.setView(view);
                toast.show();
            }


            firstbutton.setEnabled(false);
            secondbutton.setEnabled(false);
            thirdbutton.setEnabled(false);
            fourthbutton.setEnabled(false);

            final Runnable mrunnable =new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable() {



                        @Override
                        public void run() {
                            mediaPlayer2.stop();
                            if(index<20)setQuestion();
                            else
                            {
                                if(backTrack==0)
                                {
                                    storeValue(score);
                                }
                            }

                        }
                    });
                }

            };
            new Thread(mrunnable).start();


        }
        else
        {
            wrongTrack=1;
            wrong.start();

            if(score<10) textView3.setText("0"+score);
            else textView3.setText(""+score);
            Animation animation=AnimationUtils.loadAnimation(Second.this,R.anim.slide_in_right);
            if(Splash_screen.fourth)
            {
                fourthbutton.startAnimation(animation);
                fourthbutton.setBackgroundColor(Color.RED);
            }
            if(Splash_screen.second)
            {
                secondbutton.startAnimation(animation);
                secondbutton.setBackgroundColor(Color.RED);
            }
            if(Splash_screen.third)
            {
                thirdbutton.startAnimation(animation);
                thirdbutton.setBackgroundColor(Color.RED);
            }
            if(Splash_screen.first)
            {
                firstbutton.startAnimation(animation);
                firstbutton.setBackgroundColor(Color.RED);
            }
            if(index!=1 && index!=20 && index!=7 && index!=13 && index!=19 && index!=5 && index!=3 && index!=9 && index!=15 && index!=11 && index!=17)
            {
                LayoutInflater layoutInflater=getLayoutInflater();
                View view=layoutInflater.inflate(R.layout.wrong,(ViewGroup)findViewById(R.id.customsad));
                Toast toast=new Toast(Second.this);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.setView(view);
                toast.show();
            }
            else
            {
                LayoutInflater layoutInflater=getLayoutInflater();
                View view=layoutInflater.inflate(R.layout.wrong_imagetoast,(ViewGroup)findViewById(R.id.wrongImageToast));
                Toast toast=new Toast(Second.this);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.setView(view);
                toast.show();
            }
            firstbutton.setEnabled(false);
            secondbutton.setEnabled(false);
            thirdbutton.setEnabled(false);
            fourthbutton.setEnabled(false);
            final Runnable mr=new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Log.e("api",""+backTrack);
                            if (backTrack==0)storeValue(score);
                        }
                    });

                }
            };new Thread(mr).start();


        }
    }

    private void storeValue(final int score)
    {
        SharedPreferences sharedPreferences=getSharedPreferences("Highscore", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor=sharedPreferences.edit();
        int val=sharedPreferences.getInt("1",0);
        boolean suk=false;
        if(val<=score && !suk &&score!=0)
        {
            Splash_screen.Rlayout=0;

            suk=true;
            if(val==-1)
            {
                editor.putInt("1",score);
                editor.putBoolean("6",true);

                final Runnable mrunnable =new Runnable()
                {
                    @Override
                    public void run() {

                        handler.post(new Runnable() {




                            public void run() {
                                AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(Second.this);
                                View mView =getLayoutInflater().inflate(R.layout.namecustomlayout,null);
                                TextView text1=mView.findViewById(R.id.sadText);
                                TextView scoreText=mView.findViewById(R.id.scoreText);
                                final EditText name=mView.findViewById(R.id.nameText);

                                Button submitButton =mView.findViewById(R.id.submitButton);
                                if(score<10)scoreText.setText("0"+score+".");
                                else scoreText.setText(""+score+".");
                                submitButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        if(name.getText().toString().trim().equals(""))
                                        {
                                            Toast.makeText(getApplicationContext(),"Please enter your name",Toast.LENGTH_SHORT).show();
                                        }
                                        else if(name.getText().toString().trim().length()>13)
                                        {
                                            Toast.makeText(getApplicationContext(),"Name is too large",Toast.LENGTH_SHORT).show();
                                        }

                                        else
                                        {
                                            editor.putString("11",name.getText().toString());
                                            editor.commit();
                                            index=0;
                                            Intent i=new Intent(getApplicationContext(),MainMenu.class);
                                            startActivity(i);
                                            overridePendingTransition(R.anim.fadeout1,R.anim.fadeout1);
                                            finish();
                                        }
                                    }
                                });

                                alertDialogBuilder.setView(mView);
                                alertDialogBuilder.setCancelable(false);
                                AlertDialog alertDialog=alertDialogBuilder.create();
                                alertDialog.show();



                            }
                        });
                    }

                };
                new Thread(mrunnable).start();


            }
            else
            {
                val=sharedPreferences.getInt("4",0);
                if(val!=-1)
                {
                    editor.putInt("5",val);
                    editor.putString("15",sharedPreferences.getString("14",""));
                    editor.putBoolean("10",true);
                }
                val=sharedPreferences.getInt("3",0);
                if(val!=-1)
                {
                    editor.putInt("4",val);
                    editor.putString("14",sharedPreferences.getString("13",""));
                    editor.putBoolean("9",true);
                }
                val=sharedPreferences.getInt("2",0);
                if(val!=-1)
                {
                    editor.putInt("3",val);
                    editor.putString("13",sharedPreferences.getString("12",""));
                    editor.putBoolean("8",true);
                }
                val=sharedPreferences.getInt("1",0);
                if(val!=-1)
                {
                    editor.putInt("2",val);
                    editor.putString("12",sharedPreferences.getString("11",""));
                    Log.e("tag","dy");
                    editor.putBoolean("7",true);
                }
                editor.putInt("1",score);
                editor.putBoolean("6",true);

                final Runnable mrunnable =new Runnable()
                {
                    @Override
                    public void run() {

                        handler.post(new Runnable() {




                            public void run() {

                                AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(Second.this);
                                View mView =getLayoutInflater().inflate(R.layout.namecustomlayout,null);
                                TextView text1=mView.findViewById(R.id.sadText);
                                TextView scoreText=mView.findViewById(R.id.scoreText);
                                final EditText name=mView.findViewById(R.id.nameText);

                                Button submitButton =mView.findViewById(R.id.submitButton);
                                if(score<10)scoreText.setText("0"+score+".");
                                else scoreText.setText(""+score+".");
                                submitButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                        if(name.getText().toString().trim().equals(""))
                                        {
                                            Toast.makeText(getApplicationContext(),"Please enter your name",Toast.LENGTH_SHORT).show();
                                        }
                                        else if(name.getText().toString().trim().length()>13)
                                        {
                                            Toast.makeText(getApplicationContext(),"Name is too large",Toast.LENGTH_SHORT).show();
                                        }
                                        else {
                                            editor.putString("11",name.getText().toString());
                                            editor.commit();
                                            Intent i=new Intent(getApplicationContext(),MainMenu.class);
                                            startActivity(i);
                                            index=0;
                                            overridePendingTransition(R.anim.fadeout1,R.anim.fadeout1);
                                            finish();
                                        }
                                    }
                                });

                                alertDialogBuilder.setView(mView);
                                alertDialogBuilder.setCancelable(false);
                                AlertDialog alertDialog=alertDialogBuilder.create();
                                alertDialog.show();


                            }
                        });
                    }

                };
                new Thread(mrunnable).start();



            }
        }
        val = sharedPreferences.getInt("2",0);
        if(val<=score && !suk&&score!=0)
        {
            Splash_screen.Rlayout=0;
            suk=true;
            if(val==-1)
            {
                editor.putInt("2",score);
                editor.putBoolean("7",true);

                final Runnable mrunnable =new Runnable()
                {
                    @Override
                    public void run() {

                        handler.post(new Runnable() {




                            public void run() {

                                AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(Second.this);
                                View mView =getLayoutInflater().inflate(R.layout.namecustomlayout,null);
                                TextView text1=mView.findViewById(R.id.sadText);
                                TextView scoreText=mView.findViewById(R.id.scoreText);
                                final EditText name=mView.findViewById(R.id.nameText);

                                Button submitButton =mView.findViewById(R.id.submitButton);
                                if(score<10)scoreText.setText("0"+score+".");
                                else scoreText.setText(""+score+".");
                                submitButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if(name.getText().toString().trim().equals(""))
                                        {
                                            Toast.makeText(getApplicationContext(),"Please enter your name",Toast.LENGTH_SHORT).show();
                                        }
                                        else if(name.getText().toString().trim().length()>13)
                                        {
                                            Toast.makeText(getApplicationContext(),"Name is too large",Toast.LENGTH_SHORT).show();
                                        }
                                        else
                                        {
                                            editor.putString("12",name.getText().toString());
                                            editor.commit();
                                            index=0;
                                            Intent i=new Intent(getApplicationContext(),MainMenu.class);
                                            startActivity(i);
                                            overridePendingTransition(R.anim.fadeout1,R.anim.fadeout1);
                                            finish();
                                        }
                                    }
                                });

                                alertDialogBuilder.setView(mView);
                                alertDialogBuilder.setCancelable(false);
                                AlertDialog alertDialog=alertDialogBuilder.create();
                                alertDialog.show();



                            }
                        });
                    }

                };
                new Thread(mrunnable).start();

            }
            else
            {
                val=sharedPreferences.getInt("4",0);
                if(val!=-1)
                {
                    editor.putInt("5",val);
                    editor.putString("15",sharedPreferences.getString("14",""));
                    editor.putBoolean("10",true);
                }
                val=sharedPreferences.getInt("3",0);
                if(val!=-1)
                {
                    editor.putInt("4",val);
                    editor.putString("14",sharedPreferences.getString("13",""));
                    editor.putBoolean("9",true);
                }
                val=sharedPreferences.getInt("2",0);
                if(val!=-1)
                {
                    editor.putInt("3",val);
                    editor.putString("13",sharedPreferences.getString("12",""));
                    editor.putBoolean("8",true);
                }
                editor.putInt("2",score);
                editor.putBoolean("7",true);

                final Runnable mrunnable =new Runnable()
                {
                    @Override
                    public void run() {

                        handler.post(new Runnable() {




                            public void run() {
                                AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(Second.this);
                                View mView =getLayoutInflater().inflate(R.layout.namecustomlayout,null);
                                TextView text1=mView.findViewById(R.id.sadText);
                                TextView scoreText=mView.findViewById(R.id.scoreText);
                                final EditText name=mView.findViewById(R.id.nameText);

                                Button submitButton =mView.findViewById(R.id.submitButton);
                                if(score<10)scoreText.setText("0"+score+".");
                                else scoreText.setText(""+score+".");
                                submitButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if(name.getText().toString().trim().equals(""))
                                        {
                                            Toast.makeText(getApplicationContext(),"Please enter your name",Toast.LENGTH_SHORT).show();
                                        }
                                        else if(name.getText().toString().trim().length()>13)
                                        {
                                            Toast.makeText(getApplicationContext(),"Name is too large",Toast.LENGTH_SHORT).show();
                                        }
                                        else
                                        {
                                            editor.putString("12",name.getText().toString());
                                            editor.commit();
                                            index=0;
                                            Intent i=new Intent(getApplicationContext(),MainMenu.class);
                                            startActivity(i);
                                            overridePendingTransition(R.anim.fadeout1,R.anim.fadeout1);
                                            finish();
                                        }
                                    }
                                });

                                alertDialogBuilder.setView(mView);
                                alertDialogBuilder.setCancelable(false);
                                AlertDialog alertDialog=alertDialogBuilder.create();
                                alertDialog.show();



                            }
                        });
                    }

                };
                new Thread(mrunnable).start();


            }
        }
        val = sharedPreferences.getInt("3",0);
        if(val<=score && !suk&&score!=0)
        {
            Splash_screen.Rlayout=0;
            suk=true;
            if(val==-1)
            {
                editor.putInt("3",score);
                editor.putBoolean("8",true);

                final Runnable mrunnable =new Runnable()
                {
                    @Override
                    public void run() {

                        handler.post(new Runnable() {




                            public void run() {

                                AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(Second.this);
                                View mView =getLayoutInflater().inflate(R.layout.namecustomlayout,null);
                                TextView text1=mView.findViewById(R.id.sadText);
                                TextView scoreText=mView.findViewById(R.id.scoreText);
                                final EditText name=mView.findViewById(R.id.nameText);

                                Button submitButton =mView.findViewById(R.id.submitButton);
                                if(score<10)scoreText.setText("0"+score+".");
                                else scoreText.setText(""+score+".");
                                submitButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if(name.getText().toString().trim().equals(""))
                                        {
                                            Toast.makeText(getApplicationContext(),"Please enter your name",Toast.LENGTH_SHORT).show();
                                        }
                                        else if(name.getText().toString().trim().length()>13)
                                        {
                                            Toast.makeText(getApplicationContext(),"Name is too large",Toast.LENGTH_SHORT).show();
                                        }
                                        else
                                        {
                                            editor.putString("13",name.getText().toString());
                                            editor.commit();
                                            index=0;
                                            Intent i=new Intent(getApplicationContext(),MainMenu.class);
                                            startActivity(i);
                                            overridePendingTransition(R.anim.fadeout1,R.anim.fadeout1);
                                            finish();
                                        }
                                    }
                                });

                                alertDialogBuilder.setView(mView);
                                alertDialogBuilder.setCancelable(false);
                                AlertDialog alertDialog=alertDialogBuilder.create();
                                alertDialog.show();



                            }
                        });
                    }

                };
                new Thread(mrunnable).start();

            }
            else
            {
                val=sharedPreferences.getInt("4",0);
                if(val!=-1)
                {
                    editor.putInt("5",val);
                    editor.putString("15",sharedPreferences.getString("14",""));
                    editor.putBoolean("10",true);
                }
                val=sharedPreferences.getInt("3",0);
                if(val!=-1)
                {
                    editor.putInt("4",val);
                    editor.putString("14",sharedPreferences.getString("13",""));
                    editor.putBoolean("9",true);
                }
                editor.putInt("3",score);
                editor.putBoolean("8",true);

                final Runnable mrunnable =new Runnable()
                {
                    @Override
                    public void run() {

                        handler.post(new Runnable() {




                            public void run() {

                                AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(Second.this);
                                View mView =getLayoutInflater().inflate(R.layout.namecustomlayout,null);
                                TextView text1=mView.findViewById(R.id.sadText);
                                TextView scoreText=mView.findViewById(R.id.scoreText);
                                final EditText name=mView.findViewById(R.id.nameText);

                                Button submitButton =mView.findViewById(R.id.submitButton);
                                if(score<10)scoreText.setText("0"+score+".");
                                else scoreText.setText(""+score+".");
                                submitButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if(name.getText().toString().trim().equals(""))
                                        {
                                            Toast.makeText(getApplicationContext(),"Please enter your name",Toast.LENGTH_SHORT).show();
                                        }
                                        else if(name.getText().toString().trim().length()>13)
                                        {
                                            Toast.makeText(getApplicationContext(),"Name is too large",Toast.LENGTH_SHORT).show();
                                        }
                                        else
                                        {
                                            editor.putString("13",name.getText().toString());
                                            editor.commit();
                                            index=0;
                                            Intent i=new Intent(getApplicationContext(),MainMenu.class);
                                            startActivity(i);
                                            overridePendingTransition(R.anim.fadeout1,R.anim.fadeout1);
                                            finish();
                                        }
                                    }
                                });

                                alertDialogBuilder.setView(mView);
                                alertDialogBuilder.setCancelable(false);
                                AlertDialog alertDialog=alertDialogBuilder.create();
                                alertDialog.show();




                            }
                        });
                    }

                };
                new Thread(mrunnable).start();


            }
        }
        val = sharedPreferences.getInt("4",0);
        if(val<=score && !suk&&score!=0)
        {
            Splash_screen.Rlayout=0;
            suk=true;
            if(val==-1)
            {
                editor.putInt("4",score);
                editor.putBoolean("9",true);

                final Runnable mrunnable =new Runnable()
                {
                    @Override
                    public void run() {

                        handler.post(new Runnable() {




                            public void run() {
                                AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(Second.this);
                                View mView =getLayoutInflater().inflate(R.layout.namecustomlayout,null);
                                TextView text1=mView.findViewById(R.id.sadText);
                                TextView scoreText=mView.findViewById(R.id.scoreText);
                                final EditText name=mView.findViewById(R.id.nameText);

                                Button submitButton =mView.findViewById(R.id.submitButton);
                                if(score<10)scoreText.setText("0"+score+".");
                                else scoreText.setText(""+score+".");
                                submitButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if(name.getText().toString().trim().equals(""))
                                        {
                                            Toast.makeText(getApplicationContext(),"Please enter your name",Toast.LENGTH_SHORT).show();
                                        }
                                        else if(name.getText().toString().trim().length()>13)
                                        {
                                            Toast.makeText(getApplicationContext(),"Name is too large",Toast.LENGTH_SHORT).show();
                                        }
                                        else
                                        {
                                            editor.putString("14",name.getText().toString());
                                            editor.commit();
                                            index=0;
                                            Intent i=new Intent(getApplicationContext(),MainMenu.class);
                                            startActivity(i);
                                            overridePendingTransition(R.anim.fadeout1,R.anim.fadeout1);
                                            finish();
                                        }
                                    }
                                });

                                alertDialogBuilder.setView(mView);
                                alertDialogBuilder.setCancelable(false);
                                AlertDialog alertDialog=alertDialogBuilder.create();
                                alertDialog.show();



                            }
                        });
                    }

                };
                new Thread(mrunnable).start();

            }
            else
            {
                val=sharedPreferences.getInt("4",0);
                if(val!=-1)
                {
                    editor.putInt("5",val);
                    editor.putString("15",sharedPreferences.getString("14",""));
                    editor.putBoolean("10",true);
                }
                editor.putInt("4",score);
                editor.putBoolean("9",true);

                final Runnable mrunnable =new Runnable()
                {
                    @Override
                    public void run() {

                        handler.post(new Runnable() {




                            public void run() {


                                AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(Second.this);
                                View mView =getLayoutInflater().inflate(R.layout.namecustomlayout,null);
                                TextView text1=mView.findViewById(R.id.sadText);
                                TextView scoreText=mView.findViewById(R.id.scoreText);
                                final EditText name=mView.findViewById(R.id.nameText);

                                Button submitButton =mView.findViewById(R.id.submitButton);
                                if(score<10)scoreText.setText("0"+score+".");
                                else scoreText.setText(""+score+".");
                                submitButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if(name.getText().toString().trim().equals(""))
                                        {
                                            Toast.makeText(getApplicationContext(),"Please enter your name",Toast.LENGTH_SHORT).show();
                                        }
                                        else if(name.getText().toString().trim().length()>13)
                                        {
                                            Toast.makeText(getApplicationContext(),"Name is too large",Toast.LENGTH_SHORT).show();
                                        }
                                        else
                                        {
                                            editor.putString("14",name.getText().toString());
                                            editor.commit();
                                            index=0;
                                            Intent i=new Intent(getApplicationContext(),MainMenu.class);
                                            startActivity(i);
                                            overridePendingTransition(R.anim.fadeout1,R.anim.fadeout1);
                                            finish();
                                        }
                                    }
                                });

                                alertDialogBuilder.setView(mView);
                                alertDialogBuilder.setCancelable(false);
                                AlertDialog alertDialog=alertDialogBuilder.create();
                                alertDialog.show();

                            }
                        });
                    }

                };
                new Thread(mrunnable).start();


            }
        }
        val = sharedPreferences.getInt("5",0);
        if(val<=score && !suk&&score!=0)
        {
            Splash_screen.Rlayout=0;
            suk=true;
            if(val==-1)
            {
                editor.putInt("5",score);
                editor.putBoolean("10",true);

                final Runnable mrunnable =new Runnable()
                {
                    @Override
                    public void run() {

                        handler.post(new Runnable() {




                            public void run() {
                                AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(Second.this);
                                View mView =getLayoutInflater().inflate(R.layout.namecustomlayout,null);
                                TextView text1=mView.findViewById(R.id.sadText);
                                TextView scoreText=mView.findViewById(R.id.scoreText);
                                final EditText name=mView.findViewById(R.id.nameText);

                                Button submitButton =mView.findViewById(R.id.submitButton);
                                if(score<10)scoreText.setText("0"+score+".");
                                else scoreText.setText(""+score+".");
                                submitButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if(name.getText().toString().trim().equals(""))
                                        {
                                            Toast.makeText(getApplicationContext(),"Please enter your name",Toast.LENGTH_SHORT).show();
                                        }
                                        else if(name.getText().toString().trim().length()>13)
                                        {
                                            Toast.makeText(getApplicationContext(),"Name is too large",Toast.LENGTH_SHORT).show();
                                        }
                                        else
                                        {
                                            editor.putString("15",name.getText().toString());
                                            editor.commit();
                                            index=0;
                                            Intent i=new Intent(getApplicationContext(),MainMenu.class);
                                            startActivity(i);
                                            overridePendingTransition(R.anim.fadeout1,R.anim.fadeout1);
                                            finish();
                                        }
                                    }
                                });

                                alertDialogBuilder.setView(mView);
                                alertDialogBuilder.setCancelable(false);
                                AlertDialog alertDialog=alertDialogBuilder.create();
                                alertDialog.show();




                            }
                        });
                    }

                };
                new Thread(mrunnable).start();

            }
            else
            {
                editor.putInt("5",score);
                editor.putBoolean("10",true);

                final Runnable mrunnable =new Runnable()
                {
                    @Override
                    public void run() {

                        handler.post(new Runnable() {




                            public void run() {
                                AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(Second.this);
                                View mView =getLayoutInflater().inflate(R.layout.namecustomlayout,null);
                                TextView text1=mView.findViewById(R.id.sadText);
                                TextView scoreText=mView.findViewById(R.id.scoreText);
                                final EditText name=mView.findViewById(R.id.nameText);

                                Button submitButton =mView.findViewById(R.id.submitButton);
                                if(score<10)scoreText.setText("0"+score+".");
                                else scoreText.setText(""+score+".");
                                submitButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if(name.getText().toString().trim().equals(""))
                                        {
                                            Toast.makeText(getApplicationContext(),"Please enter your name",Toast.LENGTH_SHORT).show();
                                        }
                                        else if(name.getText().toString().trim().length()>13)
                                        {
                                            Toast.makeText(getApplicationContext(),"Name is too large",Toast.LENGTH_SHORT).show();
                                        }
                                        else
                                        {
                                            editor.putString("15",name.getText().toString());
                                            editor.commit();
                                            index=0;
                                            Intent i=new Intent(getApplicationContext(),MainMenu.class);
                                            startActivity(i);
                                            overridePendingTransition(R.anim.fadeout1,R.anim.fadeout1);
                                            finish();
                                        }
                                    }
                                });

                                alertDialogBuilder.setView(mView);
                                alertDialogBuilder.setCancelable(false);
                                AlertDialog alertDialog=alertDialogBuilder.create();
                                alertDialog.show();




                            }
                        });
                    }

                };
                new Thread(mrunnable).start();
            }
        }
        if(!suk)
        {
            Splash_screen.Rlayout=0;
            final Runnable mrunnable =new Runnable()
            {
                @Override
                public void run() {

                    handler.post(new Runnable() {




                        public void run() {

                            AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(Second.this);
                            View mView =getLayoutInflater().inflate(R.layout.customalertdialog,null);
                            TextView text1=mView.findViewById(R.id.sadText);
                            TextView scoreText=mView.findViewById(R.id.scoreText);
                            TextView exit=mView.findViewById(R.id.exit);
                            Button noButton=mView.findViewById(R.id.noButton);
                            Button yesButton =mView.findViewById(R.id.yesButton);
                            if(score<10)scoreText.setText("0"+score+".");
                            else scoreText.setText(""+score+".");
                            yesButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent a = new Intent(Intent.ACTION_MAIN);
                                    a.addCategory(Intent.CATEGORY_HOME);
                                    a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(a);
                                    overridePendingTransition(R.anim.fadeout1,R.anim.fadeout1);
                                    index=0;
                                    finish();
                                }
                            });
                            noButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent=new Intent(getApplicationContext(),MainMenu.class);
                                    startActivity(intent);
                                    overridePendingTransition(R.anim.fadeout1,R.anim.fadeout1);
                                    index
                                            =0;
                                    finish();
                                }
                            });
                            alertDialogBuilder.setView(mView);
                            alertDialogBuilder.setCancelable(false);
                            AlertDialog alertDialog=alertDialogBuilder.create();
                            alertDialog.show();


                        }
                    });
                }

            };
            new Thread(mrunnable).start();

        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        f=true;
        mediaPlayer2.stop();
        backTrack=1;
        MainMenu.kuntaSelect=2;

        Splash_screen.Rlayout=1;

        Intent er=new Intent(Second.this,MainMenu.class);
        startActivity(er);
        overridePendingTransition(R.anim.shake,R.anim.fadeout1);
        finish();

    }
}
