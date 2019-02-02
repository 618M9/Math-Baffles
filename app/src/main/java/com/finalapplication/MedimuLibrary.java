package com.finalapplication;

import java.util.Arrays;

public class MedimuLibrary {
    public  int []arr=new int[25];
    MedimuLibrary(){
        Arrays.fill(arr,-1);
        arr[0]=R.drawable.question8;
        arr[1]=R.drawable.ia;
        arr[2]=R.drawable.question19;
        arr[3]=R.drawable.backabout;
        arr[4]=R.drawable.question18;
        arr[5]=R.drawable.image8;
        arr[6]=R.drawable.question9;
        arr[7]=R.drawable.image6;
        arr[8]=R.drawable.question21;
        arr[9]=R.drawable.image9;
        arr[10]=R.drawable.question26;
        arr[11]=R.drawable.image5;
        arr[12]=R.drawable.question10;
        arr[13]=R.drawable.ia;
        arr[14]=R.drawable.question23;
        arr[15]=R.drawable.backabout;
        arr[16]=R.drawable.question27;
        arr[17]=R.drawable.image8;
        arr[18]=R.drawable.question11;
        arr[19]=R.drawable.question28;
    }
    public int getImage(int pos)
    {
        return arr[pos];
    }
    private String[] Qution_set_1 = {
            "",
        "3 , 2 = 7\n4 , 5 = 24\n7 , 8 = 63\n9 , 10 = ?"
            ,""
            ,"4 , 2 = 4\n16 , 3 = 7\n36 , 4 = 10\n64 , 5 = ?"
            ,""
            ,"2 , 3 = 9\n3 , 5 = 20\n6 , 7 = 49\n8 , 10 = ?",
            ""
            ,"3 , 2 = 11\n4 , 5 = 21\n6 , 5 = 41\n7 , 6 = ?"
            ,""
            ,"8 = 13\n16 = 6\n4 = 19\n22 = ?"
            ,""
            ,"2 = 3\n6 = 4\n8 = 12\n24 = ?"
            ,""
            ,"3 + 3 * 3 - 3 + 3 = ?"
            ,""
            ,"3 , 2 , 4 = 10\n5 , 4 , 6 = 26\n6 , 5 , 7 = 37\n7 , 6 , 8 = ?"
            ,""
,"2 * 3 = 36\n3 * 4 = 144\n4 * 5 = 400\n5 * 6 = ?"
            ,""
            ,""
    };
    private String[][] Choice_set_1 = {
            {"1","2","3","4"},
            {"108","89","99","910"},
            {"16","15","3","2"},
            {"12","13","14","15"},
            {"42","52","62","72"},
            {"80","100","70","90"},
            {"6","7","8","9"},
            {"55","45","75","65"},
            {"23","33","43","53"},
            {"2","42","7","37"},
            {"104","114","124","134"},
            {"24","20","16","18"},
            {"20","30","40","50"},
            {"18","12","03","06"},
            {"1160","1260","1360","1460"},
            {"50","60","55","57"},
            {"102","103","104","105"},
            {"1900","1200","800","900"}
            ,{"18","19","20","21"}
            ,{"107","108","109","110"}

    };
    private String[] correctAns_1 =
            {
                "3","99","2","13","72","90","8","55","43","2","114","16","20","12","1260","50","104","900","18","108"
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
