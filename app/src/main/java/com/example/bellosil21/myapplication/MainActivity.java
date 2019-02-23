package com.example.bellosil21.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText text1;
    EditText text2;
    EditText text3;
    EditText text4;
    EditText text5;
    EditText text6;
    EditText text7;
    EditText text8;
    EditText text9;
    EditText text10;
    EditText text11;
    EditText text12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.editText);
        text2 = findViewById(R.id.editText2);
        text3 = findViewById(R.id.editText3);
        text4 = findViewById(R.id.editText4);
        text5 = findViewById(R.id.editText5);
        text6 = findViewById(R.id.editText6);
        text7 = findViewById(R.id.editText7);
        text8 = findViewById(R.id.editText8);
        text9 = findViewById(R.id.editText9);
        text10 = findViewById(R.id.editText10);
        text11 = findViewById(R.id.editText11);
        text12 = findViewById(R.id.editText12);

        Button runTest = findViewById(R.id.button);
            runTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        text1.setText("Clear");
        text2.setText("Clear");
        text3.setText("Clear");
        text4.setText("Clear");
        text5.setText("Clear");
        text6.setText("Clear");
        text7.setText("Clear");
        text8.setText("Clear");
        text9.setText("Clear");
        text10.setText("Clear");
        text11.setText("Clear");
        text12.setText("Clear");

    }
}
