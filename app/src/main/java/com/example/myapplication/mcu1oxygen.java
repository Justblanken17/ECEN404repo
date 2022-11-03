package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.firestore.auth.User;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class mcu1oxygen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcu1oxygen);
        TextView oxyg1 = findViewById(R.id.oxy9);
        TextView oxyg2 = findViewById(R.id.oxy2);
        TextView oxyg3 = findViewById(R.id.oxy3);
        TextView oxyg4 = findViewById(R.id.oxy4);
        Button buttonreferesh = (Button) findViewById(R.id.refreshmcu3);
        Button buttonback = (Button) findViewById(R.id.backmcu3);
        Button buttongraph = (Button) findViewById(R.id.graphmcu);
        Button buttonhome = (Button) findViewById(R.id.homebutton4);
        DatabaseReference rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("MCU 1").child("Oxygen").child("Sensor 1");
        DatabaseReference rootDatabaseref2 = FirebaseDatabase.getInstance().getReference().child("MCU 1").child("Oxygen").child("Sensor 2");
        DatabaseReference rootDatabaseref3 = FirebaseDatabase.getInstance().getReference().child("MCU 1").child("Oxygen").child("Sensor 3");
        DatabaseReference rootDatabaseref4 = FirebaseDatabase.getInstance().getReference().child("MCU 1").child("Oxygen").child("Sensor 4");
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
        rootDatabaseref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
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
                oxyg1.setText(String.valueOf(c));
                //GraphView graph = (GraphView) findViewById(R.id.graph1);
                //series = new LineGraphSeries<DataPoint>();
                //for(int i = 0; i < 100; i++) {
                //    series.appendData(new DataPoint(time[i], concentration[i]), true, 100);

                //}
                //graph.addSeries(series);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        rootDatabaseref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
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
                oxyg2.setText(String.valueOf(c));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        rootDatabaseref3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
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
                oxyg3.setText(String.valueOf(c));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        rootDatabaseref4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
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
                oxyg4.setText(String.valueOf(c));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void openActivityrefresh(){
        Intent intent = new Intent(this, mcu1oxygen.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivitymain(){
        Intent intent = new Intent(this, Recycleviewtest.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivitygraph(){
        Intent intent = new Intent(this, mcu1oxygengraph.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivityhome(){
        Intent intent = new Intent(this, MainActivity.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
}
