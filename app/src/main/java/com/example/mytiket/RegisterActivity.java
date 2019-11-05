package com.example.mytiket;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;



public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonRegister;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextConfirm;
    private ProgressDialog progressDialog;
DatabaseHalper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db=new DatabaseHalper(this);


        progressDialog=new ProgressDialog(this);
        buttonRegister=(Button)findViewById(R.id.registrationBtn);
        editTextEmail=(EditText)findViewById(R.id.regEmailTxt);
        editTextPassword=(EditText)findViewById(R.id.regpasswordtxt);
        editTextConfirm=(EditText)findViewById(R.id.confirmpasswordtxt);
        buttonRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==buttonRegister){
            registerUser();
        }
    }

    private void registerUser() {
        String email=editTextEmail.getText().toString();
        String password=editTextPassword.getText().toString().trim();
        String confirmpassword=editTextConfirm.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter Email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter Password",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(confirmpassword)){
            Toast.makeText(this,"Please enter Password again",Toast.LENGTH_SHORT).show();
            return;
        }

        if(password.equals(confirmpassword)){
            Boolean chkemail=db.chkemail(email);
            if(chkemail==true) {
                Boolean insert = db.insert(email, password);
                if (insert == true) {
                    Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                    Intent homeIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(homeIntent);
                    finish();
                }
            }
                else{
                Toast.makeText(this,"Email Already exists",Toast.LENGTH_SHORT).show();
                    Intent homeIntent=new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(homeIntent);
                    finish();
                }

        }
        else {
            Toast.makeText(this,"Password do not match",Toast.LENGTH_SHORT).show();
        }
        progressDialog.setMessage("Registring User...");
        progressDialog.show();

    }
}
