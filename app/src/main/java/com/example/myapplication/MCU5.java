package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MCU5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcu5);
        Button button = (Button) findViewById(R.id.co2mcu5);
        Button co = (Button) findViewById(R.id.comcu5);
        Button ethy = (Button) findViewById(R.id.ethylenemcu5);
        Button methan = (Button) findViewById(R.id.mh4mcu5);
        Button oxy = (Button) findViewById(R.id.oxymcu5);
        Button flowv = (Button) findViewById(R.id.flowlevelmcu5);
        Button temphumid = (Button) findViewById(R.id.temphumidmcu5);
        Button buttonreferesh = (Button) findViewById(R.id.refreshmcu20);
        Button buttonback = (Button) findViewById(R.id.backmcu20);
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

    }
    public void openactivityco2(){
        Intent intent = new Intent(this, mcu5co2.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openactivityco(){
        Intent intent = new Intent(this, mcu5co.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openactivityethy(){
        Intent intent = new Intent(this, mcu5ethy.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openactivitymetha(){
        Intent intent = new Intent(this, mcu5meth.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openactivityoxy(){
        Intent intent = new Intent(this, mcu5oxy.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openactivityflowv(){
        Intent intent = new Intent(this, mcu5flowv.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openactivitytemphumid(){
        Intent intent = new Intent(this, mcu5temphumid.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivityrefresh(){
        Intent intent = new Intent(this, MCU5.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivitymain(){
        Intent intent = new Intent(this, MainActivity.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
}