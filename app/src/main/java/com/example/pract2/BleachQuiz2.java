package com.example.pract2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.example.pract2.databinding.ActivityBleachQuiz2Binding;


public class BleachQuiz2 extends AppCompatActivity {
    private static final String TAG = "MyApp";
    static final int KEY = 2;
    ActivityBleachQuiz2Binding activityBleachQuizBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        activityBleachQuizBinding = ActivityBleachQuiz2Binding.inflate(getLayoutInflater());

        View view = activityBleachQuizBinding.getRoot();
        setContentView(view);

        activityBleachQuizBinding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BleachQuiz2.this, End.class);
                startActivity(intent);
                Log.i(TAG, "Выбран верный ответ");
                finish();
            }
        });
        activityBleachQuizBinding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BleachQuiz2.this, End2.class);
                startActivity(intent);
                intent.putExtra("countWrongAnsw", KEY);
                Log.w(TAG, "Выбран неверный ответ");
                finish();
            }
        });
        activityBleachQuizBinding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BleachQuiz2.this, End2.class);
                startActivity(intent);
                intent.putExtra("countWrongAnsw", KEY);
                Log.e(TAG, "Выбран неверный ответ");
                finish();
            }
        });
        activityBleachQuizBinding.button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BleachQuiz2.this, End2.class);
                startActivity(intent);
                intent.putExtra("countWrongAnsw", KEY);
                Log.e(TAG, "Выбран неверный ответ");
                finish();
            }
        });
    }

}
