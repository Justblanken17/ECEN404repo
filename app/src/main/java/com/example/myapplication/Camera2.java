package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class Camera2 extends AppCompatActivity {
    private StorageReference lStorage;
    private StorageReference lStorage2;
    private StorageReference lStorage3;
    private StorageReference lStorage4;
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private ImageView fakeimage;
    private int photonumber = 0;
    private String filepath;
    private String filepath2;
    private String filepathappen;
    public String filepathhappen2;
    String[] filepathhappen2array = new String[1];
    public String saveinhere;
    private int stringlenght = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera2);
        image1 = (ImageView)findViewById(R.id.imageView105);
        //image2 = (ImageView)findViewById(R.id.imageView16);
        //image3 = (ImageView)findViewById(R.id.imageView17);
        //image4 = (ImageView)findViewById(R.id.imageView18);
        Button buttonreferesh = (Button) findViewById(R.id.buttonrefreshimage3);
        Button buttonback = (Button) findViewById(R.id.buttonbsckimage3);
        Button buttonhome = (Button) findViewById(R.id.homebutton8);
        Button buttongraph = (Button) findViewById(R.id.graphthing2);
        TextView stateb = findViewById(R.id.statetext2);
        filepath = "MCU 1/Camera 2/";
        filepath2 = "";
        filepathappen = "";
        filepathhappen2 = "";
        //saveinhere = "";
        DatabaseReference rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("MCU Test").child("Camera States").child("State 2");
        //stuff();
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
        buttonhome.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
            @Override
            public void onClick(View view) {
                openActivityhome();
            }
        });
        buttongraph.setOnClickListener(new View.OnClickListener() { //this section will allow the button to perform the method call when the button is pressed
            @Override
            public void onClick(View view) {
                openActivitygraph();
            }
        });

        lStorage2 = FirebaseStorage.getInstance().getReference().child("MCU 1/Camera 2");
        filepathhappen2 = "";
        lStorage2.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onSuccess(ListResult listResult) {

                String conversion1 = "";
                String conversion2 = "";
                String value = "";
                char newvalue = ' ';
                int sanitycheck = 0;
                int placeholder = 6;
                int binaryevalueation = 0;
                for (StorageReference item : listResult.getItems())
                {
                    value = item.getName();
                    if(value.length()>placeholder)
                    {

                        binaryevalueation = 1;

                        while(value.charAt(placeholder) == '0' || value.charAt(placeholder) == '1' || value.charAt(placeholder) == '2' || value.charAt(placeholder) == '3' || value.charAt(placeholder) == '4' || value.charAt(placeholder) == '5' || value.charAt(placeholder) == '6' || value.charAt(placeholder) == '7' || value.charAt(placeholder) == '8' || value.charAt(placeholder) == '9') {
                            conversion1 = conversion1 + value.charAt(placeholder);
                            if (value.length() > placeholder + 1) {
                                placeholder = placeholder + 1;

                            }
                        }
                        if(!conversion1.equals("")) {
                            if (Integer.valueOf(conversion1) > sanitycheck) {
                                sanitycheck = Integer.valueOf(conversion1);
                            }
                        }

                        //buttonback.setText(String.valueOf(sanitycheck));
                        conversion1 = "";
                        placeholder = 6;

                    }
                    else{
                        binaryevalueation = 0;
                    }
                    //buttonback.setText(String.valueOf(sanitycheck));
                    //newvalue = value.charAt(6);

                    //buttonhome.setText(Character.toString(newvalue));
                    filepathappen = item.getName();
                    if(binaryevalueation == 1) {
                        filepathhappen2 = "Images" + String.valueOf(sanitycheck) ;

                    }
                    else
                    {
                        filepathhappen2 = "Images";
                    }

                    //saveinHere(filepathhappen2);
                    filepathhappen2array[0] = filepathhappen2;
                    //buttonback.setText(filepathhappen2array[0]);
                }
                //buttonback.setText(filepathhappen2array[0]);
                //buttonreferesh.setText(filepathhappen2array[0]);
                //buttonreferesh.setText(String.valueOf(filepathappen));
                filepath = filepathhappen2;

                filepath2 = "MCU 1/Camera 2/"+ filepathhappen2;
                //buttonback.setText(filepathhappen2);
                //stateb.setText(filepath2);
                //buttonback.setText(filepath2);
               // stateb.setText(filepath2);
                lStorage = FirebaseStorage.getInstance().getReference().child(filepath2);
                filepath = "";
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

            }






        });







        //TextView stateb = findViewById(R.id.statetext2);
        //DatabaseReference rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("MCU 1").child("State").child("Camera 1");
        StorageReference storrey = FirebaseStorage.getInstance().getReference().child("MCU 1/Camera 2/Images");

        StorageReference lStorage = FirebaseStorage.getInstance().getReference().child("MCU 1/Camera 2/Images");
        /////////////////////////CHECK AGAIN
        //if(lStorage.child().listAll().)
        //
        //lStorage2 = FirebaseStorage.getInstance().getReference().child("MCU 1/Camera 2/Images");
        //lStorage3 = FirebaseStorage.getInstance().getReference().child("MCU 1/Camera 3/Images");
        //lStorage4 = FirebaseStorage.getInstance().getReference().child("MCU 1/Camera 4/Images");



        rootDatabaseref.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if((snapshot.getChildrenCount()== 0)) {
                    return;
                }
                int t = 0;
                int iterator = 0;
                double c = 0;

                double y;
                int x;
                x = -1;
                int arraysize = 0;
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    arraysize = arraysize + 1;
                }
                int[] time = new int[arraysize];
                double[] concentration = new double[arraysize];
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    time[iterator] = Integer.parseInt(snapshot1.child("7-Seconds").getValue().toString());
                    concentration[iterator] = Double.parseDouble(snapshot1.child("1-Concentration").getValue().toString());
                    iterator = iterator + 1;
                }
                t = time[0];
                c = concentration[arraysize - 1];
                if (c == 0) {
                    stateb.setText("Nitrogen Deficient - Check Sensors");
                }
                if (c == 1) {
                    stateb.setText("Healthy");
                }
                //stateb.setText(String.valueOf(c));
                //GraphView graph = (GraphView) findViewById(R.id.graph1);
                //series = new LineGraphSeries<DataPoint>();
                //for(int i = 0; i < 100; i++) {
                //    series.appendData(new DataPoint(time[i], concentration[i]), true, 100);

                //}
                //graph.addSeries(series);
                //photonumber = photonumber + 1
                stuff();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //updating();



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
      public void stuff(){
          String urlstuff = "MCU 1/Camera 2/Images";
          urlstuff = urlstuff + String.valueOf(photonumber);
          Button buttonback = (Button) findViewById(R.id.buttonbsckimage2);
          TextView stateb = findViewById(R.id.statetext2);
          DatabaseReference rootDatabaseref = FirebaseDatabase.getInstance().getReference().child("MCU 1").child("State").child("Camera 2");
          lStorage2.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {

              @Override
              public void onSuccess(ListResult listResult) {

                  String conversion1 = "";
                  String conversion2 = "";
                  String value = "";
                  char newvalue = ' ';
                  int sanitycheck = 0;
                  int placeholder = 6;
                  int binaryevaluation = 0;

                  for (StorageReference item : listResult.getItems())
                  {
                      value = item.getName();
                      if(value.length()>placeholder)
                      {

                          binaryevaluation = 1;

                          while(value.charAt(placeholder) == '0' || value.charAt(placeholder) == '1' || value.charAt(placeholder) == '2' || value.charAt(placeholder) == '3' || value.charAt(placeholder) == '4' || value.charAt(placeholder) == '5' || value.charAt(placeholder) == '6' || value.charAt(placeholder) == '7' || value.charAt(placeholder) == '8' || value.charAt(placeholder) == '9') {
                              conversion1 = conversion1 + value.charAt(placeholder);
                              if (value.length() > placeholder + 1) {
                                  placeholder = placeholder + 1;

                              }
                          }
                          if(!conversion1.equals("")) {
                              if (Integer.valueOf(conversion1) > sanitycheck) {
                                  sanitycheck = Integer.valueOf(conversion1);
                              }
                          }
                          //buttonback.setText(String.valueOf(sanitycheck));
                          conversion1 = "";
                          placeholder = 6;

                      }
                      else
                      {
                          binaryevaluation = 0;
                      }
                      //buttonback.setText(String.valueOf(sanitycheck));
                      //newvalue = value.charAt(7);

                      //buttonhome.setText(Character.toString(newvalue));
                      filepathappen = item.getName();
                      if(binaryevaluation == 1)
                      {
                          filepathhappen2 = "Images" + String.valueOf(sanitycheck);

                      }
                      else
                      {
                          filepathhappen2 = "Images";
                      }
                      //filepathhappen2 = "spinach" + String.valueOf(sanitycheck) + ".jpg";
                      //saveinHere(filepathhappen2);
                      filepathhappen2array[0] = filepathhappen2;
                      //buttonback.setText(filepathhappen2array[0]);
                  }
                  //buttonback.setText(filepathhappen2array[0]);
                  //buttonreferesh.setText(filepathhappen2array[0]);
                  //buttonreferesh.setText(String.valueOf(filepathappen));
                  filepath = filepathhappen2;

                  filepath2 = "MCU 1/Camera 2/"+ filepathhappen2;
                  //buttonback.setText(filepathhappen2);
                  //stateb.setText(filepath2);
                  //stateb.setText(filepath2);
                  lStorage = FirebaseStorage.getInstance().getReference().child(filepath2);
                  filepath = "";
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

              }






          });


          rootDatabaseref.addValueEventListener(new ValueEventListener() {
              @SuppressLint("SetTextI18n")
              @Override
              public void onDataChange(@NonNull DataSnapshot snapshot) {
                  if((snapshot.getChildrenCount()== 0)) {
                      return;
                  }
                  int t = 0;
                  int iterator = 0;
                  double c = 0;

                  double y;
                  int x;
                  x = -1;
                  int arraysize = 0;
                  for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                      arraysize = arraysize + 1;
                  }
                  int[] time = new int[arraysize];
                  double[] concentration = new double[arraysize];
                  for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                      time[iterator] = Integer.parseInt(snapshot1.child("7-Seconds").getValue().toString());
                      concentration[iterator] = Double.parseDouble(snapshot1.child("1-Concentration").getValue().toString());
                      iterator = iterator + 1;
                  }
                  t = time[0];
                  c = concentration[arraysize - 1];
                  if (c == 0) {
                      stateb.setText("Nitrogen Deficient - Check Sensors");
                  }
                  if (c == 1) {
                      stateb.setText("Healthy");
                  }
                  //stateb.setText(String.valueOf(c));
                  //GraphView graph = (GraphView) findViewById(R.id.graph1);
                  //series = new LineGraphSeries<DataPoint>();
                  //for(int i = 0; i < 100; i++) {
                  //    series.appendData(new DataPoint(time[i], concentration[i]), true, 100);

                  //}
                  //graph.addSeries(series);

              }

              @Override
              public void onCancelled(@NonNull DatabaseError error) {

              }
          });
          //updating();
      }
    public void openActivityimage(){
        Intent intent = new Intent(this, Camera2.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivitymain(){
        Intent intent = new Intent(this, Imagebutton.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivityhome(){
        Intent intent = new Intent(this, MainActivity.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    public void openActivitygraph(){
        Intent intent = new Intent(this, camera2graph.class); //causes the subordinate activity file to be opened, redirects to new layout
        startActivity(intent);
    }
    private void updating()
    {
        final Handler han = new Handler();
        final Runnable run = new Runnable() {
            @Override
            public void run() {

                //stuff();
            }
        };
        han.postDelayed(run, 10000);

    }

}