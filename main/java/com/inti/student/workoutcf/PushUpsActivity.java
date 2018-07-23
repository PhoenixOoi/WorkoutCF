package com.inti.student.workoutcf;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class PushUpsActivity extends AppCompatActivity {

    private static final long START_TIME_IN_MILLIS = 120000;

    private TextView mTextViewCountDown;
    private Button mPushUpsButtonStartPause;
    private Button mButtonReset;

    private CountDownTimer mCountDownTimer;

    private boolean mTimerRunning;

    private long mTimeLeftMillis = START_TIME_IN_MILLIS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_ups);

        mTextViewCountDown = findViewById(R.id.TextViewCountDown);
        mPushUpsButtonStartPause = (Button) findViewById(R.id.PushUpsButtonStartPause);
        mButtonReset = findViewById(R.id.button_reset);

        mPushUpsButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
        updateCountDownText();
    }
    public void HelpMenu(View view){
        Intent helpmenu = new Intent(this,DisplayPushUpsVid.class);
        startActivity(helpmenu);

    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftMillis = millisUntilFinished;
                updateCountDownText();

            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mPushUpsButtonStartPause.setText("Start");
                mTextViewCountDown.setText("00:00");
                Toast.makeText(PushUpsActivity.this, "Congratz, you have successfully completed the Push Ups workout!", Toast.LENGTH_LONG).show();
                mPushUpsButtonStartPause.setVisibility(View.INVISIBLE);
                mButtonReset.setVisibility(View.VISIBLE);
            }
        }.start();

        mTimerRunning = true;
        mPushUpsButtonStartPause.setText("Pause");
        mButtonReset.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mPushUpsButtonStartPause.setText("Start");
        mButtonReset.setVisibility(View.VISIBLE);
    }

    private void resetTimer() {
        mTimeLeftMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        mButtonReset.setVisibility(View.INVISIBLE);
        mPushUpsButtonStartPause.setVisibility((View.VISIBLE));
    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        mTextViewCountDown.setText(timeLeftFormatted);

    }
}
