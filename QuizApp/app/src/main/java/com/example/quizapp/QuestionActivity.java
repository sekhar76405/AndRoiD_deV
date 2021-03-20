package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class QuestionActivity extends AppCompatActivity {
    private TextView textView;
    private Button button1,button2,button3,button4;
    private int key = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        textView = (TextView) findViewById(R.id.question);
        button1 = (Button) findViewById(R.id.a);
        button2 = (Button) findViewById(R.id.b);
        button3 = (Button) findViewById(R.id.c);
        button4 = (Button) findViewById(R.id.d);
    }
    public void receive_key(int key)
    {
        this.key = key;
    }
    
    void topic1()
    {

    }
}
