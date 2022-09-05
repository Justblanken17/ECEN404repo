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
public class ActivityCt extends AppCompatActivity {

    @Override // used to redefine class definitions
    protected void onCreate(Bundle savedInstanceState) { //used to produce non-graphical initialisations
        super.onCreate(savedInstanceState); //calling from super
        //setContentView(R.layout.activity_main);
        //setContentView(R.layout.activity_main);
        //TextView textView1 = (TextView) findViewById(R.id.textView);
        //textView1.setText("hi");

        new Connector().execute();

    }

    class Connector extends AsyncTask<String, String, String> {
        // public void setContentView (int layoutResID){

        // }
        //public final void setText (int resid)
        //{

        //}
        @Override

        protected String doInBackground(String... params) {

            String result ="";

            String host = "http://10.230.160.179/android_connect/cm.php"; //10.216.2.136  10.236.39.36 10.236.46.44
            try{
                URL url = new URL(host);
                HttpClient androidclient = new DefaultHttpClient();
                HttpGet androidget = new HttpGet();
                androidget.setURI(new URI(host));
                HttpResponse response = androidclient.execute(androidget);
                BufferedReader phpread = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                StringBuilder stringBuffer = new StringBuilder("");
                String line = ""; //
                while ((line = phpread.readLine()) != null) {
                    stringBuffer.append(line + "\n");

                }
                phpread.close();
                result = stringBuffer.toString();

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
            final String res_fin4 = result; //result
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    setContentView(R.layout.activity_activitycdc );
                    TextView textView2 = (TextView)findViewById(R.id.textViewcdc);
                    textView2.setText(res_fin4);


                }
            });

            return result;

        }
        /*
        @Override

        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(),result, Toast.LENGTH_SHORT).show();
        }
        */
    }




}