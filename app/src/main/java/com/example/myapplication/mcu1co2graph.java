package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class mcu1co2graph extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private int indication = 0;  //default value on spinner
    private int indication2 = 0; //not used
    PointsGraphSeries<DataPoint> seriessupersecond; //initializing series for seconds
    GraphView graphz;
    int arraysizesecondglobal1;
    //int max = 0;
    double max = 0;
    int second1max = 0;
    PointsGraphSeries<DataPoint> seriessuperminute1; //initializing series for minutes
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
    PointsGraphSeries<DataPoint> seriesgweek2;
    int arraysizeglobalweek2;
    int week2max = 0;
    PointsGraphSeries<DataPoint> seriesgyear2;
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
        setContentView(R.layout.activity_mcu1co2graph);
        seriessupersecond = new PointsGraphSeries<DataPoint>();
        //bull[0] = new DataPoint(0, 0);
        //seriessupersecond.appendData(bull[0], true, 2);

        Button buttonreferesh = (Button) findViewById(R.id.refreshmcu9); //declaring value of  buttons on screen
        Button buttonback = (Button) findViewById(R.id.backmcu10); //declaring value of button
        //Button buttonseconds = (Button) findViewById(R.id.secondstab);
        //Button buttonminutes = (Button) findViewById(R.id.minutestab);

        Spinner spinner = findViewById(R.id.spinner); // declaring spinner, which is used for scrollview

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.period, android.R.layout.simple_spinner_item); //adapter is filled with contents of period, which are the time periods
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //setting up spinner to be a able to dropdown
        spinner.setAdapter(adapter); //adapter set to spinner
        spinner.setSelection(0,false); //default value on spinner (seconds)
        spinner.setOnItemSelectedListener(this); //triggers action when item is selected
        DatabaseReference rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("MCU Test").child("Carbon Dioxide").child("1"); // Accesses portion of database        "MCU Test").child("Carbon Dioxide").child("1");                                 .child("MCU Test").child("Carbon Dioxide").child("1");
        DatabaseReference rootDatabaseref2 = FirebaseDatabase.getInstance().getReference().child("MCU Test2").child("Carbon Dioxide").child("1");//Accesses portion of database
        DatabaseReference rootDatabaseref3 = FirebaseDatabase.getInstance().getReference().child("MCU 1").child("Carbon Dioxide").child("Sensor 3");//Accesses portion of database
        DatabaseReference rootDatabaseref4 = FirebaseDatabase.getInstance().getReference().child("MCU 1").child("Carbon Dioxide").child("Sensor 4");//Access portion of database
        //these are seconds, create an array for j
        buttonback.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
            @Override
            public void onClick(View view) {
                openActivitymain();
            }//on click
        });
        buttonreferesh.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
            @Override
            public void onClick(View view) {
                openActivityrefresh();
            }//on click
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
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        rootDatabaseref.addValueEventListener(new ValueEventListener() { //listens for change in sensor data
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) { // listens for changes in data
                if((snapshot.getChildrenCount()== 0)) { //error handling, prevent null pointer error
                    return;
                }
                LineGraphSeries<DataPoint> series;       //next 6 lines, used for line graphs, not used current
                LineGraphSeries<DataPoint> seriesminutes;
                LineGraphSeries<DataPoint> serieshours;
                LineGraphSeries<DataPoint> seriesday;
                LineGraphSeries<DataPoint> seriesweek;
                LineGraphSeries<DataPoint> seriesyear;
               ////////////////////////////////////////////////////////////////////////////////////
                /////////////////////////////////////////////////////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////A
                PointsGraphSeries<DataPoint> seriesB;        //declares series's used for producing point graphs
                PointsGraphSeries<DataPoint> seriesminutesB;
                PointsGraphSeries<DataPoint> serieshoursB;
                PointsGraphSeries<DataPoint> seriesdayB;
                PointsGraphSeries<DataPoint> seriesweekB;
                PointsGraphSeries<DataPoint> seriesyearB;
                /////////////////////////////////////////////////////////////////////////////////////B
                ///////////////////////////////////////////////////////////////////////////////////
                /////////////////////////////////////////////////////////////////////////////////
                String data;// = snapshot.child();           //not used
                Double z;// = Double.parseDouble(data);      //not used
                // oxyg1.setText(S tring.valueOf(z));      //not used
                int t = 0;               //not used
                int iterator = 0; //variable used to iterate through data
                //double max = 0;
                double c = 0; //not used
                double y; //not used
                int x; //not used
                //x = -1;
                int arraysize = 0; //variable used to get size of array
                for(DataSnapshot snapshot1 : snapshot.getChildren()) //iterate through list of data; next couple segments of code were used for early graphing function that did total elapsed time. This is no longer being used
                {
                    arraysize = arraysize + 1;
                }
                int[] time = new int[arraysize];
                double minutediv = arraysize/60;                ///////////code no longer used, getting size of minutes
                double hourdiv = arraysize/3600;
                double daydiv = arraysize/43200;
                double weekdiv = arraysize/302400;
                double yeardiv = arraysize/15768000;


                double minutesdoub = Math.floor(minutediv);     ///////////code no longer used, making size into a whole value
                double hoursdoub = Math.floor(hourdiv);     ///////////
                double daydouble = Math.floor(daydiv);
                double weekdouble = Math.floor(weekdiv);
                double yearsdouble = Math.floor(yeardiv);

                int minutes = (int)minutesdoub;
                int hours = (int)hoursdoub;                 ////////// code no longer used, converting to integer
                int days = (int)daydouble;
                int weeks = (int)weekdouble;
                int years = (int)yearsdouble;

                int[] minutetime = new int[minutes];
                int[] hourtime = new int[hours];            ////////// code no longer used, creating arrrays for time entries
                int[] daytime = new int[days];
                int[] weektime = new int[weeks];
                int[] yeartime = new int[years];
                /////////////////////////////////////////////////////NEW VARIABLES TO PLAY WITH A
                ////////////////////////////////////////////////////
                /////////////////////////////////////////////////
                int parsetogetsizes = 0; //not used

                int[] minutetimeB = new int[arraysize];          //used to store minute values read from database
                int[] hourtimeB = new int[arraysize];            ////////// used to store hour values read from database
                int[] daytimeB = new int[arraysize];            //used to store day values read from database
                int[] monthtimeB = new int[arraysize];             //used to store second values read from database
                int[] yeartimeB = new int[arraysize];           //used to store year values read from database

                int[] secondwindow = new int[60];  //window of seconds in a given minute
                int[] minutewindow = new int[60]; //window of minutes in an hour
                for(int i = 0; i < 60; i++)  //here set the default for array of window values, -1 means that the value is empty for minutes seconds years etc
                {
                    secondwindow[i] = -1;
                    minutewindow[i] = -1;
                }
                int[] hourwindow = new int[24];            //////////window of hours in a day, also default of negative 1
                for(int i = 0; i < 24; i++)
                {
                    hourwindow[i] = -1;

                }
                int[] daywindow = new int[32];              /////////window of days in a month, also default of negative 1
                for(int i = 0; i < 32; i++)
                {
                    daywindow[i] = -1;

                }
                int[] monthwindow = new int[13];                /////////window of months in a year, also default of negative 1
                for(int i = 0; i < 13; i++)
                {
                    monthwindow[i] = -1;

                }
                int[] yearwindow = new int[10];                 /////////window of years in 10 years, also default of negative 1
                for(int i = 0; i < 10; i++)
                {
                    yearwindow[i] = -1;

                }
                double [] secconcentrationAVG = new double[60];
                double[] mintuteconcentrationAVG = new double[60]; ////// hold average values for each unit for different units of time in the given time value
                double[] hourconcentrationAVG = new double[24]; ////// hold average
                double[] dayconcenctrationAVG = new double[32]; //
                double[] weekconcenctrationAVG = new double[13];
                double[] yearsconcentrationAVG = new double[10];
                int iteratorB = 0;
                int minutiteratorB = 0;      /////// variable not used
                int houriteratorB = 0;      ///////
                int dayiteratorB = 0;
                int weekiteratorB = 0;
                int yeariteratorB = 0;

                //put sizes back here if it doesnt work
                /////////////////////////////////////////////////////
                /////////////////////////////////////////////////////
                /////////////////////////////////////////////////////NEW VARIABLES TO PLAY WITH B
                double[] concentration = new double[arraysize];
                double[] mintuteconcentration = new double[minutes]; ////// variables for concentration used in previous graphing formula
                double[] hourconcentration = new double[hours]; //////
                double[] dayconcenctration = new double[days];
                double[] weekconcenctration = new double[weeks];
                double[] yearsconcentration = new double[years];

                int minutiterator = 0;      /////// used in previous graphing formula
                int houriterator = 0;      ///////
                int dayiterator = 0;
                int weekiterator = 0;
                int yeariterator = 0;

                double averagesum = 0;
                series = new LineGraphSeries<DataPoint>();        //not used
                seriesminutes = new LineGraphSeries<DataPoint>(); //not used
                serieshours = new LineGraphSeries<DataPoint>(); //not used

                /////////////////////////////////////////////////////////A
                /////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////
                seriesB = new PointsGraphSeries<DataPoint>();            //next 6 lines are declaring series so that they are not null
                seriesminutesB = new PointsGraphSeries<DataPoint>();
                serieshoursB = new PointsGraphSeries<DataPoint>();
                seriesdayB = new PointsGraphSeries<DataPoint>();
                seriesweekB = new PointsGraphSeries<DataPoint>();
                seriesyearB = new PointsGraphSeries<DataPoint>();

                DataPoint[] aseriesB= new DataPoint[60];        //these are datapoints for each unit of time
                DataPoint[] aseriesminutesB= new DataPoint[60]; //they consist of data being put into the graph
                DataPoint[] aserieshoursB= new DataPoint[24];   //both x and y values
                DataPoint[] aseriesdayB= new DataPoint[32];
                DataPoint[] aseriesweekB= new DataPoint[13];
                DataPoint[] aseriesyearB= new DataPoint[10];
                //time[iterator] = Integer.parseInt((snapshot.getChildren()).child("time").getValue().toString());
                ////////////////////////////////////////////////////////

                for(DataSnapshot snapshot1 : snapshot.getChildren())
                { //iterates through ever variable thats put into the database

                    int secondssize = 0; //tells how much stuff is in a window
                    int minutessize = 0;  //for each different unit of time
                    int hourssize = 0;
                    int dayssize = 0;
                    int monthssize = 0;
                    int yearssize = 0;



                    time[iterator] = Integer.parseInt(snapshot1.child("7-Seconds").getValue().toString());                     //7-Seconds time               seconds value in database
                    concentration[iterator] = Double.parseDouble(snapshot1.child("1-Concentration").getValue().toString()); //1-Concentration concentration   concentration value
                    minutetimeB[iterator] = Integer.parseInt(snapshot1.child("6-Minute").getValue().toString());            //6-Minute minute
                    hourtimeB[iterator] = Integer.parseInt(snapshot1.child("5-Hour").getValue().toString());                //5-Hour hour
                    daytimeB[iterator] = Integer.parseInt(snapshot1.child("4-Day").getValue().toString());                  //4-Day day
                    monthtimeB[iterator] = Integer.parseInt(snapshot1.child("3-Month").getValue().toString());              //3-Month month
                    yeartimeB[iterator] = Integer.parseInt(snapshot1.child("2-Year").getValue().toString());                //2-Year year
                    //7 lines of code above are used to access database entries that are the iterator entry within the database, these
                    //are the actual values being read
                    if(concentration[iterator] > max)
                    {
                        max = concentration[iterator];  //used to determine max of y axis in all of the graphs
                    }



                    //if(snapshot1 == snapshot.getChildren()-1)
                    //secondwindow[time[iterator]] = time[iterator];GO BACK
                    //////////////////////////////////////////////A
                    //////////////////////////////////////////////
                    /////////////////////////////////////////////
                    for(int i = 0; i < 60; i++)                 //this section of for loops is used to determine the number of non null values in an array
                    {
                        if(secondwindow[i] != -1)               //this section if used to once again default seconds and minutes
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
                        if(hourwindow[i] != -1)             //used to default on hours
                        {
                            hourssize = hourssize + 1;
                        }

                    }

                    for(int i = 0; i < 32; i++)              //used to default values on days
                    {
                        if(daywindow[i] != -1)
                        {
                            dayssize = dayssize + 1;
                        }

                    }

                    for(int i = 0; i < 13; i++) //used to default values of months
                    {
                        if(monthwindow[i] != -1 )
                        {
                            monthssize = monthssize + 1;
                        }
                    }

                    for(int i = 0; i < 10; i++)   //used to default values of years
                    {
                        if(yearwindow[i] != -1)
                        {
                            yearssize = yearssize + 1;
                        }

                    }
                    //controlling seconds and part of minutes arrays
                    if(iterator > 0) //checks if time index is greateer then zero 0
                    {
                        if(iterator>0) {//iterator > 0 && nested statement, redundant
                            if ( minutetimeB[iterator - 1] != minutetimeB[iterator]) //checks if end of a minute has been reached
                            {
                                secondwindow[time[iterator]] = time[iterator]; //gets value in array for second window, in terms of secons
                                secconcentrationAVG[time[iterator]] = concentration[iterator]; //gets value for conentration value, not actually an average , in secons
                                //reset all other values
                                for (int i = 1; i < 60; i++) {
                                    secondwindow[i] = -1;                 //resets the window
                                    secconcentrationAVG[i] = 0;
                                }
                                //seriesB.resetData(aserieshoursB);
                                minutewindow[minutetimeB[iterator]] = minutetimeB[iterator]; //gets a value in the minute window                 minutetimeB[iterator-1]  iterator-1

                                secondwindow[time[iterator]] = time[iterator]; //gets value in array for second window again
                                secconcentrationAVG[time[iterator]] = concentration[iterator]; //  getting concentration
                                if (secondssize < 60) {               //checks if secondsize is less then 60, wants to average all values in the previous minute window
                                    for (int i = iterator - (secondssize); i < iterator+1; i++)        ////ITERATOR+1
                                    {                                                         ////

                                        averagesum = averagesum + concentration[i];           ////takes some of all values in this window
                                        ////
                                        //buttonreferesh.setText(String.valueOf(secondssize));
                                    }
                                    //mintuteconcentrationAVG[minutetimeB[iterator]] = averagesum / (secondssize + 1); //CHECK AGAIN IF INCOTTRct
                                    mintuteconcentrationAVG[minutetimeB[iterator]] = concentration[iterator]; //only one concentration value in the current window
                                    averagesum = 0; //resets average sum so
                                    //buttonreferesh.setText(String.valueOf(mintuteconcentrationAVG[0]));
                                    //minutiteratorB = minutiteratorB + 1;


                                } else {
                                    for (int i = iterator - (secondssize); i < iterator+1; i++)        ////iterates through seconds
                                    {                                                         ////

                                        averagesum = averagesum + concentration[i];           //// adds up for the concentration
                                        ////
                                        //buttonreferesh.setText(String.valueOf(secondssize));
                                    }
                                    mintuteconcentrationAVG[minutetimeB[iterator]] = averagesum / 60; //takes average, redundant
                                    mintuteconcentrationAVG[minutetimeB[iterator]] = concentration[iterator]; //only one value to average
                                    averagesum = 0;
                                    //buttonreferesh.setText(String.valueOf(mintuteconcentrationAVG[0]));
                                }
                            }
                            else
                            {
                                secondwindow[time[iterator]] = time[iterator];   //just append value from seconds to second window if not worrying about other case
                                secconcentrationAVG[time[iterator]] = concentration[iterator]; //appending the concentration at a given second
                                for(int i = iterator - (secondssize); i< iterator+1 ; i++)        ////
                                {                                                         ////

                                    averagesum = averagesum + concentration[i];           ////takes the sum in a given window
                                    ////
                                    //buttonreferesh.setText(String.valueOf(secondssize));j
                                }
                                minutewindow[minutetimeB[iterator]] = minutetimeB[iterator];  //reading the value of the current minute
                                mintuteconcentrationAVG[minutetimeB[iterator]] = averagesum/(secondssize + 1); //gets the average over the given minute
                                //mintuteconcentrationAVG[23]
                                averagesum = 0;
                                //buttonback.setText(String.valueOf(mintuteconcentrationAVG[0]));//mintuteconcentrationAVG[23] FFFFF
                            }
                        }
                        //ENDING STUFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF
                        //end of checking if you passed the iteration greater then zero
                        else
                        {
                            secondwindow[time[iterator]] = time[iterator];   //simpyi appending the second time window
                            secconcentrationAVG[time[iterator]] = concentration[iterator]; //appending second concentration window
                            for(int i = iterator - (secondssize); i< iterator+1 ; i++)        ////ITERATOR+1
                            {                                                         ////

                                averagesum = averagesum + concentration[i];           ////summing up
                                ////
                                //buttonreferesh.setText(String.valueOf(secondssize));j
                            }
                            minutewindow[minutetimeB[iterator]] = minutetimeB[iterator]; //appending minute and concentrations
                            mintuteconcentrationAVG[minutetimeB[iterator]] = averagesum/(secondssize + 1);

                            //buttonback.setText(String.valueOf(secondssize)); //mintuteconcentrationAVG[23]
                            averagesum = 0;
                            //buttonback.setText(String.valueOf(mintuteconcentrationAVG[0]));
                        }
                    }//if i isnt greater then zero
                    else
                    {
                        secondwindow[time[iterator]] = time[iterator];      //appending second window and concentration
                        secconcentrationAVG[time[iterator]] = concentration[iterator];
                        for(int i = iterator - (secondssize); i< iterator+1 ; i++)        ////
                        {                                                         ////

                            averagesum = averagesum + concentration[i];           ////summing up concentrations
                            ////
                            //buttonreferesh.setText(String.valueOf(secondssize));j
                        }
                        minutewindow[minutetimeB[iterator]] = minutetimeB[iterator];  // appending minute and concentration values
                        mintuteconcentrationAVG[minutetimeB[iterator]] = averagesum/(secondssize + 1);
                         //mintuteconcentrationAVG[23]
                        averagesum = 0;
                        //buttonback.setText(String.valueOf(mintuteconcentrationAVG[0]));//mintuteconcentrationAVG[23] FFFFF
                    }
                    //buttonback.setText(String.valueOf(mintuteconcentrationAVG[0]));
                    //buttonback.setText(String.valueOf(mintuteconcentrationAVG[0]));
                    //buttonreferesh.setText(String.valueOf(mintuteconcentrationAVG[59]));
                    ///////////////CHANGE  TO MINUTES/HOURS

                    if(minutetimeB[iterator] == 0) //checks if time index is 0, indicates window has reset
                    {
                        if(iterator>0) {//iterator > 0 &&
                            if ( minutetimeB[iterator - 1] == 59) //makes sure last point was 59 and your higher then 0
                            {
                                //minutewindow[minutetimeB[iterator]] = minutetimeB[iterator];
                                //mintuteconcentrationAVG[minutetimeB[iterator]] = concentration[iterator]; //get back over here
                                //reset all other values

                                //seriesB.resetData(aserieshoursB);
                                hourwindow[hourtimeB[iterator-1]] = hourtimeB[iterator-1]; // minutetimeB[iterator-1]  iterator-1, sets the window of the previous hour
                                hourwindow[hourtimeB[iterator]] = hourtimeB[iterator];          ///ERROR   sets window of current hour
                                hourconcentrationAVG[hourtimeB[iterator]] = concentration[iterator];//sets window of current concentration
                                if (minutessize < 60) {               //iterator - (secondssize) // checks if size of lase window was less then 60
                                    for (int i = 60 - (minutessize); i < 60; i++)        ////adds up values accordingly
                                    {                                                         ////

                                        averagesum = averagesum + mintuteconcentrationAVG[i];           ///////BOOK MARK!
                                        ////
                                        //buttonreferesh.setText(String.valueOf(secondssize));
                                    }
                                    for (int i = 1; i < 60; i++) {    //resets concentration, window since edge of window
                                        minutewindow[i] = -1;
                                        mintuteconcentrationAVG[i] = 0;
                                    }
                                    if(minutessize == 0)                                               /////////
                                    {
                                        hourconcentrationAVG[hourtimeB[iterator-1]] = averagesum;     ///////////// averagin values
                                    }
                                    else {                                                            ///////////////
                                        hourconcentrationAVG[hourtimeB[iterator - 1]] = averagesum / minutessize; //iterator-1
                                    }
                                    averagesum = 0;
                                    //buttonreferesh.setText(String.valueOf(hourconcentrationAVG[12])); THIS ONE FIXS IT
                                    //buttonreferesh.setText(String.valueOf(mintuteconcentrationAVG[22]));
                                    //buttonreferesh.setText(String.valueOf(iterator));
                                    //minutiteratorB = minutiteratorB + 1;


                                } else { //size isnt greater then zero
                                    for (int i = 0; i < 60; i++)        ////averaging values again, here its known that there a 60 entries inside
                                    {                                                         ////

                                        averagesum = averagesum + mintuteconcentrationAVG[i];           ////
                                        ////
                                        //buttonreferesh.setText(String.valueOf(secondssize));
                                    }
                                    hourconcentrationAVG[hourtimeB[iterator-1]] = averagesum / 60; //averaging values again

                                    averagesum = 0;
                                    //buttonreferesh.setText(String.valueOf(mintuteconcentrationAVG[22]));
                                }
                            }//else when your not on an edge case
                            else
                            {
                                for(int i = 0; i < 60; i++)        ////60 - (minutessize)    60
                                {                                                         ////

                                    averagesum = averagesum + mintuteconcentrationAVG[i];           ////averagin all the values in the window
                                    ////
                                    //buttonreferesh.setText(String.valueOf(secondssize));j
                                }
                                hourwindow[hourtimeB[iterator]] = hourtimeB[iterator];          //inputting the hourwindow value
                                if(minutessize == 0)                                               /////////
                                {
                                    hourconcentrationAVG[hourtimeB[iterator]] = averagesum;     /////////////computing the average
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

                            for(int i = 0; i < 60; i++)        ////////just summing up for the averrage again
                            {                                                         ////

                                averagesum = averagesum + mintuteconcentrationAVG[i];           ////just
                                ////
                                //buttonreferesh.setText(String.valueOf(secondssize));j
                            }
                            hourwindow[hourtimeB[iterator]] = hourtimeB[iterator];//getting hour window datapoint
                            if(minutessize == 0)                                               /////////
                            {
                                hourconcentrationAVG[hourtimeB[iterator]] = averagesum;     /////////////
                            }
                            else {
                                hourconcentrationAVG[hourtimeB[iterator]] = averagesum / minutessize;  //getting hourconcentration value from average
                            }
                            //buttonback.setText(String.valueOf(secondssize)); //mintuteconcentrationAVG[23]
                            averagesum = 0;

                            //buttonback.setText(String.valueOf(mintuteconcentrationAVG[23]));
                        }
                    }//if iterator isnt equal to zero
                    ///////////////CHANGE  TO MINUTES/HOURS

                    else
                    {//
                        //secondwindow[time[iterator]] = time[iterator];
                        //secconcentrationAVG[time[iterator]] = concentration[iterator];
                        for(int i = 0; i < 60; i++)        ////averagin the value again
                        {                                                         ////

                            averagesum = averagesum + mintuteconcentrationAVG[i];           ////
                            ////
                            //buttonreferesh.setText(String.valueOf(secondssize));
                        }
                        hourwindow[hourtimeB[iterator]] = hourtimeB[iterator];  //getting the window of the hour
                        if(minutessize == 0)                                               /////////
                        {
                            hourconcentrationAVG[hourtimeB[iterator]] = averagesum;     ///////////// getting average concentration and putting it in concentration entry
                        }
                        else {
                            hourconcentrationAVG[hourtimeB[iterator]] = averagesum / minutessize;
                        }
                        //buttonreferesh.setText(String.valueOf(hourconcentrationAVG[11]));
                        //buttonback.setText(String.valueOf(mintuteconcentrationAVG[23])); //mintuteconcentrationAVG[23]
                        averagesum = 0; //resets averagesum to zero
                        //buttonreferesh.setText(String.valueOf(iterator));
                        //buttonback.setText(String.valueOf(hourwindow[3]));
                        //buttonback.setText(String.valueOf(hourconcentrationAVG[3]));
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
                                daywindow[daytimeB[iterator-1]] = daytimeB[iterator-1]; // sets window value for previouw day
                                daywindow[daytimeB[iterator]] = daytimeB[iterator]; //sets window value for current day
                                dayconcenctrationAVG[daytimeB[iterator]] = concentration[iterator]; //sets concentration value for current day
                                //buttonreferesh.setText(String.valueOf(dayconcenctrationAVG[1]));
                                //buttonback.setText(String.valueOf(daywindow[1]));
                                //GO BACK
                                if (hourssize < 24) {               //check if last window was less then 24 hours
                                    for (int i = 24 - (hourssize); i < 24; i++)        ////iterate through it to sum up values
                                    {                                                         ////

                                        averagesum = averagesum + hourconcentrationAVG[i];           ///////BOOK MARK!
                                        ////
                                        //buttonreferesh.setText(String.valueOf(secondssize));
                                    }
                                    for (int i = 1; i < 24; i++) {
                                        hourwindow[i] = -1;                 //reset the hour/concentration windows
                                        hourconcentrationAVG[i] = 0;
                                    }
                                    if(hourssize == 0)                                               /////////
                                    {
                                        dayconcenctrationAVG[daytimeB[iterator-1]] = averagesum;     ///////////// get concentration for previous day
                                    }
                                    else {
                                        dayconcenctrationAVG[daytimeB[iterator - 1]] = averagesum / hourssize; //iterator-1
                                    }
                                    averagesum = 0;
                                    //buttonreferesh.setText(String.valueOf(hourconcentrationAVG[12])); THIS ONE FIXS IT
                                    //buttonreferesh.setText(String.valueOf(mintuteconcentrationAVG[22]));
                                    //buttonreferesh.setText(String.valueOf(iterator));
                                    //minutiteratorB = minutiteratorB + 1;


                                } else {            //computes average if it wasnt taken at full window
                                    for (int i = 0; i < 24; i++)        ////
                                    {                                                         ////

                                        averagesum = averagesum + hourconcentrationAVG[i];           ////averaging up hours over the entire window
                                        ////
                                        //buttonreferesh.setText(String.valueOf(secondssize));
                                    }
                                    dayconcenctrationAVG[daytimeB[iterator-1]] = averagesum /24; //putting average in the concentration array

                                    averagesum = 0;  //reset averagsum to zero
                                    //buttonreferesh.setText(String.valueOf(mintuteconcentrationAVG[22]));
                                }
                            }
                            else//if its not a rest value
                            {
                                for(int i = 0; i < hourwindow.length; i++)        ////iterating through the hour window
                                {                                                         ////

                                    averagesum = averagesum + hourconcentrationAVG[i];           ////summing it up
                                    ////
                                    //buttonreferesh.setText(String.valueOf(secondssize));j
                                }
                                daywindow[daytimeB[iterator]] = daytimeB[iterator];
                                if(hourssize == 0)                                               /////////
                                {
                                    dayconcenctrationAVG[daytimeB[iterator]] = averagesum;     ///////////// put average into the array
                                }
                                else {
                                    dayconcenctrationAVG[daytimeB[iterator]] = averagesum / hourssize;
                                }
                                //buttonreferesh.setText(String.valueOf(mintuteconcentrationAVG[0]));
                                //buttonback.setText(String.valueOf(secondssize)); //mintuteconcentrationAVG[23]
                                averagesum = 0;

                            }
                        } //if iterator isnt greater then zero

                        else//
                        {

                            for(int i = 0; i < hourwindow.length; i++)        ////////checking if i is not greater then zero
                            {                                                         ////

                                if(hourwindow[i] != -1) {
                                    averagesum = averagesum + hourconcentrationAVG[i];           ////redunant code checks if hourwindow has a value
                                    ////
                                }         ////
                                ////
                                //buttonreferesh.setText(String.valueOf(secondssize));j
                            }
                            daywindow[daytimeB[iterator]] = daytimeB[iterator]; //add appropriate value to daywindow
                            if(hourssize == 0)                                               /////////
                            {
                                dayconcenctrationAVG[daytimeB[iterator]] = averagesum;     ///////////// put day value into the array
                            }
                            else {
                                dayconcenctrationAVG[daytimeB[iterator]] = averagesum / hourssize;
                            }
                            //buttonback.setText(String.valueOf(secondssize)); //mintuteconcentrationAVG[23]
                            averagesum = 0;

                            //buttonback.setText(String.valueOf(mintuteconcentrationAVG[23]));
                        }
                    }



                    else//checking if it isnt equal to zero
                    {
                        //secondwindow[time[iterator]] = time[iterator];
                        //secconcentrationAVG[time[iterator]] = concentration[iterator];
                        for(int i = 0; i < hourwindow.length; i++)        ////
                        {                                                         ////averaging up concentration values

                            if(hourwindow[i] != -1) {
                                averagesum = averagesum + hourconcentrationAVG[i];           ////
                                ////
                            }           ////
                            ////
                            //buttonreferesh.setText(String.valueOf(secondssize));
                        }
                        daywindow[daytimeB[iterator]] = daytimeB[iterator];  //getting window entry value
                        if(hourssize == 0)                                               /////////
                        {
                            dayconcenctrationAVG[daytimeB[iterator]] = averagesum;     /////////////getting concentration value from average
                        }
                        else {
                            dayconcenctrationAVG[daytimeB[iterator]] = averagesum / hourssize; //average value
                        }
                        //buttonreferesh.setText(String.valueOf(hourconcentrationAVG[11]));
                        //buttonback.setText(String.valueOf(mintuteconcentrationAVG[23])); //mintuteconcentrationAVG[23]
                        averagesum = 0;
                        //buttonreferesh.setText(String.valueOf(iterator));
                        //buttonback.setText(String.valueOf(hourconcentrationAVG[11]));
                    }
                    //buttonreferesh.setText(String.valueOf(dayconcenctrationAVG[1]));
                    //buttonback.setText(String.valueOf(daywindow[1]));
                    //checkpoint//849


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
                                monthwindow[monthtimeB[iterator-1]] = monthtimeB[iterator-1]; // minutetimeB[iterator-1]  iterator-1, put last monthwindow into table
                                monthwindow[monthtimeB[iterator]] = monthtimeB[iterator]; //put current monthwindow into table
                                weekconcenctrationAVG[monthtimeB[iterator]] = concentration[iterator];//put single concentration value into array
                                //CHANGE STUFF OVER HERE
                                if (dayssize < daytimeB[iterator - 1]) {               //iterator - (secondssize)
                                    for (int i = daytimeB[iterator - 1] - (dayssize); i < daytimeB[iterator - 1] + 1; i++)        ////gathering average
                                    {                                                         ////

                                        averagesum = averagesum + dayconcenctrationAVG[i];           ///////BOOK MARK!
                                        ////
                                        //buttonreferesh.setText(String.valueOf(secondssize));
                                    }
                                    for (int i = 2; i < daytimeB[iterator - 1] + 1; i++) { //resetting concentration and time window
                                        daywindow[i] = -1;
                                        dayconcenctrationAVG[i] = 0;
                                    }

                                    if(dayssize == 0)                                               /////////
                                    {
                                        weekconcenctrationAVG[monthtimeB[iterator-1]] = averagesum;     ///////////// puts average into window
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
                                    for (int i = 1; i < daytimeB[iterator - 1] + 1; i++)        ////sums up average over here
                                    {                                                         ////

                                        averagesum = averagesum + dayconcenctrationAVG[i];           ////
                                        ////
                                        //buttonreferesh.setText(String.valueOf(secondssize));
                                    }
                                    weekconcenctrationAVG[monthtimeB[iterator-1]] = averagesum /daytimeB[iterator - 1]; //takes average for previous time entry

                                    averagesum = 0;
                                    //buttonreferesh.setText(String.valueOf(mintuteconcentrationAVG[22]));
                                }
                                //buttonreferesh.setText(String.valueOf(weekconcenctrationAVG[12]));
                                //buttonback.setText(String.valueOf(weekconcenctrationAVG[12]));
                            }
                            else //no we are looking at present entries
                            {
                                for(int i = 1; i < daytimeB[iterator - 1] + 1; i++)        ////60 - (minutessize)    60
                                {                                                         ////

                                    averagesum = averagesum + dayconcenctrationAVG[i];           ////takes sum of all values
                                    ////
                                    //buttonreferesh.setText(String.valueOf(secondssize));j
                                }
                                monthwindow[monthtimeB[iterator]] = monthtimeB[iterator];  // puts in value for monthwindow
                                if(dayssize == 0)                                               /////////
                                {
                                    weekconcenctrationAVG[monthtimeB[iterator]] = averagesum;     /////////////puts in concentration average for month
                                }
                                else {
                                    weekconcenctrationAVG[monthtimeB[iterator]] = averagesum / dayssize;
                                }
                                //buttonreferesh.setText(String.valueOf(weekconcenctrationAVG[12]));
                                //buttonback.setText(String.valueOf(weekconcenctrationAVG[12]));
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
                                    averagesum = averagesum + dayconcenctrationAVG[i];           ////takes average once again, if iterator = 0
                                    ////
                                }          ////
                                ////
                                //buttonreferesh.setText(String.valueOf(secondssize));j
                            }
                            monthwindow[monthtimeB[iterator]] = monthtimeB[iterator];
                            if(dayssize == 0)                                               /////////
                            {
                                weekconcenctrationAVG[monthtimeB[iterator]] = averagesum;     /////////////put month concentration into the array
                            }
                            else {
                                weekconcenctrationAVG[monthtimeB[iterator]] = averagesum / dayssize;
                            }

                            //buttonback.setText(String.valueOf(secondssize)); //mintuteconcentrationAVG[23]
                            averagesum = 0;

                            //buttonback.setText(String.valueOf(mintuteconcentrationAVG[23]));
                        }
                    }


                    else //check when not at edge case
                    {
                        //secondwindow[time[iterator]] = time[iterator];
                        //secconcentrationAVG[time[iterator]] = concentration[iterator];
                        for(int i = 1; i < daywindow.length; i++)         ////dayssize  another elese statement computes the average
                        {                                                         ////
                            if(daywindow[i] != -1) {
                                averagesum = averagesum + dayconcenctrationAVG[i];           ////adds up values
                                ////
                            }
                            //buttonreferesh.setText(String.valueOf(secondssize));
                        }
                        monthwindow[monthtimeB[iterator]] = monthtimeB[iterator]; //puts value in time iterator
                        if(dayssize == 0)                                               /////////
                        {
                            weekconcenctrationAVG[monthtimeB[iterator]] = averagesum;     /////////////puts value in concentration iterator
                            //buttonreferesh.setText(String.valueOf(weekconcenctrationAVG[11]));
                        }
                        else {
                            weekconcenctrationAVG[monthtimeB[iterator]] = averagesum / dayssize;
                            //buttonreferesh.setText(String.valueOf(weekconcenctrationAVG[11]));
                        }
                        //buttonreferesh.setText(String.valueOf(hourconcentrationAVG[11]));
                        //buttonback.setText(String.valueOf(mintuteconcentrationAVG[23])); //mintuteconcentrationAVG[23]
                        averagesum = 0;
                        //buttonreferesh.setText(String.valueOf(iterator));
                        //buttonback.setText(String.valueOf(dayssize));
                        //buttonreferesh.setText(String.valueOf(weekconcenctrationAVG[11]));
                    }
                    //buttonreferesh.setText(String.valueOf(weekconcenctrationAVG[12]));
                    //buttonback.setText(String.valueOf(weekconcenctrationAVG[12]));
                    //buttonback.setText(String.valueOf(daywindow[14]));
                    //buttonreferesh.setText(String.valueOf(daywindow[14]));
                    //buttonback.setText(String.valueOf(weekconcenctrationAVG[11]));

                    ////////////////////////////////////////MONTH TO YEAR//////////////////////////////////////
                    if(monthtimeB[iterator] == 1) //checks if on month of snauay
                    {
                        if(iterator>0) {//iterator > 0 &&
                            if ( (monthtimeB[iterator - 1] == 12) ) //makes sure last point was in december
                            {
                                //minutewindow[minutetimeB[iterator]] = minutetimeB[iterator];
                                //mintuteconcentrationAVG[minutetimeB[iterator]] = concentration[iterator]; //get back over here
                                //reset all other values

                                //seriesB.resetData(aserieshoursB);
                                yearwindow[yeartimeB[iterator-1]-2021] = yeartimeB[iterator-1]-2000; // adds a value to the year window array

                                //CHANGE STUFF OVER HERE
                                if (monthssize < 12) {               //iterator - (secondssize)  //once again checks if past year entries going for less then a year
                                    for (int i = monthtimeB[iterator - 1] - (monthssize); i < monthtimeB[iterator - 1] + 1; i++)        ////
                                    {                                                         ////

                                        averagesum = averagesum + weekconcenctrationAVG[i];           ///////BOOK MARK!
                                        ////
                                        //buttonreferesh.setText(String.valueOf(secondssize));
                                    }
                                    for (int i = 2; i < monthtimeB[iterator - 1] + 1; i++) { //resets the 2 windows of time
                                        monthwindow[i] = -1;
                                        weekconcenctrationAVG[i] = 0;
                                    }
                                    if(monthssize == 0)                                               /////////
                                    {
                                        yearsconcentrationAVG[yeartimeB[iterator-1]-2021]  = averagesum;     /////////////puts year entries into the values
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

                                        averagesum = averagesum + weekconcenctrationAVG[i];           ////sums up and averages vlaues, puts in year concentration array
                                        ////
                                        //buttonreferesh.setText(String.valueOf(secondssize));
                                    }
                                    yearsconcentrationAVG[yeartimeB[iterator-1]-2021] = averagesum /12; //iterator-1

                                    averagesum = 0;
                                    //buttonreferesh.setText(String.valueOf(mintuteconcentrationAVG[22]));
                                }
                            }
                            else//if not at 12
                            {
                                for(int i = 1; i < monthtimeB[iterator - 1] + 1; i++)        ////60 - (minutessize)    60
                                {                                                         ////

                                    averagesum = averagesum + weekconcenctrationAVG[i];           ////summs up value, should have only one to being with
                                    ////
                                    //buttonreferesh.setText(String.valueOf(secondssize));j
                                }
                                yearwindow[yeartimeB[iterator]-2021] = yeartimeB[iterator]-2000; //adds the value to the array
                                if(monthssize == 0)                                               /////////
                                {
                                    yearsconcentrationAVG[yeartimeB[iterator]-2021]  = averagesum;     /////////////puts average values into month
                                }
                                else {
                                    yearsconcentrationAVG[yeartimeB[iterator] - 2021] = averagesum / monthssize;
                                }
                                //buttonreferesh.setText(String.valueOf(mintuteconcentrationAVG[0]));
                                //buttonback.setText(String.valueOf(secondssize)); //mintuteconcentrationAVG[23]
                                averagesum = 0;

                            }
                        }

                        else //checks if iterator is not greater then 0, and takes concentration average and time netries
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
                    }//if month isnt january
                    else
                    {
                        //secondwindow[time[iterator]] = time[iterator];
                        //secconcentrationAVG[time[iterator]] = concentration[iterator];
                        for(int i = 1; i < monthwindow.length; i++)         ////dayssize
                        {                                                         ////
                            if(monthwindow[i] != -1) {
                                averagesum = averagesum + weekconcenctrationAVG[i];           ///sums up values to average them
                                ////
                            }
                            //buttonreferesh.setText(String.valueOf(weekconcenctrationAVG[11]));
                           // buttonback.setText(String.valueOf(averagesum));

                            //buttonreferesh.setText(String.valueOf(secondssize));
                        }
                        yearwindow[yeartimeB[iterator]-2021] = yeartimeB[iterator]-2000;  //adds window entry
                        if(monthssize == 0)                                               /////////
                        {
                            yearsconcentrationAVG[yeartimeB[iterator]-2021]  = averagesum;     /////////////
                            //buttonback.setText(String.valueOf(yearsconcentrationAVG[1]));
                        }

                        else {
                            yearsconcentrationAVG[yeartimeB[iterator] - 2021] = averagesum / monthssize; //adds concentration entries
                            //buttonback.setText(String.valueOf(yearsconcentrationAVG[1]));


                        }
                        if(iterator>0)
                        {
                            if(monthtimeB[iterator-1] != monthtimeB[iterator])
                            {
                                yearsconcentrationAVG[yeartimeB[iterator] - 2021] = averagesum / (monthssize+1); //need to add this for edge cases
                                //buttonreferesh.setText(String.valueOf(averagesum));
                                //buttonreferesh.setText(String.valueOf(averagesum));
                                //buttonback.setText(String.valueOf(weekconcenctrationAVG[12]));
                                //buttonback.setText(String.valueOf(yearsconcentrationAVG[1]));

                            }
                        }
                        //buttonreferesh.setText(String.valueOf(averagesum));
                        //buttonreferesh.setText(String.valueOf(yearsconcentrationAVG[1]));
                        //buttonback.setText(String.valueOf(monthssize)); //mintuteconcentrationAVG[23]
                        averagesum = 0;
                        //buttonreferesh.setText(String.valueOf(iterator));
                        //buttonback.setText(String.valueOf(daywindow[1]));
                        //buttonreferesh.setText(String.valueOf(weekconcenctrationAVG[11]));
                    }
                    //buttonreferesh.setText(String.valueOf(weekconcenctrationAVG[11]));
                    //buttonback.setText(String.valueOf(weekconcenctrationAVG[12]));
                    buttonreferesh.setText(String.valueOf(yearsconcentrationAVG[1]));

                    //buttonback.setText(String.valueOf(yearsconcentrationAVG[12]));
                    //buttonback.setText(String.valueOf(monthwindow[12]));
                    //buttonreferesh.setText(String.valueOf(weekconcenctrationAVG[12]));
                    //buttonback.setText(String.valueOf(secondwindow[7]));
                    //buttonreferesh.setText(String.valueOf(secondwindow[7]));
                    //buttonreferesh.setText(String.valueOf(yearsconcentrationAVG[1]));
                    //buttonreferesh.setText(String.valueOf(minutewindow[0]));
                    //buttonback.setText(String.valueOf(mintuteconcentrationAVG[0]));
                    ////////////////////////////////////////MONTH TO YEAR//////////////////////////////////////
                    ///////////////////////////////////////////// OLD STUFF, NOT CURRENTLY BEEING USED
                    ////////////////////////////////////////////////////////////////////////////////
                    /////////////////////////////////////////////////////////////////////////////////
                    //THE FOLLOWING FEW LINES OF CODE WERE FORMERLY USED TO DETERMINE AVERAGE CONCENTRATION VALUEs
                    ///////////////////////////////////////////////////////////////////////////////// Old w

                    if((iterator+1)%60==0)                                        /////
                    {                                                             /////
                        minutetime[minutiterator] = minutiterator;                //// +1
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
                        hourtime[houriterator] = houriterator ;                //// +1
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
                //////////////////////////////////////////////////////////////////////////////////////////
                ///////////////////////////////////////////////////////////////////////////////////////////
                ///////////////////////////////////////////////////////////////////////////////////////////
                int whilecheck = 0;
                for(int i = 0; i < 60; i++) /// THis section involves checking if there is content in the second window and
                {                           // and adding it to the dataset if it is, both x and y values

                    if(secondwindow[i] != -1)
                    {                   //if it isnt -1, indicates that it has an actual value
                    aseriesB[whilecheck] = new DataPoint(secondwindow[i], secconcentrationAVG[i] );
                    seriesB.appendData( aseriesB[whilecheck], true, 100);
                    whilecheck = whilecheck + 1;
                    }
                }

                int whilecheck2 = 0;
                for(int i = 0; i < 60; i++) //same thing but in terms of minutes instead of seconds
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

                    if(hourwindow[i] != -1) //same thing but hours instead of minutes
                    {                   //secondwindow[i]
                        aserieshoursB[whilecheck3] = new DataPoint(hourwindow[i], hourconcentrationAVG[i] );
                        serieshoursB.appendData( aserieshoursB[whilecheck3], true, 100);
                        whilecheck3 = whilecheck3 + 1;
                    }
                }
                int whilecheck4 = 0;
                for(int i = 0; i < 32; i++)
                {

                    if(daywindow[i] != -1) //same thing but with hours
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
                    {                   //same think but with months
                        aseriesweekB[whilecheck5] = new DataPoint(monthwindow[i], weekconcenctrationAVG[i] );
                        seriesweekB.appendData( aseriesweekB[whilecheck5], true, 100);
                        whilecheck5 = whilecheck5 + 1;
                    }
                }

                int whilecheck6 = 0;
                for(int i = 0; i < 10; i++)
                {

                    if(yearwindow[i] != -1)
                    {                   //same thing but with years
                        aseriesyearB[whilecheck6] = new DataPoint(yearwindow[i], yearsconcentrationAVG[i] );
                        seriesyearB.appendData( aseriesyearB[whilecheck6], true, 100);
                        whilecheck6 = whilecheck6 + 1;
                    }
                }


                ////////////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////////////B

                //buttonreferesh.setText(String.valueOf(secondwindow[6]));       ///////////////////////DEBUGGGING HERE

                //series = new LineGraphSeries<DataPoint>();
                //seriesminutes = new LineGraphSeries<DataPoint>();
                //serieshours = new LineGraphSeries<DataPoint>();
                t = time[0];
                c = concentration[0];// not used, ignore
                //oxyg1.setText(String.valueOf(c));
                GraphView graph = (GraphView) findViewById(R.id.graphth);
                //GraphView graph2 = (GraphView) findViewById(R.id.graph);
                //This section is also from old style of graphing , ignore this
                double g = 0;
                String ge;
                DataPoint[] a = new DataPoint[arraysize];
                DataPoint[] aminutes = new DataPoint[minutes];
                for(int i = 0; i < minutes; i++) {                                      ////
                    //protected(series.resetData(new DataPoint[] {}));
                    aminutes[i] = new DataPoint(minutetime[i], mintuteconcentration[i]);       ////

                    //seriesminutes.appendData(aminutes[i], true, minutes + 3);    ////
                    //g = Double.parseDouble(String.valueOf(series.findDataPointAtX(time[i])));

                }
                //if(series.)
                for(int i = 0; i < arraysize; i++) {
                    //protected(series.resetData(new DataPoint[] {}));
                    a[i] = new DataPoint(time[i], concentration[i]);
                    //graph.onDataChanged(true,true);
                    //series.appendData(a[i], true, arraysize + 40); UNCOMMENT LATER MAYBE
                    //graph.onDataChanged(true,true);
                    //g = Double.parseDouble(String.valueOf(series.findDataPointAtX(time[i])));

                }
                DataPoint[] ahours = new DataPoint[hours];  ///////
                for(int i = 0; i < hours; i++) {                                      ////
                    //protected(series.resetData(new DataPoint[] {}));
                    ahours[i] = new DataPoint(hourtime[i], hourconcentration[i]);       ////

                    //serieshours.appendData(ahours[i], true, hours + 3);    ////
                    //g = Double.parseDouble(String.valueOf(series.findDataPointAtX(time[i])));

                }


                seriesday = new LineGraphSeries<DataPoint>();
                //double g = 0;
                //String ge;
                DataPoint[] aday= new DataPoint[days];  ///////

                //if(series.)
                for(int i = 0; i < days; i++) {                                      ////
                    //protected(series.resetData(new DataPoint[] {}));
                    aday[i] = new DataPoint(daytime[i], dayconcenctration[i]);       ////

                    //seriesday.appendData(aday[i], true, days + 3);    ////
                    //g = Double.parseDouble(String.valueOf(series.findDataPointAtX(time[i])));

                }

                seriesweek = new LineGraphSeries<DataPoint>();
                //double g = 0;
                //String ge;
                DataPoint[] aweek= new DataPoint[weeks];  ///////


                for(int i = 0; i < weeks; i++) {                                      ////
                    //protected(series.resetData(new DataPoint[] {}));
                    aweek[i] = new DataPoint(weektime[i], weekconcenctration[i]);       ////

                    //seriesweek.appendData(aweek[i], true, weeks + 3);    ////

                }

                seriesyear = new LineGraphSeries<DataPoint>();

                DataPoint[] ayear= new DataPoint[years];  ///////

                for(int i = 0; i < years; i++) {                                      ////
                    //protected(series.resetData(new DataPoint[] {}));
                    ayear[i] = new DataPoint(yeartime[i], yearsconcentration[i]);       ////

                    //seriesyear.appendData(ayear[i], true, years + 3);    ////
                    graph.onDataChanged(true,true);

                    //g = Double.parseDouble(String.valueOf(series.findDataPointAtX(time[i])));

                }
                //In this section, the produced series's are set to the global series, so they can be accessed by
                //the graphs
                seriessupersecond = seriesB;  //series
                seriessuperminute1 = seriesminutesB; //seriesminutes
                seriesghour1 = serieshoursB; //serieshours
                seriesgday1 = seriesdayB; //seriesday
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
                //here you go to opentesting, which sets up the graphs automatically
                opentesting();



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        /*
        GraphView graph = (GraphView) findViewById(R.id.graph);
        graph.setTitle("         CO2 Sensor 1");
        graph.setTitleTextSize(25);
        graph.getGridLabelRenderer().setNumHorizontalLabels(3);
        //graph.getGridLabelRenderer().setNumVerticalLabels(4);
        graph.removeAllSeries();
        graph.addSeries(seriessupersecond);
        //graph.setVisibility(View.GONE);
        GridLabelRenderer griLa = graph.getGridLabelRenderer();
        LineGraphSeries lil = seriessupersecond;
        lil.setThickness(2);
        griLa.setHorizontalAxisTitle("              Seconds");
        griLa.setHorizontalAxisTitleTextSize(20);
        griLa.setVerticalAxisTitle("ppm");
        griLa.setLabelVerticalWidth(43);
        //griLa.setH;
        griLa.setVerticalAxisTitleTextSize(20);
        graph.getViewport().setXAxisBoundsManual(true);
        */


        rootDatabaseref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //check comments on previous databaseref for understanding functionality
                if((snapshot.getChildrenCount()== 0)) { //error handling
                    return;
                }
                LineGraphSeries<DataPoint> series;
                LineGraphSeries<DataPoint> seriesminutes;
                LineGraphSeries<DataPoint> serieshours;
                LineGraphSeries<DataPoint> seriesday;
                LineGraphSeries<DataPoint> seriesweek;
                LineGraphSeries<DataPoint> seriesyear;
                ////////////////////////////////////////////////////////////////////////////////////
                /////////////////////////////////////////////////////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////A
                PointsGraphSeries<DataPoint> seriesB;        //declares series's used for producing graphs
                PointsGraphSeries<DataPoint> seriesminutesB;
                PointsGraphSeries<DataPoint> serieshoursB;
                PointsGraphSeries<DataPoint> seriesdayB;
                PointsGraphSeries<DataPoint> seriesweekB;
                PointsGraphSeries<DataPoint> seriesyearB;
                /////////////////////////////////////////////////////////////////////////////////////B
                ///////////////////////////////////////////////////////////////////////////////////
                /////////////////////////////////////////////////////////////////////////////////
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
                for(DataSnapshot snapshot1 : snapshot.getChildren()) //iterate through list of data to get size
                {
                    arraysize = arraysize + 1;
                }
                int[] time = new int[arraysize];
                double minutediv = arraysize/60;                ///////////code no longer used
                double hourdiv = arraysize/3600;
                double daydiv = arraysize/43200;
                double weekdiv = arraysize/302400;
                double yeardiv = arraysize/15768000;


                double minutesdoub = Math.floor(minutediv);     ///////////code no longer used
                double hoursdoub = Math.floor(hourdiv);     ///////////
                double daydouble = Math.floor(daydiv);
                double weekdouble = Math.floor(weekdiv);
                double yearsdouble = Math.floor(yeardiv);

                int minutes = (int)minutesdoub;
                int hours = (int)hoursdoub;                 ////////// code no longer used
                int days = (int)daydouble;
                int weeks = (int)weekdouble;
                int years = (int)yearsdouble;

                int[] minutetime = new int[minutes];
                int[] hourtime = new int[hours];            ////////// code no longer used
                int[] daytime = new int[days];
                int[] weektime = new int[weeks];
                int[] yeartime = new int[years];
                /////////////////////////////////////////////////////NEW VARIABLES TO PLAY WITH A
                ////////////////////////////////////////////////////
                /////////////////////////////////////////////////
                int parsetogetsizes = 0;

                int[] minutetimeB = new int[arraysize];
                int[] hourtimeB = new int[arraysize];            //////////
                int[] daytimeB = new int[arraysize];
                int[] monthtimeB = new int[arraysize];
                int[] yeartimeB = new int[arraysize];

                int[] secondwindow = new int[60];
                int[] minutewindow = new int[60];
                for(int i = 0; i < 60; i++)  //here set the default for array of window values, -1 means that the value is empty for minutes seconds years etc
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
                double[] mintuteconcentrationAVG = new double[60]; ////// hold average values for each unit for different units of time
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

                //put sizes back here if it doesnt work
                /////////////////////////////////////////////////////
                /////////////////////////////////////////////////////
                /////////////////////////////////////////////////////NEW VARIABLES TO PLAY WITH B
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
                series = new LineGraphSeries<DataPoint>();
                seriesminutes = new LineGraphSeries<DataPoint>();
                serieshours = new LineGraphSeries<DataPoint>();

                /////////////////////////////////////////////////////////A
                /////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////
                seriesB = new PointsGraphSeries<DataPoint>();
                seriesminutesB = new PointsGraphSeries<DataPoint>();
                serieshoursB = new PointsGraphSeries<DataPoint>();
                seriesdayB = new PointsGraphSeries<DataPoint>();
                seriesweekB = new PointsGraphSeries<DataPoint>();
                seriesyearB = new PointsGraphSeries<DataPoint>();

                DataPoint[] aseriesB= new DataPoint[60];
                DataPoint[] aseriesminutesB= new DataPoint[60]; //data points to put in series
                DataPoint[] aserieshoursB= new DataPoint[24];
                DataPoint[] aseriesdayB= new DataPoint[32];
                DataPoint[] aseriesweekB= new DataPoint[13];
                DataPoint[] aseriesyearB= new DataPoint[10];
                //time[iterator] = Integer.parseInt((snapshot.getChildren()).child("time").getValue().toString());
                ////////////////////////////////////////////////////////

                for(DataSnapshot snapshot1 : snapshot.getChildren())
                { //iterates through ever variable thats put into the database

                    int secondssize = 0; //tells how much stuff is in a window
                    int minutessize = 0;
                    int hourssize = 0;
                    int dayssize = 0;
                    int monthssize = 0;
                    int yearssize = 0;



                    time[iterator] = Integer.parseInt(snapshot1.child("7-Seconds").getValue().toString());                     //7-Seconds time               seconds value in database
                    concentration[iterator] = Double.parseDouble(snapshot1.child("1-Concentration").getValue().toString()); //1-Concentration concentration   concentration value
                    minutetimeB[iterator] = Integer.parseInt(snapshot1.child("6-Minute").getValue().toString());            //6-Minute minute
                    hourtimeB[iterator] = Integer.parseInt(snapshot1.child("5-Hour").getValue().toString());                //5-Hour hour
                    daytimeB[iterator] = Integer.parseInt(snapshot1.child("4-Day").getValue().toString());                  //4-Day day
                    monthtimeB[iterator] = Integer.parseInt(snapshot1.child("3-Month").getValue().toString());              //3-Month month
                    yeartimeB[iterator] = Integer.parseInt(snapshot1.child("2-Year").getValue().toString());                //2-Year year

                    if(concentration[iterator] > max)
                    {
                        max = concentration[iterator];  //used to determine max of y axis in graph
                    }



                    //if(snapshot1 == snapshot.getChildren()-1)
                    //secondwindow[time[iterator]] = time[iterator];GO BACK
                    //////////////////////////////////////////////A
                    //////////////////////////////////////////////
                    /////////////////////////////////////////////
                    for(int i = 0; i < 60; i++)                 //this section of for loops is used to determine the number of non null values in an array
                    {
                        if(secondwindow[i] != -1)               //
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
                    if(iterator > 0) //checks if time index is greateer then zero 0
                    {
                        if(iterator>0) {//iterator > 0 && nested statement, redundant
                            if ( minutetimeB[iterator - 1] != minutetimeB[iterator]) //ensures that there is a change in minute window
                            {
                                secondwindow[time[iterator]] = time[iterator]; //gets value in array for second window
                                secconcentrationAVG[time[iterator]] = concentration[iterator]; //gets value for conentration value, not actually an average
                                //reset all other values
                                for (int i = 1; i < 60; i++) {
                                    secondwindow[i] = -1;                 //resets the window
                                    secconcentrationAVG[i] = 0;
                                }
                                //seriesB.resetData(aserieshoursB);
                                minutewindow[minutetimeB[iterator]] = minutetimeB[iterator]; //gets a value in the minute window                 minutetimeB[iterator-1]  iterator-1

                                secondwindow[time[iterator]] = time[iterator]; //gets value in array for second window again
                                secconcentrationAVG[time[iterator]] = concentration[iterator]; //  getting concentration
                                if (secondssize < 60) {               //iterator - (secondssize)
                                    for (int i = iterator - (secondssize); i < iterator+1; i++)        ////ITERATOR+1
                                    {                                                         ////

                                        averagesum = averagesum + concentration[i];           ////
                                        ////
                                        //buttonreferesh.setText(String.valueOf(secondssize));
                                    }
                                    //mintuteconcentrationAVG[minutetimeB[iterator]] = averagesum / (secondssize + 1); //CHECK AGAIN IF INCOTTRct
                                    mintuteconcentrationAVG[minutetimeB[iterator]] = concentration[iterator];
                                    averagesum = 0; //resets average sum so
                                    //buttonreferesh.setText(String.valueOf(mintuteconcentrationAVG[0]));
                                    //minutiteratorB = minutiteratorB + 1;


                                } else {
                                    for (int i = iterator - (secondssize); i < iterator+1; i++)        ////iterates through seconds
                                    {                                                         ////

                                        averagesum = averagesum + concentration[i];           //// adds up for the concentration
                                        ////
                                        //buttonreferesh.setText(String.valueOf(secondssize));
                                    }
                                    mintuteconcentrationAVG[minutetimeB[iterator]] = averagesum / 60; //iterator-1
                                    mintuteconcentrationAVG[minutetimeB[iterator]] = concentration[iterator]; //TAKE OUT IF WRONG
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
                                    else {                                                            ///////////////
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
                        //buttonback.setText(String.valueOf(hourwindow[3]));
                        //buttonback.setText(String.valueOf(hourconcentrationAVG[3]));
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
                                //buttonreferesh.setText(String.valueOf(dayconcenctrationAVG[1]));
                                //buttonback.setText(String.valueOf(daywindow[1]));
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
                    //buttonreferesh.setText(String.valueOf(dayconcenctrationAVG[1]));
                    //buttonback.setText(String.valueOf(daywindow[1]));
                    //checkpoint//849


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
                                //buttonreferesh.setText(String.valueOf(weekconcenctrationAVG[12]));
                                //buttonback.setText(String.valueOf(weekconcenctrationAVG[12]));
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
                                //buttonreferesh.setText(String.valueOf(weekconcenctrationAVG[12]));
                                //buttonback.setText(String.valueOf(weekconcenctrationAVG[12]));
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
                            //buttonreferesh.setText(String.valueOf(weekconcenctrationAVG[11]));
                        }
                        else {
                            weekconcenctrationAVG[monthtimeB[iterator]] = averagesum / dayssize;
                            //buttonreferesh.setText(String.valueOf(weekconcenctrationAVG[11]));
                        }
                        //buttonreferesh.setText(String.valueOf(hourconcentrationAVG[11]));
                        //buttonback.setText(String.valueOf(mintuteconcentrationAVG[23])); //mintuteconcentrationAVG[23]
                        averagesum = 0;
                        //buttonreferesh.setText(String.valueOf(iterator));
                        //buttonback.setText(String.valueOf(dayssize));
                        //buttonreferesh.setText(String.valueOf(weekconcenctrationAVG[11]));
                    }
                    //buttonreferesh.setText(String.valueOf(weekconcenctrationAVG[12]));
                    //buttonback.setText(String.valueOf(weekconcenctrationAVG[12]));
                    //buttonback.setText(String.valueOf(daywindow[14]));
                    //buttonreferesh.setText(String.valueOf(daywindow[14]));
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
                                    for (int i = 2; i < monthtimeB[iterator - 1] + 1; i++) {
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
                            //buttonreferesh.setText(String.valueOf(weekconcenctrationAVG[11]));
                            // buttonback.setText(String.valueOf(averagesum));

                            //buttonreferesh.setText(String.valueOf(secondssize));
                        }
                        yearwindow[yeartimeB[iterator]-2021] = yeartimeB[iterator]-2000;
                        if(monthssize == 0)                                               /////////
                        {
                            yearsconcentrationAVG[yeartimeB[iterator]-2021]  = averagesum;     /////////////
                            //buttonback.setText(String.valueOf(yearsconcentrationAVG[1]));
                        }

                        else {
                            yearsconcentrationAVG[yeartimeB[iterator] - 2021] = averagesum / monthssize;
                            //buttonback.setText(String.valueOf(yearsconcentrationAVG[1]));


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
                        //buttonreferesh.setText(String.valueOf(averagesum));
                        //buttonreferesh.setText(String.valueOf(yearsconcentrationAVG[1]));
                        //buttonback.setText(String.valueOf(monthssize)); //mintuteconcentrationAVG[23]
                        averagesum = 0;
                        //buttonreferesh.setText(String.valueOf(iterator));
                        //buttonback.setText(String.valueOf(daywindow[1]));
                        //buttonreferesh.setText(String.valueOf(weekconcenctrationAVG[11]));
                    }
                    //buttonreferesh.setText(String.valueOf(weekconcenctrationAVG[11]));
                    //buttonback.setText(String.valueOf(weekconcenctrationAVG[12]));
                    buttonreferesh.setText(String.valueOf(yearsconcentrationAVG[1]));

                    //buttonback.setText(String.valueOf(yearsconcentrationAVG[12]));
                    //buttonback.setText(String.valueOf(monthwindow[12]));
                    //buttonreferesh.setText(String.valueOf(weekconcenctrationAVG[12]));
                    //buttonback.setText(String.valueOf(secondwindow[7]));
                    //buttonreferesh.setText(String.valueOf(secondwindow[7]));
                    //buttonreferesh.setText(String.valueOf(yearsconcentrationAVG[1]));
                    //buttonreferesh.setText(String.valueOf(minutewindow[0]));
                    //buttonback.setText(String.valueOf(mintuteconcentrationAVG[0]));
                    ////////////////////////////////////////MONTH TO YEAR//////////////////////////////////////
                    ///////////////////////////////////////////// NEW STUFF2
                    ////////////////////////////////////////////////////////////////////////////////
                    /////////////////////////////////////////////////////////////////////////////////
                    /////////////////////////////////////////////////////////////////////////////////

                    if((iterator+1)%60==0)                                        /////
                    {                                                             /////
                        minutetime[minutiterator] = minutiterator;                //// +1
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
                        hourtime[houriterator] = houriterator ;                //// +1
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
                //////////////////////////////////////////////////////////////////////////////////////////
                ///////////////////////////////////////////////////////////////////////////////////////////
                ///////////////////////////////////////////////////////////////////////////////////////////
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


                ////////////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////////////B

                //buttonreferesh.setText(String.valueOf(secondwindow[6]));       ///////////////////////DEBUGGGING HERE

                //series = new LineGraphSeries<DataPoint>();
                //seriesminutes = new LineGraphSeries<DataPoint>();
                //serieshours = new LineGraphSeries<DataPoint>();
                t = time[0];
                c = concentration[0];
                //oxyg1.setText(String.valueOf(c));
                GraphView graph = (GraphView) findViewById(R.id.graph12th);
                //GraphView graph2 = (GraphView) findViewById(R.id.graph);

                double g = 0;
                String ge;
                DataPoint[] a = new DataPoint[arraysize];
                DataPoint[] aminutes = new DataPoint[minutes];
                for(int i = 0; i < minutes; i++) {                                      ////
                    //protected(series.resetData(new DataPoint[] {}));
                    aminutes[i] = new DataPoint(minutetime[i], mintuteconcentration[i]);       ////

                    //seriesminutes.appendData(aminutes[i], true, minutes + 3);    ////
                    //g = Double.parseDouble(String.valueOf(series.findDataPointAtX(time[i])));

                }
                //if(series.)
                for(int i = 0; i < arraysize; i++) {
                    //protected(series.resetData(new DataPoint[] {}));
                    a[i] = new DataPoint(time[i], concentration[i]);
                    //graph.onDataChanged(true,true);
                    //series.appendData(a[i], true, arraysize + 40); UNCOMMENT LATER MAYBE
                    //graph.onDataChanged(true,true);
                    //g = Double.parseDouble(String.valueOf(series.findDataPointAtX(time[i])));

                }
                DataPoint[] ahours = new DataPoint[hours];  ///////
                for(int i = 0; i < hours; i++) {                                      ////
                    //protected(series.resetData(new DataPoint[] {}));
                    ahours[i] = new DataPoint(hourtime[i], hourconcentration[i]);       ////

                    //serieshours.appendData(ahours[i], true, hours + 3);    ////
                    //g = Double.parseDouble(String.valueOf(series.findDataPointAtX(time[i])));

                }


                seriesday = new LineGraphSeries<DataPoint>();
                //double g = 0;
                //String ge;
                DataPoint[] aday= new DataPoint[days];  ///////

                //if(series.)
                for(int i = 0; i < days; i++) {                                      ////
                    //protected(series.resetData(new DataPoint[] {}));
                    aday[i] = new DataPoint(daytime[i], dayconcenctration[i]);       ////

                    //seriesday.appendData(aday[i], true, days + 3);    ////
                    //g = Double.parseDouble(String.valueOf(series.findDataPointAtX(time[i])));

                }

                seriesweek = new LineGraphSeries<DataPoint>();
                //double g = 0;
                //String ge;
                DataPoint[] aweek= new DataPoint[weeks];  ///////


                for(int i = 0; i < weeks; i++) {                                      ////
                    //protected(series.resetData(new DataPoint[] {}));
                    aweek[i] = new DataPoint(weektime[i], weekconcenctration[i]);       ////

                    //seriesweek.appendData(aweek[i], true, weeks + 3);    ////

                }

                seriesyear = new LineGraphSeries<DataPoint>();

                DataPoint[] ayear= new DataPoint[years];  ///////

                for(int i = 0; i < years; i++) {                                      ////
                    //protected(series.resetData(new DataPoint[] {}));
                    ayear[i] = new DataPoint(yeartime[i], yearsconcentration[i]);       ////

                    //seriesyear.appendData(ayear[i], true, years + 3);    ////
                    graph.onDataChanged(true,true);

                    //g = Double.parseDouble(String.valueOf(series.findDataPointAtX(time[i])));

                }

                seriesgsecond2 = seriesB;  //series
                seriesgsuperminute2 = seriesminutesB; //seriesminutes
                seriesghour2 = serieshoursB; //serieshours
                seriesgday2 = seriesdayB; //seriesday
                seriesgweek2 = seriesweekB;
                seriesgyear2 = seriesyearB;
                arraysizeCHECKglobal = arraysize;
                arraysizeglobalsecond2 = arraysize;
                arraysizeglobalminute2= minutes;
                arraysizeglobalhour2 = hours;
                arraysizeglobalday2 = days;
                arraysizeglobalweek2 = weeks;
                arraysizeglobalyear2 = years;
                graph = (GraphView) findViewById(R.id.graphth);
                opentesting2();



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        rootDatabaseref3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                LineGraphSeries<DataPoint> series;
                LineGraphSeries<DataPoint> seriesminutes;
                LineGraphSeries<DataPoint> serieshours;
                LineGraphSeries<DataPoint> seriesday;
                LineGraphSeries<DataPoint> seriesweek;
                LineGraphSeries<DataPoint> seriesyear;
                String data;// = snapshot.child();
                Double z;// = Double.parseDouble(data);
                //double max = 0;
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
                    concentration[iterator] = Double.parseDouble(snapshot1.child("concentration").getValue().toString());
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
                GraphView graph = (GraphView) findViewById(R.id.graph3th); /////////////////////////////////////////

                series = new LineGraphSeries<DataPoint>();
                seriesminutes = new LineGraphSeries<DataPoint>();
                serieshours = new LineGraphSeries<DataPoint>();
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

                    series.appendData(a[i], true, arraysize + 40);
                    //g = Double.parseDouble(String.valueOf(series.findDataPointAtX(time[i])));

                }
                DataPoint[] ahours = new DataPoint[hours];  ///////
                for(int i = 0; i < hours; i++) {                                      ////
                    //protected(series.resetData(new DataPoint[] {}));
                    ahours[i] = new DataPoint(hourtime[i], hourconcentration[i]);       ////

                    serieshours.appendData(ahours[i], true, hours + 3);    ////
                    //g = Double.parseDouble(String.valueOf(series.findDataPointAtX(time[i])));

                }


                seriesday = new LineGraphSeries<DataPoint>();
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

                seriesweek = new LineGraphSeries<DataPoint>();
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

                seriesyear = new LineGraphSeries<DataPoint>();
                //double g = 0;
                //String ge;
                DataPoint[] ayear= new DataPoint[years];  ///////

                //if(series.)
                for(int i = 0; i < years; i++) {                                      ////
                    //protected(series.resetData(new DataPoint[] {}));
                    ayear[i] = new DataPoint(yeartime[i], yearsconcentration[i]);       ////

                    seriesyear.appendData(ayear[i], true, years + 3);    ////
                    //g = Double.parseDouble(String.valueOf(series.findDataPointAtX(time[i])));

                }
                seriesgsecond3 = series;

                seriesgsuperminute3 = seriesminutes;
                seriesghour3 = serieshours;
                seriesgday3 = seriesday;
                seriesgweek3 = seriesweek;
                seriesgyear3 = seriesyear;

                arraysizeglobalsecond3 = arraysize;
                arraysizeglobalminute3 = minutes;
                arraysizeglobalhour3 = hours;
                arraysizeglobalday3 = days;
                arraysizeglobalweek3 = weeks;
                arraysizeglobalyear3 = years;
                opentesting3();
                //series = null;
                //series = new LineGraphSeries<DataPoint>(a);
                //ge = String.valueOf(series.findDataPointAtX(1));
                //cra.setText(ge);
                ///////////////////////////////////////////////////////////////////
                /*
                graph.setTitle("         CO2 Sensor 3");
                graph.setTitleTextSize(25);

                //graph.getGridLabelRenderer().setNumVerticalLabels(4);
                graph.removeAllSeries();
                graph.addSeries(series);
                graph.getGridLabelRenderer().setNumHorizontalLabels(3);
                GridLabelRenderer griLa = graph.getGridLabelRenderer();
                LineGraphSeries lil = series;
                lil.setThickness(2);
                griLa.setHorizontalAxisTitle("              Seconds");
                griLa.setHorizontalAxisTitleTextSize(20);
                griLa.setVerticalAxisTitle("ppm");
                griLa.setLabelVerticalWidth(43);
                //griLa.setH;
                griLa.setVerticalAxisTitleTextSize(20);
                graph.getViewport().setXAxisBoundsManual(true);
                graph.getViewport().setYAxisBoundsManual(true);
                if(arraysize<60)
                {
                    graph.getViewport().setMinX(0);
                    graph.getViewport().setMaxX(60);
                }
                else
                {
                    graph.getViewport().setMinX(arraysize-60);
                    graph.getViewport().setMaxX(arraysize);
                }
                //graph.getViewport().setMaxX(arraysize);
                graph.getViewport().setMaxY(max + .2*max);
                graph.getViewport().setMinY(0);

                 */
                /////////////////////////////////////////////////////////////////
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        rootDatabaseref4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                LineGraphSeries<DataPoint> series;
                LineGraphSeries<DataPoint> seriesminutes;
                LineGraphSeries<DataPoint> serieshours;
                LineGraphSeries<DataPoint> seriesday;
                LineGraphSeries<DataPoint> seriesweek;
                LineGraphSeries<DataPoint> seriesyear;
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
                    concentration[iterator] = Double.parseDouble(snapshot1.child("concentration").getValue().toString());
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

                //GraphView graph = (GraphView) findViewById(R.id.graph4);                //////////////////////////////////////////////////
                //GraphView graph2 = (GraphView) findViewById(R.id.graph);
                series = new LineGraphSeries<DataPoint>();
                seriesminutes = new LineGraphSeries<DataPoint>();
                serieshours = new LineGraphSeries<DataPoint>();
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

                    series.appendData(a[i], true, arraysize + 40);

                    //g = Double.parseDouble(String.valueOf(series.findDataPointAtX(time[i])));

                }
                DataPoint[] ahours = new DataPoint[hours];  ///////
                for(int i = 0; i < hours; i++) {                                      ////
                    //protected(series.resetData(new DataPoint[] {}));
                    ahours[i] = new DataPoint(hourtime[i], hourconcentration[i]);       ////

                    serieshours.appendData(ahours[i], true, hours + 3);    ////
                    //g = Double.parseDouble(String.valueOf(series.findDataPointAtX(time[i])));

                }


                seriesday = new LineGraphSeries<DataPoint>();
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

                seriesweek = new LineGraphSeries<DataPoint>();
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

                seriesyear = new LineGraphSeries<DataPoint>();
                //double g = 0;
                //String ge;
                DataPoint[] ayear= new DataPoint[years];  ///////

                //if(series.)
                for(int i = 0; i < years; i++) {                                      ////
                    //protected(series.resetData(new DataPoint[] {}));
                    ayear[i] = new DataPoint(yeartime[i], yearsconcentration[i]);       ////

                    seriesyear.appendData(ayear[i], true, years + 3);    ////
                    //g = Double.parseDouble(String.valueOf(series.findDataPointAtX(time[i])));

                }
                seriesgsecond4 = series;

                seriesgsuperminute4 = seriesminutes;
                seriesghour4 = serieshours;
                seriesgday4 = seriesday;
                seriesgweek4 = seriesweek;
                seriesgyear4 = seriesyear;

                arraysizeglobalsecond4 = arraysize;
                arraysizeglobalminute4 = minutes;
                arraysizeglobalhour4 = hours;
                arraysizeglobalday4 = days;
                arraysizeglobalweek4 = weeks;
                arraysizeglobalyear4 = years;

                opentesting4();
                //series = null;
                //series = new LineGraphSeries<DataPoint>(a);
                //ge = String.valueOf(series.findDataPointAtX(1));
                //cra.setText(ge);

                //////////////////////////////////////////////////////
                /*
                graph.setTitle("         CO2 Sensor 4");
                graph.setTitleTextSize(25);

                //graph.getGridLabelRenderer().setNumVerticalLabels(4);
                graph.removeAllSeries();
                graph.addSeries(series);
                graph.getGridLabelRenderer().setNumHorizontalLabels(3);
                GridLabelRenderer griLa = graph.getGridLabelRenderer();
                LineGraphSeries lil = series;
                lil.setThickness(2);
                griLa.setHorizontalAxisTitle("              Seconds");
                griLa.setHorizontalAxisTitleTextSize(20);
                griLa.setVerticalAxisTitle("ppm");
                griLa.setLabelVerticalWidth(43);
                //griLa.setH;
                griLa.setVerticalAxisTitleTextSize(20);
                graph.getViewport().setXAxisBoundsManual(true);
                graph.getViewport().setYAxisBoundsManual(true);
                /*
                if(arraysize<60)
                {
                    graph.getViewport().setMinX(0);
                    graph.getViewport().setMaxX(60);
                }
                else
                {
                    graph.getViewport().setMinX(arraysize-60);
                    graph.getViewport().setMaxX(arraysize);
                }

                //graph.getViewport().setMaxX(arraysize); //arraysize
                //graph.getViewport().setMaxX(arraysize);
                graph.getViewport().setMaxY(max + .2*max);
                graph.getViewport().setMinY(0);

                */
                /////////////////////////////////////////////////////
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    } //this portion is used to go to co2graph when prompted, refresh button
    public void openActivityrefresh(){
        Intent intent = new Intent(this, mcu1co2graph.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }//this section goes back to mcu1co2
    public void openActivitymain(){
        Intent intent = new Intent(this, mcu1co2.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }

    public void openActivityminutes(){

        GraphView graph = (GraphView) findViewById(R.id.graphth);

        GraphView graph2 = (GraphView) findViewById(R.id.graph12th);
        GraphView graph3 = (GraphView) findViewById(R.id.graph3th);
        GraphView graph4 = (GraphView) findViewById(R.id.graph4);
        Button buttonminutes = (Button) findViewById(R.id.minutestab);
        //here it goes to graphing, the 4 graphs are declared here
        if(indication == 0)
        {
            //indication == 0 means that the value is in terms of seconds, fomratting aspects of graph will be set
            //such as size of values, labels, these are properly described
            graph.setTitle("         CO2 Sensor 1");
            graph.setTitleTextSize(25);
            graph.removeAllSeries();
            seriessupersecond.setSize(2);
            graph.addSeries(seriessupersecond);
            GridLabelRenderer griLa = graph.getGridLabelRenderer();
            //LineGraphSeries lil = seriessupersecond;
            //lil.setThickness(2);
            griLa.setHorizontalAxisTitle("              seconds");
            griLa.setHorizontalAxisTitleTextSize(20);
            griLa.setVerticalAxisTitle("ppm");
            griLa.setLabelVerticalWidth(43);
            griLa.setLabelVerticalWidth(55);
            griLa.setGridColor(Color.LTGRAY);
            //griLa.setH;
            griLa.setVerticalAxisTitleTextSize(20);
            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setYAxisBoundsManual(true);

            //if(arraysizeCHECKglobal<60)
            //{}
                graph.getViewport().setMinX(0);
                graph.getViewport().setMaxX(60);
            /*
            else
            {
                graph.getViewport().setMinX(arraysizeCHECKglobal-60);
                graph.getViewport().setMaxX(arraysizeCHECKglobal);
            }

             */
            graph.getViewport().setMinY(0);
            graph.getViewport().setMaxY(max + .2*max); // here maximum comes into play

            graph2.setTitle("         CO2 Sensor 2");
            graph2.setTitleTextSize(25);
            graph2.removeAllSeries();
            seriesgsecond2.setSize(2);
            graph2.addSeries(seriesgsecond2);
            GridLabelRenderer griLa2 = graph2.getGridLabelRenderer();
            //LineGraphSeries lil2 = seriesgsecond2;
            //lil2.setThickness(2);
            griLa2.setHorizontalAxisTitle("              seconds");
            griLa2.setHorizontalAxisTitleTextSize(20);
            griLa2.setVerticalAxisTitle("ppm");
            griLa2.setLabelVerticalWidth(43);
            griLa2.setLabelVerticalWidth(55);
            griLa2.setGridColor(Color.LTGRAY);
            //griLa.setH;
            griLa2.setVerticalAxisTitleTextSize(20);
            graph2.getViewport().setXAxisBoundsManual(true);
            graph2.getViewport().setYAxisBoundsManual(true);
            //graph2.getViewport().setMaxX(arraysizeglobalsecond2 + 1);
            //graph2.getViewport().setMaxX(arraysizeglobalsecond2 + 1);

            //if(arraysizeglobalsecond2<60)
            //{
                graph2.getViewport().setMinX(0);
                graph2.getViewport().setMaxX(60);
            //}
            /*
            else
            {
                graph2.getViewport().setMinX(arraysizeglobalsecond2-60);
                graph2.getViewport().setMaxX(arraysizeglobalsecond2);
            }

             */
            graph2.getViewport().setMinY(0);
            graph2.getViewport().setMaxY(max + .2*max);

            graph3.setTitle("         CO2 Sensor 3");
            graph3.setTitleTextSize(25);
            graph3.removeAllSeries();
            graph3.addSeries(seriesgsecond3);
            GridLabelRenderer griLa3 = graph3.getGridLabelRenderer();
            LineGraphSeries lil3 = seriesgsecond3;
            lil3.setThickness(2);
            griLa3.setHorizontalAxisTitle("              second");
            griLa3.setHorizontalAxisTitleTextSize(20);
            griLa3.setVerticalAxisTitle("ppm");
            griLa3.setLabelVerticalWidth(43);
            griLa3.setLabelVerticalWidth(55);
            griLa3.setGridColor(Color.LTGRAY);
            //griLa.setH;
            griLa3.setVerticalAxisTitleTextSize(20);
            graph3.getViewport().setXAxisBoundsManual(true);
            graph3.getViewport().setYAxisBoundsManual(true);
            graph3.getViewport().setMaxX(arraysizeglobalsecond3 + 1);
            //graph3.getViewport().setMaxX(arraysizeglobalsecond3 + 1);

            //if(arraysizeglobalsecond3<60)
            //{
                graph3.getViewport().setMinX(0);
                graph3.getViewport().setMaxX(60);
            //}
            //else
            //{
            //    graph3.getViewport().setMinX(arraysizeglobalsecond3-60);
            //    graph3.getViewport().setMaxX(arraysizeglobalsecond3);
            //}
            graph3.getViewport().setMinY(0);
            graph3.getViewport().setMaxY(max + .2*max);

            graph4.setTitle("         CO2 Sensor 4");
            graph4.setTitleTextSize(25);
            graph4.removeAllSeries();
            graph4.addSeries(seriesgsecond4);
            GridLabelRenderer griLa4 = graph4.getGridLabelRenderer();
            LineGraphSeries lil4 = seriesgsecond4;
            lil4.setThickness(2);
            griLa4.setHorizontalAxisTitle("              seconds");
            griLa4.setHorizontalAxisTitleTextSize(20);
            griLa4.setVerticalAxisTitle("ppm");
            griLa4.setLabelVerticalWidth(43);
            griLa4.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa4.setGridColor(Color.LTGRAY);
            griLa4.setVerticalAxisTitleTextSize(20);
            graph4.getViewport().setXAxisBoundsManual(true);
            graph4.getViewport().setYAxisBoundsManual(true);
            graph4.getViewport().setMaxX(arraysizeglobalsecond4 + 1);


            //if(arraysizeglobalsecond4<60)
            //{
                graph4.getViewport().setMinX(0);
                graph4.getViewport().setMaxX(60);
            //}
            //else
            //{
            //    graph4.getViewport().setMinX(arraysizeglobalsecond4-60);
            //    graph4.getViewport().setMaxX(arraysizeglobalsecond4);
            //}
            graph4.getViewport().setMinY(0);
            graph4.getViewport().setMaxY(max + .2*max);


        }
        if(indication == 1)
        { //this is used in the case of minutes, notice that the index changes to minutes for this one


            graph.setTitle("         CO2 Sensor 1");
            graph.setTitleTextSize(25);
            graph.removeAllSeries();
            seriessuperminute1.setSize(2);
            graph.addSeries(seriessuperminute1);

            GridLabelRenderer griLa = graph.getGridLabelRenderer();
            //LineGraphSeries lil = seriessuperminute1;
            //lil.setThickness(2);
            griLa.setHorizontalAxisTitle("              minutes");
            griLa.setHorizontalAxisTitleTextSize(20);
            griLa.setVerticalAxisTitle("ppm");
            griLa.setLabelVerticalWidth(43);
            griLa.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa.setGridColor(Color.LTGRAY);
            griLa.setVerticalAxisTitleTextSize(20);
            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalminute1<10)
            //{}
                graph.getViewport().setMinX(0);
                graph.getViewport().setMaxX(60);
            //}
            /*
            else
            {
                graph.getViewport().setMinX(arraysizeglobalminute1-10);
                graph.getViewport().setMaxX(arraysizeglobalminute1);
            }

             */
            graph.getViewport().setMinY(0);
            graph.getViewport().setMaxY(max + .2*max);

            graph2.setTitle("         CO2 Sensor 2");
            graph2.setTitleTextSize(25);
            graph2.removeAllSeries();
            seriesgsuperminute2.setSize(2);
            graph2.addSeries(seriesgsuperminute2);
            GridLabelRenderer griLa2 = graph2.getGridLabelRenderer();
            //LineGraphSeries lil2 = seriesgsuperminute2;
            //lil2.setThickness(2);
            griLa2.setHorizontalAxisTitle("              minutes");
            griLa2.setHorizontalAxisTitleTextSize(20);
            griLa2.setVerticalAxisTitle("ppm");
            griLa2.setLabelVerticalWidth(43);
            griLa2.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa2.setGridColor(Color.LTGRAY);
            griLa2.setVerticalAxisTitleTextSize(20);
            graph2.getViewport().setXAxisBoundsManual(true);
            graph2.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalminute2<10)
            //{
                graph2.getViewport().setMinX(0);
                graph2.getViewport().setMaxX(60);
            //}
            /*
            else
            {
                graph2.getViewport().setMinX(arraysizeglobalminute2-10);
                graph2.getViewport().setMaxX(arraysizeglobalminute2);
            }

             */
            graph2.getViewport().setMinY(0);
            graph2.getViewport().setMaxY(max + .2*max);

            graph3.setTitle("         CO2 Sensor 3");
            graph3.setTitleTextSize(25);
            graph3.removeAllSeries();
            graph3.addSeries(seriesgsuperminute3);
            GridLabelRenderer griLa3 = graph3.getGridLabelRenderer();
            LineGraphSeries lil3 = seriesgsuperminute3;
            lil3.setThickness(2);
            griLa3.setHorizontalAxisTitle("              minutes");
            griLa3.setHorizontalAxisTitleTextSize(20);
            griLa3.setVerticalAxisTitle("ppm");
            griLa3.setLabelVerticalWidth(43);
            griLa3.setLabelVerticalWidth(55);
            griLa3.setGridColor(Color.LTGRAY);
            //griLa.setH;
            griLa3.setVerticalAxisTitleTextSize(20);
            graph3.getViewport().setXAxisBoundsManual(true);
            graph3.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalminute3<10)
            //{
                graph3.getViewport().setMinX(0);
                graph3.getViewport().setMaxX(60);
            //}
            //else
            //{
            //    graph3.getViewport().setMinX(arraysizeglobalminute3-10);
            //    graph3.getViewport().setMaxX(arraysizeglobalminute3);
            //}
            graph3.getViewport().setMinY(0);
            graph3.getViewport().setMaxY(max + .2*max);

            graph4.setTitle("         CO2 Sensor 4");
            graph4.setTitleTextSize(25);
            graph4.removeAllSeries();
            graph4.addSeries(seriesgsuperminute4);
            GridLabelRenderer griLa4 = graph4.getGridLabelRenderer();
            LineGraphSeries lil4 = seriesgsuperminute4;
            lil4.setThickness(2);
            griLa4.setHorizontalAxisTitle("              minutes");
            griLa4.setHorizontalAxisTitleTextSize(20);
            griLa4.setVerticalAxisTitle("ppm");
            griLa4.setLabelVerticalWidth(43);
            griLa4.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa4.setGridColor(Color.LTGRAY);
            griLa4.setVerticalAxisTitleTextSize(20);
            graph4.getViewport().setXAxisBoundsManual(true);
            graph4.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalminute4<10)
            //{
                graph4.getViewport().setMinX(0);
                graph4.getViewport().setMaxX(60);
            //}
            //else
            //{
            //    graph4.getViewport().setMinX(arraysizeglobalminute3-10);
            //    graph4.getViewport().setMaxX(arraysizeglobalminute3);
            //}
            graph4.getViewport().setMinY(0);
            graph4.getViewport().setMaxY(max + .2*max);
        }
        else if(indication == 2)
        { //this one is used for hours, notice hours index
            graph.setTitle("         CO2 Sensor 1");
            graph.setTitleTextSize(25);
            graph.removeAllSeries();
            seriesghour1.setSize(2);
            graph.addSeries(seriesghour1);
            GridLabelRenderer griLa = graph.getGridLabelRenderer();
            //LineGraphSeries lil = seriesghour1;
            //lil.setThickness(2);
            griLa.setHorizontalAxisTitle("              hours");
            griLa.setHorizontalAxisTitleTextSize(20);
            griLa.setVerticalAxisTitle("ppm");
            griLa.setLabelVerticalWidth(43);
            griLa.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa.setVerticalAxisTitleTextSize(20);
            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setYAxisBoundsManual(true);
            griLa.setGridColor(Color.LTGRAY);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalhour1<10)
            //{}
                graph.getViewport().setMinX(0);
                graph.getViewport().setMaxX(24);
            //}
            /*
            else
            {
                graph.getViewport().setMinX(arraysizeglobalhour1-10);
                graph.getViewport().setMaxX(arraysizeglobalhour1);
            }

             */
            graph.getViewport().setMinY(0);
            graph.getViewport().setMaxY(max + .2*max);

            graph2.setTitle("         CO2 Sensor 2");
            graph2.setTitleTextSize(25);
            graph2.removeAllSeries();
            seriesghour2.setSize(2);
            graph2.addSeries(seriesghour2);
            GridLabelRenderer griLa2 = graph2.getGridLabelRenderer();
            //LineGraphSeries lil2 = seriesghour2;
            //lil2.setThickness(2);
            griLa2.setHorizontalAxisTitle("              hours");
            griLa2.setHorizontalAxisTitleTextSize(20);
            griLa2.setVerticalAxisTitle("ppm");
            griLa2.setLabelVerticalWidth(43);
            griLa2.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa2.setGridColor(Color.LTGRAY);
            griLa2.setVerticalAxisTitleTextSize(20);
            graph2.getViewport().setXAxisBoundsManual(true);
            graph2.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalhour2<10)
            //{
                graph2.getViewport().setMinX(0);
                graph2.getViewport().setMaxX(24);
            //}
            //else
            //{
            //    graph2.getViewport().setMinX(arraysizeglobalhour2-10);
            //    graph2.getViewport().setMaxX(arraysizeglobalhour2);
            //}
            graph2.getViewport().setMinY(0);
            graph2.getViewport().setMaxY(max + .2*max);

            graph3.setTitle("         CO2 Sensor 3");
            graph3.setTitleTextSize(25);
            graph3.removeAllSeries();
            graph3.addSeries(seriesghour3);
            GridLabelRenderer griLa3 = graph3.getGridLabelRenderer();
            LineGraphSeries lil3 = seriesghour3;
            lil3.setThickness(2);
            griLa3.setGridColor(Color.LTGRAY);
            griLa3.setHorizontalAxisTitle("              hours");
            griLa3.setHorizontalAxisTitleTextSize(20);
            griLa3.setVerticalAxisTitle("ppm");
            griLa3.setLabelVerticalWidth(43);
            griLa3.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa3.setVerticalAxisTitleTextSize(20);
            graph3.getViewport().setXAxisBoundsManual(true);
            graph3.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalhour3<10)
            //{
                graph3.getViewport().setMinX(0);
                graph3.getViewport().setMaxX(24);
            //}
            //else
            //{
            //    graph3.getViewport().setMinX(arraysizeglobalhour3-10);
            //    graph3.getViewport().setMaxX(arraysizeglobalhour3);
            //}
            graph3.getViewport().setMinY(0);
            graph3.getViewport().setMaxY(max + .2*max);

            graph4.setTitle("         CO2 Sensor 4");
            graph4.setTitleTextSize(25);
            graph4.removeAllSeries();
            graph4.addSeries(seriesghour4);
            GridLabelRenderer griLa4 = graph4.getGridLabelRenderer();
            LineGraphSeries lil4 = seriesghour4;
            lil4.setThickness(2);
            griLa4.setGridColor(Color.LTGRAY);
            griLa4.setHorizontalAxisTitle("              hours");
            griLa4.setHorizontalAxisTitleTextSize(20);
            griLa4.setVerticalAxisTitle("ppm");
            griLa4.setLabelVerticalWidth(43);
            griLa4.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa4.setVerticalAxisTitleTextSize(20);
            graph4.getViewport().setXAxisBoundsManual(true);
            graph4.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalhour4<10)
            //{
                graph4.getViewport().setMinX(0);
                graph4.getViewport().setMaxX(24);
            //}
            //else
            //{
            //    graph4.getViewport().setMinX(arraysizeglobalhour4-10);
            //    graph4.getViewport().setMaxX(arraysizeglobalhour4);
            //}
            graph4.getViewport().setMinY(0);
            graph4.getViewport().setMaxY(max + .2*max);
        }
        else if(indication == 3)
        { //this one is used for days
            graph.setTitle("         CO2 Sensor 1");
            graph.setTitleTextSize(25);
            graph.removeAllSeries();
            seriesgday1.setSize(2);
            graph.addSeries(seriesgday1);
            GridLabelRenderer griLa = graph.getGridLabelRenderer();
            //LineGraphSeries lil = seriesgday1;
            //lil.setThickness(2);
            griLa.setHorizontalAxisTitle("              days");
            griLa.setHorizontalAxisTitleTextSize(20);
            griLa.setVerticalAxisTitle("ppm");
            griLa.setLabelVerticalWidth(43);
            griLa.setLabelVerticalWidth(55);
            griLa.setGridColor(Color.LTGRAY);
            //griLa.setH;
            griLa.setVerticalAxisTitleTextSize(20);
            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalday1<10)
            //{}
                graph.getViewport().setMinX(0);
                graph.getViewport().setMaxX(31);
            //}
            /*
            else
            {
                graph.getViewport().setMinX(arraysizeglobalday1-10);
                graph.getViewport().setMaxX(arraysizeglobalday1);
            }

             */
            graph.getViewport().setMinY(0);
            graph.getViewport().setMaxY(max + .2*max);

            graph2.setTitle("         CO2 Sensor 2");
            graph2.setTitleTextSize(25);
            graph2.removeAllSeries();
            seriesgday2.setSize(2);
            graph2.addSeries(seriesgday2);
            GridLabelRenderer griLa2 = graph2.getGridLabelRenderer();
            //LineGraphSeries lil2 = seriesgday2;
            //lil2.setThickness(2);
            griLa2.setHorizontalAxisTitle("              days");
            griLa2.setHorizontalAxisTitleTextSize(20);
            griLa2.setVerticalAxisTitle("ppm");
            griLa2.setLabelVerticalWidth(43);
            griLa2.setLabelVerticalWidth(55);
            griLa2.setGridColor(Color.LTGRAY);
            //griLa.setH;
            griLa2.setVerticalAxisTitleTextSize(20);
            graph2.getViewport().setXAxisBoundsManual(true);
            graph2.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalday2<10)
            //{
                graph2.getViewport().setMinX(0);
                graph2.getViewport().setMaxX(31);
            //}
            //else
            //{
            //    graph2.getViewport().setMinX(arraysizeglobalday2-10);
            //    graph2.getViewport().setMaxX(arraysizeglobalday2);
            //}
            graph2.getViewport().setMinY(0);
            graph2.getViewport().setMaxY(max + .2*max);

            graph3.setTitle("         CO2 Sensor 3");
            graph3.setTitleTextSize(25);
            graph3.removeAllSeries();
            graph3.addSeries(seriesgday3);
            GridLabelRenderer griLa3 = graph3.getGridLabelRenderer();
            LineGraphSeries lil3 = seriesgday3;
            lil3.setThickness(2);
            griLa3.setHorizontalAxisTitle("              days");
            griLa3.setHorizontalAxisTitleTextSize(20);
            griLa3.setVerticalAxisTitle("ppm");
            griLa3.setLabelVerticalWidth(43);
            griLa3.setLabelVerticalWidth(55);
            griLa3.setGridColor(Color.LTGRAY);
            //griLa.setH;
            griLa3.setVerticalAxisTitleTextSize(20);
            graph3.getViewport().setXAxisBoundsManual(true);
            graph3.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalday3<10)
            //{
                graph3.getViewport().setMinX(0);
                graph3.getViewport().setMaxX(31);
            //}
            //else
            //{
            //    graph3.getViewport().setMinX(arraysizeglobalday3-10);
            //    graph3.getViewport().setMaxX(arraysizeglobalday3);
            //}
            graph3.getViewport().setMinY(0);
            graph3.getViewport().setMaxY(max + .2*max);

            graph4.setTitle("         CO2 Sensor 4");
            graph4.setTitleTextSize(25);
            graph4.removeAllSeries();
            graph4.addSeries(seriesgday4);
            GridLabelRenderer griLa4 = graph4.getGridLabelRenderer();
            LineGraphSeries lil4 = seriesgday4;
            lil4.setThickness(2);
            griLa4.setHorizontalAxisTitle("              days");
            griLa4.setHorizontalAxisTitleTextSize(20);
            griLa4.setVerticalAxisTitle("ppm");
            griLa4.setLabelVerticalWidth(43);
            griLa4.setLabelVerticalWidth(55);
            griLa4.setGridColor(Color.LTGRAY);
            //griLa.setH;
            griLa4.setVerticalAxisTitleTextSize(20);
            graph4.getViewport().setXAxisBoundsManual(true);
            graph4.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalday4<10)
            //{
                graph4.getViewport().setMinX(0);
                graph4.getViewport().setMaxX(31);
            //}
            //else
            //{
            //    graph4.getViewport().setMinX(arraysizeglobalday4-10);
            //    graph4.getViewport().setMaxX(arraysizeglobalday4);
            //}
            graph4.getViewport().setMinY(0);
            graph4.getViewport().setMaxY(max + .2*max);
        }
        else if(indication == 4)
        {//this one is used for months
            graph.setTitle("         CO2 Sensor 1");
            graph.setTitleTextSize(25);
            graph.removeAllSeries();
            seriesgweek1.setSize(2);
            graph.addSeries(seriesgweek1);
            GridLabelRenderer griLa = graph.getGridLabelRenderer();
            //LineGraphSeries lil = seriesgweek1;
            //lil.setThickness(2);
            griLa.setHorizontalAxisTitle("              months");
            griLa.setHorizontalAxisTitleTextSize(20);
            griLa.setVerticalAxisTitle("ppm");
            griLa.setLabelVerticalWidth(43);
            griLa.setLabelVerticalWidth(55);
            griLa.setGridColor(Color.LTGRAY);
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
            /*
            else
            {
                graph.getViewport().setMinX(arraysizeglobalweek1-10);
                graph.getViewport().setMaxX(arraysizeglobalweek1);
            }

             */
            graph.getViewport().setMinY(0);
            graph.getViewport().setMaxY(max + .2*max);

            graph2.setTitle("         CO2 Sensor 2");
            graph2.setTitleTextSize(25);
            graph2.removeAllSeries();
            seriesgweek2.setSize(2);
            graph2.addSeries(seriesgweek2);
            GridLabelRenderer griLa2 = graph2.getGridLabelRenderer();
            //LineGraphSeries lil2 = seriesgweek2;
            //lil2.setThickness(2);
            griLa2.setHorizontalAxisTitle("              months");
            griLa2.setHorizontalAxisTitleTextSize(20);
            griLa2.setVerticalAxisTitle("ppm");
            griLa2.setLabelVerticalWidth(43);
            griLa2.setLabelVerticalWidth(55);
            griLa2.setGridColor(Color.LTGRAY);
            //griLa.setH;
            griLa2.setVerticalAxisTitleTextSize(20);
            graph2.getViewport().setXAxisBoundsManual(true);
            graph2.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalweek2<10)
            //{
                graph2.getViewport().setMinX(0);
                graph2.getViewport().setMaxX(13);
            //}
            /*
            else
            {
                graph2.getViewport().setMinX(arraysizeglobalweek1-10);
                graph2.getViewport().setMaxX(arraysizeglobalweek1);
            }

             */
            graph2.getViewport().setMinY(0);
            graph2.getViewport().setMaxY(max + .2*max);

            graph3.setTitle("         CO2 Sensor 3");
            graph3.setTitleTextSize(25);
            graph3.removeAllSeries();
            graph3.addSeries(seriesgweek3);
            GridLabelRenderer griLa3 = graph3.getGridLabelRenderer();
            LineGraphSeries lil3 = seriesgweek3;
            lil3.setThickness(2);
            griLa3.setHorizontalAxisTitle("              months");
            griLa3.setHorizontalAxisTitleTextSize(20);
            griLa3.setVerticalAxisTitle("ppm");
            griLa3.setLabelVerticalWidth(43);
            griLa3.setLabelVerticalWidth(55);
            griLa3.setGridColor(Color.LTGRAY);
            //griLa.setH;
            griLa3.setVerticalAxisTitleTextSize(20);
            graph3.getViewport().setXAxisBoundsManual(true);
            graph3.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalweek3<10)
            //{
                graph3.getViewport().setMinX(0);
                graph3.getViewport().setMaxX(13);
            //}
            //else
            //{
            //    graph3.getViewport().setMinX(arraysizeglobalweek3-10);
            //    graph3.getViewport().setMaxX(arraysizeglobalweek3);
            //}
            graph3.getViewport().setMinY(0);
            graph3.getViewport().setMaxY(max + .2*max);

            graph4.setTitle("         CO2 Sensor 4");
            graph4.setTitleTextSize(25);
            graph4.removeAllSeries();
            graph4.addSeries(seriesgweek4);
            GridLabelRenderer griLa4 = graph4.getGridLabelRenderer();
            LineGraphSeries lil4 = seriesgweek4;
            lil4.setThickness(2);
            griLa4.setHorizontalAxisTitle("              months");
            griLa4.setHorizontalAxisTitleTextSize(20);
            griLa4.setVerticalAxisTitle("ppm");
            griLa4.setLabelVerticalWidth(43);
            griLa4.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa4.setGridColor(Color.LTGRAY);
            griLa4.setVerticalAxisTitleTextSize(20);
            graph4.getViewport().setXAxisBoundsManual(true);
            graph4.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalweek4<10)
            //{
                graph4.getViewport().setMinX(0);
                graph4.getViewport().setMaxX(13);
            //}
            //else
            //{
            //    graph4.getViewport().setMinX(arraysizeglobalweek4-10);
            //    graph4.getViewport().setMaxX(arraysizeglobalweek4);
            //}
            graph4.getViewport().setMinY(0);
            graph4.getViewport().setMaxY(max + .2*max);
        }
        else if(indication == 5)
        {//this one is used for years
            graph.setTitle("         CO2 Sensor 1");
            graph.setTitleTextSize(25);
            graph.removeAllSeries();
            seriesgyear1.setSize(2);
            graph.addSeries(seriesgyear1);

            GridLabelRenderer griLa = graph.getGridLabelRenderer();
            //LineGraphSeries lil = seriesgyear1;
            //lil.setThickness(2);
            griLa.setHorizontalAxisTitle("              years");
            griLa.setHorizontalAxisTitleTextSize(20);
            griLa.setVerticalAxisTitle("ppm");
            griLa.setLabelVerticalWidth(43);
            griLa.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa.setGridColor(Color.LTGRAY);
            griLa.setVerticalAxisTitleTextSize(20);
            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalyear1<3)
            //{
                graph.getViewport().setMinX(21);
                graph.getViewport().setMaxX(31);
            //}
            /*
            else
            {
                graph.getViewport().setMinX(arraysizeglobalyear1-3);
                graph.getViewport().setMaxX(arraysizeglobalyear1);
            }

             */
            graph.getViewport().setMinY(0);
            graph.getViewport().setMaxY(max + .2*max);

            graph2.setTitle("         CO2 Sensor 2");
            graph2.setTitleTextSize(25);
            graph2.removeAllSeries();
            seriesgyear2.setSize(2);
            graph2.addSeries(seriesgyear2);
            GridLabelRenderer griLa2 = graph2.getGridLabelRenderer();
            //LineGraphSeries lil2 = seriesgyear2;
            //lil2.setThickness(2);
            griLa2.setHorizontalAxisTitle("              years");
            griLa2.setHorizontalAxisTitleTextSize(20);
            griLa2.setVerticalAxisTitle("ppm");
            griLa2.setLabelVerticalWidth(43);
            griLa2.setLabelVerticalWidth(55);
            griLa2.setGridColor(Color.LTGRAY);
            //griLa.setH;
            griLa2.setVerticalAxisTitleTextSize(20);
            graph2.getViewport().setXAxisBoundsManual(true);
            graph2.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalyear2<3)
            //{
                graph2.getViewport().setMinX(21);
                graph2.getViewport().setMaxX(31);
            //}
            //else
            //{
            //    graph2.getViewport().setMinX(arraysizeglobalyear2-3);
            //    graph2.getViewport().setMaxX(arraysizeglobalyear2);
            //}
            graph2.getViewport().setMinY(0);
            graph2.getViewport().setMaxY(max + .2*max);

            graph3.setTitle("         CO2 Sensor 3");
            graph3.setTitleTextSize(25);
            graph3.removeAllSeries();
            graph3.addSeries(seriesgyear3);
            GridLabelRenderer griLa3 = graph3.getGridLabelRenderer();
            LineGraphSeries lil3 = seriesgyear3;
            lil3.setThickness(2);
            griLa3.setHorizontalAxisTitle("              years");
            griLa3.setHorizontalAxisTitleTextSize(20);
            griLa3.setVerticalAxisTitle("ppm");
            griLa3.setLabelVerticalWidth(43);
            griLa3.setLabelVerticalWidth(55);
            griLa3.setGridColor(Color.LTGRAY);
            //griLa.setH;
            griLa3.setVerticalAxisTitleTextSize(20);
            graph3.getViewport().setXAxisBoundsManual(true);
            graph3.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalyear3<3)
            //{
                graph3.getViewport().setMinX(21);
                graph3.getViewport().setMaxX(31);
            //}
            //else
            //{
            //    graph3.getViewport().setMinX(arraysizeglobalyear3-3);
            //    graph3.getViewport().setMaxX(arraysizeglobalyear3);
            //}
            graph3.getViewport().setMinY(0);
            graph3.getViewport().setMaxY(max + .2*max);

            graph4.setTitle("         CO2 Sensor 4");
            graph4.setTitleTextSize(25);
            graph4.removeAllSeries();
            graph4.addSeries(seriesgyear4);
            GridLabelRenderer griLa4 = graph4.getGridLabelRenderer();
            LineGraphSeries lil4 = seriesgyear4;
            lil4.setThickness(2);
            griLa4.setHorizontalAxisTitle("              years");
            griLa4.setHorizontalAxisTitleTextSize(20);
            griLa4.setVerticalAxisTitle("ppm");
            griLa4.setLabelVerticalWidth(43);
            griLa4.setLabelVerticalWidth(55);
            griLa4.setGridColor(Color.LTGRAY);
            //griLa.setH;
            griLa4.setVerticalAxisTitleTextSize(20);
            graph4.getViewport().setXAxisBoundsManual(true);
            graph4.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalyear4<3)
            //{
                graph4.getViewport().setMinX(21);
                graph4.getViewport().setMaxX(31);
            //}
            //else
            //{
            //    graph4.getViewport().setMinX(arraysizeglobalyear4-3);
            //   graph4.getViewport().setMaxX(arraysizeglobalyear4);
            //}
            graph4.getViewport().setMinY(0);
            graph4.getViewport().setMaxY(max + .2*max);

        }

        //Intent intent = new Intent(this, mcu1co2graphminutes.class); //causes the subordinate activity file to be opened, redirects to new layout
        //startActivity(intent);
    }


    @Override

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //adapterView.setSelection(i);
        //This is the action being done when item is selcted.
        if((seriessupersecond == null) || (seriessuperminute1 == null) || (seriesghour1 == null) || (seriesgday1 == null) || (seriesgweek1 == null) || (seriesgyear1 == null)  || (seriesgsecond2 == null)  || (seriesgsuperminute2 == null)  || (seriesghour2 == null) || (seriesgday2 == null)  || (seriesgweek2 == null)   || (seriesgyear2 == null))
        {return;} //this section deals with error handling, such as when
        indication = i; //changing indication based on whats currently selected
        openActivityminutes(); //opeining openactivity minutes
        //graph.setTitle(indication);
        //openActivityrefresh();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void indicator2(){
        indication2 = indication; //ignrore, useless




    }

    public void opentesting(){
        //opentesting resets the graph value automatically
        GraphView graph = (GraphView) findViewById(R.id.graphth);
        if(indication == 0)
        {
            graph.setTitle("         CO2 Sensor 1");
            graph.setTitleTextSize(25);
            graph.removeAllSeries();
            seriessupersecond.setSize(2);
            graph.addSeries(seriessupersecond);
            GridLabelRenderer griLa = graph.getGridLabelRenderer();
            //LineGraphSeries lil = seriessupersecond;
            //lil.setThickness(2);
            griLa.setHorizontalAxisTitle("              seconds");
            griLa.setHorizontalAxisTitleTextSize(20);
            griLa.setVerticalAxisTitle("ppm");
            griLa.setLabelVerticalWidth(43);
            griLa.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa.setGridColor(Color.LTGRAY);
            griLa.setVerticalAxisTitleTextSize(20);
            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setYAxisBoundsManual(true);

            //if(arraysizeCHECKglobal<60)
            //{}
                graph.getViewport().setMinX(0);
                graph.getViewport().setMaxX(60);
            //}
            /*
            else
            {
                graph.getViewport().setMinX(arraysizeCHECKglobal-60);
                graph.getViewport().setMaxX(arraysizeCHECKglobal);
            }

             */
            graph.getViewport().setMinY(0);
            graph.getViewport().setMaxY(max + .2*max);




        }
        if(indication == 1)
        {


            graph.setTitle("         CO2 Sensor 1");
            graph.setTitleTextSize(25);
            graph.removeAllSeries();
            seriessuperminute1.setSize(2);
            graph.addSeries(seriessuperminute1);

            GridLabelRenderer griLa = graph.getGridLabelRenderer();
            //LineGraphSeries lil = seriessuperminute1;
            //lil.setThickness(2);
            griLa.setHorizontalAxisTitle("              minutes");
            griLa.setHorizontalAxisTitleTextSize(20);
            griLa.setVerticalAxisTitle("ppm");
            griLa.setLabelVerticalWidth(43);
            griLa.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa.setGridColor(Color.LTGRAY);
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
            graph.setTitle("         CO2 Sensor 1");
            graph.setTitleTextSize(25);
            graph.removeAllSeries();
            seriesghour1.setSize(2);
            graph.addSeries(seriesghour1);
            GridLabelRenderer griLa = graph.getGridLabelRenderer();
            //LineGraphSeries lil = seriesghour1;
            //lil.setThickness(2);
            griLa.setHorizontalAxisTitle("              hours");
            griLa.setHorizontalAxisTitleTextSize(20);
            griLa.setVerticalAxisTitle("ppm");
            griLa.setLabelVerticalWidth(43);
            griLa.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa.setGridColor(Color.LTGRAY);
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
            graph.setTitle("         CO2 Sensor 1");
            graph.setTitleTextSize(25);
            graph.removeAllSeries();
            seriesgday1.setSize(2);
            graph.addSeries(seriesgday1);
            GridLabelRenderer griLa = graph.getGridLabelRenderer();
            //LineGraphSeries lil = seriesgday1;
            //lil.setThickness(2);
            griLa.setHorizontalAxisTitle("              days");
            griLa.setHorizontalAxisTitleTextSize(20);
            griLa.setVerticalAxisTitle("ppm");
            griLa.setLabelVerticalWidth(43);
            griLa.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa.setGridColor(Color.LTGRAY);
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
            graph.setTitle("         CO2 Sensor 1");
            graph.setTitleTextSize(25);
            graph.removeAllSeries();
            seriesgweek1.setSize(2);
            graph.addSeries(seriesgweek1);
            GridLabelRenderer griLa = graph.getGridLabelRenderer();
            //LineGraphSeries lil = seriesgweek1;
            //lil.setThickness(2);
            griLa.setHorizontalAxisTitle("              months");
            griLa.setHorizontalAxisTitleTextSize(20);
            griLa.setVerticalAxisTitle("ppm");
            griLa.setLabelVerticalWidth(43);
            griLa.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa.setGridColor(Color.LTGRAY);
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
            graph.setTitle("         CO2 Sensor 1");
            graph.setTitleTextSize(25);
            graph.removeAllSeries();
            seriesgyear1.setSize(2);
            graph.addSeries(seriesgyear1);

            GridLabelRenderer griLa = graph.getGridLabelRenderer();
            //LineGraphSeries lil = seriesgyear1;
            //lil.setThickness(2);
            griLa.setHorizontalAxisTitle("              years");
            griLa.setHorizontalAxisTitleTextSize(20);
            griLa.setVerticalAxisTitle("ppm");
            griLa.setLabelVerticalWidth(43);
            griLa.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa.setGridColor(Color.LTGRAY);
            griLa.setVerticalAxisTitleTextSize(20);
            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalyear1<3)
            //{
                graph.getViewport().setMinX(0);
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
    public void opentesting2(){
        GraphView graph2 = (GraphView) findViewById(R.id.graph12th);

        if(indication == 0)
        {


            graph2.setTitle("         CO2 Sensor 2");
            graph2.setTitleTextSize(25);
            graph2.removeAllSeries();
            seriesgsecond2.setSize(2);
            graph2.addSeries(seriesgsecond2);
            GridLabelRenderer griLa2 = graph2.getGridLabelRenderer();
            //LineGraphSeries lil2 = seriesgsecond2;
            //lil2.setThickness(2);
            griLa2.setHorizontalAxisTitle("              seconds");
            griLa2.setHorizontalAxisTitleTextSize(20);
            griLa2.setVerticalAxisTitle("ppm");
            griLa2.setLabelVerticalWidth(43);
            griLa2.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa2.setGridColor(Color.LTGRAY);
            griLa2.setVerticalAxisTitleTextSize(20);
            graph2.getViewport().setXAxisBoundsManual(true);
            graph2.getViewport().setYAxisBoundsManual(true);
            //graph2.getViewport().setMaxX(arraysizeglobalsecond2 + 1);
            //graph2.getViewport().setMaxX(arraysizeglobalsecond2 + 1);

            //if(arraysizeglobalsecond2<60)
            //{
                graph2.getViewport().setMinX(0);
                graph2.getViewport().setMaxX(60);
            //}
            //else
            //{
            //    graph2.getViewport().setMinX(arraysizeglobalsecond2-60);
            //    graph2.getViewport().setMaxX(arraysizeglobalsecond2);
            //}
            graph2.getViewport().setMinY(0);
            graph2.getViewport().setMaxY(max + .2*max);






        }
        if(indication == 1)
        {




            graph2.setTitle("         CO2 Sensor 2");
            graph2.setTitleTextSize(25);
            graph2.removeAllSeries();
            graph2.addSeries(seriesgsuperminute2);
            GridLabelRenderer griLa2 = graph2.getGridLabelRenderer();
            //LineGraphSeries lil2 = seriesgsuperminute2;
            //lil2.setThickness(2);
            griLa2.setHorizontalAxisTitle("              minutes");
            griLa2.setHorizontalAxisTitleTextSize(20);
            griLa2.setVerticalAxisTitle("ppm");
            griLa2.setLabelVerticalWidth(43);
            griLa2.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa2.setGridColor(Color.LTGRAY);
            griLa2.setVerticalAxisTitleTextSize(20);
            graph2.getViewport().setXAxisBoundsManual(true);
            graph2.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalminute2<10)
            //{
                graph2.getViewport().setMinX(0);
                graph2.getViewport().setMaxX(60);
            //}
            //else
            //{
            //    graph2.getViewport().setMinX(arraysizeglobalminute2-10);
            //    graph2.getViewport().setMaxX(arraysizeglobalminute2);
            //}
            graph2.getViewport().setMinY(0);
            graph2.getViewport().setMaxY(max + .2*max);




        }
        else if(indication == 2)
        {

            graph2.setTitle("         CO2 Sensor 2");
            graph2.setTitleTextSize(25);
            graph2.removeAllSeries();
            graph2.addSeries(seriesghour2);
            GridLabelRenderer griLa2 = graph2.getGridLabelRenderer();
            //LineGraphSeries lil2 = seriesghour2;
            //lil2.setThickness(2);
            griLa2.setHorizontalAxisTitle("              hours");
            griLa2.setHorizontalAxisTitleTextSize(20);
            griLa2.setVerticalAxisTitle("ppm");
            griLa2.setLabelVerticalWidth(43);
            griLa2.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa2.setGridColor(Color.LTGRAY);
            griLa2.setVerticalAxisTitleTextSize(20);
            graph2.getViewport().setXAxisBoundsManual(true);
            graph2.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalhour2<10)
            //{
                graph2.getViewport().setMinX(0);
                graph2.getViewport().setMaxX(24);
            //}
            //else
            //{
            //    graph2.getViewport().setMinX(arraysizeglobalhour2-10);
            //    graph2.getViewport().setMaxX(arraysizeglobalhour2);
            //}
            graph2.getViewport().setMinY(0);
            graph2.getViewport().setMaxY(max + .2*max);


        }
        else if(indication == 3)
        {


            graph2.setTitle("         CO2 Sensor 2");
            graph2.setTitleTextSize(25);
            graph2.removeAllSeries();
            graph2.addSeries(seriesgday2);
            GridLabelRenderer griLa2 = graph2.getGridLabelRenderer();
            //LineGraphSeries lil2 = seriesgday2;
            //lil2.setThickness(2);
            griLa2.setHorizontalAxisTitle("              days");
            griLa2.setHorizontalAxisTitleTextSize(20);
            griLa2.setVerticalAxisTitle("ppm");
            griLa2.setLabelVerticalWidth(43);
            griLa2.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa2.setGridColor(Color.LTGRAY);
            griLa2.setVerticalAxisTitleTextSize(20);
            graph2.getViewport().setXAxisBoundsManual(true);
            graph2.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalday2<10)
            //{
                graph2.getViewport().setMinX(0);
                graph2.getViewport().setMaxX(31);
            //}
            //else
            //{
                graph2.getViewport().setMinX(arraysizeglobalday2-10);
                graph2.getViewport().setMaxX(arraysizeglobalday2);
            //}
            graph2.getViewport().setMinY(0);
            graph2.getViewport().setMaxY(max + .2*max);


        }
        else if(indication == 4)
        {

            graph2.setTitle("         CO2 Sensor 2");
            graph2.setTitleTextSize(25);
            graph2.removeAllSeries();
            graph2.addSeries(seriesgweek2);
            GridLabelRenderer griLa2 = graph2.getGridLabelRenderer();
            //LineGraphSeries lil2 = seriesgweek2;
            //lil2.setThickness(2);
            griLa2.setHorizontalAxisTitle("              months");
            griLa2.setHorizontalAxisTitleTextSize(20);
            griLa2.setVerticalAxisTitle("ppm");
            griLa2.setLabelVerticalWidth(43);
            griLa2.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa2.setGridColor(Color.LTGRAY);
            griLa2.setVerticalAxisTitleTextSize(20);
            graph2.getViewport().setXAxisBoundsManual(true);
            graph2.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalweek2<10)
            //{
                graph2.getViewport().setMinX(0);
                graph2.getViewport().setMaxX(13);
            //}
            //else
            //{
            //    graph2.getViewport().setMinX(arraysizeglobalweek1-10);
            //    graph2.getViewport().setMaxX(arraysizeglobalweek1);
            //}
            graph2.getViewport().setMinY(0);
            graph2.getViewport().setMaxY(max + .2*max);


        }
        else if(indication == 5)
        {

            graph2.setTitle("         CO2 Sensor 2");
            graph2.setTitleTextSize(25);
            graph2.removeAllSeries();
            graph2.addSeries(seriesgyear2);
            GridLabelRenderer griLa2 = graph2.getGridLabelRenderer();
            //LineGraphSeries lil2 = seriesgyear2;
            //lil2.setThickness(2);
            griLa2.setHorizontalAxisTitle("              years");
            griLa2.setHorizontalAxisTitleTextSize(20);
            griLa2.setVerticalAxisTitle("ppm");
            griLa2.setLabelVerticalWidth(43);
            griLa2.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa2.setGridColor(Color.LTGRAY);
            griLa2.setVerticalAxisTitleTextSize(20);
            graph2.getViewport().setXAxisBoundsManual(true);
            graph2.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalyear2<3)
            //{
                graph2.getViewport().setMinX(0);
                graph2.getViewport().setMaxX(31);
            //}
            //else
            //{
            //    graph2.getViewport().setMinX(arraysizeglobalyear2-3);
            //    graph2.getViewport().setMaxX(arraysizeglobalyear2);
            //}
            graph2.getViewport().setMinY(0);
            graph2.getViewport().setMaxY(max + .2*max);



        }



    }
    public void opentesting3(){
        GraphView graph3 = (GraphView) findViewById(R.id.graph3th);
        if(indication == 0)
        {


            graph3.setTitle("         CO2 Sensor 3");
            graph3.setTitleTextSize(25);
            graph3.removeAllSeries();
            graph3.addSeries(seriesgsecond3);
            GridLabelRenderer griLa3 = graph3.getGridLabelRenderer();
            LineGraphSeries lil3 = seriesgsecond3;
            lil3.setThickness(2);
            griLa3.setHorizontalAxisTitle("              second");
            griLa3.setHorizontalAxisTitleTextSize(20);
            griLa3.setVerticalAxisTitle("ppm");
            griLa3.setLabelVerticalWidth(43);
            griLa3.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa3.setGridColor(Color.LTGRAY);
            griLa3.setVerticalAxisTitleTextSize(20);
            graph3.getViewport().setXAxisBoundsManual(true);
            graph3.getViewport().setYAxisBoundsManual(true);
            graph3.getViewport().setMaxX(arraysizeglobalsecond3 + 1);
            //graph3.getViewport().setMaxX(arraysizeglobalsecond3 + 1);

            //if(arraysizeglobalsecond3<60)
            //{
                graph3.getViewport().setMinX(0);
                graph3.getViewport().setMaxX(60);
            //}
            //else
            //{
            //    graph3.getViewport().setMinX(arraysizeglobalsecond3-60);
            //    graph3.getViewport().setMaxX(arraysizeglobalsecond3);
            //}
            graph3.getViewport().setMinY(0);
            graph3.getViewport().setMaxY(max + .2*max);




        }
        if(indication == 1)
        {




            graph3.setTitle("         CO2 Sensor 3");
            graph3.setTitleTextSize(25);
            graph3.removeAllSeries();
            graph3.addSeries(seriesgsuperminute3);
            GridLabelRenderer griLa3 = graph3.getGridLabelRenderer();
            LineGraphSeries lil3 = seriesgsuperminute3;
            lil3.setThickness(2);
            griLa3.setHorizontalAxisTitle("              minutes");
            griLa3.setHorizontalAxisTitleTextSize(20);
            griLa3.setVerticalAxisTitle("ppm");
            griLa3.setLabelVerticalWidth(43);
            griLa3.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa3.setGridColor(Color.LTGRAY);
            griLa3.setVerticalAxisTitleTextSize(20);
            graph3.getViewport().setXAxisBoundsManual(true);
            graph3.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalminute3<10)
            //{
                graph3.getViewport().setMinX(0);
                graph3.getViewport().setMaxX(60);
            //}
            //else
            //{
            //    graph3.getViewport().setMinX(arraysizeglobalminute3-10);
            //    graph3.getViewport().setMaxX(arraysizeglobalminute3);
            //}
            graph3.getViewport().setMinY(0);
            graph3.getViewport().setMaxY(max + .2*max);


        }
        else if(indication == 2)
        {


            graph3.setTitle("         CO2 Sensor 3");
            graph3.setTitleTextSize(25);
            graph3.removeAllSeries();
            graph3.addSeries(seriesghour3);
            GridLabelRenderer griLa3 = graph3.getGridLabelRenderer();
            LineGraphSeries lil3 = seriesghour3;
            lil3.setThickness(2);
            griLa3.setHorizontalAxisTitle("              hours");
            griLa3.setHorizontalAxisTitleTextSize(20);
            griLa3.setVerticalAxisTitle("ppm");
            griLa3.setLabelVerticalWidth(43);
            griLa3.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa3.setGridColor(Color.LTGRAY);
            griLa3.setVerticalAxisTitleTextSize(20);
            graph3.getViewport().setXAxisBoundsManual(true);
            graph3.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalhour3<10)
            //{
                graph3.getViewport().setMinX(0);
                graph3.getViewport().setMaxX(24);
            //}
            //else
            //{
            //    graph3.getViewport().setMinX(arraysizeglobalhour3-10);
            //    graph3.getViewport().setMaxX(arraysizeglobalhour3);
            //}
            graph3.getViewport().setMinY(0);
            graph3.getViewport().setMaxY(max + .2*max);


        }
        else if(indication == 3)
        {


            graph3.setTitle("         CO2 Sensor 3");
            graph3.setTitleTextSize(25);
            graph3.removeAllSeries();
            graph3.addSeries(seriesgday3);
            GridLabelRenderer griLa3 = graph3.getGridLabelRenderer();
            LineGraphSeries lil3 = seriesgday3;
            lil3.setThickness(2);
            griLa3.setHorizontalAxisTitle("              days");
            griLa3.setHorizontalAxisTitleTextSize(20);
            griLa3.setVerticalAxisTitle("ppm");
            griLa3.setLabelVerticalWidth(43);
            griLa3.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa3.setGridColor(Color.LTGRAY);
            griLa3.setVerticalAxisTitleTextSize(20);
            graph3.getViewport().setXAxisBoundsManual(true);
            graph3.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalday3<10)
            //{
                graph3.getViewport().setMinX(0);
                graph3.getViewport().setMaxX(31);
            //}
            //else
            //{
            //    graph3.getViewport().setMinX(arraysizeglobalday3-10);
            //    graph3.getViewport().setMaxX(arraysizeglobalday3);
            //}
            graph3.getViewport().setMinY(0);
            graph3.getViewport().setMaxY(max + .2*max);


        }
        else if(indication == 4)
        {


            graph3.setTitle("         CO2 Sensor 3");
            graph3.setTitleTextSize(25);
            graph3.removeAllSeries();
            graph3.addSeries(seriesgweek3);
            GridLabelRenderer griLa3 = graph3.getGridLabelRenderer();
            LineGraphSeries lil3 = seriesgweek3;
            lil3.setThickness(2);
            griLa3.setHorizontalAxisTitle("              months");
            griLa3.setHorizontalAxisTitleTextSize(20);
            griLa3.setVerticalAxisTitle("ppm");
            griLa3.setLabelVerticalWidth(43);
            griLa3.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa3.setGridColor(Color.LTGRAY);
            griLa3.setVerticalAxisTitleTextSize(20);
            graph3.getViewport().setXAxisBoundsManual(true);
            graph3.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalweek3<10)
            //{
                graph3.getViewport().setMinX(0);
                graph3.getViewport().setMaxX(13);
            //}
            //else
            //{
            //    graph3.getViewport().setMinX(arraysizeglobalweek3-10);
            //    graph3.getViewport().setMaxX(arraysizeglobalweek3);
            //}
            graph3.getViewport().setMinY(0);
            graph3.getViewport().setMaxY(max + .2*max);


        }
        else if(indication == 5)
        {


            graph3.setTitle("         CO2 Sensor 3");
            graph3.setTitleTextSize(25);
            graph3.removeAllSeries();
            graph3.addSeries(seriesgyear3);
            GridLabelRenderer griLa3 = graph3.getGridLabelRenderer();
            LineGraphSeries lil3 = seriesgyear3;
            lil3.setThickness(2);
            griLa3.setHorizontalAxisTitle("              months");
            griLa3.setHorizontalAxisTitleTextSize(20);
            griLa3.setVerticalAxisTitle("ppm");
            griLa3.setLabelVerticalWidth(43);
            griLa3.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa3.setGridColor(Color.LTGRAY);
            griLa3.setVerticalAxisTitleTextSize(20);
            graph3.getViewport().setXAxisBoundsManual(true);
            graph3.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalyear3<3)
            //{
                graph3.getViewport().setMinX(0);
                graph3.getViewport().setMaxX(12);
            //}
            //else
            //{
            //    graph3.getViewport().setMinX(arraysizeglobalyear3-3);
            //    graph3.getViewport().setMaxX(arraysizeglobalyear3);
            //}
            graph3.getViewport().setMinY(0);
            graph3.getViewport().setMaxY(max + .2*max);



        }


    }
    public void opentesting4(){
        GraphView graph4 = (GraphView) findViewById(R.id.graph4);
        if(indication == 0)
        {
            graph4.setTitle("         CO2 Sensor 4");
            graph4.setTitleTextSize(25);
            graph4.removeAllSeries();
            graph4.addSeries(seriesgsecond4);
            GridLabelRenderer griLa4 = graph4.getGridLabelRenderer();
            LineGraphSeries lil4 = seriesgsecond4;
            lil4.setThickness(2);
            griLa4.setHorizontalAxisTitle("              seconds");
            griLa4.setHorizontalAxisTitleTextSize(20);
            griLa4.setVerticalAxisTitle("ppm");
            griLa4.setLabelVerticalWidth(43);
            griLa4.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa4.setGridColor(Color.LTGRAY);
            griLa4.setVerticalAxisTitleTextSize(20);
            graph4.getViewport().setXAxisBoundsManual(true);
            graph4.getViewport().setYAxisBoundsManual(true);
            graph4.getViewport().setMaxX(arraysizeglobalsecond4 + 1);


            //if(arraysizeglobalsecond4<60)
            //{
                graph4.getViewport().setMinX(0);
                graph4.getViewport().setMaxX(60);
            //}
            //else
            //{
            //    graph4.getViewport().setMinX(arraysizeglobalsecond4-60);
            //    graph4.getViewport().setMaxX(arraysizeglobalsecond4);
            //}
            graph4.getViewport().setMinY(0);
            graph4.getViewport().setMaxY(max + .2*max);


        }
        if(indication == 1)
        {


            graph4.setTitle("         CO2 Sensor 4");
            graph4.setTitleTextSize(25);
            graph4.removeAllSeries();
            graph4.addSeries(seriesgsuperminute4);
            GridLabelRenderer griLa4 = graph4.getGridLabelRenderer();
            LineGraphSeries lil4 = seriesgsuperminute4;
            lil4.setThickness(2);
            griLa4.setHorizontalAxisTitle("              minutes");
            griLa4.setHorizontalAxisTitleTextSize(20);
            griLa4.setVerticalAxisTitle("ppm");
            griLa4.setLabelVerticalWidth(43);
            griLa4.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa4.setGridColor(Color.LTGRAY);
            griLa4.setVerticalAxisTitleTextSize(20);
            graph4.getViewport().setXAxisBoundsManual(true);
            graph4.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalminute4<10)
            //{
                graph4.getViewport().setMinX(0);
                graph4.getViewport().setMaxX(60);
            //}
            //else
            //{
            //    graph4.getViewport().setMinX(arraysizeglobalminute3-10);
            //    graph4.getViewport().setMaxX(arraysizeglobalminute3);
            //}
            graph4.getViewport().setMinY(0);
            graph4.getViewport().setMaxY(max + .2*max);
        }
        else if(indication == 2)
        {


            graph4.setTitle("         CO2 Sensor 4");
            graph4.setTitleTextSize(25);
            graph4.removeAllSeries();
            graph4.addSeries(seriesghour4);
            GridLabelRenderer griLa4 = graph4.getGridLabelRenderer();
            LineGraphSeries lil4 = seriesghour4;
            lil4.setThickness(2);
            griLa4.setHorizontalAxisTitle("              hours");
            griLa4.setHorizontalAxisTitleTextSize(20);
            griLa4.setVerticalAxisTitle("ppm");
            griLa4.setLabelVerticalWidth(43);
            griLa4.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa4.setGridColor(Color.LTGRAY);
            griLa4.setVerticalAxisTitleTextSize(20);
            graph4.getViewport().setXAxisBoundsManual(true);
            graph4.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalhour4<10)
            //{
                graph4.getViewport().setMinX(0);
                graph4.getViewport().setMaxX(24);
            //}
            //else
            //{
            //    graph4.getViewport().setMinX(arraysizeglobalhour4-10);
            //    graph4.getViewport().setMaxX(arraysizeglobalhour4);
            //}
            graph4.getViewport().setMinY(0);
            graph4.getViewport().setMaxY(max + .2*max);
        }
        else if(indication == 3)
        {



            graph4.setTitle("         CO2 Sensor 4");
            graph4.setTitleTextSize(25);
            graph4.removeAllSeries();
            graph4.addSeries(seriesgday4);
            GridLabelRenderer griLa4 = graph4.getGridLabelRenderer();
            LineGraphSeries lil4 = seriesgday4;
            lil4.setThickness(2);
            griLa4.setHorizontalAxisTitle("              days");
            griLa4.setHorizontalAxisTitleTextSize(20);
            griLa4.setVerticalAxisTitle("ppm");
            griLa4.setLabelVerticalWidth(43);
            griLa4.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa4.setGridColor(Color.LTGRAY);
            griLa4.setVerticalAxisTitleTextSize(20);
            graph4.getViewport().setXAxisBoundsManual(true);
            graph4.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalday4<10)
            //{
                graph4.getViewport().setMinX(0);
                graph4.getViewport().setMaxX(31);
            //}
            //else
            //{
            //    graph4.getViewport().setMinX(arraysizeglobalday4-10);
            //    graph4.getViewport().setMaxX(arraysizeglobalday4);
            //}
            graph4.getViewport().setMinY(0);
            graph4.getViewport().setMaxY(max + .2*max);
        }
        else if(indication == 4)
        {


            graph4.setTitle("         CO2 Sensor 4");
            graph4.setTitleTextSize(25);
            graph4.removeAllSeries();
            graph4.addSeries(seriesgweek4);
            GridLabelRenderer griLa4 = graph4.getGridLabelRenderer();
            LineGraphSeries lil4 = seriesgweek4;
            lil4.setThickness(2);
            griLa4.setHorizontalAxisTitle("              months");
            griLa4.setHorizontalAxisTitleTextSize(20);
            griLa4.setVerticalAxisTitle("ppm");
            griLa4.setLabelVerticalWidth(43);
            griLa4.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa4.setGridColor(Color.LTGRAY);
            griLa4.setVerticalAxisTitleTextSize(20);
            graph4.getViewport().setXAxisBoundsManual(true);
            graph4.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalweek4<10)
            //{
                graph4.getViewport().setMinX(0);
                graph4.getViewport().setMaxX(13);
            //}
            //else
            //{
            //    graph4.getViewport().setMinX(arraysizeglobalweek4-10);
            //    graph4.getViewport().setMaxX(arraysizeglobalweek4);
            //}
            graph4.getViewport().setMinY(0);
            graph4.getViewport().setMaxY(max + .2*max);
        }
        else if(indication == 5)
        {
            graph4.setTitle("         CO2 Sensor 4");
            graph4.setTitleTextSize(25);
            graph4.removeAllSeries();
            graph4.addSeries(seriesgyear4);
            GridLabelRenderer griLa4 = graph4.getGridLabelRenderer();
            LineGraphSeries lil4 = seriesgyear4;
            lil4.setThickness(2);
            griLa4.setHorizontalAxisTitle("              years");
            griLa4.setHorizontalAxisTitleTextSize(20);
            griLa4.setVerticalAxisTitle("ppm");
            griLa4.setLabelVerticalWidth(43);
            griLa4.setLabelVerticalWidth(55);
            //griLa.setH;
            griLa4.setGridColor(Color.LTGRAY);
            griLa4.setVerticalAxisTitleTextSize(20);
            graph4.getViewport().setXAxisBoundsManual(true);
            graph4.getViewport().setYAxisBoundsManual(true);
            //graph.getViewport().setMaxX(10);
            //if(arraysizeglobalyear4<3)
            //{
                graph4.getViewport().setMinX(0);
                graph4.getViewport().setMaxX(31);
            //}
            //else
            //{
            //    graph4.getViewport().setMinX(arraysizeglobalyear4-3);
            //    graph4.getViewport().setMaxX(arraysizeglobalyear4);
            //}
            graph4.getViewport().setMinY(0);
            graph4.getViewport().setMaxY(max + .2*max);

        }

    }    ////////////////////////////////////////////////////////////////////////////////////////////

}