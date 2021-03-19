package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Topics extends AppCompatActivity {
    private Button button1,button2,button3,button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);
        button1 = (Button) findViewById(R.id.kohli);
        button2 = (Button) findViewById(R.id.web_dev);
        button3 = (Button) findViewById(R.id.politics);
        button4 = (Button) findViewById(R.id.science);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open_questions_page();
            }
        });
    }
    void open_questions_page()
    {
        Intent intent = new Intent(this,QuestionActivity.class);
        startActivity(intent);
    }
}