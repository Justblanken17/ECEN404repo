package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
public class Imagebutton extends AppCompatActivity {
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private ImageView fakeimage;

    //ImageView image1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagebutton);
        image1 = (ImageView)findViewById(R.id.imageView15);
        image2 = (ImageView)findViewById(R.id.imageView16);
        image3 = (ImageView)findViewById(R.id.imageView17);
        image4 = (ImageView)findViewById(R.id.imageView18);
        //new Connector().execute();

        //Picasso.get().load("implementation 'com.github.bumptech.glide:glide:4.13.2'
        //  annotationProcessor 'com.github.bumptech.glide:compiler:4.13.2').into((ImageView)findViewById(R.id.imageView15));

        //new Connector().execute();
        //imageView15
         //this
        Glide.with(this).load("https://static.wixstatic.com/media/ea3599_e0835e77947042cfbcf1f13191f56305~mv2.jpg").into(image1);
        Glide.with(this).load("https://static.wixstatic.com/media/ea3599_190d49e6c908464a833568f78023ab20~mv2.jpg").into(image2);
        Glide.with(this).load("https://static.wixstatic.com/media/ea3599_5ec0d92c14354729b3e7ee633c84447a~mv2.jpg").into(image3);
        Glide.with(this).load("https://static.wixstatic.com/media/ea3599_2fdc8cc3bae9440998084fa171bca03a~mv2.webp").into(image4);
        Button buttonreferesh = (Button) findViewById(R.id.buttonrefreshimage);
        Button buttonback = (Button) findViewById(R.id.buttonbsckimage);
        buttonreferesh.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
            @Override
            public void onClick(View view) {
                openActivityimage();
            }
        });
        buttonback.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
            @Override
            public void onClick(View view) {
                openActivitymain();
            }
        });
    }
      /*class Connector extends AsyncTask<String, String, String> {



        // public void setContentView (int layoutResID){
        // in this class we will do background operations through a background thread, and update in the main thread
        // }
        //public final void setText (int resid)
        //{

        //}
        @Override
        protected String doInBackground(String... params) {
            String dataread = "";
            //final ImageView[] i = {fakeimage};
            runOnUiThread(new Runnable() { //runONUi thread allows content to run on main thread since, only there can necessary code be run
                @Override
                public void run() {
                   // i[0] = (ImageView)findViewById(R.id.imageView15);
                    setContentView(R.layout.activity_imagebutton); //adds desired layout to be displayed
                    //TextView textView7 = (TextView)findViewById(R.id.textViewCTC); //connects a text variable to text button in the layout
                    // textView7.setText(res_fin13); //sets a value to the text
                    Button buttonreferesh = (Button) findViewById(R.id.buttonrefreshimage);
                    Button buttonback = (Button) findViewById(R.id.buttonbsckimage);



                    buttonreferesh.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
                        @Override
                        public void onClick(View view) {
                            openActivityimage();
                        }
                    });
                    buttonback.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
                        @Override
                        public void onClick(View view) {
                            openActivitymain();
                        }
                    });

                }
            });
            return dataread;
        }
    }
    */

    public void openActivityimage(){
        Intent intent = new Intent(this, Imagebutton.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivitymain(){
        Intent intent = new Intent(this, MainActivity.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    }
/*v
    class Connector extends AsyncTask<String, String, Drawable> {
        @Override

        protected Drawable doInBackground(String... params){

                Drawable drawn = Drawable.createFromPath("https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Cat03.jpg/1200px-Cat03.jpg");//"C:\Users\jjbla\Pictures\Output2.jpg" https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Cat03.jpg/1200px-Cat03.jpg
            runOnUiThread(new Runnable() { //runONUi thread allows content to run on main thread since, only there can necessary code be run
                @Override
                public void run() {
                    setContentView(R.layout.activity_imagebutton); //adds desired layout to be displayed
                    ImageView image2 = (ImageView) findViewById(R.id.imageView15); //connects a text variable to text button in the layout
                    image2.setImageDrawable(drawn);
                    //textView7.setText(res_fin12); //sets a value to the text


                }
            });


                return drawn;


        }


    }


*/



