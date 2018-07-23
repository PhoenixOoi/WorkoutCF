package com.inti.student.workoutcf;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditDataActivity extends AppCompatActivity {

    private static final String TAG = "EditDataActivity";
    private Button btnSave,btnDelete;
    private EditText editable_item;

    DatabaseHelper mDatabaseHelper;

    private String selectedNotes;
    private int selectedID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);

        btnSave=(Button)findViewById(R.id.btnSave);
        btnDelete=(Button)findViewById(R.id.btnDelete);
        editable_item=(EditText)findViewById(R.id.editable_item);
        mDatabaseHelper = new DatabaseHelper(this);

        //get intent extra from the ListDataActivity
        Intent receivedIntent = getIntent();

        //now get the itemID we passed as an extra
        selectedID = receivedIntent.getIntExtra("id",-1);//-1 is just a default value

        //get the notes we passed as an extra
        selectedNotes = receivedIntent.getStringExtra("name");

        //set text to show the current selected notes
        editable_item.setText(selectedNotes);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = editable_item.getText().toString();
                if(!item.equals("")){
                    mDatabaseHelper.updateName(item,selectedID,selectedNotes);

                }else
                    toastMessage("You must enter a notes");
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabaseHelper.deleteName(selectedID,selectedNotes);
                editable_item.setText("");
                toastMessage("data removed from databased");
            }
        });
    }
    private void toastMessage(String message){
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
    }
}

