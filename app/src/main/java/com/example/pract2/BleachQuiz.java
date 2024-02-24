package com.example.pract2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.security.Key;

public class BleachQuiz extends AppCompatActivity {
    private static final String TAG = "MyApp";
    static final int KEY = 1;
    static final String ACCESS_MESSAGE="countWrongAnsw";

    static int accessMessage = 0;
    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent intent = result.getData();
                        accessMessage = intent.getIntExtra(ACCESS_MESSAGE, 0);
                        Log.i(TAG, "возврат" + accessMessage);
                    }
                    else Log.e(TAG, "net возвратa");
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bleach_quiz);
        final ImageButton button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BleachQuiz.this, BleachQuiz2.class);
                startActivity(intent);
                Log.i(TAG, "Выбран верный ответ");
                finish();
            }
        });
        final ImageButton button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BleachQuiz.this, End2.class);
                intent.putExtra("countWrongAnsw", KEY); //key==1
                startActivity(intent);
                mStartForResult.launch(intent);
                Log.i(TAG, "Выбран неверный ответ" + accessMessage);
                finish();

            }
        });
        final ImageButton button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BleachQuiz.this, End2.class);
                intent.putExtra("countWrongAnsw", KEY);
                startActivity(intent);
                mStartForResult.launch(intent);
                Log.i(TAG, "Выбран неверный ответ");
                finish();
            }
        });
    }
}