package com.example.triviaadi;

import java.util.ArrayList;
import java.util.Collections;

public class Collection2 {
    private ArrayList<Question> arr;
    private int index;//מספר השאלה הבאה בתור
    public Collection2(){
        Question q1 = new Question("מהו 5 + 7?", "12", "13", "14", "15", 1); // התשובה הנכונה היא 12
        Question q2 = new Question("מהו 8 - 3?", "4", "5", "6", "7", 2); // התשובה הנכונה היא 5
        Question q3 = new Question("כמה הוא 6 * 7?", "38", "42", "44", "48", 2); // התשובה הנכונה היא 42
        Question q4 = new Question("מהו 12 / 4?", "3", "4", "2", "1", 1); // התשובה הנכונה היא 3
        Question q5 = new Question("מהו 9 + 10?", "18", "19", "20", "21", 2); // התשובה הנכונה היא 19

        arr=new ArrayList<>();
        arr.add(q1);
        arr.add(q2);
        arr.add(q3);
        arr.add(q4);
        arr.add(q5);

        Collections.shuffle(arr);
    }
    public void initQuestions()
    {
        index=0;
    }

    public Question getNextQuestion()
    {//הפעולה מחזירה הפניה לשאלה הבאה
        Question q=arr.get(index);
        index++;
        return q;
    }
    public boolean isNotLastOuestion()
    {
        //הפעולה מחזירה אמץ אם אנו בשאלה האחרונה
        return (index< arr.size());// אם לא בסוף בארייאט
    }
    public int getIndex()
    {
        return index;
    }
}
