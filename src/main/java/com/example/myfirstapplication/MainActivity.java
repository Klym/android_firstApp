package com.example.myfirstapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText firstEdit;
    private EditText secondEdit;
    private Button colorButton;
    private Button swapButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstEdit = (EditText) findViewById(R.id.editText);
        secondEdit = (EditText) findViewById(R.id.editText2);

        colorButton = (Button) findViewById(R.id.button);
        swapButton = (Button) findViewById(R.id.button2);

        colorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstEdit.getCurrentTextColor() == Color.BLACK) {
                    firstEdit.setTextColor(Color.RED);
                    secondEdit.setTextColor(Color.RED);
                } else {
                    firstEdit.setTextColor(Color.BLACK);
                    secondEdit.setTextColor(Color.BLACK);
                }
            }
        });

        swapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence tmp = firstEdit.getText();
                firstEdit.setText(secondEdit.getText());
                secondEdit.setText(tmp);
            }
        });
    }

    public void sendData(View view) {
        Intent intent = new Intent(this, GetValsActivity.class);
        intent.putExtra("Login", firstEdit.getText().toString());
        intent.putExtra("Pass", secondEdit.getText().toString());
        startActivity(intent);
    }
}
