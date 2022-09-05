package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activityumcexpected extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityumcexpected);
        Button buttonback = (Button) findViewById(R.id.buttonbackexpecumc);
        buttonback.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
            @Override
            public void onClick(View view) {
                openActivityumcexpected();
            }

        });

    }
    public void openActivityumcexpected(){
        Intent intent = new Intent(this, ActivityUMC.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
}