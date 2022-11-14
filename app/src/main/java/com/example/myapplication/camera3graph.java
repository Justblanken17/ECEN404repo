package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

public class camera3graph extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private int indication = 0;
    private int indication2 = 0;
    PointsGraphSeries<DataPoint> seriessupersecond;
    GraphView graphz;
    int arraysizesecondglobal1;
    //int max = 0;
    double max = 0;
    int second1max = 0;
    PointsGraphSeries<DataPoint> seriessuperminute1;
    int arraysizeglobalminute1;
    int arraysizeCHECKglobal;
    int minute1max = 0;
    PointsGraphSeries<DataPoint> seriesghour1;
    int arraysizeglobalhour1;
    int hour1max = 0;
    PointsGraphSeries<DataPoint> seriesgday1;
    int arraysizeglobalday1;
    int day1max = 0;
    PointsGraphSeries<DataPoint> seriesgweek1;
    int arraysizeglobalweek1;
    int week1max = 0;
    PointsGraphSeries<DataPoint> seriesgyear1;
    int arraysizeglobalyear1;
    int year1max = 0;
    LineGraphSeries<DataPoint> seriesgsecond2;
    int arraysizeglobalsecond2;
    int second2max = 0;
    LineGraphSeries<DataPoint> seriesgsuperminute2;
    int arraysizeglobalminute2;
    int minute2max = 0;
    LineGraphSeries<DataPoint> seriesghour2;
    int arraysizeglobalhour2;
    int hour2max = 0;
    LineGraphSeries<DataPoint> seriesgday2;
    int arraysizeglobalday2;
    int day2max = 0;
    LineGraphSeries<DataPoint> seriesgweek2;
    int arraysizeglobalweek2;
    int week2max = 0;
    LineGraphSeries<DataPoint> seriesgyear2;
    int arraysizeglobalyear2;
    int year2max = 0;
    LineGraphSeries<DataPoint> seriesgsecond3;
    int arraysizeglobalsecond3;
    int second3max = 0;
    LineGraphSeries<DataPoint> seriesgsuperminute3;
    int arraysizeglobalminute3;
    int minute3max = 0;
    LineGraphSeries<DataPoint> seriesghour3;
    int arraysizeglobalhour3;
    int hour3max = 0;
    LineGraphSeries<DataPoint> seriesgday3;
    int arraysizeglobalday3;
    int day3max = 0;
    LineGraphSeries<DataPoint> seriesgweek3;
    int arraysizeglobalweek3;
    int week3max = 0;
    LineGraphSeries<DataPoint> seriesgyear3;
    int arraysizeglobalyear3;
    int year3max = 0;
    LineGraphSeries<DataPoint> seriesgsecond4;
    int arraysizeglobalsecond4;
    int second4max = 0;
    LineGraphSeries<DataPoint> seriesgsuperminute4;
    int arraysizeglobalminute4;
    int minute4max = 0;
    LineGraphSeries<DataPoint> seriesghour4;
    int arraysizeglobalhour4;
    int hour4max = 0;
    LineGraphSeries<DataPoint> seriesgday4;
    int arraysizeglobalday4;
    int day4max = 0;
    LineGraphSeries<DataPoint> seriesgweek4;
    int arraysizeglobalweek4;
    int week4max = 0;
    LineGraphSeries<DataPoint> seriesgyear4;
    int arraysizeglobalyear4;
    int year4max;
    //GraphView graph1 = (GraphView) findViewById(R.id.graph);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        graphz = (GraphView) findViewById(R.id.graphth);
        setContentView(R.layout.activity_camera3graph);
        seriessupersecond = new PointsGraphSeries<DataPoint>();
        //bull[0] = new DataPoint(0, 0);
        //seriessupersecond.appendData(bull[0], true, 2);

        Button buttonreferesh = (Button) findViewById(R.id.refreshmcu9);
        Button buttonback = (Button) findViewById(R.id.backmcu10);
        //Button buttonseconds = (Button) findViewById(R.id.secondstab);
        //Button buttonminutes = (Button) findViewById(R.id.minutestab);

        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.period, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0,false);
        spinner.setOnItemSelectedListener(this);
        DatabaseReference rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("MCU 1").child("State").child("Camera 3");
        //DatabaseReference rootDatabaseref2 = FirebaseDatabase.getInstance().getReference().child("MCU 1").child("Water Level").child("Sensor 1");

        //DatabaseReference rootDatabaserefmin = FirebaseDatabase.getInstance().getReference().child("MCU 1").child("Carbon Dioxide").child("Sensor 1");
        //DatabaseReference rootDatabaserefmin2 = FirebaseDatabase.getInstance().getReference().child("MCU 1").child("Carbon Dioxide").child("Sensor 2");
        //DatabaseReference rootDatabaserefmin3 = FirebaseDatabase.getInstance().getReference().child("MCU 1").child("Carbon Dioxide").child("Sensor 3");
        //DatabaseReference rootDatabaserefmin4 = FirebaseDatabase.getInstance().getReference().child("MCU 1").child("Carbon Dioxide").child("Sensor 4");
        //DatabaseReference rootDatabaserefhour = FirebaseDatabase.getInstance().getReference().child("MCU 1").child("Carbon Dioxide").child("Sensor 1");
        //DatabaseReference rootDatabaserefhour2 = FirebaseDatabase.getInstance().getReference().child("MCU 1").child("Carbon Dioxide").child("Sensor 2");
        //DatabaseReference rootDatabaserefhour3 = FirebaseDatabase.getInstance().getReference().child("MCU 1").child("Carbon Dioxide").child("Sensor 3");
        //DatabaseReference rootDatabaserefhour4 = FirebaseDatabase.getInstance().getReference().child("MCU 1").child("Carbon Dioxide").child("Sensor 4");
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
        /*
        buttonseconds.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
            @Override
            public void onClick(View view) {
                openActivityrefresh();
            }
        }); */
        //buttonminutes.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
        //    @Override
        //    public void onClick(View view) {
        //        openActivityminutes();
        //    }
        //});
        rootDatabaseref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                PointsGraphSeries<DataPoint> series;
                PointsGraphSeries<DataPoint> seriesminutes;
                PointsGraphSeries<DataPoint> serieshours;
                PointsGraphSeries<DataPoint> seriesday;
                PointsGraphSeries<DataPoint> seriesweek;
                PointsGraphSeries<DataPoint> seriesyear;
                String data;// = snapshot.child();
                Double z;// = Double.parseDouble(data);
                // oxyg1.setText(S tring.valueOf(z));
                int t = 0;
                int iterator = 0;
                //double max = 0;
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
                double hourdiv = arraysize/3600;
                double daydiv = arraysize/43200;
                double weekdiv = arraysize/302400;
                double yeardiv = arraysize/15768000;

                double minutesdoub = Math.floor(minutediv);     ///////////
                double hoursdoub = Math.floor(hourdiv);     ///////////
                double daydouble = Math.floor(daydiv);
                double weekdouble = Math.floor(weekdiv);
                double yearsdouble = Math.floor(yeardiv);

                int minutes = (int)minutesdoub;
                int hours = (int)hoursdoub;                 //////////
                int days = (int)daydouble;
                int weeks = (int)weekdouble;
                int years = (int)yearsdouble;

                int[] minutetime = new int[minutes];
                int[] hourtime = new int[hours];            //////////
                int[] daytime = new int[days];
                int[] weektime = new int[weeks];
                int[] yeartime = new int[years];


                double[] concentration = new double[arraysize];
                double[] mintuteconcentration = new double[minutes]; //////
                double[] hourconcentration = new double[hours]; //////
                double[] dayconcenctration = new double[days];
                double[] weekconcenctration = new double[weeks];
                double[] yearsconcentration = new double[years];

                int minutiterator = 0;      ///////
                int houriterator = 0;      ///////
                int dayiterator = 0;
                int weekiterator = 0;
                int yeariterator = 0;

                double averagesum = 0;
                for(DataSnapshot snapshot1 : snapshot.getChildren())
                {

                    time[iterator] = Integer.parseInt(snapshot1.child("time").getValue().toString());
                    concentration[iterator] = Double.parseDouble(snapshot1.child("state").getValue().toString());
                    if(concentration[iterator] > max)
                    {
                        max = concentration[iterator];
                    }
                    if((iterator+1)%60==0)                                        /////
                    {                                                             /////
                        minutetime[minutiterator] = minutiterator;                ////
                        for(int i = (iterator-59); i< (iterator + 1); i++)        ////
                        {                                                         ////
                            averagesum = averagesum + concentration[i];           ////
                            ////
                        }                                                         ////
                        mintuteconcentration[minutiterator] = averagesum/60;      ////
                        averagesum = 0;
                        minutiterator = minutiterator + 1;////

                    }
                    if((iterator+1)%3600==0)                                        /////
                    {                                                             /////
                        hourtime[houriterator] = houriterator;                ////
                        for(int i = (iterator-3599); i< (iterator + 1); i++)        ////
                        {                                                         ////
                            averagesum = averagesum + concentration[i];           ////
                            ////
                        }                                                         ////
                        hourconcentration[houriterator] = averagesum/3600;      ////
                        averagesum = 0;
                        houriterator = houriterator + 1;////

                    }
                    if((iterator+1)%43200==0)                                        /////
                    {                                                             /////
                        daytime[dayiterator] = dayiterator;                ////
                        for(int i = (iterator-43199); i< (iterator + 1); i++)        ////
                        {                                                         ////
                            averagesum = averagesum + concentration[i];           ////
                            ////
                        }                                                         ////
                        dayconcenctration[dayiterator] = averagesum/43200;      ////
                        averagesum = 0;
                        dayiterator = dayiterator + 1;////

                    }
                    if((iterator+1)%302400==0)                                        /////
                    {                                                             /////
                        weektime[weekiterator] = weekiterator;                ////
                        for(int i = (iterator-302399); i< (iterator + 1); i++)        ////
                        {                                                         ////
                            averagesum = averagesum + concentration[i];           ////
                            ////
                        }                                                         ////
                        weekconcenctration[weekiterator] = averagesum/302400;      ////
                        averagesum = 0;
                        weekiterator = weekiterator + 1;////

                    }
                    if((iterator+1)%1576800==0)                                        /////
                    {                                                             /////
                        yeartime[yeariterator] = yeariterator;                ////
                        for(int i = (iterator-1576799); i< (iterator + 1); i++)        ////
                        {                                                         ////
                            averagesum = averagesum + concentration[i];           ////
                            ////
                        }                                                         ////
                        yearsconcentration[yeariterator] = averagesum/1576800;      ////
                        averagesum = 0;
                        yeariterator = yeariterator + 1;////

                    }

                    iterator = iterator + 1;
                }

                t = time[0];
                c = concentration[0];
                //oxyg1.setText(String.valueOf(c));
                GraphView graph = (GraphView) findViewById(R.id.graphth);
                //GraphView graph2 = (GraphView) findViewById(R.id.graph);
                series = new PointsGraphSeries<DataPoint>();
                seriesminutes = new PointsGraphSeries<DataPoint>();
                serieshours = new PointsGraphSeries<DataPoint>();
                double g = 0;
                String ge;
                DataPoint[] a = new DataPoint[arraysize];
                DataPoint[] aminutes = new DataPoint[minutes];
                for(int i = 0; i < minutes; i++) {                                      ////
                    //protected(series.resetData(new DataPoint[] {}));
                    aminutes[i] = new DataPoint(minutetime[i], mintuteconcentration[i]);       ////

                    seriesminutes.appendData(aminutes[i], true, minutes + 3);    ////
                    //g = Double.parseDouble(String.valueOf(series.findDataPointAtX(time[i])));

                }
                //if(series.)
                for(int i = 0; i < arraysize; i++) {
                    //protected(series.resetData(new DataPoint[] {}));
                    a[i] = new DataPoint(time[i], concentration[i]);
                    //graph.onDataChanged(true,true);
                    series.appendData(a[i], true, arraysize + 40);
                    //graph.onDataChanged(true,true);
                    //g = Double.parseDouble(String.valueOf(series.findDataPointAtX(time[i])));

                }
                DataPoint[] ahours = new DataPoint[hours];  ///////
                for(int i = 0; i < hours; i++) {                                      ////
                    //protected(series.resetData(new DataPoint[] {}));
                    ahours[i] = new DataPoint(hourtime[i], hourconcentration[i]);       ////

                    serieshours.appendData(ahours[i], true, hours + 3);    ////
                    //g = Double.parseDouble(String.valueOf(series.findDataPointAtX(time[i])));

                }


                seriesday = new PointsGraphSeries<DataPoint>();
                //double g = 0;
                //String ge;
                DataPoint[] aday= new DataPoint[days];  ///////

                //if(series.)
                for(int i = 0; i < days; i++) {                                      ////
                    //protected(series.resetData(new DataPoint[] {}));
                    aday[i] = new DataPoint(daytime[i], dayconcenctration[i]);       ////

                    seriesday.appendData(aday[i], true, days + 3);    ////
                    //g = Double.parseDouble(String.valueOf(series.findDataPointAtX(time[i])));

                }

                seriesweek = new PointsGraphSeries<DataPoint>();
                //double g = 0;
                //String ge;
                DataPoint[] aweek= new DataPoint[weeks];  ///////

                //if(series.)
                for(int i = 0; i < weeks; i++) {                                      ////
                    //protected(series.resetData(new DataPoint[] {}));
                    aweek[i] = new DataPoint(weektime[i], weekconcenctration[i]);       ////

                    seriesweek.appendData(aweek[i], true, weeks + 3);    ////
                    //g = Double.parseDouble(String.valueOf(series.findDataPointAtX(time[i])));

                }

                seriesyear = new PointsGraphSeries<DataPoint>();
                //double g = 0;
                //String ge;
                DataPoint[] ayear= new DataPoint[years];  ///////

                //if(series.)
                for(int i = 0; i < years; i++) {                                      ////
                    //protected(series.resetData(new DataPoint[] {}));
                    ayear[i] = new DataPoint(yeartime[i], yearsconcentration[i]);       ////

                    seriesyear.appendData(ayear[i], true, years + 3);    ////
                    graph.onDataChanged(true,true);

                    //g = Double.parseDouble(String.valueOf(series.findDataPointAtX(time[i])));

                }

                seriessupersecond = series;
                seriessuperminute1 = seriesminutes;
                seriesghour1 = serieshours;
                seriesgday1 = seriesday;
                seriesgweek1 = seriesweek;
                seriesgyear1 = seriesyear;
                arraysizeCHECKglobal = arraysize;
                arraysizesecondglobal1 = arraysize;
                arraysizeglobalminute1 = minutes;
                arraysizeglobalhour1 = hours;
                arraysizeglobalday1 = days;
                arraysizeglobalweek1 = weeks;
                arraysizeglobalyear1 = years;
                graph = (GraphView) findViewById(R.id.graphth);

                opentesting();



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    }
    public void openActivityrefresh(){
        Intent intent = new Intent(this, mcu1flowvgraph.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivitymain(){
        Intent intent = new Intent(this, mcu1flowv.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }

    public void openActivityminutes(){

        GraphView graph = (GraphView) findViewById(R.id.graphth);

        GraphView graph2 = (GraphView) findViewById(R.id.graph12th);

        Button buttonminutes = (Button) findViewById(R.id.minutestab);

        if(indication == 0)
        {
            graph.setTitle("        State");
            graph.setTitleTextSize(25);
            graph.removeAllSeries();
            seriessupersecond.setSize(2);
            graph.addSeries(seriessupersecond);
            GridLabelRenderer griLa = graph.getGridLabelRenderer();
            //PointsGraphSeries lil = seriessupersecond;
            //lil.setThickness(2);
            griLa.setHorizontalAxisTitle("              seconds");
            griLa.setHorizontalAxisTitleTextSize(20);
            griLa.setVerticalAxisTitle("state");
            griLa.setLabelVerticalWidth(43);
            griLa.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa.setVerticalAxisTitleTextSize(20);
            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setYAxisBoundsManual(true);
            graph.getGridLabelRenderer().setNumVerticalLabels(3);
            if(arraysizeCHECKglobal<60)
            {
                graph.getViewport().setMinX(0);
                graph.getViewport().setMaxX(60);
            }
            else
            {
                graph.getViewport().setMinX(arraysizeCHECKglobal-60);
                graph.getViewport().setMaxX(arraysizeCHECKglobal);
            }
            graph.getViewport().setMinY(0);
            graph.getViewport().setMaxY(max + .2*max);






        }
        if(indication == 1)
        {


            graph.setTitle("        State");
            graph.setTitleTextSize(25);
            graph.removeAllSeries();
            seriessuperminute1.setSize(2);
            graph.addSeries(seriessuperminute1);

            GridLabelRenderer griLa = graph.getGridLabelRenderer();
            //LineGraphSeries lil = seriessuperminute1;
            //lil.setThickness(2);
            griLa.setHorizontalAxisTitle("              minutes");
            griLa.setHorizontalAxisTitleTextSize(20);
            griLa.setVerticalAxisTitle("state");
            griLa.setLabelVerticalWidth(43);
            griLa.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa.setVerticalAxisTitleTextSize(20);
            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            if(arraysizeglobalminute1<10)
            {
                graph.getViewport().setMinX(0);
                graph.getViewport().setMaxX(10);
            }
            else
            {
                graph.getViewport().setMinX(arraysizeglobalminute1-10);
                graph.getViewport().setMaxX(arraysizeglobalminute1);
            }
            graph.getViewport().setMinY(0);
            graph.getViewport().setMaxY(max + .2*max);




        }
        else if(indication == 2)
        {
            graph.setTitle("        State");
            graph.setTitleTextSize(25);
            graph.removeAllSeries();
            seriesghour1.setSize(2);
            graph.addSeries(seriesghour1);
            GridLabelRenderer griLa = graph.getGridLabelRenderer();
            //LineGraphSeries lil = seriesghour1;
            //lil.setThickness(2);
            griLa.setHorizontalAxisTitle("              hours");
            griLa.setHorizontalAxisTitleTextSize(20);
            griLa.setVerticalAxisTitle("state");
            griLa.setLabelVerticalWidth(43);
            griLa.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa.setVerticalAxisTitleTextSize(20);
            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            if(arraysizeglobalhour1<10)
            {
                graph.getViewport().setMinX(0);
                graph.getViewport().setMaxX(10);
            }
            else
            {
                graph.getViewport().setMinX(arraysizeglobalhour1-10);
                graph.getViewport().setMaxX(arraysizeglobalhour1);
            }
            graph.getViewport().setMinY(0);
            graph.getViewport().setMaxY(max + .2*max);




        }
        else if(indication == 3)
        {
            graph.setTitle("        State");
            graph.setTitleTextSize(25);
            graph.removeAllSeries();
            seriesgday1.setSize(2);
            graph.addSeries(seriesgday1);
            GridLabelRenderer griLa = graph.getGridLabelRenderer();
            //LineGraphSeries lil = seriesgday1;
            //lil.setThickness(2);
            griLa.setHorizontalAxisTitle("              days");
            griLa.setHorizontalAxisTitleTextSize(20);
            griLa.setVerticalAxisTitle("state");
            griLa.setLabelVerticalWidth(43);
            griLa.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa.setVerticalAxisTitleTextSize(20);
            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            if(arraysizeglobalday1<10)
            {
                graph.getViewport().setMinX(0);
                graph.getViewport().setMaxX(10);
            }
            else
            {
                graph.getViewport().setMinX(arraysizeglobalday1-10);
                graph.getViewport().setMaxX(arraysizeglobalday1);
            }
            graph.getViewport().setMinY(0);
            graph.getViewport().setMaxY(max + .2*max);




        }
        else if(indication == 4)
        {
            graph.setTitle("        State");
            graph.setTitleTextSize(25);
            graph.removeAllSeries();
            seriesgweek1.setSize(2);
            graph.addSeries(seriesgweek1);
            GridLabelRenderer griLa = graph.getGridLabelRenderer();
            //LineGraphSeries lil = seriesgweek1;
            //lil.setThickness(2);
            griLa.setHorizontalAxisTitle("              weeks");
            griLa.setHorizontalAxisTitleTextSize(20);
            griLa.setVerticalAxisTitle("state");
            griLa.setLabelVerticalWidth(43);
            griLa.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa.setVerticalAxisTitleTextSize(20);
            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            if(arraysizeglobalweek1<10)
            {
                graph.getViewport().setMinX(0);
                graph.getViewport().setMaxX(10);
            }
            else
            {
                graph.getViewport().setMinX(arraysizeglobalweek1-10);
                graph.getViewport().setMaxX(arraysizeglobalweek1);
            }
            graph.getViewport().setMinY(0);
            graph.getViewport().setMaxY(max + .2*max);




        }
        else if(indication == 5)
        {
            graph.setTitle("        State");
            graph.setTitleTextSize(25);
            graph.removeAllSeries();
            seriesgyear1.setSize(2);
            graph.addSeries(seriesgyear1);

            GridLabelRenderer griLa = graph.getGridLabelRenderer();
            //LineGraphSeries lil = seriesgyear1;
            //lil.setThickness(2);
            griLa.setHorizontalAxisTitle("              years");
            griLa.setHorizontalAxisTitleTextSize(20);
            griLa.setVerticalAxisTitle("state");
            griLa.setLabelVerticalWidth(43);
            griLa.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa.setVerticalAxisTitleTextSize(20);
            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            if(arraysizeglobalyear1<3)
            {
                graph.getViewport().setMinX(0);
                graph.getViewport().setMaxX(3);
            }
            else
            {
                graph.getViewport().setMinX(arraysizeglobalyear1-3);
                graph.getViewport().setMaxX(arraysizeglobalyear1);
            }
            graph.getViewport().setMinY(0);
            graph.getViewport().setMaxY(max + .2*max);





        }

        //Intent intent = new Intent(this, mcu1co2graphminutes.class); //causes the subordinate activity file to be opened, redirects to new layout
        //startActivity(intent);
    }


    @Override

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //adapterView.setSelection(i);

        indication = i;
        openActivityminutes();
        //graph.setTitle(indication);
        //openActivityrefresh();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void indicator2(){
        indication2 = indication;
    }

    public void opentesting(){
        GraphView graph = (GraphView) findViewById(R.id.graphth);
        if(indication == 0)
        {
            graph.setTitle("        State");
            graph.setTitleTextSize(25);
            graph.removeAllSeries();
            seriessupersecond.setSize(2);
            graph.addSeries(seriessupersecond);
            GridLabelRenderer griLa = graph.getGridLabelRenderer();
            //LineGraphSeries lil = seriessupersecond;
            //lil.setThickness(2);
            griLa.setHorizontalAxisTitle("              seconds");
            griLa.setHorizontalAxisTitleTextSize(20);
            griLa.setVerticalAxisTitle("state");
            griLa.setLabelVerticalWidth(43);
            griLa.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa.setVerticalAxisTitleTextSize(20);
            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setYAxisBoundsManual(true);
            graph.getGridLabelRenderer().setNumVerticalLabels(3);
            if(arraysizeCHECKglobal<60)
            {
                graph.getViewport().setMinX(0);
                graph.getViewport().setMaxX(60);
            }
            else
            {
                graph.getViewport().setMinX(arraysizeCHECKglobal-60);
                graph.getViewport().setMaxX(arraysizeCHECKglobal);
            }
            graph.getViewport().setMinY(0);
            graph.getViewport().setMaxY(max + .2*max);




        }
        if(indication == 1)
        {


            graph.setTitle("        State");
            graph.setTitleTextSize(25);
            graph.removeAllSeries();
            seriessuperminute1.setSize(2);
            graph.addSeries(seriessuperminute1);

            GridLabelRenderer griLa = graph.getGridLabelRenderer();
            //LineGraphSeries lil = seriessuperminute1;
            //lil.setThickness(2);
            griLa.setHorizontalAxisTitle("              minutes");
            griLa.setHorizontalAxisTitleTextSize(20);
            griLa.setVerticalAxisTitle("state");
            griLa.setLabelVerticalWidth(43);
            griLa.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa.setVerticalAxisTitleTextSize(20);
            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            if(arraysizeglobalminute1<10)
            {
                graph.getViewport().setMinX(0);
                graph.getViewport().setMaxX(10);
            }
            else
            {
                graph.getViewport().setMinX(arraysizeglobalminute1-10);
                graph.getViewport().setMaxX(arraysizeglobalminute1);
            }
            graph.getViewport().setMinY(0);
            graph.getViewport().setMaxY(max + .2*max);


        }
        else if(indication == 2)
        {
            graph.setTitle("        State");
            graph.setTitleTextSize(25);
            graph.removeAllSeries();
            seriesghour1.setSize(2);
            graph.addSeries(seriesghour1);
            GridLabelRenderer griLa = graph.getGridLabelRenderer();
            //LineGraphSeries lil = seriesghour1;
            //lil.setThickness(2);
            griLa.setHorizontalAxisTitle("              hours");
            griLa.setHorizontalAxisTitleTextSize(20);
            griLa.setVerticalAxisTitle("state");
            griLa.setLabelVerticalWidth(43);
            griLa.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa.setVerticalAxisTitleTextSize(20);
            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            if(arraysizeglobalhour1<10)
            {
                graph.getViewport().setMinX(0);
                graph.getViewport().setMaxX(10);
            }
            else
            {
                graph.getViewport().setMinX(arraysizeglobalhour1-10);
                graph.getViewport().setMaxX(arraysizeglobalhour1);
            }
            graph.getViewport().setMinY(0);
            graph.getViewport().setMaxY(max + .2*max);


        }
        else if(indication == 3)
        {
            graph.setTitle("        State");
            graph.setTitleTextSize(25);
            graph.removeAllSeries();
            seriesgday1.setSize(2);
            graph.addSeries(seriesgday1);
            GridLabelRenderer griLa = graph.getGridLabelRenderer();
            //LineGraphSeries lil = seriesgday1;
            //lil.setThickness(2);
            griLa.setHorizontalAxisTitle("              days");
            griLa.setHorizontalAxisTitleTextSize(20);
            griLa.setVerticalAxisTitle("state");
            griLa.setLabelVerticalWidth(43);
            griLa.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa.setVerticalAxisTitleTextSize(20);
            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            if(arraysizeglobalday1<10)
            {
                graph.getViewport().setMinX(0);
                graph.getViewport().setMaxX(10);
            }
            else
            {
                graph.getViewport().setMinX(arraysizeglobalday1-10);
                graph.getViewport().setMaxX(arraysizeglobalday1);
            }
            graph.getViewport().setMinY(0);
            graph.getViewport().setMaxY(max + .2*max);


        }
        else if(indication == 4)
        {
            graph.setTitle("        State");
            graph.setTitleTextSize(25);
            graph.removeAllSeries();
            seriesgweek1.setSize(2);
            graph.addSeries(seriesgweek1);
            GridLabelRenderer griLa = graph.getGridLabelRenderer();
            //LineGraphSeries lil = seriesgweek1;
            //lil.setThickness(2);
            griLa.setHorizontalAxisTitle("              weeks");
            griLa.setHorizontalAxisTitleTextSize(20);
            griLa.setVerticalAxisTitle("state");
            griLa.setLabelVerticalWidth(43);
            griLa.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa.setVerticalAxisTitleTextSize(20);
            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            if(arraysizeglobalweek1<10)
            {
                graph.getViewport().setMinX(0);
                graph.getViewport().setMaxX(10);
            }
            else
            {
                graph.getViewport().setMinX(arraysizeglobalweek1-10);
                graph.getViewport().setMaxX(arraysizeglobalweek1);
            }
            graph.getViewport().setMinY(0);
            graph.getViewport().setMaxY(max + .2*max);


        }
        else if(indication == 5)
        {
            graph.setTitle("        State");
            graph.setTitleTextSize(25);
            graph.removeAllSeries();
            seriesgyear1.setSize(2);
            graph.addSeries(seriesgyear1);

            GridLabelRenderer griLa = graph.getGridLabelRenderer();
            //LineGraphSeries lil = seriesgyear1;
            //lil.setThickness(2);
            griLa.setHorizontalAxisTitle("              years");
            griLa.setHorizontalAxisTitleTextSize(20);
            griLa.setVerticalAxisTitle("state");
            griLa.setLabelVerticalWidth(43);
            griLa.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa.setVerticalAxisTitleTextSize(20);

            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            if(arraysizeglobalyear1<3)
            {
                graph.getViewport().setMinX(0);
                graph.getViewport().setMaxX(3);
            }
            else
            {
                graph.getViewport().setMinX(arraysizeglobalyear1-3);
                graph.getViewport().setMaxX(arraysizeglobalyear1);
            }
            graph.getViewport().setMinY(0);
            graph.getViewport().setMaxY(max + .2*max);



        }

    }
    public void opentesting2() {
        GraphView graph2 = (GraphView) findViewById(R.id.graph12th);

    }
}