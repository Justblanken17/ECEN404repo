package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class mcu1flowvgraphminutes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcu1flowvgraphminutes);
        Button buttonreferesh = (Button) findViewById(R.id.refreshmcu9);
        Button buttonback = (Button) findViewById(R.id.backmcu10);
        Button buttonseconds = (Button) findViewById(R.id.secondstab);
        Button buttonminutes = (Button) findViewById(R.id.minutestab);
        DatabaseReference rootDatabaserefmin = FirebaseDatabase.getInstance().getReference().child("MCU 1").child("Water Flow").child("Sensor 1");
        DatabaseReference rootDatabaserefmin2 = FirebaseDatabase.getInstance().getReference().child("MCU 1").child("Water Level").child("Sensor 2");
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
        buttonseconds.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
            @Override
            public void onClick(View view) {
                openActivityseconds();
            }
        });
        buttonminutes.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
            @Override
            public void onClick(View view) {
                openActivityrefresh();
            }
        });
        rootDatabaserefmin.addValueEventListener(new ValueEventListener() {
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
                int arraysize = 0;
                for(DataSnapshot snapshot1 : snapshot.getChildren())
                {
                    arraysize = arraysize + 1;
                }
                int[] time = new int[arraysize];
                double minutediv = arraysize/60;                ///////////
                double minutesdoub = Math.floor(minutediv);     ///////////
                int minutes = (int)minutesdoub;                 //////////
                int[] minutetime = new int[minutes];            //////////
                double[] concentration = new double[arraysize];
                double[] mintuteconcentration = new double[minutes]; //////
                int minutiterator = 0;      ///////
                double averagesum = 0;      ///////
                for(DataSnapshot snapshot1 : snapshot.getChildren())
                {
                    time[iterator] = Integer.parseInt(snapshot1.child("time").getValue().toString());
                    concentration[iterator] = Double.parseDouble(snapshot1.child("concentration").getValue().toString());
                    if((iterator+1)%60==0)                                        /////
                    {                                                             /////
                        minutetime[minutiterator] = minutiterator + 1;                ////
                        for(int i = (iterator-59); i< (iterator + 1); i++)        ////
                        {                                                         ////
                            averagesum = averagesum + concentration[i];           ////
                            ////
                        }                                                         ////
                        mintuteconcentration[minutiterator] = averagesum/60;      ////
                        averagesum = 0;
                        minutiterator = minutiterator + 1;////

                    }                                                             ////
                    iterator = iterator + 1;
                }

                t = time[0];
                c = concentration[0];
                //oxyg1.setText(String.valueOf(c));
                GraphView graph = (GraphView) findViewById(R.id.graph5);
                //GraphView graph2 = (GraphView) findViewById(R.id.graph);
                series = new LineGraphSeries<DataPoint>();
                double g = 0;
                String ge;
                DataPoint[] a = new DataPoint[minutes];  ///////

                //if(series.)
                for(int i = 0; i < minutes; i++) {                                      ////
                    //protected(series.resetData(new DataPoint[] {}));
                    a[i] = new DataPoint(minutetime[i], mintuteconcentration[i]);       ////

                    series.appendData(a[i], true, minutes + 3);    ////
                    //g = Double.parseDouble(String.valueOf(series.findDataPointAtX(time[i])));

                }
                //a[1] = new DataPoint(1, 15.2);
                //series.appendData(a[1], true, minutes + 3);
                //series = null;
                //series = new LineGraphSeries<DataPoint>(a);
                //ge = String.valueOf(series.findDataPointAtX(1));
                //cra.setText(ge);
                graph.setTitle("         Flow Sensor 1");
                graph.setTitleTextSize(25);
                graph.removeAllSeries();
                graph.addSeries(series);
                GridLabelRenderer griLa = graph.getGridLabelRenderer();
                LineGraphSeries lil = series;
                lil.setThickness(2);
                griLa.setHorizontalAxisTitle("              Minutes");
                griLa.setHorizontalAxisTitleTextSize(20);
                griLa.setVerticalAxisTitle("gpm");
                griLa.setLabelVerticalWidth(43);
                griLa.setLabelVerticalWidth(55);
                //griLa.setH;
                griLa.setVerticalAxisTitleTextSize(20);
                graph.getViewport().setXAxisBoundsManual(true);
                graph.getViewport().setMaxX(minutes + 1);

                //buttonreferesh.setText(String.valueOf(mintuteconcentration[0]));
                //graph.getViewport().set


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        rootDatabaserefmin2.addValueEventListener(new ValueEventListener() {
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
                int arraysize = 0;

                for(DataSnapshot snapshot1 : snapshot.getChildren())
                {
                    arraysize = arraysize + 1;
                }
                double minutediv = arraysize/60;                ///////////
                double minutesdoub = Math.floor(minutediv);     ///////////
                int minutes = (int)minutesdoub;                 //////////
                int[] minutetime = new int[minutes];            //////////
                int[] time = new int[arraysize];
                //int[] pertwentfive = new int[4];
                double[] concentration = new double[arraysize];
                double[] mintuteconcentration = new double[minutes]; //////
                int minutiterator = 0;      ///////
                double averagesum = 0;      ///////
                for(DataSnapshot snapshot1 : snapshot.getChildren())
                {
                    time[iterator] = Integer.parseInt(snapshot1.child("time").getValue().toString());
                    concentration[iterator] = Double.parseDouble(snapshot1.child("concentration").getValue().toString());
                    if((iterator+1)%60==0)                                        /////
                    {                                                             /////
                        minutetime[minutiterator] = minutiterator + 1;                ////
                        for(int i = (iterator-59); i< (iterator + 1); i++)        ////
                        {                                                         ////
                            averagesum = averagesum + concentration[i];           ////
                            ////
                        }                                                         ////
                        mintuteconcentration[minutiterator] = averagesum/60;      ////
                        averagesum = 0;
                        minutiterator = minutiterator + 1;////

                    }                                                             ////
                    iterator = iterator + 1;
                }

                t = time[0];
                c = concentration[0];
                //oxyg1.setText(String.valueOf(c));
                GraphView graph = (GraphView) findViewById(R.id.graph6);
                //GraphView graph2 = (GraphView) findViewById(R.id.graph);
                series = new LineGraphSeries<DataPoint>();
                double g = 0;
                String ge;
                DataPoint[] a = new DataPoint[minutes];  ///////

                //if(series.)
                for(int i = 0; i < minutes; i++) {                                      ////
                    //protected(series.resetData(new DataPoint[] {}));
                    a[i] = new DataPoint(minutetime[i], mintuteconcentration[i]);       ////

                    series.appendData(a[i], true, minutes + 3);    ////
                    //g = Double.parseDouble(String.valueOf(series.findDataPointAtX(time[i])));

                }


                //if(series.)

                //series = null;
                //series = new LineGraphSeries<DataPoint>(a);
                //ge = String.valueOf(series.findDataPointAtX(1));
                //cra.setText(ge);
                graph.setTitle("         Level Sensor 2");
                graph.setTitleTextSize(25);
                graph.removeAllSeries();
                graph.addSeries(series);
                LineGraphSeries lil = series;
                lil.setThickness(2);
                GridLabelRenderer griLa = graph.getGridLabelRenderer();
                griLa.setHorizontalAxisTitle("              Minutes");
                griLa.setLabelVerticalWidth(55);
                griLa.setHorizontalAxisTitleTextSize(20);
                griLa.setLabelVerticalWidth(43);
                griLa.setVerticalAxisTitle("inches");
                griLa.setVerticalAxisTitleTextSize(20);


                graph.getViewport().setXAxisBoundsManual(true);
                graph.getViewport().setMaxX(minutes+1);
                //buttonback.setText(String.valueOf(iterator));


            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    public void openActivityrefresh(){
        Intent intent = new Intent(this, mcu1flowvgraphminutes.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivitymain(){
        Intent intent = new Intent(this, mcu1flowv.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivityseconds(){
        Intent intent = new Intent(this, mcu1flowvgraph.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
}