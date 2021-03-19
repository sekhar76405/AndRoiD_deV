package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editText;
    public String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.start_btn);
        editText = (EditText) findViewById(R.id.edit_txt_name);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(editText.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(), "Please enter the name", Toast.LENGTH_SHORT).show();
                }
                else {
                    username = editText.getText().toString();
                    open_second_page();
                    Toast.makeText(getApplicationContext(),"Welcome",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    void open_second_page()
    {
        Intent intent = new Intent(this,Topics.class);
        startActivity(intent);
    }

}
