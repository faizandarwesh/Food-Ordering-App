package com.example.homepc.restauranteatitapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView = null;
    Toolbar toolbar = null;
    Button logout,cancel;
    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb = new DatabaseHelper(this);


        Intent i = getIntent();
        String save1 = i.getStringExtra("Name_marker");
       // String save2 = i.getStringExtra("pass_marker");


            Toast.makeText(getApplicationContext(),"Hello " + save1+ " , Welcome to Eat It Restaurant",Toast.LENGTH_SHORT).show();
         //   Toast.makeText(getApplicationContext(),save2,Toast.LENGTH_SHORT).show();


        //DEFAULT FRAGMENT

        MainFragment fragment = new MainFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.Fragment_container, fragment);
        fragmentTransaction.commit();



        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_fastfood) {
              FastFoodFragment fragment = new FastFoodFragment();
              android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
              fragmentTransaction.replace(R.id.Fragment_container, fragment);
              fragmentTransaction.commit();


        }else if (id == R.id.nav_seafood) {


            SeaFragment fragment = new SeaFragment();
           android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.Fragment_container, fragment);
            fragmentTransaction.commit();

        }
        else if (id == R.id.nav_italian) {

            ItalianFragment fragment = new ItalianFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.Fragment_container, fragment);
           fragmentTransaction.commit();

        } else if (id == R.id.nav_continental) {

            ContinentalFragment fragment = new ContinentalFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.Fragment_container, fragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_traditional) {


            TraditionalFragment fragment = new TraditionalFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
           fragmentTransaction.replace(R.id.Fragment_container, fragment);
            fragmentTransaction.commit();

        }else if (id == R.id.nav_chinese) {


            ChineseFragment fragment = new ChineseFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.Fragment_container, fragment);
            fragmentTransaction.commit();
        }
        else if(id == R.id.order_details_drawer ){

            Cursor check ;
            check = mydb.Get_OrderDetails() ;

            if(check!=null && check.getCount()>0)
            {      Intent intent = new Intent(getApplicationContext(), OrderPage.class);
                startActivity(intent);
            }
            else  {Toast.makeText(getApplicationContext(),"No details found because you didn't order something...",Toast.LENGTH_SHORT).show();}
        }
        else if(id == R.id.submit_order ){

            Cursor check ;
            check = mydb.Get_OrderDetails() ;

            if(check!=null && check.getCount()>0)
                {   Submit_Order fragment = new Submit_Order();
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.Fragment_container, fragment);
                fragmentTransaction.commit();

            }
            else  {Toast.makeText(getApplicationContext(),"Sorry, You don't order anything...",Toast.LENGTH_SHORT).show();}
        }

        else if(id == R.id.log_out ){

            openDialog();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    public void openDialog() {

        final Dialog builder = new Dialog(this); // Context, this, etc.
        builder.setContentView(R.layout.dialogdesign);
        builder.setTitle(R.string.dialog_popup);
        builder.show();
        logout = (Button) builder.findViewById(R.id.dialog_ok);
        cancel = (Button) builder.findViewById(R.id.dialog_cancel);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mydb.delete_all();
                Toast.makeText(getApplicationContext(),"Hope you like our service, Have a good day !!!",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),LoginOptionsPage.class);
                startActivity(intent);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"So you don't want to, Logout !!!",Toast.LENGTH_SHORT).show();
                builder.dismiss();
            }
        });

    }
}
