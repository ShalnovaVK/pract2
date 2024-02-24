package com.example.pract2;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class End2 extends AppCompatActivity {
    private int count = 0;
    private int val = 0;
    private static final String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end2);
        final TextView textView = findViewById(R.id.textView1);
        Bundle arguments = getIntent().getExtras();

        count = arguments.getInt("countWrongAnsw");
        textView.setText("Количество неправильных ответов " + count );
        val ++;
        Intent rezintent = new Intent();
        rezintent.putExtra(BleachQuiz.ACCESS_MESSAGE, val);
        setResult(RESULT_OK, rezintent);


        Log.i(TAG, "возврат" + val );

        Button b_back = (Button)findViewById(R.id.b_back);
        b_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count == 1){
                        Intent intent = new Intent(End2.this, BleachQuiz.class);
                        startActivity(intent);
                        finish();
                }
                if (count == 0){
                    Intent intent = new Intent(End2.this, BleachQuiz2.class);
                    startActivity(intent);
                    finish();
                }
                }
            });
        }



    }