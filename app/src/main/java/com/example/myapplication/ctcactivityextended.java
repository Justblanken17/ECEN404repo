package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ctcactivityextended extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ctcactivityextended);
        Button buttonback = (Button) findViewById(R.id.buttonbackactctc4);
        buttonback.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
            @Override
            public void onClick(View view) {
                openActivityctc();
            }

        });
    }
    public void openActivityctc(){
        Intent intent = new Intent(this, CTCActivity.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
}