package com.inti.student.workoutcf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BMIcalculator extends AppCompatActivity {
    private EditText height;
    private EditText weight;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculator);

        height = (EditText)findViewById(R.id.height);
        weight = (EditText)findViewById(R.id.weight);
        result = (TextView)findViewById(R.id.result);

    }
    public void calculateBMI(View v){
        String heightbox = height.getText().toString();
        String weightbox = weight.getText().toString();

        if(heightbox!= null && !"".equals(heightbox) && weightbox!=null && !"".equals(weightbox)){
            float heightValue=Float.parseFloat(heightbox)/100;
            float weightValue = Float.parseFloat(weightbox);

            float bmi = weightValue/(heightValue * heightValue);

            displayResult(bmi);
        }
    }
    private void displayResult(float bmi){
        String bmiResult = "";

        if (Float.compare(bmi,15f)<=0){
            bmiResult= getString(R.string.vsunderweight);
        }else if (Float.compare(bmi, 15f)>0 && Float.compare(bmi,16f)<=0){
            bmiResult=getString(R.string.sunderweight);
        }else if(Float.compare(bmi,16f)>0 && Float.compare(bmi,18.5f)<=0){
            bmiResult=getString(R.string.underweight);
        }else if (Float.compare(bmi,18.5f)>0 && Float.compare(bmi,25f)<=0){
            bmiResult=getString(R.string.normal);
        }else if(Float.compare(bmi,25f)>0 && Float.compare(bmi,30f)<=0){
            bmiResult=getString(R.string.overweight);
        }else if (Float.compare(bmi,30f)>0 && Float.compare(bmi,35f)<=0){
            bmiResult=getString(R.string.obese1);
        }else if (Float.compare(bmi,35f)>0 && Float.compare(bmi,40f)<=0){
            bmiResult=getString(R.string.obese2);
        }else{
            bmiResult=getString(R.string.obese3);
        }
        bmiResult=bmi+"\n\n"+bmiResult;
        result.setText(bmiResult);

    }
}
