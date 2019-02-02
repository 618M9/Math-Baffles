package com.finalapplication;

import java.util.Arrays;

public class QuizLIbrary {
    public  int []arr=new int[25];
    QuizLIbrary(){
        Arrays.fill(arr,-1);
        arr[0]=R.drawable.ia;
        arr[1]=R.drawable.backabout;
        arr[2]=R.drawable.question4;
        arr[3]=R.drawable.image8;
        arr[4]=R.drawable.image6;
        arr[5]=R.drawable.image9;
        arr[6]=R.drawable.question2;
        arr[7]=R.drawable.image5;
        arr[8]=R.drawable.question1;
        arr[9]=R.drawable.ia;
        arr[10]=R.drawable.backabout;
arr[11]=R.drawable.question3;
        arr[12]=R.drawable.image8;
        arr[13]=R.drawable.image6;
        arr[14]=R.drawable.question5;
        arr[15]=R.drawable.image9;
        arr[16]=R.drawable.image5;
        arr[17]=R.drawable.question6;
        arr[18]=R.drawable.ia;
        arr[19]=R.drawable.question7;

    }
    public int getImage(int pos)
    {
        return arr[pos];
    }
    private String[] Qution_set_1 = {

            "1 , 1 = 11\n2 , 2 = 22\n3 , 3 = 33\n5 , 5 = ?",
            "1 , 2 = 3\n4 , 6 = 10\n7 , 12 = 19\n10 , 20 = ?",
            "",
            "3 , 5 = 2\n4 , 9 = 5\n6 , 12 = 6\n11 , 25 = ?"
            ,"1 , 2 = 2\n2 , 3 = 6\n3 , 3 = 9\n4 , 5 = ?",
            "4 , 2 = 2\n3 , 1 = 3\n6 , 3 = 2\n10 , 2 = ?",
            "",
            "2651 = 86\n3342 = 66\n9017 = 98\n6113 = ?",
            "",
            "143 = 31\n997 = 79\n366 = 63\n608 = ?",
            "2 = 3\n3 = 6\n4 = 10\n5 = ?",
            "",
            "2 = 4\n3 = 9\n5 = 25\n8 = ?",
            "1 , 2 = 3\n4 , 6 = 13\n7 , 12 = 32\n10 , 20 = ?",
            "",
            "1 = 1\n3 = 6\n5 = 120\n7 = ?",
            "176 = 127867\n402 = 450123\n833 = 893434\n562 = ?",
            "",
            "1 , 2 = 2\n2 , 4 = 16\n3 , 6 = 216\n4 , 8 = ?"
            ,""
    };
    private String[][] Choice_set_1 = {
            {"44", "66", "88", "55"},
                    {"10", "20", "30", "40"},
            {"5","6","7","8"},
                            {"14", "15", "16", "17"},
            {"10", "20", "30", "40"},
            {"2","3","4","5"},
            {"31","32","33","34"},
            {"84","74","83","73"},
            {"1","2","3","4"},
            {"86","80","68","70"},
            {"10","15","20","25"},
            {"11","12","13","14"},
            {"36","49","64","81"},
            {"59","60","61","62"},
            {"-3,-2","3,-2","2,-3","2,3"},
            {"3040","4050","5040","6025"},
            {"566723","567623","576623","652367"},
            {"23","24","25","26"},
            {"4076","4086","4096","5006"}
            ,{"11","12","13","14"}

                    };
    private String[] correctAns_1 =
            {
            "55", "30","7", "14","20","5","32","74","1","86","15","13","64","62","3,-2","5040","566723","26","4096","12"
    };
    public String getQuestion(int pos){
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


