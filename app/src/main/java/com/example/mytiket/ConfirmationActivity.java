package com.example.mytiket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.mytiket.BookMovie.selectednoofseat;
import static com.example.mytiket.BookMovie.selectedtheatre;
import static com.example.mytiket.BookMovie.selectedtypeofseat;
import static com.example.mytiket.MovieActivity.selecteddate;
import static com.example.mytiket.MovieActivity.selectedtime;
import static com.example.mytiket.MovieActivity.value1;
import static com.example.mytiket.MovieActivity.value3;

public class ConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        try {
            JSONObject jsonDetails = new JSONObject(getIntent().getExtras().getString("PaymentDetails"));

            //Displaying payment details
            showDetails(jsonDetails.getJSONObject("response"), getIntent().getExtras().getString("PaymentAmount"));
        } catch (JSONException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void showDetails(JSONObject jsonDetails, String paymentAmount) throws JSONException {
        //Views

        TextView textViewId = (TextView) findViewById(R.id.paymentId);
        TextView textViewStatus= (TextView) findViewById(R.id.paymentStatus);
        TextView textViewAmount = (TextView) findViewById(R.id.paymentAmount);
        TextView textViewname=(TextView)findViewById(R.id.mavieName);
        TextView textViewLanguage=(TextView)findViewById(R.id.mavieLanguage);
        TextView textViewdate=(TextView)findViewById(R.id.bookDate);
        TextView textViewtime=(TextView)findViewById(R.id.bookTime);
        TextView textViewtheatre=(TextView)findViewById(R.id.theatreName);
        TextView textViewseat=(TextView)findViewById(R.id.bookSeat);
        TextView textViewtype=(TextView)findViewById(R.id.bookType);





        //Showing the details from json object
        textViewId.setText(jsonDetails.getString("id"));
        textViewStatus.setText(jsonDetails.getString("state"));
        textViewAmount.setText(paymentAmount+" USD");
        textViewname.setText(value1);
        textViewLanguage.setText(value3);
        textViewdate.setText(selecteddate);
        textViewtime.setText(selectedtime);
        textViewtheatre.setText(selectedtheatre);
        textViewseat.setText(selectednoofseat);
        textViewtype.setText(selectedtypeofseat);
        Toast.makeText(this," Movie Booked:"+value1+"",Toast.LENGTH_SHORT).show();

    }
}
