package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MCU3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcu3);
        Button button = (Button) findViewById(R.id.co2mcu6);
        Button co = (Button) findViewById(R.id.comcu6);
        Button ethy = (Button) findViewById(R.id.ethylenemcu6);
        Button methan = (Button) findViewById(R.id.mh4mcu6);
        Button oxy = (Button) findViewById(R.id.oxymcu3);
        Button flowv = (Button) findViewById(R.id.flowlevelmcu3);
        Button temphumid = (Button) findViewById(R.id.temphumidmcu3);
        Button buttonreferesh = (Button) findViewById(R.id.refreshmcu4);
        Button buttonback = (Button) findViewById(R.id.backmcu5);
        button.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
            @Override
            public void onClick(View view) {
                openactivityco2();
            }
        });
        co.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
            @Override
            public void onClick(View view) {
                openactivityco();
            }
        });
        ethy.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
            @Override
            public void onClick(View view) {
                openactivityethy();
            }
        });
        methan.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
            @Override
            public void onClick(View view) {
                openactivitymetha();
            }
        });
        oxy.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
            @Override
            public void onClick(View view) {
                openactivityoxy();
            }
        });

        flowv.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
            @Override
            public void onClick(View view) {
                openactivityflowv();
            }
        });
        temphumid.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
            @Override
            public void onClick(View view) {
                openactivitytemphumid();
            }
        });
        buttonback .setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
            @Override
            public void onClick(View view) {
                openActivitymain();
            }
        });
        buttonreferesh.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
            @Override
            public void onClick(View view) {
                openActivityrefresh();
            }
        });
        /*
        DatabaseReference rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("MCU 1").child("Carbon Dioxide");

        rootDatabaseref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    String data = snapshot.getValue().toString();
                    textView43.setText(data);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        */
    }
    public void openactivityco2(){
        Intent intent = new Intent(this, mcu3co2.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openactivityco(){
        Intent intent = new Intent(this, mcu3co.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openactivityethy(){
        Intent intent = new Intent(this, mcu3ethy.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openactivitymetha(){
        Intent intent = new Intent(this, mcu3metha.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openactivityoxy(){
        Intent intent = new Intent(this, mcu3oxy.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openactivityflowv(){
        Intent intent = new Intent(this, mcu3flowl.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openactivitytemphumid(){
        Intent intent = new Intent(this, mcu3temp.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivityrefresh(){
        Intent intent = new Intent(this, MCU3.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivitymain(){
        Intent intent = new Intent(this, MainActivity.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
}