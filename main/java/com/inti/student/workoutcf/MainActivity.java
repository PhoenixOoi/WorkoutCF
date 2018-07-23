package com.inti.student.workoutcf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView mBMIcalculator;
    private ImageView mToDolist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MenuFragment menu = new MenuFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container,menu).commit();

        mBMIcalculator = findViewById(R.id.BMIcalculator);
        mBMIcalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calculate = new Intent (MainActivity.this, BMIcalculator.class);
                startActivity(calculate);
            }
        });

        mToDolist = findViewById(R.id.todoicon);
        mToDolist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ToDo = new Intent (MainActivity.this, ToDolist.class);
                startActivity(ToDo);
            }
        });


    }
}
