package com.example.assignment3_quizapp_dhivya;

public class Questions  {
    int colorId;
    //questionId stores the list of questions
    int questionId;
    //answer will store the answers for the question provided
    boolean answer;

    public Questions(int colorId,int questionId,boolean answer) {
        this.questionId = questionId;
        this.colorId = colorId;
        this.answer= answer;
    }
    //returning the question passed
    public int getQuestionId()
    {return  questionId;}
    public int getColorId()
    {
        return colorId;
    }
    public void setColorId()
    {
        this.colorId = colorId;
    }
    public void setQuestionId()
    {
        this.questionId = questionId;
    }

    //returning the correctanswer of the question
    public boolean checkAnswer()
    {
        return answer;
    }

    //setting the correct answer to the question
    public void setAnswer(boolean answerTrue)
    {
        this.answer = answer;
    }

}
