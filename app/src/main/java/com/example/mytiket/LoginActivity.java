package com.example.mytiket;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private Button buttonLogin;
    private EditText txtEmail;
    private EditText txtPassword;
    private ProgressDialog progressDialog;
    DatabaseHalper db;

    public static boolean loginstatus=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db=new DatabaseHalper(this);
        progressDialog=new ProgressDialog(this);
        buttonLogin=(Button)findViewById(R.id.signinBtn);
        txtEmail=(EditText)findViewById(R.id.usernametxt);
        txtPassword=(EditText)findViewById(R.id.passwordtxt);
        buttonLogin.setOnClickListener(this);

    }
    public void register(View v){
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }

    @Override
    public void onClick(View view) {
        if(view==buttonLogin){

            loginUser();
        }
    }

    private void loginUser() {
        String logemail=txtEmail.getText().toString();
        String logpassword=txtPassword.getText().toString().trim();
        if(TextUtils.isEmpty(logemail)){
            Toast.makeText(this,"Please enter Email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(logpassword)){
            Toast.makeText(this,"Please enter Password",Toast.LENGTH_SHORT).show();
            return;
        }
        Boolean chkemail=db.chkemail(logemail);
        if(chkemail==false){
            Toast.makeText(this,"Login Successfully",Toast.LENGTH_SHORT).show();
            loginstatus=true;
            Intent homeIntent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(homeIntent);
            finish();
        }
        else{
            Toast.makeText(this,"Please Register",Toast.LENGTH_SHORT).show();
            Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(registerIntent);
            finish();
        }
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();
    }
}
