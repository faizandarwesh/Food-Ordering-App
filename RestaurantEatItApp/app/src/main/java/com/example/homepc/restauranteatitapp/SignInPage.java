package com.example.homepc.restauranteatitapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInPage extends AppCompatActivity {
    DatabaseHelper myDB;
    EditText signinName, signinPassword;
    Button signinbtn;
    String usernameSaver, passwordSaver;
    boolean finalcheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page);
        myDB = new DatabaseHelper(this);
        signinName = (EditText) findViewById(R.id.signin_id);
        signinPassword = (EditText) findViewById(R.id.signin_password);
        signinbtn = (Button) findViewById(R.id.signinBtn);
        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_holder = "";
                String password_holder = "";
                if(signinName.getText().toString().equalsIgnoreCase("")||(signinPassword.getText().toString().equalsIgnoreCase("")))
                {
                    Toast.makeText(getApplicationContext(),"Username and Password fields can't left blank",Toast.LENGTH_SHORT).show();

                }else
                {

                    Cursor c = myDB.CheckAccount(signinName.getText().toString());
                    if(c != null)
                        try {
                            name_holder = c.getString(1);
                            password_holder = c.getString(2);

                        }catch (Exception e){

                        }
                    if(name_holder.equalsIgnoreCase(signinName.getText().toString()) &&(password_holder.equals(signinPassword.getText().toString())))
                    {
                        usernameSaver = name_holder;
                        passwordSaver = password_holder;
                        Toast.makeText(getApplicationContext(),"Successfully Logged In !",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        intent.putExtra("Name_marker",usernameSaver);
                        intent.putExtra("pass_marker",passwordSaver);
                        startActivity(intent);
                        finish();

                    }
                    else if(name_holder.equalsIgnoreCase(signinName.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Invalid Password, Try Again !",Toast.LENGTH_SHORT).show();


                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Please Register yourself first !",Toast.LENGTH_SHORT).show();

                    }

                }

            }
        });
    }
}
