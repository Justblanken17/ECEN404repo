package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class Camera4 extends AppCompatActivity {
    private StorageReference lStorage;
    private StorageReference lStorage2;
    private StorageReference lStorage3;
    private StorageReference lStorage4;
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private ImageView fakeimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera4);
        image1 = (ImageView)findViewById(R.id.imageView108);
        //image2 = (ImageView)findViewById(R.id.imageView16);
        //image3 = (ImageView)findViewById(R.id.imageView17);
        //image4 = (ImageView)findViewById(R.id.imageView18);
        Button buttonreferesh = (Button) findViewById(R.id.buttonrefreshimage5);
        Button buttonback = (Button) findViewById(R.id.buttonbsckimage5);
        //Button buttoncamera1 = (Button) findViewById(R.id.buttoncamera1);
        //Button buttoncamera2 = (Button) findViewById(R.id.buttoncamera2);
        //Button buttoncamera3 = (Button) findViewById(R.id.buttoncamera1);
        //Button buttoncamera4 = (Button) findViewById(R.id.buttoncamera2);
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


        lStorage = FirebaseStorage.getInstance().getReference().child("MCU 1/Camera 4/Images");
        //lStorage2 = FirebaseStorage.getInstance().getReference().child("MCU 1/Camera 2/Images");
        //lStorage3 = FirebaseStorage.getInstance().getReference().child("MCU 1/Camera 3/Images");
        //lStorage4 = FirebaseStorage.getInstance().getReference().child("MCU 1/Camera 4/Images");
        try {
            final File lclfile = File.createTempFile("Images", "jpg");
            lStorage.getFile(lclfile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    Bitmap bitmap = BitmapFactory.decodeFile(lclfile.getAbsolutePath()); //getAbsolutePath
                    image1.setImageBitmap(bitmap);
                    //image2.setImageBitmap(bitmap);
                    //image3.setImageBitmap(bitmap);
                    //image4.setImageBitmap(bitmap);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        try {
            final File lclfile2 = File.createTempFile("Images", "jpg");
            lStorage2.getFile(lclfile2).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    Bitmap bitmap = BitmapFactory.decodeFile(lclfile2.getAbsolutePath());
                    image2.setImageBitmap(bitmap);
                    //image2.setImageBitmap(bitmap);
                    //image3.setImageBitmap(bitmap);
                    //image4.setImageBitmap(bitmap);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            final File lclfile3 = File.createTempFile("Images", "jpg");
            lStorage3.getFile(lclfile3).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    Bitmap bitmap = BitmapFactory.decodeFile(lclfile3.getAbsolutePath());
                    image3.setImageBitmap(bitmap);
                    //image2.setImageBitmap(bitmap);
                    //image3.setImageBitmap(bitmap);
                    //image4.setImageBitmap(bitmap);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            final File lclfile4 = File.createTempFile("Images", "jpg");
            lStorage4.getFile(lclfile4).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    Bitmap bitmap = BitmapFactory.decodeFile(lclfile4.getAbsolutePath());
                    image4.setImageBitmap(bitmap);
                    //image2.setImageBitmap(bitmap);
                    //image3.setImageBitmap(bitmap);
                    //image4.setImageBitmap(bitmap);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        //Glide.with(this).load("https://firebasestorage.googleapis.com/v0/b/growable-space-habitat.appspot.com/o/MCU%201%2FImages?alt=media&token=34adb9e1-9780-40d2-b4ea-c59aa8d081a9").into(image1);
        //Glide.with(this).load("https://static.wixstatic.com/media/ea3599_6d9f1eb2433a4d08a1f4eea008cd46be~mv2.webp").into(image2);
        //Glide.with(this).load("https://static.wixstatic.com/media/ea3599_32f97523a8524d779143794da7761a46~mv2.webp").into(image3);
        //Glide.with(this).load("https://static.wixstatic.com/media/ea3599_e988211277c544a4b3bb26a63f384d64~mv2.webp").into(image4);
        //https://firebasestorage.googleapis.com/v0/b/growable-space-habitat.appspot.com/o/MCU%201%2FImages.jpg?alt=media&token=b9991faa-7ad9-4185-a56c-69eff24bf646

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
        Intent intent = new Intent(this, Camera4.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivitymain(){
        Intent intent = new Intent(this, Imagebutton.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }

}