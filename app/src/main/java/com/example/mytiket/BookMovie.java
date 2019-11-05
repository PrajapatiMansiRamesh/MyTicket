package com.example.mytiket;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;

import java.math.BigDecimal;

import static com.example.mytiket.PayPalConfig.PAYPAL_REQUEST_CODE;
import static com.example.mytiket.PayPalConfig.config;

public class BookMovie extends AppCompatActivity implements View.OnClickListener {
    public static String selectedtheatre,selectednoofseat,selectedtypeofseat;
    public int amount=150;
    public String paymentAmount;
    TextView totalamount;
    Button buttonPay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_movie);
        Spinner s1=findViewById(R.id.theatre);
        Spinner s3=findViewById(R.id.noofseat);
        Spinner s2=findViewById(R.id.typeofseat);
        totalamount=(TextView)findViewById(R.id.totalamount);
        buttonPay=(Button)findViewById(R.id.buttonPay);
        buttonPay.setOnClickListener(this);

        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(this,R.array.theatrename,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       s1.setAdapter(adapter1);
       s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                selectedtheatre=adapterView.getItemAtPosition(position).toString();
               Toast.makeText(adapterView.getContext(),"Booked Theatre: "+selectedtheatre+"",Toast.LENGTH_SHORT).show();

           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });
        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this,R.array.noofseat,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s3.setAdapter(adapter2);
        s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                 selectednoofseat=adapterView.getItemAtPosition(position).toString();
                Toast.makeText(adapterView.getContext(),"Booked Number of seat: "+selectednoofseat+"",Toast.LENGTH_SHORT).show();
                if(selectedtypeofseat.equals("Golden")){
                    amount=150;
                    amount=(3*amount)*Integer.parseInt(selectednoofseat);
                    totalamount.setText(Integer.toString(amount));

                }
                else if(selectedtypeofseat.equals("Silver")){
                    amount=150;
                    amount=(2*amount)*Integer.parseInt(selectednoofseat);
                    totalamount.setText(Integer.toString(amount));
                }
                else if(selectedtypeofseat.equals("Normal")){
                    amount=150;
                    amount=(1*amount)*Integer.parseInt(selectednoofseat);
                    totalamount.setText(Integer.toString(amount));
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter<CharSequence> adapter3=ArrayAdapter.createFromResource(this,R.array.seattype,android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapter3);
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                selectedtypeofseat=adapterView.getItemAtPosition(position).toString();
                Toast.makeText(adapterView.getContext(),"Booked Type of seat: "+selectedtypeofseat+"",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Intent intent = new Intent(this, PayPalService.class);

        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);

        startService(intent);

    }


    @Override
    public void onClick(View view) {
        getPayment();
    }
    private void getPayment() {
        //Getting the amount from editText
         paymentAmount = totalamount.getText().toString();

        //Creating a paypalpayment
        PayPalPayment payment = new PayPalPayment(new BigDecimal(String.valueOf(paymentAmount)), "USD", "Amount To Pay",
                PayPalPayment.PAYMENT_INTENT_SALE);

        //Creating Paypal Payment activity intent
        Intent intent = new Intent(this, PaymentActivity.class);

        //putting the paypal configuration to the intent
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);

        //Puting paypal payment to the intent
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payment);

        //Starting the intent activity for result
        //the request code will be used on the method onActivityResult
        startActivityForResult(intent, PAYPAL_REQUEST_CODE);
    }
    public void onDestroy() {
        stopService(new Intent(this, PayPalService.class));
        super.onDestroy();
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //If the result is from paypal
        if (requestCode == PAYPAL_REQUEST_CODE) {

            //If the result is OK i.e. user has not canceled the payment
            if (resultCode == Activity.RESULT_OK) {
                //Getting the payment confirmation
                PaymentConfirmation confirm = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);

                //if confirmation is not null
                if (confirm != null) {
                    try {
                        //Getting the payment details
                        String paymentDetails = confirm.toJSONObject().toString(4);
                        Log.i("paymentExample", paymentDetails);

                        //Starting a new activity for the payment details and also putting the payment details with intent
                        startActivity(new Intent(this, ConfirmationActivity.class)
                                .putExtra("PaymentDetails", paymentDetails)
                                .putExtra("PaymentAmount", paymentAmount));

                    } catch (JSONException e) {
                        Log.e("paymentExample", "an extremely unlikely failure occurred: ", e);
                    }
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Log.i("paymentExample", "The user canceled.");
            } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
                Log.i("paymentExample", "An invalid Payment or PayPalConfiguration was submitted. Please see the docs.");
            }
        }
    }
}
