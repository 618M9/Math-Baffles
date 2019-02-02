package com.finalapplication;

import java.util.Arrays;

public class HardLibrary
{
    public  int []arr=new int[25];
    HardLibrary(){
        Arrays.fill(arr,-1);
        arr[0]=R.drawable.question24;
        arr[1]=R.drawable.ia;
        arr[2]=R.drawable.question12;
        arr[3]=R.drawable.backabout;
        arr[4]=R.drawable.question22;
        arr[5]=R.drawable.image8;
        arr[6]=R.drawable.question13;
        arr[7]=R.drawable.image6;
        arr[8]=R.drawable.question14;
        arr[9]=R.drawable.image9;
        arr[10]=R.drawable.question15;
        arr[11]=R.drawable.image5;
        arr[12]=R.drawable.question16;
        arr[13]=R.drawable.question30;
        arr[14]=R.drawable.ia;
        arr[15]=R.drawable.question17;
        arr[16]=R.drawable.question29;
        arr[17]=R.drawable.backabout;
        arr[18]=R.drawable.question20;
        arr[19]=R.drawable.question25;
    }
    public int getImage(int pos)
    {
        return arr[pos];
    }
    private String[] Qution_set_1 =
            {
                    "",
                    "10 + 50 = 30\n50 + 30 = 40\n90 + 30 = 60\n80 + 60 = ?"
                    ,""
                    ,"2 , 3 , 5 , 7 , ?"
                    ,""
                    ,"1 + 2 = 3\n3 + 4 = 21\n5 + 6 =55\n4 + 5 = ?"
                    ,""
                    ,"2 + 3 = 8\n3 + 7 = 27\n4 + 5 = 32\n5 + 8 = ?",
                    "",
                    "3 , 16 , 42 , 81 , ?"
                    ,""
                    ,"2 ,1 = 1\n2 , 2 = 2\n2 , 3 = 5\n2 , 4 = 12\n2 , 6 = ?"
                    ,""
                    ,""
                    ,"6 , 28 , 496 , ?"
                    ,""
                    ,""
                    ,"1 , 2 , 3 = 2\n4 , 6 , 9 = 5\n7 , 12 , 20 = 13\n10 , 20 , 35 = ?"
                    ,""
                    ,""

    };
    private String[][] Choice_set_1 =

            {
                    {"30","40","50","60"},
            {"50","70","55","65"},
            {"12","13","14","15"},
            {"9","13","11","15"},
                    {"1","2","3","4"},
            {"36","46","56","66"},
            {"50","100","150","200"},
            {"50","60","70","80"},
            {"25","26","27","28"},
            {"130","131","132","133"},
            {"13","14","15","16"},
            {"48","45","58","55"},
            {"36","37","38","39"},
                    {"20","21","22","23"},
            {"8128","8228","8328","7028"},
            {"19","20","21","22"},
                    {"20","30","40","50"},
            {"20","30","25","35"},
            {"1","2","3","4"},
                    {"40","41","42","43"}

    };
    private String[] correctAns_1 =
            {
                "40","70","12","11","1","36","100","60","26","133","14","58","38","23","8128","20","40","25","3","41"
            };
    public String getQuestion(int pos)
    {
        return Qution_set_1[pos];
    }

    public String getChoice_1(int pos){
        return Choice_set_1[pos][0];
    }
    public String getChoice_2(int pos){
        return Choice_set_1[pos][1];
    }
    public String getChoice_3(int pos){
        return Choice_set_1[pos][2];
    }
    public String getChoice_4(int pos){
        return Choice_set_1[pos][3];
    }
    public String getCorrectAns(int pos){
        return correctAns_1[pos];
    }
    public String[] time=
            {
                    "00:15","00:15","00:15","00:15","00:15","00:30","00:20","00:45"
            };
    public String gettime(int pos)
    { return  time[pos];}
    private long[] timein={16,16,16,16,16,31,21,46};
    public long gettimein(int pos)
    {return timein[pos];}
}
