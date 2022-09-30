package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class mcu1oxygengraph extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcu1oxygengraph);
        DatabaseReference rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("MCU 1").child("Oxygen").child("Sensor 1");
        rootDatabaseref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                LineGraphSeries<DataPoint> series;
                String data;// = snapshot.child();
                Double z;// = Double.parseDouble(data);
                // oxyg1.setText(S tring.valueOf(z));
                int t = 0;
                int iterator = 0;
                double c = 0;
                double y;
                int x;
                //x = -1;
                int[] time = new int[100];
                int[] pertwentfive = new int[4];
                double[] concentration = new double[100];
                for(DataSnapshot snapshot1 : snapshot.getChildren())
                {
                    time[iterator] = Integer.parseInt(snapshot1.child("time").getValue().toString());
                    concentration[iterator] = Double.parseDouble(snapshot1.child("concentration").getValue().toString());
                    iterator = iterator + 1;
                }
                int sumtf = 0;
                int quartcount = 0;
                for(int i = 0; i<100; i++)
                {
                    sumtf += time[i];
                    if((i+1)%25 == 0)
                    {
                        pertwentfive[quartcount] = sumtf/25;
                        quartcount += 1;
                        sumtf = 0;
                    }
                }
                t = time[0];
                c = concentration[0];
                //oxyg1.setText(String.valueOf(c));
                GraphView graph = (GraphView) findViewById(R.id.graph);
                GraphView graph2 = (GraphView) findViewById(R.id.graph);
                series = new LineGraphSeries<DataPoint>();
                for(int i = 0; i < 100; i++) {
                    series.appendData(new DataPoint(time[i], concentration[i]), true, 100);

                }
                graph.addSeries(series);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}