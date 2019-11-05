package com.example.mytiket;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.MediaController;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.Calendar;

import static com.example.mytiket.LoginActivity.loginstatus;

public class MovieActivity extends AppCompatActivity  {
    public static String selectedtime,selecteddate;
    Dialog myDialog;
    TextView txttitle,txttype,txtlanguage,txtsynopsis,txtcast,txtdirector,txtmusicdirector;
    String s1,s2,s3,s4;
    public static String value1,value2,value3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie2);
        myDialog=new Dialog(this);
        VideoView videoview=findViewById(R.id.videoView);
        String videoPath="android.resource://"+getPackageName()+"/"+R.raw.toystory4;
        Uri uri= Uri.parse(videoPath);
        videoview.setVideoURI(uri);
        MediaController mediaController=new MediaController(this);
        videoview.setMediaController(mediaController);
        mediaController.setAnchorView(videoview);
        txttitle=(TextView)findViewById(R.id.textViewTitle);
        txtlanguage=(TextView)findViewById(R.id.textViewlanguage);
        txttype=(TextView)findViewById(R.id.textViewtype);
        txtsynopsis=(TextView)findViewById(R.id.synopsis);
        txtcast=(TextView)findViewById(R.id.cast);
        txtdirector=(TextView)findViewById(R.id.director);
        txtmusicdirector=(TextView)findViewById(R.id.musicdirector);
         value1 = getIntent().getExtras().getString("movieTitle");
        txttitle.setText(value1);
         value2 = getIntent().getExtras().getString("movieType");
        txtlanguage.setText(value2);
         value3 = getIntent().getExtras().getString("movieLanguage");
        txttype.setText(value3);
        s2="Chhichhore";
        s1="The Toy Story 4";
        s3 ="The Joya";
        s4 = "Dream Girl";
        if(value1.equals(s1)){
            txtsynopsis.setText("When a new toy called \"Forky\" joins Woody and the gang, a road trip alongside old and new friends reveals how big the world can be for a toy.");
            txtcast.setText("John Lasseter\t\n" +
                    "Andrew Stanton\t\n" +
                    "Josh Cooley\t\n" +
                    "Valerie LaPointe\t\n" +
                    "Rashida Jones");
            txtdirector.setText("Josh Cooley");
            txtmusicdirector.setText("Randy Newman");

        }
        else if(value1.equals(s2)){
            txtsynopsis.setText("Following a group of friends from university as they progress into middle-age life and go their own separate ways.");
            txtcast.setText("Sushant Singh Rajput\t\n" +
                    "Shraddha Kapoor\t\n" +
                    "Varun Sharma\t");
            txtdirector.setText("Nitesh Tiwari");
            txtmusicdirector.setText("Pritam Chakraborty\t\n" +
                    "Sameeruddin");
        }
        else if(value1.equals(s3)){
            txtsynopsis.setText("When the younger players in India's cricket team find out that advertising executive Zoya Singh Solanki was born at the very moment India won the World Cup back in 1983, they are intrigued. When having breakfast with her is followed by victories on the field, they are impressed. And when not eating with her results in defeat");
            txtcast.setText("Dulquer Salmaan\n" +
                    "Sonam Kapoor Ahuja\n" +
                    "Sanjay Kapoor\n" +
                    "R.Bhakti Klein");
            txtdirector.setText("Abhishek Sharma");
            txtmusicdirector.setText("Pritam Chakraborty\\t\\n\" +\n" +
                  "Sameeruddin");
        }
        else if(value1.equals(s4)){
            txtsynopsis.setText("Rom-com Movie, directed by Raaj Shaandilyaa, stars Ayushmann Khurrana who plays a 'dream girl'. In every love story, there is always one trying to win the heart of the other, who could be the 'dream girl'.");
            txtcast.setText("Nirmaan Dsingh\t\n" +
                    "Niket Pandey\t\n" +
                    "Raaj Shaandilyaa\t");
            txtdirector.setText("Raaj Shaandilyaa");
            txtmusicdirector.setText("Meet Bros");
        }

    }

    public void selectdate(View view) {
//        DialogFragment datePicker=new DatePickerFragment();
//        datePicker.show(getSupportFragmentManager(),"Date Picker");
    }
//
//    @Override
//    public void onDateSet(DatePicker datePicker, int year, int month, int dayofMonth) {
//        Calendar c=Calendar.getInstance();
//        c.set(Calendar.YEAR,year);
//        c.set(Calendar.MONTH,month);
//        c.set(Calendar.DAY_OF_WEEK_IN_MONTH,dayofMonth);
//        String currentDateString= DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
//        Toast.makeText(this, currentDateString, Toast.LENGTH_SHORT).show();
//        String selecteddate=currentDateString;
//    }
    public void ShowPopup(View v){
        if(loginstatus==true) {
            TextView txtclosed;
            final Button b1,b2,b3,b4,b5,b6,b7;
            myDialog.setContentView(R.layout.activity_custom_popup);
            txtclosed = (TextView) myDialog.findViewById(R.id.txtclose);
            b1=(Button)myDialog.findViewById(R.id.date1);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selecteddate=b1.getText().toString();
                    Toast.makeText(MovieActivity.this," selected Date:"+selecteddate+"",Toast.LENGTH_SHORT).show();
                }
            });
            b2=(Button)myDialog.findViewById(R.id.date2);
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selecteddate=b2.getText().toString();
                    Toast.makeText(MovieActivity.this," selected Date:"+selecteddate+"",Toast.LENGTH_SHORT).show();
                }
            });
            b3=(Button)myDialog.findViewById(R.id.date3);
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selecteddate=b3.getText().toString();
                    Toast.makeText(MovieActivity.this," selected Date:"+selecteddate+"",Toast.LENGTH_SHORT).show();
                }
            });
            b4=(Button)myDialog.findViewById(R.id.time1);
            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedtime=b4.getText().toString();
                    Toast.makeText(MovieActivity.this," selected Time:"+selectedtime+"",Toast.LENGTH_SHORT).show();
                }
            });
            b5=(Button)myDialog.findViewById(R.id.time2);
            b5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedtime=b5.getText().toString();
                    Toast.makeText(MovieActivity.this," selected Time:"+selectedtime+"",Toast.LENGTH_SHORT).show();
                }
            });
            b6=(Button)myDialog.findViewById(R.id.time3);
            b6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedtime=b6.getText().toString();
                    Toast.makeText(MovieActivity.this," selected Time:"+selectedtime+"",Toast.LENGTH_SHORT).show();
                }
            });

            b7=(Button)myDialog.findViewById(R.id.proceed);
            b7.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    b7.setText("Clicked");
                    if((selecteddate.equals(""))&&(selectedtime.equals("")))
                    {
                        Toast.makeText(MovieActivity.this," Please select Date and Time.",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Intent popupIntent = new Intent(MovieActivity.this, BookMovie.class);
                        startActivity(popupIntent);
                        finish();

                    }
                }
            });
            txtclosed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myDialog.dismiss();
                }
            });
            myDialog.show();
        }
        else{

            Intent loginIntent = new Intent(MovieActivity.this, LoginActivity.class);
            startActivity(loginIntent);
            finish();
        }

    }
}
