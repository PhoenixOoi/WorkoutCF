package com.inti.student.workoutcf;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.Time;
import java.util.Locale;

public class SquatsActivity extends AppCompatActivity {
    private static final long START_TIME_IN_MILLIS = 60000;

    private TextView mTextViewCountDown;
    private Button mSquatsButtonStartPause;
    private Button mButtonReset;

    private CountDownTimer mCountDownTimer;

    private boolean mTimerRunning;

    private long mTimeLeftMillis = START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squats);


        mTextViewCountDown = findViewById(R.id.TextViewCountDown);
        mSquatsButtonStartPause = (Button) findViewById(R.id.SquatsButtonStartPause);
        mButtonReset = findViewById(R.id.button_reset);


        mSquatsButtonStartPause.setOnClickListener(new View.OnClickListener() {
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
        Intent helpmenu = new Intent(this,DisplaySquatsVid.class);
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
                mSquatsButtonStartPause.setText("Start");
                mTextViewCountDown.setText("00:00");
                Toast.makeText(SquatsActivity.this,
                        "Congratz, you have successfully completed the Squats workout!",Toast.LENGTH_LONG).show();
                mSquatsButtonStartPause.setVisibility(View.INVISIBLE);
                mButtonReset.setVisibility(View.VISIBLE);
            }
        }.start();

        mTimerRunning = true;
        mSquatsButtonStartPause.setText("Pause");
        mButtonReset.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mSquatsButtonStartPause.setText("Start");
        mButtonReset.setVisibility(View.VISIBLE);
    }

    private void resetTimer() {
        mTimeLeftMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        mButtonReset.setVisibility(View.INVISIBLE);
        mSquatsButtonStartPause.setVisibility((View.VISIBLE));
    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        mTextViewCountDown.setText(timeLeftFormatted);

    }

}