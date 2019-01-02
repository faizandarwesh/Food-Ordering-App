package com.example.homepc.restauranteatitapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class LoginOptionsPage extends AppCompatActivity {
    Button sign_in,sign_up,details,orderdetails;
    DatabaseHelper myDB;
    LinearLayout l1,l2;
    Animation uptodown,downtoup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_options_page);
        sign_in = (Button) findViewById(R.id.signin);
        sign_up = (Button) findViewById(R.id.signup);
        details = (Button) findViewById(R.id.userinfo);
        orderdetails = (Button) findViewById(R.id.order_details);

        l1 = (LinearLayout) findViewById(R.id.layout1);
        l2 = (LinearLayout) findViewById(R.id.layout2);

        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);

        l1.setAnimation(uptodown);
        l2.setAnimation(downtoup);



        myDB = new DatabaseHelper(this);
        User_info();
        Order_data();
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signinpage = new Intent(getApplicationContext(),SignInPage.class);
                startActivity(signinpage);
                finish();

            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signuppage = new Intent(getApplicationContext(),SignUpPage.class);
                startActivity(signuppage);
                finish();

            }
        });


    }

    public void User_info(){

        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = myDB.GetData();
                if(res.getCount() == 0) {
                    showmessage("Error", "nothing found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){

                    buffer.append("Id : " + res.getString(0) + "\n");
                    buffer.append("Username : " + res.getString(1) + "\n");
                    buffer.append("Password : " + res.getString(2)+ "\n");

                }
                showmessage("Data",buffer.toString());


            }
        });

    }
    public void Order_data(){
        orderdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res =   myDB.Get_OrderDetails();
                if(res.getCount() == 0) {
                    showmessage("Error", "nothing found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){

                    buffer.append("Id : " + res.getString(0) + "\n");
                    buffer.append("Item Name : " + res.getString(1) + "\n");
                    buffer.append("Quantity : " + res.getString(2)+ "\n");
                    buffer.append("Price : " + res.getString(3)+ "\n");

                }
                showmessage("Data",buffer.toString());


            }
        });
    }
    public void showmessage(String title,String message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }

}

