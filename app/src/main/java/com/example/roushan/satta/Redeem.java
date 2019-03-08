package com.example.roushan.satta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Redeem extends AppCompatActivity {


    TextView redeemtxt,txthint;
    FirebaseAuth mauth;
    DatabaseReference mdb;
    String curentuser;
    String um;

    EditText edtpay,edtmob;
    Button btnsend;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redeem);



        redeemtxt = (TextView) findViewById(R.id.redeemtxt);
        txthint = (TextView) findViewById(R.id.txt);
        edtpay = (EditText) findViewById(R.id.edtpaytm);
        edtmob = (EditText) findViewById(R.id.edtpaytm4);
        btnsend = (Button) findViewById(R.id.btnpayment);


        mauth = FirebaseAuth.getInstance();
        curentuser = mauth.getCurrentUser().getUid();

        mdb = FirebaseDatabase.getInstance().getReference().child("user").child(curentuser);

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=edtpay.getText().toString();
                String s1=edtmob.getText().toString();

                  DatabaseReference firebaseDatabase=mdb.child("Paytm");
                    DatabaseReference firebaseDatabase1=mdb.child("Mobile");
                    firebaseDatabase.setValue(s);
                    firebaseDatabase1.setValue(s1);



            }
        });



        mdb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (isChild()) {

                }
                else
                {
                    um = dataSnapshot.child("redeem").getValue().toString();
                    redeemtxt.setText(um);



                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}

