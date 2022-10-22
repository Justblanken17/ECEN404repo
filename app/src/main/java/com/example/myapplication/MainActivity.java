package com.example.myapplication;
import android.content.Intent;
import android.net.http.Connection;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.Buffer;
//import java.sql.Connection;
//sources used
//https://www.youtube.com/watch?v=4_0s8KLlZKc - tutorial used for httpconnection related connections
//https://www.youtube.com/watch?v=bgIUdb-7Rqo - used to handle buttons
//https://stackoverflow.com/questions/5161951/android-only-the-original-thread-that-created-a-view-hierarchy-can-touch-its-vi
public class MainActivity extends AppCompatActivity {

    @Override // used to redefine class definitions
    protected void onCreate(Bundle savedInstanceState) { //used to produce non-graphical initialisations when my activity first starts
        super.onCreate(savedInstanceState); //calling from super, a class from which the subclasses can be produced that inherit the functions
        //setContentView(R.layout.activity_main);
        //setContentView(R.layout.activity_main);
        //TextView textView1 = (TextView) findViewById(R.id.textView);
        //textView1.setText("hi");

        new Connector().execute(); //causes the code in the connector class to run

    }

    class Connector extends AsyncTask<String, String, String> {
       // in this class we will do background operations through a background thread, and update in the main thread


        @Override

