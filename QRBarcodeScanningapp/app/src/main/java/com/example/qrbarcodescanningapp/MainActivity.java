package com.example.qrbarcodescanningapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

//we have included the dependency as (implementation 'com.journeyapps:zxing-android-embedded:4.1.0')
public class MainActivity extends AppCompatActivity  {

    private TextView textView;              //just created ref to the TextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.txtveiw);            //linking the xml object to the real java element
        Button button = (Button) findViewById(R.id.clear_btn);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},
                PackageManager.PERMISSION_GRANTED);    //asking the user to access camera(allow or deny)

        button.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textView.setText("Please Scan a Code.");
                    }
                }
                );

    }

    public void ScanButton(View view){          //we have defined this function to start onClicking the button(onSetClicklistener)
        IntentIntegrator intentIntegrator = new IntentIntegrator(this);   //predefined class in the library we used(see in dependencies the github project)
        intentIntegrator.initiateScan();        //initiated a scan
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {       //predefined
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);  //predefined
        if(intentResult != null)        //if we didnt get the results/ or scan could not happened
        {
            if(intentResult.getContents() == null)      //if no content in QR/BAR
            {
                textView.setText("No Data found.");
            }
            else{
                textView.setText(intentResult.getContents());           //display contents in intentResult
            }
        }
        else
        {
            textView.setText("Could not scan the code. Retry");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}