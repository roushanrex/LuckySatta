package com.example.roushan.satta;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.roushan.satta.Chat.DashboardActivity;
import com.example.roushan.satta.Chat.Loginchat;
import com.example.roushan.satta.Chat.models.User;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    TextView result, rnumber, dnumber, fnumber, gnumber, galinumber;
    FirebaseAuth auth;
    TextView textCartItemCount;
    int mCartItemCount = 200;
    User u;
    FirebaseDatabase database;
    DatabaseReference mRef;

    TextView oldda, oldgh, oldfa, oldga;


    //    this part is redeem point
    FirebaseAuth mauth;
    DatabaseReference mdb;
    String curentuser;
    String um;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("LUCKY SATTA");
        setSupportActionBar(toolbar);

        result = (TextView) findViewById(R.id.resultcity);
        rnumber = (TextView) findViewById(R.id.rnumber);
        dnumber = (TextView) findViewById(R.id.dnumber);
        fnumber = (TextView) findViewById(R.id.fnumber);
        gnumber = (TextView) findViewById(R.id.gnumber);
        galinumber = (TextView) findViewById(R.id.galinumber);
        oldda = (TextView) findViewById(R.id.oldda);
        oldfa = (TextView) findViewById(R.id.oldfa);
        oldgh = (TextView) findViewById(R.id.oldgh);
        oldga = (TextView) findViewById(R.id.oldga);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        mRef = database.getReference();






        if(auth.getCurrentUser() !=null){

            redeempoint();
        }

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                String s1= String.valueOf(map.get("RESULT"));
                String s2= String.valueOf(map.get("RESULTNUMBER"));
                String s3= String.valueOf(map.get("NEWGHAZIABAD"));
                String s4= String.valueOf(map.get("NEWGALI"));
                String s5= String.valueOf(map.get("NEWFARIDABAD"));
                String s6= String.valueOf(map.get("NEWDESAWAR"));
                String s7= String.valueOf(map.get("OLDDESAWAR"));
                String s8= String.valueOf(map.get("OLDFARIDABAD"));
                String s9= String.valueOf(map.get("OLDGALI"));
                String s10= String.valueOf(map.get("OLDGHAZIABAD"));

                result.setText(s1);
                rnumber.setText(s2);
                gnumber.setText(s3);
                galinumber.setText(s4);
                fnumber.setText(s5);
                dnumber.setText(s6);
                oldda.setText(s7);
                oldfa.setText(s8);
                oldga.setText(s9);
                oldgh.setText(s10);



            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    private void redeempoint() {

        mauth = FirebaseAuth.getInstance();
        curentuser = mauth.getCurrentUser().getUid();
        mdb = FirebaseDatabase.getInstance().getReference().child("user").child(curentuser);


        mdb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (isChild()) {
                    Toast.makeText(MainActivity.this, "Not rede,", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    um = dataSnapshot.child("redeem").getValue().toString();
                    textCartItemCount.setText(um);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {


            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Are you sure you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
//                            MainActivity.this.finish();
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
//        super.onBackPressed();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.redeem, menu);
        final MenuItem menuItem = menu.findItem(R.id.redeem);

        View actionView = MenuItemCompat.getActionView(menuItem);
        textCartItemCount= (TextView) actionView.findViewById(R.id.cart_badge);

        setupBadge();

        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(menuItem);
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.redeem: {

                if(auth.getCurrentUser() !=null){
                    Intent intent=new Intent(MainActivity.this,Redeem.class);
                    startActivity(intent);
                }


                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupBadge() {

        if (textCartItemCount != null) {
            if (mCartItemCount == 0) {
                if (textCartItemCount.getVisibility() != View.GONE) {
                    textCartItemCount.setVisibility(View.VISIBLE);
                }
//
            }
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            startActivity(new Intent(MainActivity.this,MainActivity.class));
        } else if (id == R.id.chat) {

            startActivity(new Intent(MainActivity.this,Loginchat.class));

        } else if (id == R.id.sattaresult) {
            startActivity(new Intent(MainActivity.this,Tablerow.class));

        } else if (id == R.id.redeem) {
            if(auth.getCurrentUser() !=null){
                Intent intent=new Intent(MainActivity.this,Redeem.class);
                startActivity(intent);
            }
        }
        else if (id == R.id.game) {
            startActivity(new Intent(MainActivity.this,Game.class));

        } else if (id == R.id.contact) {
            startActivity(new Intent(MainActivity.this,Contact.class));

        }
        else if (id == R.id.privacy) {
            startActivity(new Intent(MainActivity.this,Privacy.class));

        }
        else if (id == R.id.share) {

            try {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "SATTA GROUP");
                String sAux = "\nLet me recommend you this application\n\n";
                sAux = sAux + "https://play.google.com/store/apps/details?id=the.package.id \n\n";
                i.putExtra(Intent.EXTRA_TEXT, sAux);
                startActivity(Intent.createChooser(i, "choose one"));
            } catch(Exception e) {
                //e.toString();
            }

        }
        else if (id==R.id.logout)
        {
            auth.signOut();
            startActivity(new Intent(MainActivity.this,MainActivity.class));
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
