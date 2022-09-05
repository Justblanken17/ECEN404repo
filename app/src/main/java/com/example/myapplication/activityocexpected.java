package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activityocexpected extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityocexpected);
        Button buttonback = (Button) findViewById(R.id.buttonbackactoc);
        buttonback.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
            @Override
            public void onClick(View view) {
                openActivityoc();
            }

        });
    }
    public void openActivityoc(){
        Intent intent = new Intent(this, ActivityOC.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
}