package com.example.assignment3_quizapp_dhivya;

import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class QuestionBank   {
    ArrayList<Questions> Questionslist = new ArrayList<>(0);
    ArrayList<Integer> colorlist = new ArrayList<>(0);
    QuestionBank qbank;
    int i=0;
    public QuestionBank() {

        colorlist.add(R.color.Lime);
        colorlist.add(R.color.Aqua);
        colorlist.add(R.color.DodgerBlue);
        colorlist.add(R.color.Orange);
        colorlist.add(R.color.Purple);
        colorlist.add(R.color.CadetBlue);
        colorlist.add(R.color.MistyRose);
        colorlist.add(R.color.SlateBlue);
        colorlist.add(R.color.Chocolate);
        colorlist.add(R.color.Thistle);

        Questions q1 =new Questions(colorlist.get(0),R.string.quest1,true);
        Questions q2 =new Questions(colorlist.get(1),R.string.quest2,true);
        Questions q3 =new Questions(colorlist.get(2),R.string.quest3,true);
        Questions q4 =new Questions(colorlist.get(3),R.string.quest4,true);
        Questions q5 =new Questions(colorlist.get(4),R.string.quest5,true);
        Questions q6 =new Questions(colorlist.get(5),R.string.quest6,false);
        Questions q7 =new Questions(colorlist.get(6),R.string.quest7,false);
        Questions q8 =new Questions(colorlist.get(7),R.string.quest8,false);
        Questions q9 =new Questions(colorlist.get(8),R.string.quest9,false);
        Questions q10=new Questions(colorlist.get(9),R.string.quest10,false);

        //this.Questionslist = new ArrayList<>(3);
        Questionslist.add(q1);
        Questionslist.add(q2);
        Questionslist.add(q3);
        Questionslist.add(q4);
        Questionslist.add(q5);
        Questionslist.add(q6);
        Questionslist.add(q7);
        Questionslist.add(q8);
        Questionslist.add(q9);
        Questionslist.add(q10);

        Collections.shuffle(Questionslist);
        Collections.shuffle(colorlist);

        for (int i = 0; i < Questionslist.size();i++)
        {
            System.out.println(Questionslist.get(i));
        }

    }

    public boolean checkAnswer(boolean userselectCorrect){
       return true;
    }
 }
