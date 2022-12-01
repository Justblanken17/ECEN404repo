package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
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

public class mcu1co2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mcu1co2);
        TextView Co21 = findViewById(R.id.CO21); //Utilizing a textbox
        TextView Co22 = findViewById(R.id.CO22);  //Utilizing a textbox
        TextView Co23 = findViewById(R.id.CO23);   //Utilizing a textbox
        TextView Co24 = findViewById(R.id.CO24);  //Utilizing a textbox
        //TextView warning = findViewById(R.id.testing);
        Button buttonreferesh = (Button) findViewById(R.id.refreshmcu1co2); //Utilizing a button
        Button buttonback = (Button) findViewById(R.id.backmcu1co2);        //Utilizing a button
        Button buttongraph = (Button) findViewById(R.id.graphmcuco2);       //Utilizing a button
        Button buttonhome = (Button) findViewById(R.id.homebutton);         //Utilizing a button
        //next 4 lines create reference that access information at a specific portion on the database
        DatabaseReference rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("MCU Test").child("Carbon Dioxide").child("1"); //("MCU Test").child("Carbon Dioxide").child("1");
        DatabaseReference rootDatabaseref2 = FirebaseDatabase.getInstance().getReference().child("MCU Test").child("Carbon Dioxide").child("1");
        DatabaseReference rootDatabaseref3 = FirebaseDatabase.getInstance().getReference().child("MCU 1").child("Carbon Dioxide").child("Sensor 3");
        DatabaseReference rootDatabaseref4 = FirebaseDatabase.getInstance().getReference().child("MCU 1").child("Carbon Dioxide").child("Sensor 4");
        //next 16 lines are for setting action to occur when button is pressed, this buttons direct to a speficed method
        buttonback.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
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
        buttongraph.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
            @Override
            public void onClick(View view) {
                openActivitygraph();
            }
        });
        buttonhome.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
            @Override
            public void onClick(View view) {
                openActivityhome();
            }
        });
        //.addValueEventlistener acts on changes detected in the specified portion of the database
        rootDatabaseref.addValueEventListener(new ValueEventListener() {
            //@SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) { //actions that occur on a datachange
                if((snapshot.getChildrenCount()== 0)) { //error handling; exits the program if the area accessed is empty
                    return;
                }
                int t = 0;
                int iterator = 0;
                double c = 0;

                double y;
                int x;
                x = -1;
                int arraysize = 0;
                for(DataSnapshot snapshot1 : snapshot.getChildren()) //iterating through list of data incase
                {
                    arraysize = arraysize + 1;
                }
                int[] time = new int[arraysize]; //used to iterate through second values, not necessary for this activity
                double[] concentration = new double[arraysize]; //array for list of conenctration values
                for(DataSnapshot snapshot1 : snapshot.getChildren())  //iterates through data, and puts concentration, second values in corresponding arrray
                {
                    time[iterator] = Integer.parseInt(snapshot1.child("7-Seconds").getValue().toString());//7-Seconds                 accessing info from seconds
                    concentration[iterator] = Double.parseDouble(snapshot1.child("1-Concentration").getValue().toString());//1-Concentration        accessing info from concentration
                    iterator = iterator + 1;
                }
                t = time[0];
                c = concentration[arraysize-1]; //gets value of most recent concentration value
                Co21.setText(String.valueOf(c)); //sets text to that value
                //String data = snapshot.getValue().toString();
                //double z = Double.parseDouble(data);
                //flowv1.setText(String.valueOf(z));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) { //function error handling

            }
        });
        //rootDatabaseref2-4.addValue do the same function
        rootDatabaseref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if((snapshot.getChildrenCount()== 0)) { //error handling; exits the program if the area accessed is empty
                    return;
                }
                //String data = snapshot.getValue().toString();
                //Double z = Double.parseDouble(data);
                //Co22.setText(String.valueOf(z));
                int t = 0;
                int iterator = 0;
                double c = 0;

                double y;
                int x;
                x = -1;
                int arraysize = 0;
                for(DataSnapshot snapshot1 : snapshot.getChildren())
                {
                    arraysize = arraysize + 1;
                }
                int[] time = new int[arraysize];
                double[] concentration = new double[arraysize];
                for(DataSnapshot snapshot1 : snapshot.getChildren())
                {
                    time[iterator] = Integer.parseInt(snapshot1.child("7-Seconds").getValue().toString());//7-Seconds time
                    concentration[iterator] = Double.parseDouble(snapshot1.child("1-Concentration").getValue().toString());//1-Concentration concentration
                    iterator = iterator + 1;
                }
                t = time[0];
                c = concentration[arraysize-1];
                Co22.setText(String.valueOf(c));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        rootDatabaseref3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //String data = snapshot.getValue().toString();
                //Double z = Double.parseDouble(data);
                //Co23.setText(String.valueOf(z));
                int t = 0;
                int iterator = 0;
                double c = 0;

                double y;
                int x;
                x = -1;
                int arraysize = 0;
                for(DataSnapshot snapshot1 : snapshot.getChildren())
                {
                    arraysize = arraysize + 1;
                }
                int[] time = new int[arraysize];
                double[] concentration = new double[arraysize];
                for(DataSnapshot snapshot1 : snapshot.getChildren())
                {
                    time[iterator] = Integer.parseInt(snapshot1.child("time").getValue().toString());
                    concentration[iterator] = Double.parseDouble(snapshot1.child("concentration").getValue().toString());
                    iterator = iterator + 1;
                }
                t = time[0];
                c = concentration[arraysize-1];
                Co23.setText(String.valueOf(c));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        rootDatabaseref4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //String data = snapshot.getValue().toString();
                //Double z = Double.parseDouble(data);
                //Co24.setText(String.valueOf(z));
                int t = 0;
                int iterator = 0;
                double c = 0;

                double y;
                int x;
                x = -1;
                int arraysize = 0;
                for(DataSnapshot snapshot1 : snapshot.getChildren())
                {
                    arraysize = arraysize + 1;
                }
                int[] time = new int[arraysize];
                double[] concentration = new double[arraysize];
                for(DataSnapshot snapshot1 : snapshot.getChildren())
                {
                    time[iterator] = Integer.parseInt(snapshot1.child("time").getValue().toString());
                    concentration[iterator] = Double.parseDouble(snapshot1.child("concentration").getValue().toString());
                    iterator = iterator + 1;
                }
                t = time[0];
                c = concentration[arraysize-1];
                Co24.setText(String.valueOf(c));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
    // opens mcu1co2 activity
    public void openActivityrefresh(){
        Intent intent = new Intent(this, mcu1co2.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }

    public void openActivitymain(){
        Intent intent = new Intent(this, Recycleviewtest.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivitygraph(){
        Intent intent = new Intent(this, mcu1co2graph.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivityhome(){
        Intent intent = new Intent(this, MainActivity.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
}