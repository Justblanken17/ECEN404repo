package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class Recycleviewtest extends AppCompatActivity {
    private TextView textView43;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleviewtest);
        //textView43 = findViewById(R.id.textView49);
        Button button = (Button) findViewById(R.id.co2mcu1);
        Button co = (Button) findViewById(R.id.comcu1);
        Button ethy = (Button) findViewById(R.id.ethylenemcu1);
        Button methan = (Button) findViewById(R.id.mh4mcu1);
        Button oxy = (Button) findViewById(R.id.oxymcu1);
        Button flowv = (Button) findViewById(R.id.Flowlevelmcu1);
        Button temphumid = (Button) findViewById(R.id.temphumidmcu1);
        Button buttonreferesh = (Button) findViewById(R.id.refreshmcu);
        Button buttonback = (Button) findViewById(R.id.backmcu);
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
        Intent intent = new Intent(this, mcu1co2.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openactivityco(){
        Intent intent = new Intent(this, mcu1co.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openactivityethy(){
        Intent intent = new Intent(this, mcu1ethy.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openactivitymetha(){
        Intent intent = new Intent(this, mcu1methane.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openactivityoxy(){
        Intent intent = new Intent(this, mcu1oxygen.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openactivityflowv(){
        Intent intent = new Intent(this, mcu1flowv.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openactivitytemphumid(){
        Intent intent = new Intent(this, mcu1temphumid.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivityrefresh(){
        Intent intent = new Intent(this, Recycleviewtest.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivitymain(){
        Intent intent = new Intent(this, MainActivity.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
}