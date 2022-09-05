package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity2expected extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2expected);
        Button buttonback = (Button) findViewById(R.id.buttonbackact2);
        buttonback.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
            @Override
            public void onClick(View view) {
                openActivity2();
            }

        });
    }
    public void openActivity2(){
        Intent intent = new Intent(this, Activity2.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
}