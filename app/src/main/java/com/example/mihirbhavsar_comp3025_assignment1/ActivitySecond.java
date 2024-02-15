package com.example.mihirbhavsar_comp3025_assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySecond extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Calling the Intent To continue the activity
        Intent intent = getIntent();

        // Here Finding Views with their associated Id's

        TextView luckypersonName = findViewById(R.id.luckyPersonName);
        TextView luckyPersonNumber = findViewById(R.id.luckyPersonNumber);
        Button shareButton = findViewById(R.id.shareLuckyNumber);

        // Calling the person's name and lucky number from the declared Intent
        String personName = intent.getStringExtra("personName");
        int luckyNum = intent.getIntExtra("luckyNum", 0);

        // Set the views of Text and Number with Person's name and lucky number
        luckypersonName.setText(personName + "'s Lucky Number is :");
        luckyPersonNumber.setText(String.valueOf(luckyNum));

        // Add share button functionality

        Button buttonShare = findViewById(R.id.shareLuckyNumber);
        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               shareLuckyNumber(luckyNum);
                }
            });
    }
        private void shareLuckyNumber(int luckyNum){

        String shareMessage= "My Lucky Number is: " + luckyNum;

        // Creating Intent to share the message

        Intent shareIntent= new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
        shareIntent.setType("text/plain");
        // Creating chooser to share the message
        Intent sendIntent= Intent.createChooser(shareIntent,null);
        startActivity(sendIntent);
}
}