        protected String doInBackground(String... params) {
        //where I do operations in the background
            String dataread ="";
            //note: the code in this section isnt actually displayed, was just used during early stages of project to test out connect
        //    String link = "http://10.228.235.82/android_connect/establishconnection.php"; //This string will be used as URI I will use to access the php file
        //    try{ //block of code 58-61 sets up connection to the internet via apache, 63-69 read the contents of the code
        //        URL url = new URL(link);
        //        HttpClient androidclient = new DefaultHttpClient(); // HTTP - Hypertext Transfer Protocol, used to connect browsers/clients and servers. HTTP client sends requests to access my resources/php file
        //        HttpGet androidget = new HttpGet(); //androidget will request data from a server
        //        androidget.setURI(new URI(link)); //the Uniform Resource Identifier is set to identify the php file whose hyperlink I mentioned previously
        //        HttpResponse respond = androidclient.execute(androidget); //Httprespnse gets the data that androidget requested
        //        BufferedReader phpread = new BufferedReader(new InputStreamReader(respond.getEntity().getContent()));//will be used to read the contents of response
        //        StringBuilder stringBuffer = new StringBuilder(""); //string builder is what I use to store the data that is being read
        //        String lineread = ""; //will store a line of the read contents of phpread
        //        while ((lineread = phpread.readLine()) != null) {  //loop reads through each line of the php file, and adds the contents to the stringBuffer
        //            stringBuffer.append(lineread + "\n"); //adds the line to string buffer

        //        }
        //        phpread.close(); //closes phpread since all its contents are read
        //        dataread = stringBuffer.toString(); //closes phpread since all its contents are read

          //      HttpClient androidclient = new DefaultHttpClient();
          //        HttpGet androidget = new HttpGet();
          //        androidget.setURI(new URI(host));
         //         HttpResponse androidresponse = androidclient.execute(androidget);
         //         BufferedReader phpread = new BufferedReader(new InputStreamReader(androidresponse.getEntity().getContent()));

         //        StringBuffer stringBuffer = new StringBuffer("");

        //         String line = ""; //
        //         while ((line = phpread.readLine()) != null){
        //            stringBuffer.append(line);
        //            break;
        //        }
        //        phpread.close();
        //        result = stringBuffer.toString();



        //    }
        //    catch (Exception e){
        //        return new String("Exception" + e.getMessage());
        //    }
            final String res_fin = ""; //result
            runOnUiThread(new Runnable() {//runONUi thread allows content to run on main thread since, only there can necessary code be run
                  @Override
                  public void run() {
                      setContentView(R.layout.activity_main);//adds desired layout to be displayed
                      TextView textView1 = (TextView)findViewById(R.id.textView); //connects a text variable to text button in the layout
                      textView1.setText(""); //sets a value to the text res_fin
                      //Button button = (Button) findViewById(R.id.gotothing); //connects the button from the layout to a newly defined button variable by assoicating with its ID
                      //Button buttoncdc = (Button) findViewById(R.id.cdctext); //connects the button from the layout to a newly defined button variable by assoicating with its ID
                      //Button buttoncm = (Button) findViewById(R.id.cmbutton); //connects the button from the layout to a newly defined button variable by assoicating with its ID
                      //Button buttonct = (Button) findViewById(R.id.ctbutton); //connects the button from the layout to a newly defined button variable by assoicating with its ID
                      //Button buttonec = (Button) findViewById(R.id.ecbutton); //connects the button from the layout to a newly defined button variable by assoicating with its ID
                      //Button buttonlmc = (Button) findViewById(R.id.lmcbutton); //connects the button from the layout to a newly defined button variable by assoicating with its ID
                      //Button buttonmc = (Button) findViewById(R.id.mcbutton); //connects the button from the layout to a newly defined button variable by assoicating with its ID
                      //Button buttonoc = (Button) findViewById(R.id.OCbutton); //connects the button from the layout to a newly defined button variable by assoicating with its ID
                      //Button buttonumc = (Button) findViewById(R.id.umcbutton); //connects the button from the layout to a newly defined button variable by assoicating with its ID
                      Button buttonmcu5 = (Button) findViewById(R.id.MCU5); //connects the button from the layout to a newly defined button variable by assoicating with its ID
                      Button buttonmcu4 = (Button) findViewById(R.id.MCU4button); //connects the button from the layout to a newly defined button variable by assoicating with its ID
                      Button buttonmcu3 = (Button) findViewById(R.id.mcu3button); //connects the button from the layout to a button variable by assoicating with its ID
                      Button buttonmcu2 = (Button) findViewById(R.id.mcu2button);
                      Button buttonimage = (Button) findViewById(R.id.imagebutton);//connects the button from the layout to a button variable by assoicating with its ID
                      Button recycle = (Button) findViewById(R.id.firebasetest);
                      /*
                      button.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
                          @Override
                          public void onClick(View view) {
                              openActivity2();
                          }
                      });
                      buttoncdc.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
                          @Override
                          public void onClick(View view) {
                              openActivitycdc();
                          }
                      });
                      buttoncm.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
                          @Override
                          public void onClick(View view) {
                              openActivitycm();
                          }
                      });
                      buttonct.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
                          @Override
                          public void onClick(View view) {
                              openActivityct();
                          }
                      });
                      buttonec.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
                          @Override
                          public void onClick(View view) {
                              openActivityec();
                          }
                      });
                      buttonlmc.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
                          @Override
                          public void onClick(View view) {
                              openActivitylmc();
                          }
                      });
                      buttonmc.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
                          @Override
                          public void onClick(View view) {
                              openActivitymc();
                          }
                      });
                      buttonoc.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
                          @Override
                          public void onClick(View view) {
                              openActivityoc();
                          }
                      });
                      buttonumc.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
                          @Override
                          public void onClick(View view) {
                              openActivityumc();
                          }
                      });
                      */
                      buttonmcu5.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
                          @Override
                          public void onClick(View view) {
                              openActivitymcu5();
                          }
                      });

                      buttonmcu4.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
                          @Override
                          public void onClick(View view) {
                              openActivitymcu4();
                          }
                      });
                      buttonmcu3.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
                          @Override
                          public void onClick(View view) {
                              openActivitymcu3();
                          }
                      });
                      buttonmcu2.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
                          @Override
                          public void onClick(View view) {
                              openActivitymcu2();
                          }
                      });
                      buttonimage.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
                          @Override
                          public void onClick(View view) {
                              openActivityimage();
                          }
                      });
                      recycle.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
                          @Override
                          public void onClick(View view) {
                              openActivityrecycle();
                          }
                      });


                  }
          });

            return dataread;

        }

    }
    public void openActivity2(){
        Intent intent = new Intent(this, Activity2.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivitycdc(){
        Intent intent = new Intent(this, Activitycdc.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivitycm(){
        Intent intent = new Intent(this, activitycm.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivityct(){
        Intent intent = new Intent(this, ActivityCTusing.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivityec(){
        Intent intent = new Intent(this, ActivityEC.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivitylmc(){
        Intent intent = new Intent(this, ActivityLMCReal.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivitymc(){
        Intent intent = new Intent(this, ActivityMC.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivityoc(){
        Intent intent = new Intent(this, ActivityOC.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivityumc(){
        Intent intent = new Intent(this, ActivityUMC.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivitymcu5(){
        Intent intent = new Intent(this, MCU5.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivitymcu4(){
        Intent intent = new Intent(this, MCU4.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivitymcu3(){
        Intent intent = new Intent(this, MCU3.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivitymcu2(){
        Intent intent = new Intent(this, MCU2.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivityimage(){
        Intent intent = new Intent(this, Imagebutton.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivityrecycle(){
        Intent intent = new Intent(this, Recycleviewtest.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }



}