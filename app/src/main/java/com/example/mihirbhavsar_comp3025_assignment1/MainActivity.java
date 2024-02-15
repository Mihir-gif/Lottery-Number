package com.example.mihirbhavsar_comp3025_assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // creating a Method here to generate random number between 0 and 500
    private void luckynumberGenerator(String personName) {
        Random random = new Random();
        int luckynum= random.nextInt(500);

        // Creating a Intent Here to start the ActivitySecond
        Intent intent = new Intent(MainActivity.this, ActivitySecond.class);
        intent.putExtra("personName", personName);
        intent.putExtra("luckyNum",luckynum);
        //Starting ActivitySecond
        startActivity(intent);
    }

    //Here Declaring the button and EditText Variables
    private EditText usernameInput;
    private Button luckyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Here Finding Views with their associated Id's

         usernameInput= findViewById(R.id.enterusername);
         luckyButton = findViewById(R.id.luckbutton);

        // Creating a click Listener for the luck Button

        luckyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // taking the person's name from editText
                String personName = usernameInput.getText().toString();
                //Calling the method here to create the lucky Number
                luckynumberGenerator(personName);
            }
        });
    }

}