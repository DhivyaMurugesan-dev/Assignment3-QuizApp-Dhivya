package com.example.assignment3_quizapp_dhivya;

import android.app.Activity;
import android.app.Application;

public class myApp extends Application {
    Activity appContext ;
    public StorageService storageService = new StorageService();
     QuestionBank qbank = new QuestionBank();
}
