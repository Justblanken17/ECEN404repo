package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.graphics.Color;
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

public class camera2graph extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
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
    PointsGraphSeries<DataPoint> seriesgsecond2;
    int arraysizeglobalsecond2;
    int second2max = 0;
    PointsGraphSeries<DataPoint> seriesgsuperminute2;
    int arraysizeglobalminute2;
    int minute2max = 0;
    PointsGraphSeries<DataPoint> seriesghour2;
    int arraysizeglobalhour2;
    int hour2max = 0;
    PointsGraphSeries<DataPoint> seriesgday2;
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
        setContentView(R.layout.activity_camera2graph);
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
        DatabaseReference rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("MCU Test").child("Camera States").child("State 2");
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
                if((snapshot.getChildrenCount()== 0)) {
                    return;
                }
                PointsGraphSeries<DataPoint> series;
                PointsGraphSeries<DataPoint> seriesminutes;
                PointsGraphSeries<DataPoint> serieshours;
                PointsGraphSeries<DataPoint> seriesday;
                PointsGraphSeries<DataPoint> seriesweek;
                PointsGraphSeries<DataPoint> seriesyear;

                PointsGraphSeries<DataPoint> seriesB;
                PointsGraphSeries<DataPoint> seriesminutesB;
                PointsGraphSeries<DataPoint> serieshoursB;
                PointsGraphSeries<DataPoint> seriesdayB;
                PointsGraphSeries<DataPoint> seriesweekB;
                PointsGraphSeries<DataPoint> seriesyearB;

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



                int parsetogetsizes = 0;

                int[] minutetimeB = new int[arraysize];
                int[] hourtimeB = new int[arraysize];            //////////
                int[] daytimeB = new int[arraysize];
                int[] monthtimeB = new int[arraysize];
                int[] yeartimeB = new int[arraysize];

                int[] secondwindow = new int[60];
                int[] minutewindow = new int[60];
                for(int i = 0; i < 60; i++)
                {
                    secondwindow[i] = -1;
                    minutewindow[i] = -1;
                }
                int[] hourwindow = new int[24];            //////////
                for(int i = 0; i < 24; i++)
                {
                    hourwindow[i] = -1;

                }
                int[] daywindow = new int[32];
                for(int i = 0; i < 32; i++)
                {
                    daywindow[i] = -1;

                }
                int[] monthwindow = new int[13];
                for(int i = 0; i < 13; i++)
                {
                    monthwindow[i] = -1;

                }
                int[] yearwindow = new int[10];
                for(int i = 0; i < 10; i++)
                {
                    yearwindow[i] = -1;

                }
                double [] secconcentrationAVG = new double[60];
                double[] mintuteconcentrationAVG = new double[60]; ////// hold average values for each unit
                double[] hourconcentrationAVG = new double[24]; ////// hold average
                double[] dayconcenctrationAVG = new double[32]; //
                double[] weekconcenctrationAVG = new double[13];
                double[] yearsconcentrationAVG = new double[10];
                int iteratorB = 0;
                int minutiteratorB = 0;      ///////
                int houriteratorB = 0;      ///////
                int dayiteratorB = 0;
                int weekiteratorB = 0;
                int yeariteratorB = 0;


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

                seriesB = new PointsGraphSeries<DataPoint>();
                seriesminutesB = new PointsGraphSeries<DataPoint>();
                serieshoursB = new PointsGraphSeries<DataPoint>();
                seriesdayB = new PointsGraphSeries<DataPoint>();
                seriesweekB = new PointsGraphSeries<DataPoint>();
                seriesyearB = new PointsGraphSeries<DataPoint>();

                DataPoint[] aseriesB= new DataPoint[60];
                DataPoint[] aseriesminutesB= new DataPoint[60];
                DataPoint[] aserieshoursB= new DataPoint[24];
                DataPoint[] aseriesdayB= new DataPoint[32];
                DataPoint[] aseriesweekB= new DataPoint[13];
                DataPoint[] aseriesyearB= new DataPoint[10];

                for(DataSnapshot snapshot1 : snapshot.getChildren())
                {
                    int secondssize = 0; //tells how much stuff is in a window
                    int minutessize = 0;
                    int hourssize = 0;
                    int dayssize = 0;
                    int monthssize = 0;
                    int yearssize = 0;

                    time[iterator] = Integer.parseInt(snapshot1.child("7-Seconds").getValue().toString());
                    concentration[iterator] = Double.parseDouble(snapshot1.child("1-Concentration").getValue().toString());
                    minutetimeB[iterator] = Integer.parseInt(snapshot1.child("6-Minute").getValue().toString());            //6-Minute
                    hourtimeB[iterator] = Integer.parseInt(snapshot1.child("5-Hour").getValue().toString());                //5-Hour
                    daytimeB[iterator] = Integer.parseInt(snapshot1.child("4-Day").getValue().toString());                  //4-Day
                    monthtimeB[iterator] = Integer.parseInt(snapshot1.child("3-Month").getValue().toString());              //3-Month
                    yeartimeB[iterator] = Integer.parseInt(snapshot1.child("2-Year").getValue().toString());

                    if(concentration[iterator] > max)
                    {
                        max = concentration[iterator];
                    }

                    //////////////////////////////////////////////
                    /////////////////////////////////////////////
                    for(int i = 0; i < 60; i++)
                    {
                        if(secondwindow[i] != -1)
                        {
                            secondssize = secondssize + 1;
                        }
                        if(minutewindow[i] != -1)
                        {
                            minutessize = minutessize + 1;
                        }
                    }

                    for(int i = 0; i < 24; i++)
                    {
                        if(hourwindow[i] != -1)
                        {
                            hourssize = hourssize + 1;
                        }

                    }

                    for(int i = 0; i < 32; i++)
                    {
                        if(daywindow[i] != -1)
                        {
                            dayssize = dayssize + 1;
                        }

                    }

                    for(int i = 0; i < 13; i++)
                    {
                        if(monthwindow[i] != -1 )
                        {
                            monthssize = monthssize + 1;
                        }
                    }

                    for(int i = 0; i < 10; i++)
                    {
                        if(yearwindow[i] != -1)
                        {
                            yearssize = yearssize + 1;
                        }

                    }
                    //controlling seconds and part of minutes arrays
                    if(iterator > 0) //checks if time index is 0
                    {
                        if(iterator>0) {//iterator > 0 &&
                            if ( minutetimeB[iterator - 1] != minutetimeB[iterator]) //makes sure last point was 59 and your higher then 0
                            {
                                secondwindow[time[iterator]] = time[iterator];
                                secconcentrationAVG[time[iterator]] = concentration[iterator];
                                //reset all other values
                                for (int i = 1; i < 60; i++) {
                                    secondwindow[i] = -1;
                                    secconcentrationAVG[i] = 0;
                                }
                                //seriesB.resetData(aserieshoursB);
                                minutewindow[minutetimeB[iterator]] = minutetimeB[iterator]; // minutetimeB[iterator-1]  iterator-1

                                secondwindow[time[iterator]] = time[iterator];
                                secconcentrationAVG[time[iterator]] = concentration[iterator];
                                if (secondssize < 60) {               //iterator - (secondssize)
                                    for (int i = iterator - (secondssize); i < iterator+1; i++)        ////ITERATOR+1
                                    {                                                         ////

                                        averagesum = averagesum + concentration[i];           ////
                                        ////
                                        //buttonreferesh.setText(String.valueOf(secondssize));
                                    }
                                    mintuteconcentrationAVG[minutetimeB[iterator]] = concentration[iterator]; //iterator-1
                                    averagesum = 0;
                                    //buttonreferesh.setText(String.valueOf(mintuteconcentrationAVG[0]));
                                    //minutiteratorB = minutiteratorB + 1;


                                } else {
                                    for (int i = iterator - (secondssize); i < iterator+1; i++)        ////ITERATOR+1
                                    {                                                         ////

                                        averagesum = averagesum + concentration[i];           ////
                                        ////
                                        //buttonreferesh.setText(String.valueOf(secondssize));
                                    }
                                    mintuteconcentrationAVG[minutetimeB[iterator]] = averagesum / 60; //iterator-1
                                    mintuteconcentrationAVG[minutetimeB[iterator]] = concentration[iterator];
                                    averagesum = 0;
                                    //buttonreferesh.setText(String.valueOf(mintuteconcentrationAVG[0]));
                                }
                            }
                            else
                            {
                                secondwindow[time[iterator]] = time[iterator];
                                secconcentrationAVG[time[iterator]] = concentration[iterator];
                                for(int i = iterator - (secondssize); i< iterator+1 ; i++)        ////
                                {                                                         ////

                                    averagesum = averagesum + concentration[i];           ////
                                    ////
                                    //buttonreferesh.setText(String.valueOf(secondssize));j
                                }
                                minutewindow[minutetimeB[iterator]] = minutetimeB[iterator];
                                mintuteconcentrationAVG[minutetimeB[iterator]] = averagesum/(secondssize + 1);
                                //mintuteconcentrationAVG[23]
                                averagesum = 0;
                                //buttonback.setText(String.valueOf(mintuteconcentrationAVG[0]));//mintuteconcentrationAVG[23] FFFFF
                            }

                        }
                        //ENDING STUFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF
                        //end of checking if you passed the iteration
                        else
                        {
                            secondwindow[time[iterator]] = time[iterator];
                            secconcentrationAVG[time[iterator]] = concentration[iterator];
                            for(int i = iterator - (secondssize); i< iterator+1 ; i++)        ////ITERATOR+1
                            {                                                         ////

                                averagesum = averagesum + concentration[i];           ////
                                ////
                                //buttonreferesh.setText(String.valueOf(secondssize));j
                            }
                            minutewindow[minutetimeB[iterator]] = minutetimeB[iterator];
                            mintuteconcentrationAVG[minutetimeB[iterator]] = averagesum/(secondssize + 1);

                            //buttonback.setText(String.valueOf(secondssize)); //mintuteconcentrationAVG[23]
                            averagesum = 0;
                            //buttonback.setText(String.valueOf(mintuteconcentrationAVG[0]));
                        }
                    }
                    else
                    {
                        secondwindow[time[iterator]] = time[iterator];
                        secconcentrationAVG[time[iterator]] = concentration[iterator];
                        for(int i = iterator - (secondssize); i< iterator+1 ; i++)        ////
                        {                                                         ////

                            averagesum = averagesum + concentration[i];           ////
                            ////
                            //buttonreferesh.setText(String.valueOf(secondssize));j
                        }
                        minutewindow[minutetimeB[iterator]] = minutetimeB[iterator];
                        mintuteconcentrationAVG[minutetimeB[iterator]] = averagesum/(secondssize + 1);
                        //mintuteconcentrationAVG[23]
                        averagesum = 0;
                        //buttonback.setText(String.valueOf(mintuteconcentrationAVG[0]));//mintuteconcentrationAVG[23] FFFFF
                    }
                    //buttonback.setText(String.valueOf(mintuteconcentrationAVG[0]));
                    //buttonback.setText(String.valueOf(mintuteconcentrationAVG[0]));
                    //buttonreferesh.setText(String.valueOf(mintuteconcentrationAVG[59]));
                    ///////////////CHANGE  TO MINUTES/HOURS

                    if(minutetimeB[iterator] == 0) //checks if time index is 0
                    {
                        if(iterator>0) {//iterator > 0 &&
                            if ( minutetimeB[iterator - 1] == 59) //makes sure last point was 59 and your higher then 0
                            {
                                //minutewindow[minutetimeB[iterator]] = minutetimeB[iterator];
                                //mintuteconcentrationAVG[minutetimeB[iterator]] = concentration[iterator]; //get back over here
                                //reset all other values

                                //seriesB.resetData(aserieshoursB);
                                hourwindow[hourtimeB[iterator-1]] = hourtimeB[iterator-1]; // minutetimeB[iterator-1]  iterator-1
                                hourwindow[hourtimeB[iterator]] = hourtimeB[iterator];          ///ERROR
                                hourconcentrationAVG[hourtimeB[iterator]] = concentration[iterator];//ERROR

                                if (minutessize < 60) {               //iterator - (secondssize)
                                    for (int i = 60 - (minutessize); i < 60; i++)        ////
                                    {                                                         ////

                                        averagesum = averagesum + mintuteconcentrationAVG[i];           ///////BOOK MARK!
                                        ////
                                        //buttonreferesh.setText(String.valueOf(secondssize));
                                    }
                                    for (int i = 1; i < 60; i++) {
                                        minutewindow[i] = -1;
                                        mintuteconcentrationAVG[i] = 0;
                                    }
                                    if(minutessize == 0)                                               /////////
                                    {
                                        hourconcentrationAVG[hourtimeB[iterator-1]] = averagesum;     /////////////
                                    }
                                    else {
                                        hourconcentrationAVG[hourtimeB[iterator - 1]] = averagesum / minutessize; //iterator-1
                                    }
                                    averagesum = 0;
                                    //buttonreferesh.setText(String.valueOf(hourconcentrationAVG[12])); THIS ONE FIXS IT
                                    //buttonreferesh.setText(String.valueOf(mintuteconcentrationAVG[22]));
                                    //buttonreferesh.setText(String.valueOf(iterator));
                                    //minutiteratorB = minutiteratorB + 1;


                                } else {
                                    for (int i = 0; i < 60; i++)        ////
                                    {                                                         ////

                                        averagesum = averagesum + mintuteconcentrationAVG[i];           ////
                                        ////
                                        //buttonreferesh.setText(String.valueOf(secondssize));
                                    }
                                    hourconcentrationAVG[hourtimeB[iterator-1]] = averagesum / 60; //iterator-1

                                    averagesum = 0;
                                    //buttonreferesh.setText(String.valueOf(mintuteconcentrationAVG[22]));
                                }
                            }
                            else
                            {
                                for(int i = 0; i < 60; i++)        ////60 - (minutessize)    60
                                {                                                         ////

                                    averagesum = averagesum + mintuteconcentrationAVG[i];           ////
                                    ////
                                    //buttonreferesh.setText(String.valueOf(secondssize));j
                                }
                                hourwindow[hourtimeB[iterator]] = hourtimeB[iterator];
                                if(minutessize == 0)                                               /////////
                                {
                                    hourconcentrationAVG[hourtimeB[iterator]] = averagesum;     /////////////
                                }
                                else {
                                    hourconcentrationAVG[hourtimeB[iterator]] = averagesum / minutessize;
                                }
                                //buttonreferesh.setText(String.valueOf(mintuteconcentrationAVG[0]));
                                //buttonback.setText(String.valueOf(secondssize)); //mintuteconcentrationAVG[23]
                                averagesum = 0;

                            }
                        }

                        //ENDING STUFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF
                        //end of checking if you passed the iteration
                        else
                        {

                            for(int i = 0; i < 60; i++)        ////////60 - (minutessize)    60
                            {                                                         ////

                                averagesum = averagesum + mintuteconcentrationAVG[i];           ////
                                ////
                                //buttonreferesh.setText(String.valueOf(secondssize));j
                            }
                            hourwindow[hourtimeB[iterator]] = hourtimeB[iterator];
                            if(minutessize == 0)                                               /////////
                            {
                                hourconcentrationAVG[hourtimeB[iterator]] = averagesum;     /////////////
                            }
                            else {
                                hourconcentrationAVG[hourtimeB[iterator]] = averagesum / minutessize;
                            }
                            //buttonback.setText(String.valueOf(secondssize)); //mintuteconcentrationAVG[23]
                            averagesum = 0;

                            //buttonback.setText(String.valueOf(mintuteconcentrationAVG[23]));
                        }
                    }
                    ///////////////CHANGE  TO MINUTES/HOURS

                    else
                    {
                        //secondwindow[time[iterator]] = time[iterator];
                        //secconcentrationAVG[time[iterator]] = concentration[iterator];
                        for(int i = 0; i < 60; i++)        ////
                        {                                                         ////

                            averagesum = averagesum + mintuteconcentrationAVG[i];           ////
                            ////
                            //buttonreferesh.setText(String.valueOf(secondssize));
                        }
                        hourwindow[hourtimeB[iterator]] = hourtimeB[iterator];
                        if(minutessize == 0)                                               /////////
                        {
                            hourconcentrationAVG[hourtimeB[iterator]] = averagesum;     /////////////
                        }
                        else {
                            hourconcentrationAVG[hourtimeB[iterator]] = averagesum / minutessize;
                        }
                        //buttonreferesh.setText(String.valueOf(hourconcentrationAVG[11]));
                        //buttonback.setText(String.valueOf(mintuteconcentrationAVG[23])); //mintuteconcentrationAVG[23]
                        averagesum = 0;
                        //buttonreferesh.setText(String.valueOf(iterator));
                        //buttonback.setText(String.valueOf(hourconcentrationAVG[11]));
                    }
                    //buttonreferesh.setText(String.valueOf(iterator));
                    //buttonreferesh.setText(String.valueOf(mintuteconcentrationAVG[0]));
                    //buttonback.setText(String.valueOf(hourconcentrationAVG[11]));
                    //buttonreferesh.setText(String.valueOf(hourconcentrationAVG[12]));
                    //////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////Hours/Days
                    if(hourtimeB[iterator] == 0) //checks if time index is 0
                    {
                        if(iterator>0) {//iterator > 0 &&
                            if ( hourtimeB[iterator - 1] == 23) //makes sure last point was 59 and your higher then 0
                            {
                                //minutewindow[minutetimeB[iterator]] = minutetimeB[iterator];
                                //mintuteconcentrationAVG[minutetimeB[iterator]] = concentration[iterator]; //get back over here
                                //reset all other values

                                //seriesB.resetData(aserieshoursB);
                                daywindow[daytimeB[iterator-1]] = daytimeB[iterator-1]; // minutetimeB[iterator-1]  iterator-1
                                daywindow[daytimeB[iterator]] = daytimeB[iterator];
                                dayconcenctrationAVG[daytimeB[iterator]] = concentration[iterator];
                                //GO BACK
                                if (hourssize < 24) {               //iterator - (secondssize)
                                    for (int i = 24 - (hourssize); i < 24; i++)        ////
                                    {                                                         ////

                                        averagesum = averagesum + hourconcentrationAVG[i];           ///////BOOK MARK!
                                        ////
                                        //buttonreferesh.setText(String.valueOf(secondssize));
                                    }
                                    for (int i = 1; i < 24; i++) {
                                        hourwindow[i] = -1;
                                        hourconcentrationAVG[i] = 0;
                                    }
                                    if(hourssize == 0)                                               /////////
                                    {
                                        dayconcenctrationAVG[daytimeB[iterator-1]] = averagesum;     /////////////
                                    }
                                    else {
                                        dayconcenctrationAVG[daytimeB[iterator - 1]] = averagesum / hourssize; //iterator-1
                                    }
                                    averagesum = 0;
                                    //buttonreferesh.setText(String.valueOf(hourconcentrationAVG[12])); THIS ONE FIXS IT
                                    //buttonreferesh.setText(String.valueOf(mintuteconcentrationAVG[22]));
                                    //buttonreferesh.setText(String.valueOf(iterator));
                                    //minutiteratorB = minutiteratorB + 1;


                                } else {
                                    for (int i = 0; i < 24; i++)        ////
                                    {                                                         ////

                                        averagesum = averagesum + hourconcentrationAVG[i];           ////
                                        ////
                                        //buttonreferesh.setText(String.valueOf(secondssize));
                                    }
                                    dayconcenctrationAVG[daytimeB[iterator-1]] = averagesum /24; //iterator-1

                                    averagesum = 0;
                                    //buttonreferesh.setText(String.valueOf(mintuteconcentrationAVG[22]));
                                }
                            }
                            else
                            {
                                for(int i = 0; i < hourwindow.length; i++)        ////hourssize
                                {                                                         ////

                                    averagesum = averagesum + hourconcentrationAVG[i];           ////
                                    ////
                                    //buttonreferesh.setText(String.valueOf(secondssize));j
                                }
                                daywindow[daytimeB[iterator]] = daytimeB[iterator];
                                if(hourssize == 0)                                               /////////
                                {
                                    dayconcenctrationAVG[daytimeB[iterator]] = averagesum;     /////////////
                                }
                                else {
                                    dayconcenctrationAVG[daytimeB[iterator]] = averagesum / hourssize;
                                }
                                //buttonreferesh.setText(String.valueOf(mintuteconcentrationAVG[0]));
                                //buttonback.setText(String.valueOf(secondssize)); //mintuteconcentrationAVG[23]
                                averagesum = 0;

                            }
                        }

                        else
                        {

                            for(int i = 0; i < hourwindow.length; i++)        ////////60 - (minutessize)    60
                            {                                                         ////

                                if(hourwindow[i] != -1) {
                                    averagesum = averagesum + hourconcentrationAVG[i];           ////
                                    ////
                                }         ////
                                ////
                                //buttonreferesh.setText(String.valueOf(secondssize));j
                            }
                            daywindow[daytimeB[iterator]] = daytimeB[iterator];
                            if(hourssize == 0)                                               /////////
                            {
                                dayconcenctrationAVG[daytimeB[iterator]] = averagesum;     /////////////
                            }
                            else {
                                dayconcenctrationAVG[daytimeB[iterator]] = averagesum / hourssize;
                            }
                            //buttonback.setText(String.valueOf(secondssize)); //mintuteconcentrationAVG[23]
                            averagesum = 0;

                            //buttonback.setText(String.valueOf(mintuteconcentrationAVG[23]));
                        }
                    }


                    else
                    {
                        //secondwindow[time[iterator]] = time[iterator];
                        //secconcentrationAVG[time[iterator]] = concentration[iterator];
                        for(int i = 0; i < hourwindow.length; i++)        ////
                        {                                                         ////

                            if(hourwindow[i] != -1) {
                                averagesum = averagesum + hourconcentrationAVG[i];           ////
                                ////
                            }           ////
                            ////
                            //buttonreferesh.setText(String.valueOf(secondssize));
                        }
                        daywindow[daytimeB[iterator]] = daytimeB[iterator];
                        if(hourssize == 0)                                               /////////
                        {
                            dayconcenctrationAVG[daytimeB[iterator]] = averagesum;     /////////////
                        }
                        else {
                            dayconcenctrationAVG[daytimeB[iterator]] = averagesum / hourssize;
                        }
                        //buttonreferesh.setText(String.valueOf(hourconcentrationAVG[11]));
                        //buttonback.setText(String.valueOf(mintuteconcentrationAVG[23])); //mintuteconcentrationAVG[23]
                        averagesum = 0;
                        //buttonreferesh.setText(String.valueOf(iterator));
                        //buttonback.setText(String.valueOf(hourconcentrationAVG[11]));
                    }
                    //checkpoint//849
                    //buttonreferesh.setText(String.valueOf(daywindow[3]));
                    //buttonback.setText(String.valueOf(daywindow[2]));

                    //////////////////////////////////////////////////////////////////////////////////
                    //////////    day/month

                    if(daytimeB[iterator] == 1) //checks if time index is 0
                    {
                        if(iterator>0) {//iterator > 0 &&
                            if ( (daytimeB[iterator - 1] == 29) || (daytimeB[iterator - 1] == 30) || (daytimeB[iterator - 1] == 31)) //makes sure last point was 59 and your higher then 0
                            {
                                //minutewindow[minutetimeB[iterator]] = minutetimeB[iterator];
                                //mintuteconcentrationAVG[minutetimeB[iterator]] = concentration[iterator]; //get back over here
                                //reset all other values

                                //seriesB.resetData(aserieshoursB);
                                monthwindow[monthtimeB[iterator-1]] = monthtimeB[iterator-1]; // minutetimeB[iterator-1]  iterator-1
                                monthwindow[monthtimeB[iterator]] = monthtimeB[iterator];
                                weekconcenctrationAVG[monthtimeB[iterator]] = concentration[iterator];
                                //CHANGE STUFF OVER HERE
                                if (dayssize < daytimeB[iterator - 1]) {               //iterator - (secondssize)
                                    for (int i = daytimeB[iterator - 1] - (dayssize); i < daytimeB[iterator - 1] + 1; i++)        ////
                                    {                                                         ////

                                        averagesum = averagesum + dayconcenctrationAVG[i];           ///////BOOK MARK!
                                        ////
                                        //buttonreferesh.setText(String.valueOf(secondssize));
                                    }
                                    for (int i = 2; i < daytimeB[iterator - 1] + 1; i++) {
                                        daywindow[i] = -1;
                                        dayconcenctrationAVG[i] = 0;
                                    }
                                    if(dayssize == 0)                                               /////////
                                    {
                                        weekconcenctrationAVG[monthtimeB[iterator-1]] = averagesum;     /////////////
                                    }
                                    else {
                                        weekconcenctrationAVG[monthtimeB[iterator - 1]] = averagesum / dayssize; //iterator-1 COME BACK HERE!!!!!!
                                    }
                                    averagesum = 0;
                                    //buttonreferesh.setText(String.valueOf(hourconcentrationAVG[12])); THIS ONE FIXS IT
                                    //buttonreferesh.setText(String.valueOf(mintuteconcentrationAVG[22]));
                                    //buttonreferesh.setText(String.valueOf(iterator));
                                    //minutiteratorB = minutiteratorB + 1;


                                } else {
                                    for (int i = 1; i < daytimeB[iterator - 1] + 1; i++)        ////
                                    {                                                         ////

                                        averagesum = averagesum + dayconcenctrationAVG[i];           ////
                                        ////
                                        //buttonreferesh.setText(String.valueOf(secondssize));
                                    }
                                    weekconcenctrationAVG[monthtimeB[iterator-1]] = averagesum /daytimeB[iterator - 1]; //iterator-1

                                    averagesum = 0;
                                    //buttonreferesh.setText(String.valueOf(mintuteconcentrationAVG[22]));
                                }
                            }
                            else
                            {
                                for(int i = 1; i < daytimeB[iterator - 1] + 1; i++)        ////60 - (minutessize)    60
                                {                                                         ////

                                    averagesum = averagesum + dayconcenctrationAVG[i];           ////
                                    ////
                                    //buttonreferesh.setText(String.valueOf(secondssize));j
                                }
                                monthwindow[monthtimeB[iterator]] = monthtimeB[iterator];
                                if(dayssize == 0)                                               /////////
                                {
                                    weekconcenctrationAVG[monthtimeB[iterator]] = averagesum;     /////////////
                                }
                                else {
                                    weekconcenctrationAVG[monthtimeB[iterator]] = averagesum / dayssize;
                                }
                                //buttonreferesh.setText(String.valueOf(mintuteconcentrationAVG[0]));
                                //buttonback.setText(String.valueOf(secondssize)); //mintuteconcentrationAVG[23]
                                averagesum = 0;

                            }
                        }

                        else
                        {

                            for(int i = 1; i < daywindow.length; i++)        ////////60 - (minutessize)    60
                            {                                                         ////

                                if(daywindow[i] != -1) {
                                    averagesum = averagesum + dayconcenctrationAVG[i];           ////
                                    ////
                                }          ////
                                ////
                                //buttonreferesh.setText(String.valueOf(secondssize));j
                            }
                            monthwindow[monthtimeB[iterator]] = monthtimeB[iterator];
                            if(dayssize == 0)                                               /////////
                            {
                                weekconcenctrationAVG[monthtimeB[iterator]] = averagesum;     /////////////
                            }
                            else {
                                weekconcenctrationAVG[monthtimeB[iterator]] = averagesum / dayssize;
                            }
                            //buttonback.setText(String.valueOf(secondssize)); //mintuteconcentrationAVG[23]
                            averagesum = 0;

                            //buttonback.setText(String.valueOf(mintuteconcentrationAVG[23]));
                        }
                    }


                    else
                    {
                        //secondwindow[time[iterator]] = time[iterator];
                        //secconcentrationAVG[time[iterator]] = concentration[iterator];
                        for(int i = 1; i < daywindow.length; i++)         ////dayssize
                        {                                                         ////
                            if(daywindow[i] != -1) {
                                averagesum = averagesum + dayconcenctrationAVG[i];           ////
                                ////
                            }
                            //buttonreferesh.setText(String.valueOf(secondssize));
                        }
                        monthwindow[monthtimeB[iterator]] = monthtimeB[iterator];
                        if(dayssize == 0)                                               /////////
                        {
                            weekconcenctrationAVG[monthtimeB[iterator]] = averagesum;     /////////////
                        }
                        else {
                            weekconcenctrationAVG[monthtimeB[iterator]] = averagesum / dayssize;
                        }
                        //buttonreferesh.setText(String.valueOf(hourconcentrationAVG[11]));
                        //buttonback.setText(String.valueOf(mintuteconcentrationAVG[23])); //mintuteconcentrationAVG[23]
                        averagesum = 0;
                        //buttonreferesh.setText(String.valueOf(iterator));
                        //buttonback.setText(String.valueOf(dayssize));
                        //buttonreferesh.setText(String.valueOf(weekconcenctrationAVG[11]));
                    }
                    buttonback.setText(String.valueOf(dayconcenctrationAVG[2]));
                    buttonreferesh.setText(String.valueOf(weekconcenctrationAVG[11]));
                    //buttonback.setText(String.valueOf(weekconcenctrationAVG[11]));

                    ////////////////////////////////////////MONTH TO YEAR//////////////////////////////////////
                    if(monthtimeB[iterator] == 1) //checks if time index is 0
                    {
                        if(iterator>0) {//iterator > 0 &&
                            if ( (monthtimeB[iterator - 1] == 12) ) //makes sure last point was 59 and your higher then 0
                            {
                                //minutewindow[minutetimeB[iterator]] = minutetimeB[iterator];
                                //mintuteconcentrationAVG[minutetimeB[iterator]] = concentration[iterator]; //get back over here
                                //reset all other values

                                //seriesB.resetData(aserieshoursB);
                                yearwindow[yeartimeB[iterator-1]-2021] = yeartimeB[iterator-1]-2000; // minutetimeB[iterator-1]  iterator-1

                                //CHANGE STUFF OVER HERE
                                if (monthssize < 12) {               //iterator - (secondssize)
                                    for (int i = monthtimeB[iterator - 1] - (monthssize); i < monthtimeB[iterator - 1] + 1; i++)        ////
                                    {                                                         ////

                                        averagesum = averagesum + weekconcenctrationAVG[i];           ///////BOOK MARK!
                                        ////
                                        //buttonreferesh.setText(String.valueOf(secondssize));
                                    }
                                    for (int i = 1; i < monthtimeB[iterator - 1] + 1; i++) {
                                        monthwindow[i] = -1;
                                        weekconcenctrationAVG[i] = 0;
                                    }
                                    if(monthssize == 0)                                               /////////
                                    {
                                        yearsconcentrationAVG[yeartimeB[iterator-1]-2021]  = averagesum;     /////////////
                                    }
                                    else {
                                        yearsconcentrationAVG[yeartimeB[iterator - 1] - 2021] = averagesum / monthssize; //iterator-1 COME BACK HERE!!!!!!
                                    }
                                    averagesum = 0;
                                    //buttonreferesh.setText(String.valueOf(hourconcentrationAVG[12])); THIS ONE FIXS IT
                                    //buttonreferesh.setText(String.valueOf(mintuteconcentrationAVG[22]));
                                    //buttonreferesh.setText(String.valueOf(iterator));
                                    //minutiteratorB = minutiteratorB + 1;


                                } else {
                                    for (int i = 1; i < monthtimeB[iterator - 1] + 1; i++)        ////
                                    {                                                         ////

                                        averagesum = averagesum + weekconcenctrationAVG[i];           ////
                                        ////
                                        //buttonreferesh.setText(String.valueOf(secondssize));
                                    }
                                    yearsconcentrationAVG[yeartimeB[iterator-1]-2021] = averagesum /12; //iterator-1

                                    averagesum = 0;
                                    //buttonreferesh.setText(String.valueOf(mintuteconcentrationAVG[22]));
                                }
                            }
                            else
                            {
                                for(int i = 1; i < monthtimeB[iterator - 1] + 1; i++)        ////60 - (minutessize)    60
                                {                                                         ////

                                    averagesum = averagesum + weekconcenctrationAVG[i];           ////
                                    ////
                                    //buttonreferesh.setText(String.valueOf(secondssize));j
                                }
                                yearwindow[yeartimeB[iterator]-2021] = yeartimeB[iterator]-2000;
                                if(monthssize == 0)                                               /////////
                                {
                                    yearsconcentrationAVG[yeartimeB[iterator]-2021]  = averagesum;     /////////////
                                }
                                else {
                                    yearsconcentrationAVG[yeartimeB[iterator] - 2021] = averagesum / monthssize;
                                }
                                //buttonreferesh.setText(String.valueOf(mintuteconcentrationAVG[0]));
                                //buttonback.setText(String.valueOf(secondssize)); //mintuteconcentrationAVG[23]
                                averagesum = 0;

                            }
                        }

                        else
                        {

                            for(int i = 1; i < monthwindow.length; i++)        ////////60 - (minutessize)    60
                            {                                                         ////

                                if(monthwindow[i] != -1) {
                                    averagesum = averagesum + weekconcenctrationAVG[i];           ////
                                    ////
                                }          ////
                                ////
                                //buttonreferesh.setText(String.valueOf(secondssize));j
                            }
                            yearwindow[yeartimeB[iterator]-2021] = yeartimeB[iterator]-2000;
                            if(monthssize == 0)                                               /////////
                            {
                                yearsconcentrationAVG[yeartimeB[iterator]-2021]  = averagesum;     /////////////
                            }
                            else {
                                yearsconcentrationAVG[yeartimeB[iterator] - 2021] = averagesum / monthssize;
                            }
                            //buttonback.setText(String.valueOf(secondssize)); //mintuteconcentrationAVG[23]
                            averagesum = 0;

                            //buttonback.setText(String.valueOf(mintuteconcentrationAVG[23]));
                        }
                    }


                    else
                    {
                        //secondwindow[time[iterator]] = time[iterator];
                        //secconcentrationAVG[time[iterator]] = concentration[iterator];
                        for(int i = 1; i < monthwindow.length; i++)         ////dayssize
                        {                                                         ////
                            if(monthwindow[i] != -1) {
                                averagesum = averagesum + weekconcenctrationAVG[i];           ////
                                ////
                            }
                            //buttonreferesh.setText(String.valueOf(secondssize));
                        }
                        yearwindow[yeartimeB[iterator]-2021] = yeartimeB[iterator]-2000;
                        if(monthssize == 0)                                               /////////
                        {
                            yearsconcentrationAVG[yeartimeB[iterator]-2021]  = averagesum;     /////////////
                        }
                        else {
                            yearsconcentrationAVG[yeartimeB[iterator] - 2021] = averagesum / monthssize;
                        }
                        if(iterator>0)
                        {
                            if(monthtimeB[iterator-1] != monthtimeB[iterator])
                            {
                                yearsconcentrationAVG[yeartimeB[iterator] - 2021] = averagesum / (monthssize+1);
                                //buttonreferesh.setText(String.valueOf(averagesum));
                                //buttonreferesh.setText(String.valueOf(averagesum));
                                //buttonback.setText(String.valueOf(weekconcenctrationAVG[12]));
                                //buttonback.setText(String.valueOf(yearsconcentrationAVG[1]));

                            }
                        }
                        //buttonreferesh.setText(String.valueOf(hourconcentrationAVG[11]));
                        //buttonback.setText(String.valueOf(mintuteconcentrationAVG[23])); //mintuteconcentrationAVG[23]
                        averagesum = 0;
                        //buttonreferesh.setText(String.valueOf(iterator));
                        //buttonback.setText(String.valueOf(dayssize));
                        //buttonreferesh.setText(String.valueOf(weekconcenctrationAVG[11]));
                    }
                    //buttonback.setText(String.valueOf(monthwindow[12]));
                    //buttonreferesh.setText(String.valueOf(weekconcenctrationAVG[12]));
                    buttonback.setText(String.valueOf(yearsconcentrationAVG[1]));
                    buttonreferesh.setText(String.valueOf(yearsconcentrationAVG[2]));
                    //buttonreferesh.setText(String.valueOf(yearsconcentrationAVG[12]));
                    ////////////////////////////////////////MONTH TO YEAR//////////////////////////////////////
                    ///////////////////////////////////////////// NEW STUFF2
                    /////////////////////////////////

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

                int whilecheck = 0;
                for(int i = 0; i < 60; i++)
                {

                    if(secondwindow[i] != -1)
                    {                   //secondwindow[i]
                        aseriesB[whilecheck] = new DataPoint(secondwindow[i], secconcentrationAVG[i] );
                        seriesB.appendData( aseriesB[whilecheck], true, 100);
                        whilecheck = whilecheck + 1;
                    }
                }

                int whilecheck2 = 0;
                for(int i = 0; i < 60; i++)
                {

                    if(minutewindow[i] != -1)
                    {                   //secondwindow[i]
                        aseriesminutesB[whilecheck2] = new DataPoint(minutewindow[i], mintuteconcentrationAVG[i] );
                        seriesminutesB.appendData( aseriesminutesB[whilecheck2], true, 100);
                        whilecheck2 = whilecheck2 + 1;
                    }
                }

                int whilecheck3 = 0;
                for(int i = 0; i < 24; i++)
                {

                    if(hourwindow[i] != -1)
                    {                   //secondwindow[i]
                        aserieshoursB[whilecheck3] = new DataPoint(hourwindow[i], hourconcentrationAVG[i] );
                        serieshoursB.appendData( aserieshoursB[whilecheck3], true, 100);
                        whilecheck3 = whilecheck3 + 1;
                    }
                }
                int whilecheck4 = 0;
                for(int i = 0; i < 32; i++)
                {

                    if(daywindow[i] != -1)
                    {                   //secondwindow[i]
                        aseriesdayB[whilecheck4] = new DataPoint(daywindow[i], dayconcenctrationAVG[i] );
                        seriesdayB.appendData( aseriesdayB[whilecheck4], true, 100);
                        whilecheck4 = whilecheck4 + 1;
                    }
                }

                int whilecheck5 = 0;
                for(int i = 0; i < 13; i++)
                {

                    if(monthwindow[i] != -1)
                    {                   //secondwindow[i]
                        aseriesweekB[whilecheck5] = new DataPoint(monthwindow[i], weekconcenctrationAVG[i] );
                        seriesweekB.appendData( aseriesweekB[whilecheck5], true, 100);
                        whilecheck5 = whilecheck5 + 1;
                    }
                }

                int whilecheck6 = 0;
                for(int i = 0; i < 10; i++)
                {

                    if(yearwindow[i] != -1)
                    {                   //secondwindow[i]
                        aseriesyearB[whilecheck6] = new DataPoint(yearwindow[i], yearsconcentrationAVG[i] );
                        seriesyearB.appendData( aseriesyearB[whilecheck6], true, 100);
                        whilecheck6 = whilecheck6 + 1;
                    }
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

                seriessupersecond = seriesB;
                seriessuperminute1 = seriesminutesB;
                seriesghour1 = serieshoursB;
                seriesgday1 = seriesdayB;
                seriesgweek1 = seriesweekB;
                seriesgyear1 = seriesyearB;
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
        Intent intent = new Intent(this, camera2graph.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivitymain(){
        Intent intent = new Intent(this, Camera2.class); //causes the subordinate activity file to be opened, redirects to new layout
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
            //LineGraphSeries lil = seriessupersecond;
            //lil.setThickness(2);
            griLa.setHorizontalAxisTitle("              seconds");
            griLa.setHorizontalAxisTitleTextSize(20);
            griLa.setVerticalAxisTitle("state");
            griLa.setLabelVerticalWidth(43);
            griLa.setGridColor(Color.LTGRAY);
            griLa.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa.setVerticalAxisTitleTextSize(20);
            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setYAxisBoundsManual(true);
            graph.getGridLabelRenderer().setNumVerticalLabels(3);
            //if(arraysizeCHECKglobal<60)
            //{
                graph.getViewport().setMinX(0);
                graph.getViewport().setMaxX(60);
            //}
            //else
            //{
            //    graph.getViewport().setMinX(arraysizeCHECKglobal-60);
            //    graph.getViewport().setMaxX(arraysizeCHECKglobal);
            //}
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
            griLa.setGridColor(Color.LTGRAY);
            //griLa.setH;
            griLa.setVerticalAxisTitleTextSize(20);
            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalminute1<10)
            //{
                graph.getViewport().setMinX(0);
                graph.getViewport().setMaxX(60);
            //}
            //else
            //{
            //    graph.getViewport().setMinX(arraysizeglobalminute1-10);
            //    graph.getViewport().setMaxX(arraysizeglobalminute1);
            //}
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
            griLa.setGridColor(Color.LTGRAY);
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
            //if(arraysizeglobalhour1<10)
            //{
                graph.getViewport().setMinX(0);
                graph.getViewport().setMaxX(24);
            //}
            //else
            //{
            //    graph.getViewport().setMinX(arraysizeglobalhour1-10);
            //    graph.getViewport().setMaxX(arraysizeglobalhour1);
            //}
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
            griLa.setGridColor(Color.LTGRAY);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalday1<10)
            //{
                graph.getViewport().setMinX(0);
                graph.getViewport().setMaxX(31);
            //}
            //else
            //{
            //    graph.getViewport().setMinX(arraysizeglobalday1-10);
            //    graph.getViewport().setMaxX(arraysizeglobalday1);
            //}
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
            griLa.setGridColor(Color.LTGRAY);
            //LineGraphSeries lil = seriesgweek1;
            //lil.setThickness(2);
            griLa.setHorizontalAxisTitle("              months");
            griLa.setHorizontalAxisTitleTextSize(20);
            griLa.setVerticalAxisTitle("state");
            griLa.setLabelVerticalWidth(43);
            griLa.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa.setVerticalAxisTitleTextSize(20);
            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalweek1<10)
            //{
                graph.getViewport().setMinX(0);
                graph.getViewport().setMaxX(13);
            //}
            //else
            //{
            //    graph.getViewport().setMinX(arraysizeglobalweek1-10);
            //    graph.getViewport().setMaxX(arraysizeglobalweek1);
            //}
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
            griLa.setGridColor(Color.LTGRAY);
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
            //if(arraysizeglobalyear1<3)
            //{
                graph.getViewport().setMinX(21);
                graph.getViewport().setMaxX(31);
            //}
            //else
            //{
            //    graph.getViewport().setMinX(arraysizeglobalyear1-3);
            //    graph.getViewport().setMaxX(arraysizeglobalyear1);
            //}
            graph.getViewport().setMinY(0);
            graph.getViewport().setMaxY(max + .2*max);





        }

        //Intent intent = new Intent(this, mcu1co2graphminutes.class); //causes the subordinate activity file to be opened, redirects to new layout
        //startActivity(intent);
    }


    @Override

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //adapterView.setSelection(i);
        if((seriessupersecond == null) || (seriessuperminute1 == null) || (seriesghour1 == null) || (seriesgday1 == null) || (seriesgweek1 == null) || (seriesgyear1 == null))
        {return;}
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
            griLa.setGridColor(Color.LTGRAY);
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
            //if(arraysizeCHECKglobal<60)
            //{
                graph.getViewport().setMinX(0);
                graph.getViewport().setMaxX(60);
            //}
            //else
            //{
            //    graph.getViewport().setMinX(arraysizeCHECKglobal-60);
            //    graph.getViewport().setMaxX(arraysizeCHECKglobal);
            //}
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
            griLa.setGridColor(Color.LTGRAY);
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
            //if(arraysizeglobalminute1<10)
            //{
                graph.getViewport().setMinX(0);
                graph.getViewport().setMaxX(60);
            //}
            //else
            //{
            //    graph.getViewport().setMinX(arraysizeglobalminute1-10);
            //    graph.getViewport().setMaxX(arraysizeglobalminute1);
            //}
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
            griLa.setGridColor(Color.LTGRAY);
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
            //if(arraysizeglobalhour1<10)
            //{
                graph.getViewport().setMinX(0);
                graph.getViewport().setMaxX(24);
            //}
            //else
            //{
            //    graph.getViewport().setMinX(arraysizeglobalhour1-10);
            //    graph.getViewport().setMaxX(arraysizeglobalhour1);
            //}
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
            griLa.setGridColor(Color.LTGRAY);
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
            //if(arraysizeglobalday1<10)
            //{
                graph.getViewport().setMinX(0);
                graph.getViewport().setMaxX(31);
            //}
            //else
            //{
            //    graph.getViewport().setMinX(arraysizeglobalday1-10);
            //    graph.getViewport().setMaxX(arraysizeglobalday1);
            //}
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
            griLa.setGridColor(Color.LTGRAY);
            //LineGraphSeries lil = seriesgweek1;
            //lil.setThickness(2);
            griLa.setHorizontalAxisTitle("              months");
            griLa.setHorizontalAxisTitleTextSize(20);
            griLa.setVerticalAxisTitle("state");
            griLa.setLabelVerticalWidth(43);
            griLa.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa.setVerticalAxisTitleTextSize(20);
            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalweek1<10)
            //{
                graph.getViewport().setMinX(0);
                graph.getViewport().setMaxX(13);
            //}
            //else
            //{
            //    graph.getViewport().setMinX(arraysizeglobalweek1-10);
            //    graph.getViewport().setMaxX(arraysizeglobalweek1);
            //}
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
            griLa.setGridColor(Color.LTGRAY);
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
            //if(arraysizeglobalyear1<3)
            //{
                graph.getViewport().setMinX(21);
                graph.getViewport().setMaxX(31);
            //}
            //else
            //{
            //    graph.getViewport().setMinX(arraysizeglobalyear1-3);
            //    graph.getViewport().setMaxX(arraysizeglobalyear1);
            //}
            graph.getViewport().setMinY(0);
            graph.getViewport().setMaxY(max + .2*max);



        }

    }
    public void opentesting2() {
        GraphView graph2 = (GraphView) findViewById(R.id.graph12th);

    }
}