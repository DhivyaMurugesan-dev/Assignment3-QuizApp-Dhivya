package com.example.assignment3_quizapp_dhivya;

import android.app.Activity;
import android.content.Context;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StorageService {
    String filename = "QuizScoreAttempts.txt";
    public void saveTask(Activity context, Questions task){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = context.openFileOutput(filename, Context.MODE_APPEND);// open file and continue writing
            // I have to write byte array only
            // I have to convert task to string then to byte array
            fileOutputStream.write((task.toString()+ "$").getBytes());;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();// print all previous error
        }
        finally {
            // this will run if we have exception or not
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //file outputstream for writing to the file
    }

}
