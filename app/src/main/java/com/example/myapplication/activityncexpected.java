package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activityncexpected extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityncexpected);
        Button buttonback = (Button) findViewById(R.id.buttonbackexpecnc);
        buttonback.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
            @Override
            public void onClick(View view) {
                openActivityncback();
            }

        });

    }
    public void openActivityncback(){
        Intent intent = new Intent(this, ActivityNC.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
}