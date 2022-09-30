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
public class ActivityLMCReal extends AppCompatActivity {

    @Override // used to redefine class definitions
    protected void onCreate(Bundle savedInstanceState) { //used to produce non-graphical initialisations
        super.onCreate(savedInstanceState); //calling from super
        //setContentView(R.layout.activity_main);
        //setContentView(R.layout.activity_main);
        //TextView textView1 = (TextView) findViewById(R.id.textView);
        //textView1.setText("hi");

        new Connector().execute();//causes the code in the connector class to run

    }

    class Connector extends AsyncTask<String, String, String> {
        // public void setContentView (int layoutResID){
        // in this class we will do background operations through a background thread, and update in the main thread
        // }
        //public final void setText (int resid)
        //{

        //}
        @Override

        protected String doInBackground(String... params) {
            //where I do operations in the background
            String dataread =""; //creates string of intended result

            String link = "http://10.231.226.125/android_connect/lowermixingchamber.php"; //10.216.2.136  10.236.39.36 10.236.46.44 holds the link for the php file I want to connect to
            try{
               URL url = new URL(link); // creates url, this code is throway, never used
                HttpClient androidclient = new DefaultHttpClient(); // HTTP - Hypertext Transfer Protocol, used to connect browsers/clients and servers. HTTP client sends requests to access my resources/php file
                HttpGet androidget = new HttpGet(); //androidget will request data from a server
                androidget.setURI(new URI(link)); //the Uniform Resource Identifier is set to identify the php file whose hyperlink I mentioned previously
                HttpResponse respond = androidclient.execute(androidget); //Httprespnse gets the data that androidget requested
                BufferedReader phpread = new BufferedReader(new InputStreamReader(respond.getEntity().getContent())); //will be used to read the contents of response
                StringBuilder stringBuffer = new StringBuilder(""); //string builder is what I use to store the data that is being read
                String lineread = ""; //will store a line of the read contents of phpread
                while ((lineread = phpread.readLine()) != null) { //loop reads through each line of the php file, and adds the contents to the stringBuffer
                    stringBuffer.append(lineread + "\n"); //adds the line to string buffer

                }
                phpread.close(); //closes phpread since all its contents are read
                dataread = stringBuffer.toString(); //closes phpread since all its contents are read

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



            }
            catch (Exception e){
                return new String("Exception" + e.getMessage());
            }
            final String res_fin6 = dataread; //result
            runOnUiThread(new Runnable() { //runONUi thread allows content to run on main thread since, only there can necessary code be run
                @Override
                public void run() {
                    setContentView(R.layout.activity_lmcreal); //adds desired layout to be displayed
                    TextView textView3 = (TextView)findViewById(R.id.textViewlmc);//connects a text variable to text button in the layout
                    textView3.setText(res_fin6);//sets a value to the text
                    Button buttonreferesh = (Button) findViewById(R.id.buttonrefreshlmc);
                    Button buttonback = (Button) findViewById(R.id.buttonbacklmc);
                    Button buttonexpec = (Button) findViewById(R.id.buttonback8);
                    buttonreferesh.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
                        @Override
                        public void onClick(View view) {
                            openActivitylmc();
                        }
                    });
                    buttonback .setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
                        @Override
                        public void onClick(View view) {
                            openActivitymain();
                        }
                    });
                    buttonexpec .setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
                        @Override
                        public void onClick(View view) {
                            openexpecactivity();
                        }
                    });

                }
            });

            return dataread;

        }


        /*
        @Override

        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(),result, Toast.LENGTH_SHORT).show();
        }
        */
    }
    public void openActivitylmc(){
        Intent intent = new Intent(this, ActivityLMCReal.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivitymain(){
        Intent intent = new Intent(this, MainActivity.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openexpecactivity(){
        Intent intent = new Intent(this, activitylmcrealEXPECTED.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }




}