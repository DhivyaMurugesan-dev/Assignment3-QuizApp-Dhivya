package com.example.assignment3_quizapp_dhivya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int index = 0;
    int correct = 0;
    TextView quest_text;
    ProgressBar progress_bar;
    Button btn_true, btn_false;
    ImageButton previous_button, next_button;
    private int progressStatus = 0;
    private Handler handler = new Handler();

    QuestionBank questbank = new QuestionBank();
    // to keep current question track
    private int currentQuestionIndex = 0;
    //to display the result in dialog box
    //AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_true = findViewById(R.id.btn_true);
        btn_false = findViewById(R.id.btn_false);
        previous_button = findViewById(R.id.previous_button);
        next_button = findViewById(R.id.next_button);
        btn_true.setOnClickListener(this);
        btn_false.setOnClickListener(this);
        previous_button.setOnClickListener(this);
        next_button.setOnClickListener(this);
        //prevButton.setOnClickListener(this);
        //Check for the fragment container Framelayout
        updateFragment(questbank.Questionslist.get(index).getQuestionId(),
                questbank.colorlist.get(index));
        ProgressBar progress_bar = (ProgressBar) findViewById(R.id.progess_bar); // initiate the progress bar
        int maxValue = progress_bar.getMax(); // get maximum value of the progress bar
        progress_bar.setMax(100);

        // Start long running operation in a background thread
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 1;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            progress_bar.setProgress(progressStatus);

                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    //To create the options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.item_average: {
                //Get the total score divide by 10
               //int average = score /10;
                break;
            }
            case R.id.item_noofquestions:{
                //Todo list update new set of questions
            }
            case R.id.item_resetsaveresult:{
               //To reset all the saved activities.

            }
        }
        return true;
    }


    private void updateFragment(int questId, int colorId) {
        FragmentManager fragmentmanager = getSupportFragmentManager();
        FragmentTransaction fragmenttransaction = fragmentmanager.beginTransaction();

        fragmentmanager.findFragmentById(R.id.frame_layout);//connected to the framelayout name of the main activity
        QuizFragment quizfragment = new QuizFragment();
        //creating the fragment object
        QuizFragment quizfragmentobj = QuizFragment.newInstance(questId, colorId);
        //layout is connecting with the fragment class (name of the framelayout name) using the fragment object
        fragmentmanager.beginTransaction().add(R.id.frame_layout, quizfragmentobj).commit();
         fragmentmanager.beginTransaction().replace(R.id.framelayout2,quizfragmentobj).commit();
        // fragmenttransaction.replace(R.id.frame_container,quizfragment);



    }
//    public void updateQuestions(){
//      //  if((questbank.size()!=0){
//    questbank.Questionslist.get(index+1);
//        //Log.d("updated question list" ,+questbank.Questionslist.get(0));
//    }


    private void checkAnswer(boolean userChooseCorrect) {
        boolean answerIsTrue
                = questbank.Questionslist.get(index)
                .checkAnswer();
        // getting correct ans of current question
        int toastMessageId;
        // if ans matches with the
        // button clicked

        if (userChooseCorrect == answerIsTrue) {
            toastMessageId = R.string.correct_answer;
            correct++;
            int grade = correct * 1;

        } else {
            // showing toast
            // message correct
            toastMessageId = R.string.wrong_answer;
        }

        Toast
                .makeText(MainActivity.this, toastMessageId,
                        Toast.LENGTH_SHORT)
                .show();
    }

    public void onClick(View v) {
        // checking which button is
        // clicked by user
        // in this case user choose false
        switch (v.getId()) {
            case R.id.btn_false:
                checkAnswer(false);
                break;

            case R.id.btn_true:
                checkAnswer(true);
                break;
            case R.id.next_button:
                if (currentQuestionIndex < questbank.Questionslist.size()) {
                    currentQuestionIndex += 1;
                }
                // last question reached
                // making buttons
                // invisible
                if (currentQuestionIndex == 10) {
                    quest_text.setText(getString(
                            R.string.correct, correct));
                    next_button.setVisibility(
                            View.INVISIBLE);
                    previous_button.setVisibility(
                            View.INVISIBLE);
                    btn_true.setVisibility(
                            View.INVISIBLE);
                    btn_false.setVisibility(
                            View.INVISIBLE);
                    if (correct > 3)
                        quest_text.setText(
                                "SCORE OF THE QUIZ IS " + correct
                                        + " "
                                        + "OUT OF 10");
                        // showing correctness
//                    else {
//                      updateQuestions();
//                    }
                }
                break;
                case R.id.previous_button:
                if (currentQuestionIndex > 0) {
                    currentQuestionIndex
                            = (currentQuestionIndex - 1)
                            % questbank.Questionslist.size();
                   // updateQuestions();
                }
      }
        }


}

